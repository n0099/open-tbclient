package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.collection.SparseArrayCompat;
import androidx.core.app.ActivityManagerCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public abstract class RoomDatabase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DB_IMPL_SUFFIX = "_Impl";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAllowMainThreadQueries;
    @Nullable
    public List<Callback> mCallbacks;
    public final ReentrantLock mCloseLock;
    public volatile SupportSQLiteDatabase mDatabase;
    public final InvalidationTracker mInvalidationTracker;
    public SupportSQLiteOpenHelper mOpenHelper;
    public Executor mQueryExecutor;
    public boolean mWriteAheadLoggingEnabled;

    /* loaded from: classes.dex */
    public static class Builder<T extends RoomDatabase> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mAllowMainThreadQueries;
        public ArrayList<Callback> mCallbacks;
        public final Context mContext;
        public final Class<T> mDatabaseClass;
        public SupportSQLiteOpenHelper.Factory mFactory;
        public JournalMode mJournalMode;
        public final MigrationContainer mMigrationContainer;
        public Set<Integer> mMigrationStartAndEndVersions;
        public Set<Integer> mMigrationsNotRequiredFrom;
        public final String mName;
        public Executor mQueryExecutor;
        public boolean mRequireMigration;

        public Builder(@NonNull Context context, @NonNull Class<T> cls, @Nullable String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, cls, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mContext = context;
            this.mDatabaseClass = cls;
            this.mName = str;
            this.mJournalMode = JournalMode.AUTOMATIC;
            this.mRequireMigration = true;
            this.mMigrationContainer = new MigrationContainer();
        }

        @NonNull
        public Builder<T> addCallback(@NonNull Callback callback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, callback)) == null) {
                if (this.mCallbacks == null) {
                    this.mCallbacks = new ArrayList<>();
                }
                this.mCallbacks.add(callback);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder<T> addMigrations(@NonNull Migration... migrationArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, migrationArr)) == null) {
                if (this.mMigrationStartAndEndVersions == null) {
                    this.mMigrationStartAndEndVersions = new HashSet();
                }
                for (Migration migration : migrationArr) {
                    this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
                    this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
                }
                this.mMigrationContainer.addMigrations(migrationArr);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder<T> allowMainThreadQueries() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.mAllowMainThreadQueries = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        @NonNull
        public T build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.mContext != null) {
                    if (this.mDatabaseClass != null) {
                        if (this.mQueryExecutor == null) {
                            this.mQueryExecutor = ArchTaskExecutor.getIOThreadExecutor();
                        }
                        Set<Integer> set = this.mMigrationStartAndEndVersions;
                        if (set != null && this.mMigrationsNotRequiredFrom != null) {
                            for (Integer num : set) {
                                if (this.mMigrationsNotRequiredFrom.contains(num)) {
                                    throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                                }
                            }
                        }
                        if (this.mFactory == null) {
                            this.mFactory = new FrameworkSQLiteOpenHelperFactory();
                        }
                        Context context = this.mContext;
                        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, this.mName, this.mFactory, this.mMigrationContainer, this.mCallbacks, this.mAllowMainThreadQueries, this.mJournalMode.resolve(context), this.mQueryExecutor, this.mRequireMigration, this.mMigrationsNotRequiredFrom);
                        T t = (T) Room.getGeneratedImplementation(this.mDatabaseClass, RoomDatabase.DB_IMPL_SUFFIX);
                        t.init(databaseConfiguration);
                        return t;
                    }
                    throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
                }
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            }
            return (T) invokeV.objValue;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.mRequireMigration = false;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigrationFrom(int... iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iArr)) == null) {
                if (this.mMigrationsNotRequiredFrom == null) {
                    this.mMigrationsNotRequiredFrom = new HashSet(iArr.length);
                }
                for (int i : iArr) {
                    this.mMigrationsNotRequiredFrom.add(Integer.valueOf(i));
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder<T> openHelperFactory(@Nullable SupportSQLiteOpenHelper.Factory factory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, factory)) == null) {
                this.mFactory = factory;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder<T> setJournalMode(@NonNull JournalMode journalMode) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, journalMode)) == null) {
                this.mJournalMode = journalMode;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder<T> setQueryExecutor(@NonNull Executor executor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, executor)) == null) {
                this.mQueryExecutor = executor;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Callback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, supportSQLiteDatabase) == null) {
            }
        }

        public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, supportSQLiteDatabase) == null) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class JournalMode {
        public static final /* synthetic */ JournalMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final JournalMode AUTOMATIC;
        public static final JournalMode TRUNCATE;
        @RequiresApi(16)
        public static final JournalMode WRITE_AHEAD_LOGGING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1036374357, "Landroidx/room/RoomDatabase$JournalMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1036374357, "Landroidx/room/RoomDatabase$JournalMode;");
                    return;
                }
            }
            AUTOMATIC = new JournalMode("AUTOMATIC", 0);
            TRUNCATE = new JournalMode("TRUNCATE", 1);
            JournalMode journalMode = new JournalMode("WRITE_AHEAD_LOGGING", 2);
            WRITE_AHEAD_LOGGING = journalMode;
            $VALUES = new JournalMode[]{AUTOMATIC, TRUNCATE, journalMode};
        }

        public JournalMode(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static JournalMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (JournalMode) Enum.valueOf(JournalMode.class, str) : (JournalMode) invokeL.objValue;
        }

        public static JournalMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (JournalMode[]) $VALUES.clone() : (JournalMode[]) invokeV.objValue;
        }

        @SuppressLint({"NewApi"})
        public JournalMode resolve(Context context) {
            InterceptResult invokeL;
            ActivityManager activityManager;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                if (this != AUTOMATIC) {
                    return this;
                }
                if (Build.VERSION.SDK_INT >= 16 && (activityManager = (ActivityManager) context.getSystemService("activity")) != null && !ActivityManagerCompat.isLowRamDevice(activityManager)) {
                    return WRITE_AHEAD_LOGGING;
                }
                return TRUNCATE;
            }
            return (JournalMode) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class MigrationContainer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArrayCompat<SparseArrayCompat<Migration>> mMigrations;

        public MigrationContainer() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMigrations = new SparseArrayCompat<>();
        }

        private void addMigration(Migration migration) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, migration) == null) {
                int i = migration.startVersion;
                int i2 = migration.endVersion;
                SparseArrayCompat<Migration> sparseArrayCompat = this.mMigrations.get(i);
                if (sparseArrayCompat == null) {
                    sparseArrayCompat = new SparseArrayCompat<>();
                    this.mMigrations.put(i, sparseArrayCompat);
                }
                Migration migration2 = sparseArrayCompat.get(i2);
                if (migration2 != null) {
                    Log.w(Room.LOG_TAG, "Overriding migration " + migration2 + " with " + migration);
                }
                sparseArrayCompat.append(i2, migration);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x001d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private List<Migration> findUpMigrationPath(List<Migration> list, boolean z, int i, int i2) {
            InterceptResult invokeCommon;
            SparseArrayCompat<Migration> sparseArrayCompat;
            boolean z2;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{list, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
                int i5 = z ? -1 : 1;
                do {
                    if (z) {
                        if (i >= i2) {
                            return list;
                        }
                        sparseArrayCompat = this.mMigrations.get(i);
                        if (sparseArrayCompat != null) {
                            return null;
                        }
                        int size = sparseArrayCompat.size();
                        z2 = false;
                        if (z) {
                            i4 = size - 1;
                            i3 = -1;
                        } else {
                            i3 = size;
                            i4 = 0;
                        }
                        while (true) {
                            if (i4 != i3) {
                                int keyAt = sparseArrayCompat.keyAt(i4);
                                if (!z ? keyAt < i2 || keyAt >= i : keyAt > i2 || keyAt <= i) {
                                    list.add(sparseArrayCompat.valueAt(i4));
                                    i = keyAt;
                                    z2 = true;
                                    continue;
                                    break;
                                }
                                i4 += i5;
                            }
                        }
                    } else {
                        if (i <= i2) {
                            return list;
                        }
                        sparseArrayCompat = this.mMigrations.get(i);
                        if (sparseArrayCompat != null) {
                        }
                    }
                } while (z2);
                return null;
            }
            return (List) invokeCommon.objValue;
        }

        public void addMigrations(@NonNull Migration... migrationArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, migrationArr) == null) {
                for (Migration migration : migrationArr) {
                    addMigration(migration);
                }
            }
        }

        @Nullable
        public List<Migration> findMigrationPath(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
                if (i == i2) {
                    return Collections.emptyList();
                }
                return findUpMigrationPath(new ArrayList(), i2 > i, i, i2);
            }
            return (List) invokeII.objValue;
        }
    }

    public RoomDatabase() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCloseLock = new ReentrantLock();
        this.mInvalidationTracker = createInvalidationTracker();
    }

    public static boolean isMainThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? Looper.getMainLooper().getThread() == Thread.currentThread() : invokeV.booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void assertNotMainThread() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.mAllowMainThreadQueries && isMainThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            assertNotMainThread();
            SupportSQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
            this.mInvalidationTracker.syncTriggers(writableDatabase);
            writableDatabase.beginTransaction();
        }
    }

    @WorkerThread
    public abstract void clearAllTables();

    public void close() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && isOpen()) {
            try {
                this.mCloseLock.lock();
                this.mOpenHelper.close();
            } finally {
                this.mCloseLock.unlock();
            }
        }
    }

    public SupportSQLiteStatement compileStatement(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            assertNotMainThread();
            return this.mOpenHelper.getWritableDatabase().compileStatement(str);
        }
        return (SupportSQLiteStatement) invokeL.objValue;
    }

    @NonNull
    public abstract InvalidationTracker createInvalidationTracker();

    @NonNull
    public abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration);

    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mOpenHelper.getWritableDatabase().endTransaction();
            if (inTransaction()) {
                return;
            }
            this.mInvalidationTracker.refreshVersionsAsync();
        }
    }

    public Lock getCloseLock() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mCloseLock : (Lock) invokeV.objValue;
    }

    @NonNull
    public InvalidationTracker getInvalidationTracker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mInvalidationTracker : (InvalidationTracker) invokeV.objValue;
    }

    @NonNull
    public SupportSQLiteOpenHelper getOpenHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mOpenHelper : (SupportSQLiteOpenHelper) invokeV.objValue;
    }

    @NonNull
    public Executor getQueryExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mQueryExecutor : (Executor) invokeV.objValue;
    }

    public boolean inTransaction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mOpenHelper.getWritableDatabase().inTransaction() : invokeV.booleanValue;
    }

    @CallSuper
    public void init(@NonNull DatabaseConfiguration databaseConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, databaseConfiguration) == null) {
            this.mOpenHelper = createOpenHelper(databaseConfiguration);
            if (Build.VERSION.SDK_INT >= 16) {
                r1 = databaseConfiguration.journalMode == JournalMode.WRITE_AHEAD_LOGGING;
                this.mOpenHelper.setWriteAheadLoggingEnabled(r1);
            }
            this.mCallbacks = databaseConfiguration.callbacks;
            this.mQueryExecutor = databaseConfiguration.queryExecutor;
            this.mAllowMainThreadQueries = databaseConfiguration.allowMainThreadQueries;
            this.mWriteAheadLoggingEnabled = r1;
        }
    }

    public void internalInitInvalidationTracker(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, supportSQLiteDatabase) == null) {
            this.mInvalidationTracker.internalInit(supportSQLiteDatabase);
        }
    }

    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SupportSQLiteDatabase supportSQLiteDatabase = this.mDatabase;
            return supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen();
        }
        return invokeV.booleanValue;
    }

    public Cursor query(String str, @Nullable Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, objArr)) == null) ? this.mOpenHelper.getWritableDatabase().query(new SimpleSQLiteQuery(str, objArr)) : (Cursor) invokeLL.objValue;
    }

    public void runInTransaction(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, runnable) == null) {
            beginTransaction();
            try {
                runnable.run();
                setTransactionSuccessful();
            } finally {
                endTransaction();
            }
        }
    }

    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.mOpenHelper.getWritableDatabase().setTransactionSuccessful();
        }
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, supportSQLiteQuery)) == null) {
            assertNotMainThread();
            return this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery);
        }
        return (Cursor) invokeL.objValue;
    }

    public <V> V runInTransaction(@NonNull Callable<V> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, callable)) == null) {
            beginTransaction();
            try {
                try {
                    try {
                        V call = callable.call();
                        setTransactionSuccessful();
                        return call;
                    } catch (RuntimeException e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw new RuntimeException("Exception in transaction", e2);
                }
            } finally {
                endTransaction();
            }
        }
        return (V) invokeL.objValue;
    }
}
