package androidx.room;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import org.apache.http.client.methods.HttpDelete;
/* loaded from: classes.dex */
public class InvalidationTracker {
    @VisibleForTesting
    public static final String CLEANUP_SQL = "DELETE FROM room_table_modification_log WHERE version NOT IN( SELECT MAX(version) FROM room_table_modification_log GROUP BY table_id)";
    public static final String CREATE_VERSION_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log(version INTEGER PRIMARY KEY AUTOINCREMENT, table_id INTEGER)";
    @VisibleForTesting
    public static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE version  > ? ORDER BY version ASC;";
    public static final String TABLE_ID_COLUMN_NAME = "table_id";
    public static final String[] TRIGGERS = {"UPDATE", HttpDelete.METHOD_NAME, "INSERT"};
    public static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    public static final String VERSION_COLUMN_NAME = "version";
    public volatile SupportSQLiteStatement mCleanupStatement;
    public final RoomDatabase mDatabase;
    public ObservedTableTracker mObservedTableTracker;
    public String[] mTableNames;
    @NonNull
    @VisibleForTesting
    public long[] mTableVersions;
    public Object[] mQueryArgs = new Object[1];
    public long mMaxVersion = 0;
    public AtomicBoolean mPendingRefresh = new AtomicBoolean(false);
    public volatile boolean mInitialized = false;
    @VisibleForTesting
    public final SafeIterableMap<Observer, ObserverWrapper> mObserverMap = new SafeIterableMap<>();
    @VisibleForTesting
    public Runnable mRefreshRunnable = new Runnable() { // from class: androidx.room.InvalidationTracker.1
        private boolean checkUpdatedTable() {
            InvalidationTracker invalidationTracker = InvalidationTracker.this;
            Cursor query = invalidationTracker.mDatabase.query(InvalidationTracker.SELECT_UPDATED_TABLES_SQL, invalidationTracker.mQueryArgs);
            boolean z = false;
            while (query.moveToNext()) {
                try {
                    long j = query.getLong(0);
                    InvalidationTracker.this.mTableVersions[query.getInt(1)] = j;
                    InvalidationTracker.this.mMaxVersion = j;
                    z = true;
                } finally {
                    query.close();
                }
            }
            return z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Lock closeLock = InvalidationTracker.this.mDatabase.getCloseLock();
            boolean z = false;
            try {
                try {
                    closeLock.lock();
                } finally {
                    closeLock.unlock();
                }
            } catch (SQLiteException | IllegalStateException e2) {
                Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e2);
            }
            if (InvalidationTracker.this.ensureInitialization()) {
                if (InvalidationTracker.this.mPendingRefresh.compareAndSet(true, false)) {
                    if (InvalidationTracker.this.mDatabase.inTransaction()) {
                        return;
                    }
                    InvalidationTracker.this.mCleanupStatement.executeUpdateDelete();
                    InvalidationTracker.this.mQueryArgs[0] = Long.valueOf(InvalidationTracker.this.mMaxVersion);
                    if (InvalidationTracker.this.mDatabase.mWriteAheadLoggingEnabled) {
                        SupportSQLiteDatabase writableDatabase = InvalidationTracker.this.mDatabase.getOpenHelper().getWritableDatabase();
                        try {
                            writableDatabase.beginTransaction();
                            z = checkUpdatedTable();
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } else {
                        z = checkUpdatedTable();
                    }
                    if (z) {
                        synchronized (InvalidationTracker.this.mObserverMap) {
                            Iterator<Map.Entry<Observer, ObserverWrapper>> it = InvalidationTracker.this.mObserverMap.iterator();
                            while (it.hasNext()) {
                                it.next().getValue().checkForInvalidation(InvalidationTracker.this.mTableVersions);
                            }
                        }
                    }
                }
            }
        }
    };
    @NonNull
    @VisibleForTesting
    public ArrayMap<String, Integer> mTableIdLookup = new ArrayMap<>();

    /* loaded from: classes.dex */
    public static class ObservedTableTracker {
        public static final int ADD = 1;
        public static final int NO_OP = 0;
        public static final int REMOVE = 2;
        public boolean mNeedsSync;
        public boolean mPendingSync;
        public final long[] mTableObservers;
        public final int[] mTriggerStateChanges;
        public final boolean[] mTriggerStates;

        public ObservedTableTracker(int i2) {
            long[] jArr = new long[i2];
            this.mTableObservers = jArr;
            this.mTriggerStates = new boolean[i2];
            this.mTriggerStateChanges = new int[i2];
            Arrays.fill(jArr, 0L);
            Arrays.fill(this.mTriggerStates, false);
        }

