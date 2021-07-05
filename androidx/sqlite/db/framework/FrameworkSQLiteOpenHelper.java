package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final OpenHelper mDelegate;

    /* loaded from: classes.dex */
    public static class OpenHelper extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SupportSQLiteOpenHelper.Callback mCallback;
        public final FrameworkSQLiteDatabase[] mDbRef;
        public boolean mMigrated;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(Context context, String str, FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, SupportSQLiteOpenHelper.Callback callback) {
            super(context, str, null, callback.version, new DatabaseErrorHandler(frameworkSQLiteDatabaseArr, callback) { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SupportSQLiteOpenHelper.Callback val$callback;
                public final /* synthetic */ FrameworkSQLiteDatabase[] val$dbRef;

                {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {frameworkSQLiteDatabaseArr, callback};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$dbRef = frameworkSQLiteDatabaseArr;
                    this.val$callback = callback;
                }

                @Override // android.database.DatabaseErrorHandler
                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    FrameworkSQLiteDatabase frameworkSQLiteDatabase;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) || (frameworkSQLiteDatabase = this.val$dbRef[0]) == null) {
                        return;
                    }
                    this.val$callback.onCorruption(frameworkSQLiteDatabase);
                }
            });
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, frameworkSQLiteDatabaseArr, callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue(), (DatabaseErrorHandler) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCallback = callback;
            this.mDbRef = frameworkSQLiteDatabaseArr;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    super.close();
                    this.mDbRef[0] = null;
                }
            }
        }

        public synchronized SupportSQLiteDatabase getReadableSupportDatabase() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this) {
                    this.mMigrated = false;
                    SQLiteDatabase readableDatabase = super.getReadableDatabase();
                    if (this.mMigrated) {
                        close();
                        return getReadableSupportDatabase();
                    }
                    return getWrappedDb(readableDatabase);
                }
            }
            return (SupportSQLiteDatabase) invokeV.objValue;
        }

        public FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sQLiteDatabase) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase)) == null) {
                if (this.mDbRef[0] == null) {
                    this.mDbRef[0] = new FrameworkSQLiteDatabase(sQLiteDatabase);
                }
                return this.mDbRef[0];
            }
            return (FrameworkSQLiteDatabase) invokeL.objValue;
        }

        public synchronized SupportSQLiteDatabase getWritableSupportDatabase() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                synchronized (this) {
                    this.mMigrated = false;
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    if (this.mMigrated) {
                        close();
                        return getWritableSupportDatabase();
                    }
                    return getWrappedDb(writableDatabase);
                }
            }
            return (SupportSQLiteDatabase) invokeV.objValue;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, sQLiteDatabase) == null) {
                this.mCallback.onConfigure(getWrappedDb(sQLiteDatabase));
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, sQLiteDatabase) == null) {
                this.mCallback.onCreate(getWrappedDb(sQLiteDatabase));
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048582, this, sQLiteDatabase, i2, i3) == null) {
                this.mMigrated = true;
                this.mCallback.onDowngrade(getWrappedDb(sQLiteDatabase), i2, i3);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, sQLiteDatabase) == null) || this.mMigrated) {
                return;
            }
            this.mCallback.onOpen(getWrappedDb(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, sQLiteDatabase, i2, i3) == null) {
                this.mMigrated = true;
                this.mCallback.onUpgrade(getWrappedDb(sQLiteDatabase), i2, i3);
            }
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, callback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDelegate = createDelegate(context, str, callback);
    }

    private OpenHelper createDelegate(Context context, String str, SupportSQLiteOpenHelper.Callback callback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, context, str, callback)) == null) ? new OpenHelper(context, str, new FrameworkSQLiteDatabase[1], callback) : (OpenHelper) invokeLLL.objValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mDelegate.close();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDelegate.getDatabaseName() : (String) invokeV.objValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDelegate.getReadableSupportDatabase() : (SupportSQLiteDatabase) invokeV.objValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDelegate.getWritableSupportDatabase() : (SupportSQLiteDatabase) invokeV.objValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.mDelegate.setWriteAheadLoggingEnabled(z);
        }
    }
}
