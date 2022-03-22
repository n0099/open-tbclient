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
import androidx.core.view.InputDeviceCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    @VisibleForTesting
    public static final String CLEANUP_SQL = "DELETE FROM room_table_modification_log WHERE version NOT IN( SELECT MAX(version) FROM room_table_modification_log GROUP BY table_id)";
    public static final String CREATE_VERSION_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log(version INTEGER PRIMARY KEY AUTOINCREMENT, table_id INTEGER)";
    @VisibleForTesting
    public static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE version  > ? ORDER BY version ASC;";
    public static final String TABLE_ID_COLUMN_NAME = "table_id";
    public static final String[] TRIGGERS;
    public static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    public static final String VERSION_COLUMN_NAME = "version";
    public transient /* synthetic */ FieldHolder $fh;
    public volatile SupportSQLiteStatement mCleanupStatement;
    public final RoomDatabase mDatabase;
    public volatile boolean mInitialized;
    public long mMaxVersion;
    public ObservedTableTracker mObservedTableTracker;
    @VisibleForTesting
    public final SafeIterableMap<Observer, ObserverWrapper> mObserverMap;
    public AtomicBoolean mPendingRefresh;
    public Object[] mQueryArgs;
    @VisibleForTesting
    public Runnable mRefreshRunnable;
    @NonNull
    @VisibleForTesting
    public ArrayMap<String, Integer> mTableIdLookup;
    public String[] mTableNames;
    @NonNull
    @VisibleForTesting
    public long[] mTableVersions;

    /* loaded from: classes.dex */
    public static class ObservedTableTracker {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ADD = 1;
        public static final int NO_OP = 0;
        public static final int REMOVE = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mNeedsSync;
        public boolean mPendingSync;
        public final long[] mTableObservers;
        public final int[] mTriggerStateChanges;
        public final boolean[] mTriggerStates;

        public ObservedTableTracker(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            long[] jArr = new long[i];
            this.mTableObservers = jArr;
            this.mTriggerStates = new boolean[i];
            this.mTriggerStateChanges = new int[i];
            Arrays.fill(jArr, 0L);
            Arrays.fill(this.mTriggerStates, false);
        }

        @Nullable
        public int[] getTablesToSync() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                    if (this.mNeedsSync && !this.mPendingSync) {
                        int length = this.mTableObservers.length;
                        int i = 0;
                        while (true) {
                            int i2 = 1;
                            if (i < length) {
                                boolean z = this.mTableObservers[i] > 0;
                                if (z != this.mTriggerStates[i]) {
                                    int[] iArr = this.mTriggerStateChanges;
                                    if (!z) {
                                        i2 = 2;
                                    }
                                    iArr[i] = i2;
                                } else {
                                    this.mTriggerStateChanges[i] = 0;
                                }
                                this.mTriggerStates[i] = z;
                                i++;
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
            return (int[]) invokeV.objValue;
        }

        public boolean onAdded(int... iArr) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr)) == null) {
                synchronized (this) {
                    z = false;
                    for (int i : iArr) {
                        long j = this.mTableObservers[i];
                        this.mTableObservers[i] = 1 + j;
                        if (j == 0) {
                            this.mNeedsSync = true;
                            z = true;
                        }
                    }
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        public boolean onRemoved(int... iArr) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iArr)) == null) {
                synchronized (this) {
                    z = false;
                    for (int i : iArr) {
                        long j = this.mTableObservers[i];
                        this.mTableObservers[i] = j - 1;
                        if (j == 1) {
                            this.mNeedsSync = true;
                            z = true;
                        }
                    }
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        public void onSyncCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    this.mPendingSync = false;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ObserverWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer mObserver;
        public final Set<String> mSingleTableSet;
        public final int[] mTableIds;
        public final String[] mTableNames;
        public final long[] mVersions;

        public ObserverWrapper(Observer observer, int[] iArr, String[] strArr, long[] jArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, iArr, strArr, jArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jArr) == null) {
                int length = this.mTableIds.length;
                Set<String> set = null;
                for (int i = 0; i < length; i++) {
                    long j = jArr[this.mTableIds[i]];
                    long[] jArr2 = this.mVersions;
                    if (jArr2[i] < j) {
                        jArr2[i] = j;
                        if (length == 1) {
                            set = this.mSingleTableSet;
                        } else {
                            if (set == null) {
                                set = new ArraySet<>(length);
                            }
                            set.add(this.mTableNames[i]);
                        }
                    }
                }
                if (set != null) {
                    this.mObserver.onInvalidated(set);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class WeakObserver extends Observer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<Observer> mDelegateRef;
        public final InvalidationTracker mTracker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WeakObserver(InvalidationTracker invalidationTracker, Observer observer) {
            super(observer.mTables);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {invalidationTracker, observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String[]) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTracker = invalidationTracker;
            this.mDelegateRef = new WeakReference<>(observer);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@NonNull Set<String> set) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, set) == null) {
                Observer observer = this.mDelegateRef.get();
                if (observer == null) {
                    this.mTracker.removeObserver(this);
                } else {
                    observer.onInvalidated(set);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1684395259, "Landroidx/room/InvalidationTracker;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1684395259, "Landroidx/room/InvalidationTracker;");
                return;
            }
        }
        TRIGGERS = new String[]{"UPDATE", HttpDelete.METHOD_NAME, "INSERT"};
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public InvalidationTracker(RoomDatabase roomDatabase, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {roomDatabase, strArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mQueryArgs = new Object[1];
        this.mMaxVersion = 0L;
        this.mPendingRefresh = new AtomicBoolean(false);
        this.mInitialized = false;
        this.mObserverMap = new SafeIterableMap<>();
        this.mRefreshRunnable = new Runnable(this) { // from class: androidx.room.InvalidationTracker.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ InvalidationTracker this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            private boolean checkUpdatedTable() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) {
                    InvalidationTracker invalidationTracker = this.this$0;
                    Cursor query = invalidationTracker.mDatabase.query(InvalidationTracker.SELECT_UPDATED_TABLES_SQL, invalidationTracker.mQueryArgs);
                    boolean z = false;
                    while (query.moveToNext()) {
                        try {
                            long j = query.getLong(0);
                            this.this$0.mTableVersions[query.getInt(1)] = j;
                            this.this$0.mMaxVersion = j;
                            z = true;
                        } finally {
                            query.close();
                        }
                    }
                    return z;
                }
                return invokeV.booleanValue;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    Lock closeLock = this.this$0.mDatabase.getCloseLock();
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
                    if (this.this$0.ensureInitialization()) {
                        if (this.this$0.mPendingRefresh.compareAndSet(true, false)) {
                            if (this.this$0.mDatabase.inTransaction()) {
                                return;
                            }
                            this.this$0.mCleanupStatement.executeUpdateDelete();
                            this.this$0.mQueryArgs[0] = Long.valueOf(this.this$0.mMaxVersion);
                            if (this.this$0.mDatabase.mWriteAheadLoggingEnabled) {
                                SupportSQLiteDatabase writableDatabase = this.this$0.mDatabase.getOpenHelper().getWritableDatabase();
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
                                synchronized (this.this$0.mObserverMap) {
                                    Iterator<Map.Entry<Observer, ObserverWrapper>> it = this.this$0.mObserverMap.iterator();
                                    while (it.hasNext()) {
                                        it.next().getValue().checkForInvalidation(this.this$0.mTableVersions);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
        this.mDatabase = roomDatabase;
        this.mObservedTableTracker = new ObservedTableTracker(strArr.length);
        this.mTableIdLookup = new ArrayMap<>();
        int length = strArr.length;
        this.mTableNames = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            String lowerCase = strArr[i3].toLowerCase(Locale.US);
            this.mTableIdLookup.put(lowerCase, Integer.valueOf(i3));
            this.mTableNames[i3] = lowerCase;
        }
        long[] jArr = new long[strArr.length];
        this.mTableVersions = jArr;
        Arrays.fill(jArr, 0L);
    }

    public static void appendTriggerName(StringBuilder sb, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, sb, str, str2) == null) {
            sb.append("`");
            sb.append("room_table_modification_trigger_");
            sb.append(str);
            sb.append("_");
            sb.append(str2);
            sb.append("`");
        }
    }

    private void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, supportSQLiteDatabase, i) == null) {
            String str = this.mTableNames[i];
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
                sb.append(i);
                sb.append("); END");
                supportSQLiteDatabase.execSQL(sb.toString());
            }
        }
    }

    private void stopTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, supportSQLiteDatabase, i) == null) {
            String str = this.mTableNames[i];
            StringBuilder sb = new StringBuilder();
            for (String str2 : TRIGGERS) {
                sb.setLength(0);
                sb.append("DROP TRIGGER IF EXISTS ");
                appendTriggerName(sb, str, str2);
                supportSQLiteDatabase.execSQL(sb.toString());
            }
        }
    }

    @WorkerThread
    public void addObserver(@NonNull Observer observer) {
        ObserverWrapper putIfAbsent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            String[] strArr = observer.mTables;
            int[] iArr = new int[strArr.length];
            int length = strArr.length;
            long[] jArr = new long[strArr.length];
            for (int i = 0; i < length; i++) {
                Integer num = this.mTableIdLookup.get(strArr[i].toLowerCase(Locale.US));
                if (num != null) {
                    iArr[i] = num.intValue();
                    jArr[i] = this.mMaxVersion;
                } else {
                    throw new IllegalArgumentException("There is no table with name " + strArr[i]);
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
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void addWeakObserver(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, observer) == null) {
            addObserver(new WeakObserver(this, observer));
        }
    }

    public boolean ensureInitialization() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public void internalInit(SupportSQLiteDatabase supportSQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, supportSQLiteDatabase) == null) {
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
    }

    public void refreshVersionsAsync() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.mPendingRefresh.compareAndSet(false, true)) {
            this.mDatabase.getQueryExecutor().execute(this.mRefreshRunnable);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @WorkerThread
    public void refreshVersionsSync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            syncTriggers();
            this.mRefreshRunnable.run();
        }
    }

    @WorkerThread
    public void removeObserver(@NonNull Observer observer) {
        ObserverWrapper remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, observer) == null) {
            synchronized (this.mObserverMap) {
                remove = this.mObserverMap.remove(observer);
            }
            if (remove == null || !this.mObservedTableTracker.onRemoved(remove.mTableIds)) {
                return;
            }
            syncTriggers();
        }
    }

    public void syncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, supportSQLiteDatabase) == null) || supportSQLiteDatabase.inTransaction()) {
            return;
        }
        while (true) {
            try {
                Lock closeLock = this.mDatabase.getCloseLock();
                closeLock.lock();
                int[] tablesToSync = this.mObservedTableTracker.getTablesToSync();
                if (tablesToSync == null) {
                    closeLock.unlock();
                    return;
                }
                int length = tablesToSync.length;
                supportSQLiteDatabase.beginTransaction();
                for (int i = 0; i < length; i++) {
                    int i2 = tablesToSync[i];
                    if (i2 == 1) {
                        startTrackingTable(supportSQLiteDatabase, i);
                    } else if (i2 == 2) {
                        stopTrackingTable(supportSQLiteDatabase, i);
                    }
                }
                supportSQLiteDatabase.setTransactionSuccessful();
                supportSQLiteDatabase.endTransaction();
                this.mObservedTableTracker.onSyncCompleted();
                closeLock.unlock();
            } catch (SQLiteException | IllegalStateException e2) {
                Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e2);
                return;
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Observer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String[] mTables;

        public Observer(@NonNull String str, String... strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, strArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
            this.mTables = strArr2;
            strArr2[strArr.length] = str;
        }

        public abstract void onInvalidated(@NonNull Set<String> set);

        public Observer(@NonNull String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mTables = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }

    public void syncTriggers() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.mDatabase.isOpen()) {
            syncTriggers(this.mDatabase.getOpenHelper().getWritableDatabase());
        }
    }
}
