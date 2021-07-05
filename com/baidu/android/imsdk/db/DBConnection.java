package com.baidu.android.imsdk.db;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import com.baidu.android.imsdk.db.DBVersionManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class DBConnection extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DBConnection";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    /* loaded from: classes.dex */
    public class Version27And28Handler implements DBVersionManager.VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBConnection this$0;

        public Version27And28Handler(DBConnection dBConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBConnection;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i2, i3) == null) {
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE groupmember ADD COLUMN nickname TEXT");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "DBConnection onUpgrade:27->28", e2);
                }
                Log.d(LogUtils.TAG, "DBConnection onUpgrade:27->28");
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version47And48Handler implements DBVersionManager.VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBConnection this$0;

        public Version47And48Handler(DBConnection dBConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBConnection;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i2, i3) == null) {
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN marktop INTEGER DEFAULT 1");
                    sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN marktoptime LONG ");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "DBConnection onUpgrade:27->28", e2);
                }
                Log.d(LogUtils.TAG, "DBConnection onUpgrade:27->28");
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version49And50Handler implements DBVersionManager.VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBConnection this$0;

        public Version49And50Handler(DBConnection dBConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBConnection;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i2, i3) == null) {
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN group_notice TEXT");
                    sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN group_desc TEXT");
                    sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN local_members_version LONG DEFAULT '0'");
                    sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN groupinfo_version LONG DEFAULT '0'");
                    sQLiteDatabase.execSQL("ALTER TABLE groupinfo ADD COLUMN local_groupinfo_version LONG DEFAULT '0'");
                    sQLiteDatabase.execSQL("ALTER TABLE groupmember ADD COLUMN avatar TEXT");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "DBConnection onUpgrade:49->50", e2);
                }
                Log.d(LogUtils.TAG, "DBConnection onUpgrade:49->50");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DBConnection(Context context, String str, int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    private void createDb(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, sQLiteDatabase) == null) {
            if (dropTable(sQLiteDatabase) < 0) {
                LogUtils.d(TAG, "drop table db failed when db upgrade or downgrade!");
            } else if (createTable(sQLiteDatabase) < 0) {
                LogUtils.d(TAG, "create table db failed when db upgrade or downgrade!");
            }
        }
    }

    private int createTable(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, sQLiteDatabase)) == null) {
            int i2 = -1;
            try {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.beginTransaction();
                        sQLiteDatabase.execSQL(DBTableDefine.SQL_CREATE_TABLE_LOCALMESSAGE);
                        sQLiteDatabase.execSQL(DBTableDefine.SQL_CREATE_TABLE_GROUPINFO);
                        sQLiteDatabase.execSQL(DBTableDefine.SQL_CREATE_TABLE_GROUP_MEMBER);
                        i2 = 0;
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Exception e2) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                        LogUtils.e(LogUtils.TAG, "createTable:", e2);
                    }
                }
                return i2;
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
        return invokeL.intValue;
    }

    private int dropTable(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, sQLiteDatabase)) == null) {
            int i2 = -1;
            try {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.beginTransaction();
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS grouplocalmessage");
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS groupinfo");
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS groupmember");
                        i2 = 0;
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Exception e2) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                        LogUtils.e(LogUtils.TAG, "dropTable:", e2);
                    }
                }
                return i2;
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
        return invokeL.intValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
            super.onConfigure(sQLiteDatabase);
            if (Build.VERSION.SDK_INT > 10) {
                try {
                    boolean enableWriteAheadLogging = sQLiteDatabase.enableWriteAheadLogging();
                    LogUtils.d(TAG, "enableWAL : " + enableWriteAheadLogging);
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(TAG, "onConfigure", e2);
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase) == null) {
            createDb(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, i2, i3) == null) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, sQLiteDatabase, i2, i3) == null) {
            if (i2 <= 27 && i3 >= 28) {
                new Version27And28Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 28;
            }
            if (i2 <= 47 && i3 >= 48) {
                new Version47And48Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 48;
            }
            if (i2 > 49 || i3 < 50) {
                return;
            }
            new Version49And50Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
        }
    }
}
