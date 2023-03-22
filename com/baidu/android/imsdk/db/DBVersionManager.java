package com.baidu.android.imsdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.sync.SyncAllMessage;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.PaManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class DBVersionManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "com.baidu.android.imsdk.db.DBVersionManager";
    public static DBVersionManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    /* loaded from: classes.dex */
    public interface VersionHandler {
        void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

        void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1263161730, "Lcom/baidu/android/imsdk/db/DBVersionManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1263161730, "Lcom/baidu/android/imsdk/db/DBVersionManager;");
        }
    }

    /* loaded from: classes.dex */
    public class DefaultHandler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public DefaultHandler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
                this.this$0.createDb(sQLiteDatabase);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                this.this$0.createDb(sQLiteDatabase);
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version21And22Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version21And22Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN msg_key TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN sendid TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN buid TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_DAILOG_RECORD);
                    sQLiteDatabase.execSQL("ALTER TABLE userinfo ADD COLUMN buid LONG  DEFAULT -1");
                    sQLiteDatabase.execSQL("ALTER TABLE userinfo ADD COLUMN disturb INTEGER DEFAULT 0");
                    sQLiteDatabase.execSQL("ALTER TABLE userinfo ADD COLUMN blacklist INTEGER DEFAULT 0");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN detail TEXT DEFAULT ''");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN tpl LONG DEFAULT -1");
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:21->22", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version22And223Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version22And223Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN disturb INTEGER DEFAULT 0");
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:22->23", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version22And23Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version22And23Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN disturb INTEGER DEFAULT 0");
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:22->23", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version23And24Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version23And24Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }
    }

    /* loaded from: classes.dex */
    public class Version24And25Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version24And25Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN pasubtype INTEGER DEFAULT -1 ");
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:24->25", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version25And26Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version25And26Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                LogUtils.d(DBVersionManager.TAG, "onUpgrade:25->26");
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version26And27Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version26And27Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN classtype INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN classshow INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN classtitle TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN classavatar TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN classtype INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN classshow INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN classtitle TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN classavatar TEXT DEFAULT '' ");
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:26->27", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version28And29Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version28And29Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version28And29Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, "status")) {
                        sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN status INTEGER DEFAULT 0");
                    }
                    PaManager.delPaLocalInfosByPaType(this.this$0.mContext, 5);
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:28->29", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version29And30Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version29And30Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version29And30Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "marktop")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN marktop INTEGER DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "marktoptime")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN marktoptime LONG ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, "marktop")) {
                        sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN marktop INTEGER DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, "marktoptime")) {
                        sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN marktoptime LONG ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:29->30", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version30And31Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version30And31Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version30And31Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "nickname")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN nickname TEXT ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:30->31", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version31And32Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version31And32Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version31And32Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, TableDefine.PaSubscribeColumns.COLUMN_REPLIES)) {
                        sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN replies TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, TableDefine.PaSubscribeColumns.COLUMN_REFRESH_TIME)) {
                        sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN refreshtime LONG DEFAULT 0 ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:31->32", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version32And33Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version32And33Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version32And33Handler---");
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:32->33", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version33And34Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version33And34Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version33And34Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, TableDefine.PaSubscribeColumns.COLUMN_SUBSET_TYPE)) {
                        sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN subset_type  INTEGER DEFAULT 0  ");
                    }
                    PaManager.delPaLocalInfosByPaType(this.this$0.mContext, 16);
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:33->34", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version34And35Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version34And35Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version34And35Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "message", "expires_time")) {
                        sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN expires_time  LONG DEFAULT 0  ");
                    }
                    ChatMessageDBManager.getInstance(this.this$0.mContext).delChatRecordForChatType(6);
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:34->35", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version35And36Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version35And36Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version35And36Handler---");
                    if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_RELIABLE_MESSAGE)) {
                        sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_RELIABLE_MESSAGE);
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:35->36", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version36And37Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version36And37Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version36And37Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "extra")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN extra TEXT ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:36->37", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version37And38Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version37And38Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkTableExists(sQLiteDatabase, "message")) {
                        sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MESSAGE_INDEX);
                    }
                    LogUtils.d(DBVersionManager.TAG, "Version37And38Handler create msg index ok");
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:37->38", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version38And39Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version38And39Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkTableExists(sQLiteDatabase, "message")) {
                        sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MESSAGE_QUERY_MSGID_ISEXIST_INDEX);
                        sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MESSAGE_QUERY_MSGKEY_ISEXIST_INDEX);
                    }
                    LogUtils.d(DBVersionManager.TAG, "Version38And39Handler create msg index ok");
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:38->39", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version39And40Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version39And40Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, TableDefine.PaSubscribeColumns.COLUMN_PA_EXT)) {
                        sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN pa_ext  TEXT ");
                    }
                    LogUtils.d(DBVersionManager.TAG, "Version39And40Handler add pa_ext");
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:39->40", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version40And41Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version40And41Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version40And41Handler---");
                    if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_NO_DUPLICATE_MESSAGE)) {
                        sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_DUPLICATE_MESSAGE);
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:40->41", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version41And42Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version41And42Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x012a, code lost:
            if (r9 != null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0137, code lost:
            if (r9 == null) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0139, code lost:
            r9.endTransaction();
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x013c, code lost:
            com.baidu.android.imsdk.pubaccount.PaManager.delPaLocalInfosByPaType(r8.this$0.mContext, 19);
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x0147, code lost:
            return;
         */
        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    try {
                        LogUtils.d(DBVersionManager.TAG, "---Version41And42Handler---");
                        sQLiteDatabase.beginTransaction();
                        if (this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_USERINFO)) {
                            sQLiteDatabase.execSQL("ALTER TABLE userinfo RENAME TO userinfo_temp");
                        }
                        if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_USERINFO)) {
                            sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_USERINFO);
                        }
                        if (this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_USERINFO)) {
                            sQLiteDatabase.execSQL(TableDefine.SQL_COPY_TABLE_USERINFO);
                        }
                        if (this.this$0.checkTableExists(sQLiteDatabase, "userinfo_temp")) {
                            sQLiteDatabase.execSQL("DROP TABLE userinfo_temp");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, "v_portrait")) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN v_portrait  TEXT DEFAULT '' ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, "vip_id")) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN vip_id  TEXT DEFAULT '' ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, "identity")) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN identity  TEXT DEFAULT '' ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, TableDefine.PaSubscribeColumns.COLUMN_HAS_IDENTITY)) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN has_identity INTEGER DEFAULT 0 ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, "shield")) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN shield  INTEGER DEFAULT 0 ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, "shield_time")) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN shield_time  LONG DEFAULT 0 ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, TableDefine.PaSubscribeColumns.COLUMN_THIRD_EXT)) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN third_ext  TEXT DEFAULT '' ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE)) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN subscribe  INTEGER DEFAULT 0 ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "v_portrait")) {
                            sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN v_portrait  TEXT DEFAULT '' ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "vip_id")) {
                            sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN vip_id  TEXT DEFAULT '' ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "certification")) {
                            sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN certification  TEXT DEFAULT '' ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "shield")) {
                            sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN shield  INTEGER DEFAULT 0 ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "shield_time")) {
                            sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN shield_time  LONG DEFAULT 0 ");
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Exception e) {
                        LogUtils.e(DBVersionManager.TAG, "onUpgrade:41->42", e);
                    }
                } catch (Throwable th) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version42And43Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version42And43Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "message", TableDefine.MessageColumns.COLUME_SERVICE_TYPE)) {
                        sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN service_type TEXT ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:42->43", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version43And44Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version43And44Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "message", "tips_code")) {
                        sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN tips_code INTEGER ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "message", "tips")) {
                        sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN tips TEXT ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:43->44", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version44And45Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version44And45Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_USERINFO, TableDefine.UserInfoColumns.COLUMN_USER_EXT)) {
                        sQLiteDatabase.execSQL("ALTER TABLE userinfo ADD COLUMN user_ext TEXT ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:44->45", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version45And46Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version45And46Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "message", "template_type")) {
                        sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN template_type INTEGER DEFAULT 0 ");
                    }
                    if (AccountManager.getAppid(this.this$0.mContext) == Constants.APPID_BAIDU) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBTYPE, (Integer) 29);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("chat_type", (Integer) 29);
                        if (Constants.getEnv(this.this$0.mContext) == 0) {
                            if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE)) {
                                sQLiteDatabase.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, contentValues, "paid = ?", new String[]{Long.toString(17592194956492L)});
                                sQLiteDatabase.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, contentValues, "paid = ?", new String[]{Long.toString(17592195132261L)});
                            }
                            if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION)) {
                                sQLiteDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues2, "paid = ?", new String[]{Long.toString(17592194956492L)});
                                sQLiteDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues2, "paid = ?", new String[]{Long.toString(17592195132261L)});
                                return;
                            }
                            return;
                        }
                        if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE)) {
                            sQLiteDatabase.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, contentValues, "paid = ?", new String[]{Long.toString(17592186059247L)});
                            sQLiteDatabase.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, contentValues, "paid = ?", new String[]{Long.toString(17592186061416L)});
                        }
                        if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION)) {
                            sQLiteDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues2, "paid = ?", new String[]{Long.toString(17592186059247L)});
                            sQLiteDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues2, "paid = ?", new String[]{Long.toString(17592186061416L)});
                        }
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:45->46", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version46And47Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version46And47Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version46And47Handler---");
                    if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_STUDIO_USE_PA_MESSAGE)) {
                        sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_STUDIO_USE_PA_MESSAGE);
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:46->47", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version48And49Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version48And49Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, TableDefine.PaSubscribeColumns.COLUMN_REJECT_MENU)) {
                        sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN has_reject_menu INTEGER DEFAULT 0 ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:48->49", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version49And50Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version49And50Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "last_msg_bduid")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN last_msg_bduid LONG DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "last_msg_name")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN last_msg_name TEXT ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:48->49", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version50And51Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version50And51Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version50And51Handler---");
                    if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_SESSION)) {
                        sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_BUSINESS_SESSION);
                    }
                    if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_CHAT_MSG)) {
                        sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_BUSINESS_MESSAGE);
                    }
                    if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_DIALOGUEID)) {
                        sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_BUSINESS_DIALOGUEID);
                    }
                    if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG)) {
                        sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_BUSINESS_ADV_SESSION);
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:50->51", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version51And52Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version51And52Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version50And51Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_ALLOW_REFUND_STATUS)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN allow_refund INTEGER DEFAULT -1 ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:51->52", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version52And53Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version52And53Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version52And53Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_SESSION, TableDefine.BusiSessionColumns.COLUMN_LAST_MSG_DESC)) {
                        sQLiteDatabase.execSQL("ALTER TABLE busisession ADD COLUMN last_msg_desc TEXT ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:52->53", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version53And54Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version53And54Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version53And54Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "message", "send_type")) {
                        sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN send_type INTEGER DEFAULT -1 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, "message", "send_scene")) {
                        sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN send_scene INTEGER DEFAULT -1 ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:53->54", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version54And55Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version54And55Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version54And55Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_CHAT_MSG, "logic_del")) {
                        sQLiteDatabase.execSQL("ALTER TABLE busisessmsg ADD COLUMN logic_del INTEGER DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_SESSION, TableDefine.BusiSessionColumns.COLUMN_DRAFT)) {
                        sQLiteDatabase.execSQL("ALTER TABLE busisession ADD COLUMN msg_draft TEXT ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:54->55", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version55And56Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version55And56Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version55And56Handler---");
                    if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_AD_BTN_SHOW)) {
                        sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_BUSINESS_ADV_AD_BTN_SHOW_INFO);
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_SESSION, TableDefine.BusiSessionColumns.COLUMN_STATUS_SHOW)) {
                        sQLiteDatabase.execSQL("ALTER TABLE busisession ADD COLUMN last_dialogue_status_show TEXT ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:55->56", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version56And57Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version56And57Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version56And57Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_SESSION, "classtype")) {
                        sQLiteDatabase.execSQL("ALTER TABLE busisession ADD COLUMN classtype INTEGER DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_SESSION, "classshow")) {
                        sQLiteDatabase.execSQL("ALTER TABLE busisession ADD COLUMN classshow INTEGER DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_SESSION, "classtitle")) {
                        sQLiteDatabase.execSQL("ALTER TABLE busisession ADD COLUMN classtitle TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_SESSION, "classavatar")) {
                        sQLiteDatabase.execSQL("ALTER TABLE busisession ADD COLUMN classavatar TEXT ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:56->57", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version57And58Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version57And58Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version57And58Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_REFUND_URL_TEXT)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN refund_url_text TEXT ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:57->58", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version58And59Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version58And59Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            SQLiteDatabase sQLiteDatabase2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version58And59Handler---");
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "disturb")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN disturb INTEGER DEFAULT 0");
                    }
                    if (this.this$0.mContext == null) {
                        return;
                    }
                    DBOperation newDb = DBOperationFactory.getNewDb(this.this$0.mContext);
                    Cursor cursor = null;
                    if (newDb != null) {
                        sQLiteDatabase2 = newDb.openDb();
                    } else {
                        sQLiteDatabase2 = null;
                    }
                    if (sQLiteDatabase2 == null) {
                        return;
                    }
                    try {
                        cursor = sQLiteDatabase2.query("groupinfo", new String[]{"group_id"}, "group_type = ? OR (group_type = ? AND group_sub_type = ? )", new String[]{String.valueOf(1), String.valueOf(3), String.valueOf(0)}, null, null, null, null);
                        if (cursor != null) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("disturb", (Integer) 1);
                            while (cursor.moveToNext()) {
                                long j = CursorWrapper.getLong(cursor, "group_id");
                                if (j > 0) {
                                    sQLiteDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues, "contacter = ? ", new String[]{String.valueOf(j)});
                                }
                            }
                        }
                        if (cursor == null) {
                            return;
                        }
                    } catch (Exception e) {
                        LogUtils.e(DBVersionManager.TAG, "getLatestMsg:", e);
                        if (cursor == null) {
                            return;
                        }
                    }
                    cursor.close();
                } catch (Exception e2) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:58->59", e2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version59And60Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version59And60Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    String str = DBVersionManager.TAG;
                    LogUtils.d(str, "onUpgrade:59->60  newVersion:" + i2);
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, "business_type")) {
                        sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN business_type INTEGER DEFAULT 0 ");
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("business_type", (Integer) 27);
                    int update = sQLiteDatabase.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, contentValues, "pa_ext LIKE ? ", new String[]{"%\"business_type\":27%"});
                    String str2 = DBVersionManager.TAG;
                    LogUtils.d(str2, "数据库升级更新结果影响行:" + update);
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:59->60", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version60And61Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version60And61Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, INVOKE, IF, INVOKE, IF, INVOKE, INVOKE, IF, INVOKE] complete} */
        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                LogUtils.d(DBVersionManager.TAG, "---Version60And61Handler---");
                Cursor cursor = null;
                try {
                    try {
                        sQLiteDatabase.beginTransaction();
                        if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION)) {
                            sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_MEDIA_CHAT_SESSION);
                        }
                        if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_MESSAGE)) {
                            sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_MEDIA_MESSAGE);
                        }
                        if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_DRAFT_MESSAGE)) {
                            sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_MEDIA_DRAFT_MESSAGE);
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "is_stranger")) {
                            sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN is_stranger INTEGER DEFAULT 0");
                        }
                        cursor = sQLiteDatabase.rawQuery("SELECT uid FROM userinfo WHERE has_special_identity = 0 AND (subscribe_status = 0 OR subscribe_status = 2)", null);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("is_stranger", (Integer) 1);
                        while (cursor != null && cursor.moveToNext()) {
                            sQLiteDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues, "category = ? AND contacter = ? AND is_stranger != ?", new String[]{String.valueOf(0), String.valueOf(CursorWrapper.getLong(cursor, "uid")), String.valueOf(1)});
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, TableDefine.PaSubscribeColumns.COLUMN_PA_BDUID)) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN pa_bduid LONG ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, TableDefine.PaSubscribeColumns.COLUMN_PA_IMUK)) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN pa_imuk LONG ");
                        }
                        if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION)) {
                            sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MEDIA_SESSION_QUERY_INDEX);
                            sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MEDIA_SESSION_MODE_QUERY_INDEX);
                        }
                        if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_MESSAGE)) {
                            sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MEDIA_MESSAGE_QUERY_MSGID_INDEX);
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (!sQLiteDatabase.inTransaction()) {
                            return;
                        }
                    } catch (Exception e) {
                        LogUtils.e(DBVersionManager.TAG, "onUpgrade:59->60", e);
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        if (!sQLiteDatabase.inTransaction()) {
                            return;
                        }
                    }
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version61And62Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version61And62Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    String str = DBVersionManager.TAG;
                    LogUtils.d(str, "onUpgrade:61->62  newVersion:" + i2);
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION, TableDefine.MediaSessionColumns.COLUMN_CONTACTER_IMUK)) {
                        sQLiteDatabase.execSQL("ALTER TABLE media_session ADD COLUMN imuk LONG ");
                    }
                    if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION)) {
                        sQLiteDatabase.delete(TableDefine.DB_TABLE_MEDIA_SESSION, null, null);
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:61->62", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version62And63Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version62And63Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    String str = DBVersionManager.TAG;
                    LogUtils.d(str, "onUpgrade:62->63  newVersion:" + i2);
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_SESSION, "subscribe_status")) {
                        sQLiteDatabase.execSQL("ALTER TABLE busisession ADD COLUMN subscribe_status INTEGER DEFAULT 0");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:62->63", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version63And64Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version63And64Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    try {
                        sQLiteDatabase.beginTransaction();
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_MESSAGE, "origin_pa")) {
                            sQLiteDatabase.execSQL("ALTER TABLE media_message ADD COLUMN origin_pa TEXT DEFAULT '' ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_MESSAGE, "template_type")) {
                            sQLiteDatabase.execSQL("ALTER TABLE media_message ADD COLUMN template_type INTEGER DEFAULT 0 ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, "message", "origin_pa")) {
                            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN origin_pa TEXT DEFAULT '' ");
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        if (!sQLiteDatabase.inTransaction()) {
                            return;
                        }
                    } catch (Exception e) {
                        LogUtils.e(DBVersionManager.TAG, "onUpgrade:63->64", e);
                        if (!sQLiteDatabase.inTransaction()) {
                            return;
                        }
                    }
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version64And65Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version64And65Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    try {
                        sQLiteDatabase.beginTransaction();
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, TableDefine.PaSubscribeColumns.COLUMN_SHIELD_MSG)) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN shield_msg INTEGER DEFAULT 0 ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, "map_type")) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN map_type INTEGER DEFAULT -1 ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "map_type")) {
                            sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN map_type INTEGER DEFAULT -1 ");
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        if (!sQLiteDatabase.inTransaction()) {
                            return;
                        }
                    } catch (Exception e) {
                        LogUtils.e(DBVersionManager.TAG, "onUpgrade:64->65", e);
                        if (!sQLiteDatabase.inTransaction()) {
                            return;
                        }
                    }
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version65And66Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version65And66Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                Cursor cursor = null;
                try {
                    try {
                        LogUtils.d(DBVersionManager.TAG, "onUpgrade:65->66");
                        if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_MESSAGE_WITH_TAG)) {
                            sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_MESSAGE_TAG);
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_SESSION, TableDefine.BusiSessionColumns.COLUMN_COLLECT_STATUS)) {
                            sQLiteDatabase.execSQL("ALTER TABLE busisession ADD COLUMN collect_status INTEGER DEFAULT 0");
                        }
                        if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION)) {
                            sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_MEDIA_CHAT_SESSION);
                            sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MEDIA_SESSION_QUERY_INDEX);
                            sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MEDIA_SESSION_MODE_QUERY_INDEX);
                        }
                        if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_MESSAGE)) {
                            sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_MEDIA_MESSAGE);
                            sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MEDIA_MESSAGE_QUERY_MSGID_INDEX);
                        }
                        if (!this.this$0.checkTableExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_DRAFT_MESSAGE)) {
                            sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_MEDIA_DRAFT_MESSAGE);
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "is_stranger")) {
                            sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN is_stranger INTEGER DEFAULT 0");
                            cursor = sQLiteDatabase.rawQuery("SELECT uid FROM userinfo WHERE has_special_identity = 0 AND (subscribe_status = 0 OR subscribe_status = 2)", null);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_stranger", (Integer) 1);
                            while (cursor != null && cursor.moveToNext()) {
                                sQLiteDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues, "category = ? AND contacter = ? AND is_stranger != ?", new String[]{String.valueOf(0), String.valueOf(CursorWrapper.getLong(cursor, "uid")), String.valueOf(1)});
                            }
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, TableDefine.PaSubscribeColumns.COLUMN_PA_BDUID)) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN pa_bduid LONG ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, TableDefine.PaSubscribeColumns.COLUMN_PA_IMUK)) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN pa_imuk LONG ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_SESSION, "subscribe_status")) {
                            sQLiteDatabase.execSQL("ALTER TABLE busisession ADD COLUMN subscribe_status INTEGER DEFAULT 0");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_MESSAGE, "origin_pa")) {
                            sQLiteDatabase.execSQL("ALTER TABLE media_message ADD COLUMN origin_pa TEXT DEFAULT '' ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_MESSAGE, "template_type")) {
                            sQLiteDatabase.execSQL("ALTER TABLE media_message ADD COLUMN template_type INTEGER DEFAULT 0 ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, "message", "origin_pa")) {
                            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN origin_pa TEXT DEFAULT '' ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, TableDefine.PaSubscribeColumns.COLUMN_SHIELD_MSG)) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN shield_msg INTEGER DEFAULT 0 ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, "map_type")) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN map_type INTEGER DEFAULT -1 ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "map_type")) {
                            sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN map_type INTEGER DEFAULT -1 ");
                        }
                        LogUtils.d(DBVersionManager.TAG, "onUpgrade:65->66 TransactionSuccessful");
                        if (cursor == null || cursor.isClosed()) {
                            return;
                        }
                    } catch (Exception e) {
                        LogUtils.e(DBVersionManager.TAG, "onUpgrade:65->66", e);
                        if (cursor == null || cursor.isClosed()) {
                            return;
                        }
                    }
                    cursor.close();
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version67And68Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version67And68Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_TYPE)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN eva_type INTEGER DEFAULT -1 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_TITLE)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN eva_title TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_SUBTITLE)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN eva_subtitle TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_TAG_LIST)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN eva_tag_list TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_CARD_TIP)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN cardTip TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_SOP_TITLE)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN sopTitle TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_SOP_LIST)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN sopList TEXT ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:67->68", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version69And70Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version69And70Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "remind_type")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN remind_type INTEGER DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "remind_msgid")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN remind_msgid LONG DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION, "remind_type")) {
                        sQLiteDatabase.execSQL("ALTER TABLE media_session ADD COLUMN remind_type INTEGER DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION, "remind_msgid")) {
                        sQLiteDatabase.execSQL("ALTER TABLE media_session ADD COLUMN remind_msgid LONG DEFAULT 0 ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:69->70", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version70And71Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version70And71Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "remind_uid")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN remind_uid LONG DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "remind_role_display_name")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN remind_role_display_name TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION, "remind_uid")) {
                        sQLiteDatabase.execSQL("ALTER TABLE media_session ADD COLUMN remind_uid LONG DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION, "remind_role_display_name")) {
                        sQLiteDatabase.execSQL("ALTER TABLE media_session ADD COLUMN remind_role_display_name TEXT ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:70->71", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version72And73Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version72And73Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_TYPE)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN eva_type INTEGER DEFAULT -1 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_TITLE)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN eva_title TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_SUBTITLE)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN eva_subtitle TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_EVA_TAG_LIST)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN eva_tag_list TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_CARD_TIP)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN cardTip TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_SOP_TITLE)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN sopTitle TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_BUSINESS_ADVISORY_CUSTOM_MSG, TableDefine.BusiAdvCustomMsgColumns.COLUMN_SOP_LIST)) {
                        sQLiteDatabase.execSQL("ALTER TABLE advisory_custom_msg ADD COLUMN sopList TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "remind_type")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN remind_type INTEGER DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "remind_msgid")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN remind_msgid LONG DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION, "remind_type")) {
                        sQLiteDatabase.execSQL("ALTER TABLE media_session ADD COLUMN remind_type INTEGER DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION, "remind_msgid")) {
                        sQLiteDatabase.execSQL("ALTER TABLE media_session ADD COLUMN remind_msgid LONG DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "remind_uid")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN remind_uid LONG DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "remind_role_display_name")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN remind_role_display_name TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION, "remind_uid")) {
                        sQLiteDatabase.execSQL("ALTER TABLE media_session ADD COLUMN remind_uid LONG DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION, "remind_role_display_name")) {
                        sQLiteDatabase.execSQL("ALTER TABLE media_session ADD COLUMN remind_role_display_name TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION, "extra")) {
                        sQLiteDatabase.execSQL("ALTER TABLE media_session ADD COLUMN extra TEXT ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:72->73", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version73And74Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version73And74Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "highlight_desc")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN highlight_desc TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "last_msgid_from_me")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN last_msgid_from_me LONG DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "highlight_priority")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN highlight_priority INTEGER DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_CHAT_SESSION, "highlight_data_id")) {
                        sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN highlight_data_id INTEGER DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION, "last_msgid_from_me")) {
                        sQLiteDatabase.execSQL("ALTER TABLE media_session ADD COLUMN last_msgid_from_me LONG DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION, "highlight_desc")) {
                        sQLiteDatabase.execSQL("ALTER TABLE media_session ADD COLUMN highlight_desc TEXT ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION, "highlight_priority")) {
                        sQLiteDatabase.execSQL("ALTER TABLE media_session ADD COLUMN highlight_priority INTEGER DEFAULT 0 ");
                    }
                    if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_SESSION, "highlight_data_id")) {
                        sQLiteDatabase.execSQL("ALTER TABLE media_session ADD COLUMN highlight_data_id INTEGER DEFAULT 0 ");
                    }
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:73->74", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version74And75Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version74And75Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    LogUtils.d(DBVersionManager.TAG, "onUpgrade:74->75");
                    new Version65And66Handler(this.this$0).onUpgrade(sQLiteDatabase, i, i2);
                    new Version72And73Handler(this.this$0).onUpgrade(sQLiteDatabase, i, i2);
                    new Version73And74Handler(this.this$0).onUpgrade(sQLiteDatabase, i, i2);
                } catch (Exception e) {
                    LogUtils.e(DBVersionManager.TAG, "onUpgrade:74->75", e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version77And78Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version77And78Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    try {
                        sQLiteDatabase.beginTransaction();
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_PA_SUBSCRIBE, TableDefine.PaSubscribeColumns.COLUMN_BLOCK_INFO)) {
                            sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN pa_blockinfo TEXT ");
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        if (!sQLiteDatabase.inTransaction()) {
                            return;
                        }
                    } catch (Exception e) {
                        LogUtils.e(DBVersionManager.TAG, "onUpgrade:77->78", e);
                        if (!sQLiteDatabase.inTransaction()) {
                            return;
                        }
                    }
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class Version78And79Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i, i2) == null) {
            }
        }

        public Version78And79Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, INVOKE, IF] complete} */
        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                try {
                    try {
                        sQLiteDatabase.beginTransaction();
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, "message", "auto_risk_control_status")) {
                            sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN auto_risk_control_status INTEGER DEFAULT 0 ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MESSAGE_WITH_TAG, "auto_risk_control_status")) {
                            sQLiteDatabase.execSQL("ALTER TABLE message_tag ADD COLUMN auto_risk_control_status INTEGER DEFAULT 0 ");
                        }
                        if (!this.this$0.checkColumnExists(sQLiteDatabase, TableDefine.DB_TABLE_MEDIA_MESSAGE, "auto_risk_control_status")) {
                            sQLiteDatabase.execSQL("ALTER TABLE media_message ADD COLUMN auto_risk_control_status INTEGER DEFAULT 0 ");
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        if (!sQLiteDatabase.inTransaction()) {
                            return;
                        }
                    } catch (Exception e) {
                        LogUtils.e(DBVersionManager.TAG, "onUpgrade:78->79", e);
                        if (!sQLiteDatabase.inTransaction()) {
                            return;
                        }
                    }
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                    throw th;
                }
            }
        }
    }

    public DBVersionManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createDb(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, sQLiteDatabase) == null) {
            if (dropTable(sQLiteDatabase) < 0) {
                LogUtils.e(TAG, "drop table db failed when db upgrade or downgrade!");
            } else if (createTable(sQLiteDatabase) < 0) {
                LogUtils.e(TAG, "create table db failed when db upgrade or downgrade!");
            }
        }
    }

    public static DBVersionManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            synchronized (DBVersionManager.class) {
                if (mInstance == null) {
                    mInstance = new DBVersionManager(context);
                }
            }
            return mInstance;
        }
        return (DBVersionManager) invokeL.objValue;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
            createDb(sQLiteDatabase);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00b4, code lost:
        if (r5 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00b7, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int createTable(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, sQLiteDatabase)) == null) {
            int i = -1;
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_MESSAGE);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_USERINFO);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_CHAT_SESSION);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_GROUPINFO);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_GROUP_MEMBER);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_FRIEND_GROUP);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_PA_SUBSCRIBE);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_PA_CMD_QUEUE);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_FRIEND_REALTION);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_ZHIDAINFO);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_DAILOG_RECORD);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_RELIABLE_MESSAGE);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_DUPLICATE_MESSAGE);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MESSAGE_INDEX);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MESSAGE_QUERY_MSGID_ISEXIST_INDEX);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MESSAGE_QUERY_MSGKEY_ISEXIST_INDEX);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_STUDIO_USE_PA_MESSAGE);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_BUSINESS_SESSION);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_BUSINESS_MESSAGE);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_BUSINESS_DIALOGUEID);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_BUSINESS_ADV_SESSION);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_BUSINESS_ADV_AD_BTN_SHOW_INFO);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_MEDIA_MESSAGE);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_MEDIA_CHAT_SESSION);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_MEDIA_DRAFT_MESSAGE);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MEDIA_SESSION_QUERY_INDEX);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MEDIA_SESSION_MODE_QUERY_INDEX);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MEDIA_MESSAGE_QUERY_MSGID_INDEX);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_MESSAGE_TAG);
                    i = 0;
                    sQLiteDatabase.setTransactionSuccessful();
                    LogUtils.d(TAG, "create table ok");
                } catch (Exception e) {
                    LogUtils.e(TAG, "createTable:", e);
                }
            } finally {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        } else {
            return invokeL.intValue;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00c3, code lost:
        if (r6 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00c6, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int dropTable(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, sQLiteDatabase)) == null) {
            int i = -1;
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS message");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS userinfo");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS chatrecord");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS groupinfo");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS groupmember");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS friendgroup");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS paSubscribe");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS paCmdQueue");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS friendrelation");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS crash");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS zhida_info");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS dialog_record");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS stat_log");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS liveroom_message");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS duplicate_message");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS media_session");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS media_message");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS media_draft_msg");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS message_tag");
                    Utility.clearCache(this.mContext);
                    SyncAllMessage.getInstance(this.mContext).clearCache();
                    Utility.writeIntData(this.mContext, Utility.getJumpToRecentKey(this.mContext), 1);
                    Context context = this.mContext;
                    Utility.writeLongData(context, Constants.KEY_PA_SUBSCRIBE_SYNC_TIME + AccountManager.getAppid(this.mContext) + AccountManager.getUid(this.mContext), -1L);
                    i = 0;
                    sQLiteDatabase.setTransactionSuccessful();
                    LogUtils.d(TAG, "drop table ok");
                } catch (Exception e) {
                    LogUtils.e(TAG, "dropTable:", e);
                }
            } finally {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        } else {
            return invokeL.intValue;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
        if (r2.isClosed() == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkColumnExists(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, sQLiteDatabase, str, str2)) == null) {
            boolean z = false;
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("select * from sqlite_master where name = ? and sql like ?", new String[]{str, "%" + str2 + "%"});
                    if (cursor != null) {
                        if (cursor.moveToFirst()) {
                            z = true;
                        }
                    }
                } catch (Exception e) {
                    String str3 = TAG;
                    LogUtils.e(str3, "checkColumnExists..." + e.getMessage());
                    if (cursor != null) {
                    }
                }
                return z;
            } finally {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
        if (r1.isClosed() != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkTableExists(SQLiteDatabase sQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, str)) == null) {
            boolean z = false;
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("select count(*) from sqlite_master where type ='table' and  name = ?", new String[]{str});
                    if (cursor != null && cursor.moveToFirst()) {
                        if (cursor.getInt(0) > 0) {
                            z = true;
                        }
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        return z;
                    }
                    return false;
                } catch (Exception e) {
                    String str2 = TAG;
                    LogUtils.e(str2, "checkColumnExists..." + e.getMessage());
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048579, this, sQLiteDatabase, i, i2) != null) || i == i2) {
            return;
        }
        if (i == 22 && i2 <= 21) {
            new Version21And22Handler(this).onDowngrade(sQLiteDatabase, i, i2);
            i = 21;
        }
        if (i == 21 && i2 <= 20) {
            new DefaultHandler(this).onDowngrade(sQLiteDatabase, i, i2);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048580, this, sQLiteDatabase, i, i2) != null) || i == i2) {
            return;
        }
        if (i2 >= 21 && i > 12) {
            if (i == 21 && i2 >= 22) {
                new Version21And22Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 22;
            }
            if (i == 22 && i2 >= 23) {
                new Version22And223Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 23;
            }
            if (i == 23 && i2 >= 24) {
                new Version23And24Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 24;
            }
            if (i == 24 && i2 >= 25) {
                new Version24And25Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 25;
            }
            if (i == 25 && i2 >= 26) {
                new Version25And26Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 26;
            }
            if (i == 26 && i2 >= 27) {
                new Version26And27Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 27;
            }
            if (i == 28 && i2 >= 29) {
                new Version28And29Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 29;
            }
            if (i == 29 && i2 >= 30) {
                new Version29And30Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 30;
            }
            if (i == 30 && i2 >= 31) {
                new Version30And31Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 31;
            }
            if (i == 31 && i2 >= 32) {
                new Version31And32Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 32;
            }
            if (i == 32 && i2 >= 33) {
                new Version32And33Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 33;
            }
            if (i == 33 && i2 >= 34) {
                new Version33And34Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 34;
            }
            if (i == 34 && i2 >= 35) {
                new Version34And35Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 35;
            }
            if (i == 35 && i2 >= 36) {
                new Version35And36Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 36;
            }
            if (i == 36 && i2 >= 37) {
                new Version36And37Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 37;
            }
            if (i == 37 && i2 >= 38) {
                new Version37And38Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 38;
            }
            if (i == 38 && i2 >= 39) {
                new Version38And39Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 39;
            }
            if (i == 39 && i2 >= 40) {
                new Version39And40Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 40;
            }
            if (i == 40 && i2 >= 41) {
                new Version40And41Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 41;
            }
            if (i == 41 && i2 >= 42) {
                new Version41And42Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 42;
            }
            if (i == 42 && i2 >= 43) {
                new Version42And43Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 43;
            }
            if (i == 43 && i2 >= 44) {
                new Version43And44Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 44;
            }
            if (i == 44 && i2 >= 45) {
                new Version44And45Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 45;
            }
            if (i == 45 && i2 >= 46) {
                new Version45And46Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 46;
            }
            if (i == 46 && i2 >= 47) {
                new Version46And47Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 47;
            }
            if (i <= 48 && i2 >= 49) {
                new Version48And49Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 49;
            }
            if (i <= 49 && i2 >= 50) {
                new Version49And50Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 50;
            }
            if (i <= 50 && i2 >= 51) {
                new Version50And51Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 51;
            }
            if (i <= 51 && i2 >= 52) {
                new Version51And52Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 52;
            }
            if (i <= 52 && i2 >= 53) {
                new Version52And53Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 53;
            }
            if (i <= 53 && i2 >= 54) {
                new Version53And54Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 54;
            }
            if (i <= 54 && i2 >= 55) {
                new Version54And55Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 55;
            }
            if (i <= 55 && i2 >= 56) {
                new Version55And56Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 56;
            }
            if (i <= 56 && i2 >= 57) {
                new Version56And57Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 57;
            }
            if (i <= 57 && i2 >= 58) {
                new Version57And58Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 58;
            }
            if (i <= 58 && i2 >= 59) {
                new Version58And59Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 59;
            }
            if (i <= 59 && i2 >= 60) {
                new Version59And60Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 60;
            }
            if (i <= 60 && i2 >= 61) {
                new Version60And61Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 61;
            }
            if (i <= 61 && i2 >= 62) {
                new Version61And62Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 62;
            }
            if (i <= 62 && i2 >= 63) {
                new Version62And63Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 63;
            }
            if (i == 63 && i2 >= 64) {
                new Version63And64Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 64;
            }
            if (i == 64 && i2 >= 65) {
                new Version64And65Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 65;
            }
            if (i <= 65 && i2 >= 66) {
                new Version65And66Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 66;
            }
            if (i <= 67 && i2 >= 68) {
                new Version67And68Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 68;
            }
            if (i <= 69 && i2 >= 70) {
                new Version69And70Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 70;
            }
            if (i <= 70 && i2 >= 71) {
                new Version70And71Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 71;
            }
            if (i <= 72 && i2 >= 73) {
                new Version72And73Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 73;
            }
            if (i <= 73 && i2 >= 74) {
                new Version73And74Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 74;
            }
            if (i <= 74 && i2 >= 75) {
                new Version74And75Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 75;
            }
            if (i <= 77 && i2 >= 78) {
                new Version77And78Handler(this).onUpgrade(sQLiteDatabase, i, i2);
                i = 78;
            }
            if (i <= 78 && i2 >= 79) {
                new Version78And79Handler(this).onUpgrade(sQLiteDatabase, i, i2);
            }
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("SELECT * FROM sqlite_master WHERE name='dialog_record' ", null);
                    if (cursor.getCount() == 0) {
                        createDb(sQLiteDatabase);
                    }
                    if (cursor == null) {
                        return;
                    }
                } catch (Exception unused) {
                    LogUtils.e(TAG, "database exception, check table dialog_record exist");
                    if (cursor == null) {
                        return;
                    }
                }
                try {
                    cursor.close();
                    return;
                } catch (Exception unused2) {
                    LogUtils.e(TAG, "close curse exception");
                    return;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused3) {
                        LogUtils.e(TAG, "close curse exception");
                    }
                }
                throw th;
            }
        }
        new DefaultHandler(this).onUpgrade(sQLiteDatabase, i, i2);
    }
}