        @Nullable
        public int[] getTablesToSync() {
            synchronized (this) {
                if (this.mNeedsSync && !this.mPendingSync) {
                    int length = this.mTableObservers.length;
                    int i2 = 0;
                    while (true) {
                        int i3 = 1;
                        if (i2 < length) {
                            boolean z = this.mTableObservers[i2] > 0;
                            if (z != this.mTriggerStates[i2]) {
                                int[] iArr = this.mTriggerStateChanges;
                                if (!z) {
                                    i3 = 2;
                                }
                                iArr[i2] = i3;
                            } else {
                                this.mTriggerStateChanges[i2] = 0;
                            }
                            this.mTriggerStates[i2] = z;
                            i2++;
                        } else {
                            this.mPendingSync = true;
                            this.mNeedsSync = false;
                            return this.mTriggerStateChanges;
                        }
                    }
                }
                return null;
            }
        }

        public boolean onAdded(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i2 : iArr) {
                    long j = this.mTableObservers[i2];
                    this.mTableObservers[i2] = 1 + j;
                    if (j == 0) {
                        this.mNeedsSync = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        public boolean onRemoved(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i2 : iArr) {
                    long j = this.mTableObservers[i2];
                    this.mTableObservers[i2] = j - 1;
                    if (j == 1) {
                        this.mNeedsSync = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        public void onSyncCompleted() {
            synchronized (this) {
                this.mPendingSync = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ObserverWrapper {
        public final Observer mObserver;
        public final Set<String> mSingleTableSet;
        public final int[] mTableIds;
        public final String[] mTableNames;
        public final long[] mVersions;

        public ObserverWrapper(Observer observer, int[] iArr, String[] strArr, long[] jArr) {
            this.mObserver = observer;
            this.mTableIds = iArr;
            this.mTableNames = strArr;
            this.mVersions = jArr;
            if (iArr.length == 1) {
                ArraySet arraySet = new ArraySet();
                arraySet.add(this.mTableNames[0]);
                this.mSingleTableSet = Collections.unmodifiableSet(arraySet);
                return;
            }
            this.mSingleTableSet = null;
        }

        public void checkForInvalidation(long[] jArr) {
            int length = this.mTableIds.length;
            Set<String> set = null;
            for (int i2 = 0; i2 < length; i2++) {
                long j = jArr[this.mTableIds[i2]];
                long[] jArr2 = this.mVersions;
                if (jArr2[i2] < j) {
                    jArr2[i2] = j;
                    if (length == 1) {
                        set = this.mSingleTableSet;
                    } else {
                        if (set == null) {
                            set = new ArraySet<>(length);
                        }
                        set.add(this.mTableNames[i2]);
                    }
                }
            }
            if (set != null) {
                this.mObserver.onInvalidated(set);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class WeakObserver extends Observer {
        public final WeakReference<Observer> mDelegateRef;
        public final InvalidationTracker mTracker;

        public WeakObserver(InvalidationTracker invalidationTracker, Observer observer) {
            super(observer.mTables);
            this.mTracker = invalidationTracker;
            this.mDelegateRef = new WeakReference<>(observer);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@NonNull Set<String> set) {
            Observer observer = this.mDelegateRef.get();
            if (observer == null) {
                this.mTracker.removeObserver(this);
            } else {
                observer.onInvalidated(set);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public InvalidationTracker(RoomDatabase roomDatabase, String... strArr) {
        this.mDatabase = roomDatabase;
        this.mObservedTableTracker = new ObservedTableTracker(strArr.length);
        int length = strArr.length;
        this.mTableNames = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String lowerCase = strArr[i2].toLowerCase(Locale.US);
            this.mTableIdLookup.put(lowerCase, Integer.valueOf(i2));
            this.mTableNames[i2] = lowerCase;
        }
        long[] jArr = new long[strArr.length];
        this.mTableVersions = jArr;
        Arrays.fill(jArr, 0L);
    }

    public static void appendTriggerName(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    private void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i2) {
        String[] strArr;
        String str = this.mTableNames[i2];
        StringBuilder sb = new StringBuilder();
        for (String str2 : TRIGGERS) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            appendTriggerName(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN INSERT OR REPLACE INTO ");
            sb.append(UPDATE_TABLE_NAME);
            sb.append(" VALUES(null, ");
            sb.append(i2);
            sb.append("); END");
            supportSQLiteDatabase.execSQL(sb.toString());
        }
    }

    private void stopTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i2) {
        String[] strArr;
        String str = this.mTableNames[i2];
        StringBuilder sb = new StringBuilder();
        for (String str2 : TRIGGERS) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            appendTriggerName(sb, str, str2);
            supportSQLiteDatabase.execSQL(sb.toString());
        }
    }

    @WorkerThread
    public void addObserver(@NonNull Observer observer) {
        ObserverWrapper putIfAbsent;
        String[] strArr = observer.mTables;
        int[] iArr = new int[strArr.length];
        int length = strArr.length;
        long[] jArr = new long[strArr.length];
        for (int i2 = 0; i2 < length; i2++) {
            Integer num = this.mTableIdLookup.get(strArr[i2].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i2] = num.intValue();
                jArr[i2] = this.mMaxVersion;
            } else {
                throw new IllegalArgumentException("There is no table with name " + strArr[i2]);
            }
        }
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArr, strArr, jArr);
        synchronized (this.mObserverMap) {
            putIfAbsent = this.mObserverMap.putIfAbsent(observer, observerWrapper);
        }
        if (putIfAbsent == null && this.mObservedTableTracker.onAdded(iArr)) {
            syncTriggers();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void addWeakObserver(Observer observer) {
        addObserver(new WeakObserver(this, observer));
    }

    public boolean ensureInitialization() {
        if (this.mDatabase.isOpen()) {
            if (!this.mInitialized) {
                this.mDatabase.getOpenHelper().getWritableDatabase();
            }
            if (this.mInitialized) {
                return true;
            }
            Log.e(Room.LOG_TAG, "database is not initialized even though it is open");
            return false;
        }
        return false;
    }

    public void internalInit(SupportSQLiteDatabase supportSQLiteDatabase) {
        synchronized (this) {
            if (this.mInitialized) {
                Log.e(Room.LOG_TAG, "Invalidation tracker is initialized twice :/.");
                return;
            }
            supportSQLiteDatabase.beginTransaction();
            supportSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
            supportSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
            supportSQLiteDatabase.execSQL(CREATE_VERSION_TABLE_SQL);
            supportSQLiteDatabase.setTransactionSuccessful();
            supportSQLiteDatabase.endTransaction();
            syncTriggers(supportSQLiteDatabase);
            this.mCleanupStatement = supportSQLiteDatabase.compileStatement(CLEANUP_SQL);
            this.mInitialized = true;
        }
    }

    public void refreshVersionsAsync() {
        if (this.mPendingRefresh.compareAndSet(false, true)) {
            this.mDatabase.getQueryExecutor().execute(this.mRefreshRunnable);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @WorkerThread
    public void refreshVersionsSync() {
        syncTriggers();
        this.mRefreshRunnable.run();
    }

    @WorkerThread
    public void removeObserver(@NonNull Observer observer) {
        ObserverWrapper remove;
        synchronized (this.mObserverMap) {
            remove = this.mObserverMap.remove(observer);
        }
        if (remove == null || !this.mObservedTableTracker.onRemoved(remove.mTableIds)) {
            return;
        }
        syncTriggers();
    }

    public void syncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (supportSQLiteDatabase.inTransaction()) {
            return;
        }
        while (true) {
            try {
                Lock closeLock = this.mDatabase.getCloseLock();
                closeLock.lock();
                try {
                    int[] tablesToSync = this.mObservedTableTracker.getTablesToSync();
                    if (tablesToSync == null) {
                        return;
                    }
                    int length = tablesToSync.length;
                    supportSQLiteDatabase.beginTransaction();
                    for (int i2 = 0; i2 < length; i2++) {
                        int i3 = tablesToSync[i2];
                        if (i3 == 1) {
                            startTrackingTable(supportSQLiteDatabase, i2);
                        } else if (i3 == 2) {
                            stopTrackingTable(supportSQLiteDatabase, i2);
                        }
                    }
                    supportSQLiteDatabase.setTransactionSuccessful();
                    supportSQLiteDatabase.endTransaction();
                    this.mObservedTableTracker.onSyncCompleted();
                } finally {
                    closeLock.unlock();
                }
            } catch (SQLiteException | IllegalStateException e2) {
                Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e2);
                return;
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Observer {
        public final String[] mTables;

        public Observer(@NonNull String str, String... strArr) {
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
            this.mTables = strArr2;
            strArr2[strArr.length] = str;
        }

        public abstract void onInvalidated(@NonNull Set<String> set);

        public Observer(@NonNull String[] strArr) {
            this.mTables = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }

    public void syncTriggers() {
        if (this.mDatabase.isOpen()) {
            syncTriggers(this.mDatabase.getOpenHelper().getWritableDatabase());
        }
    }
}
