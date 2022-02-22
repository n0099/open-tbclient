package com.baidu.android.imsdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.sync.SyncAllMessage;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.PaManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class DBVersionManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "com.baidu.android.imsdk.db.DBVersionManager";
    public static DBVersionManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i2, i3) == null) {
                this.this$0.createDb(sQLiteDatabase);
            }
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) {
                this.this$0.createDb(sQLiteDatabase);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version21And22Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version21And22Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN msg_key TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN sendid TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN buid TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_DAILOG_RECORD);
                    sQLiteDatabase.execSQL("ALTER TABLE userinfo ADD COLUMN buid LONG  DEFAULT -1");
                    sQLiteDatabase.execSQL("ALTER TABLE userinfo ADD COLUMN disturb INTEGER DEFAULT 0");
                    sQLiteDatabase.execSQL("ALTER TABLE userinfo ADD COLUMN blacklist INTEGER DEFAULT 0");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN detail TEXT DEFAULT ''");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN tpl LONG DEFAULT -1");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:21->22", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version22And223Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version22And223Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN disturb INTEGER DEFAULT 0");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:22->23", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version22And23Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version22And23Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN disturb INTEGER DEFAULT 0");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:22->23", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version23And24Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version23And24Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version24And25Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version24And25Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN pasubtype INTEGER DEFAULT -1 ");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:24->25", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version25And26Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version25And26Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                LogUtils.d(LogUtils.TAG, "onUpgrade:25->26");
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version26And27Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version26And27Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN classtype INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN classshow INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN classtitle TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN classavatar TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN classtype INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN classshow INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN classtitle TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN classavatar TEXT DEFAULT '' ");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:26->27", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version28And29Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version28And29Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    LogUtils.d(DBVersionManager.TAG, "---Version28And29Handler---");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN status INTEGER DEFAULT 0");
                    PaManager.delPaLocalInfosByPaType(this.this$0.mContext, 5);
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:28->29", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version29And30Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version29And30Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    LogUtils.d(DBVersionManager.TAG, "---Version29And30Handler---");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN marktop INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN marktoptime LONG ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN marktop INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN marktoptime LONG ");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:29->30", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version30And31Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version30And31Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    LogUtils.d(DBVersionManager.TAG, "---Version30And31Handler---");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN nickname TEXT ");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:30->31", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version31And32Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version31And32Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    LogUtils.d(DBVersionManager.TAG, "---Version31And32Handler---");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN replies TEXT ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN refreshtime LONG DEFAULT 0 ");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:31->32", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version32And33Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version32And33Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    LogUtils.d(DBVersionManager.TAG, "---Version32And33Handler---");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:32->33", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version33And34Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version33And34Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    LogUtils.d(DBVersionManager.TAG, "---Version33And34Handler---");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN subset_type  INTEGER DEFAULT 0  ");
                    PaManager.delPaLocalInfosByPaType(this.this$0.mContext, 16);
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:33->34", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version34And35Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version34And35Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    LogUtils.d(DBVersionManager.TAG, "---Version34And35Handler---");
                    sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN expires_time  LONG DEFAULT 0  ");
                    ChatMessageDBManager.getInstance(this.this$0.mContext).delChatRecordForChatType(6);
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:34->35", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version35And36Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version35And36Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    LogUtils.d(DBVersionManager.TAG, "---Version35And36Handler---");
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_RELIABLE_MESSAGE);
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:35->36", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version36And37Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version36And37Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    LogUtils.d(DBVersionManager.TAG, "---Version36And37Handler---");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN extra TEXT ");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:36->37", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version37And38Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version37And38Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MESSAGE_INDEX);
                    LogUtils.d(DBVersionManager.TAG, "Version37And38Handler create msg index ok");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:37->38", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version38And39Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version38And39Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MESSAGE_QUERY_MSGID_ISEXIST_INDEX);
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_MESSAGE_QUERY_MSGKEY_ISEXIST_INDEX);
                    LogUtils.d(DBVersionManager.TAG, "Version38And39Handler create msg index ok");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:38->39", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version39And40Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version39And40Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN pa_ext  TEXT ");
                    LogUtils.d(DBVersionManager.TAG, "Version39And40Handler add pa_ext");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:39->40", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version40And41Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version40And41Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    LogUtils.d(DBVersionManager.TAG, "---Version40And41Handler---");
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_DUPLICATE_MESSAGE);
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:40->41", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version41And42Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version41And42Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
        }

        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, sQLiteDatabase, i2, i3) == null) {
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x00a9, code lost:
            if (r5 == null) goto L10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x00ab, code lost:
            r5.endTransaction();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x00ae, code lost:
            com.baidu.android.imsdk.pubaccount.PaManager.delPaLocalInfosByPaType(r4.this$0.mContext, 19);
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x00b9, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0086, code lost:
            if (r5 != null) goto L12;
         */
        @Override // com.baidu.android.imsdk.db.DBVersionManager.VersionHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) != null) {
                return;
            }
            try {
                try {
                    LogUtils.d(DBVersionManager.TAG, "---Version41And42Handler---");
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.execSQL("ALTER TABLE userinfo RENAME TO userinfo_temp");
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_TABLE_USERINFO);
                    sQLiteDatabase.execSQL(TableDefine.SQL_COPY_TABLE_USERINFO);
                    sQLiteDatabase.execSQL("DROP TABLE userinfo_temp");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN v_portrait  TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN vip_id  TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN identity  TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN has_identity INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN shield  INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN shield_time  LONG DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN third_ext  TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN subscribe  INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN v_portrait  TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN vip_id  TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN certification  TEXT DEFAULT '' ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN shield  INTEGER DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN shield_time  LONG DEFAULT 0 ");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:41->42", e2);
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                throw th;
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version42And43Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version42And43Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN service_type TEXT ");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:42->43", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version43And44Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version43And44Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN tips_code INTEGER ");
                    sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN tips TEXT ");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:43->44", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version44And45Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version44And45Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    sQLiteDatabase.execSQL("ALTER TABLE userinfo ADD COLUMN user_ext TEXT ");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:44->45", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version45And46Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version45And46Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    sQLiteDatabase.execSQL("ALTER TABLE message ADD COLUMN template_type INTEGER DEFAULT 0 ");
                    if (AccountManager.getAppid(this.this$0.mContext) == 405384) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(TableDefine.PaSubscribeColumns.COLUMN_SUBTYPE, (Integer) 29);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("chat_type", (Integer) 29);
                        if (Constants.getEnv(this.this$0.mContext) == 0) {
                            sQLiteDatabase.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, contentValues, "paid = ?", new String[]{Long.toString(17592194956492L)});
                            sQLiteDatabase.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, contentValues, "paid = ?", new String[]{Long.toString(17592195132261L)});
                            sQLiteDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues2, "paid = ?", new String[]{Long.toString(17592194956492L)});
                            sQLiteDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues2, "paid = ?", new String[]{Long.toString(17592195132261L)});
                            return;
                        }
                        sQLiteDatabase.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, contentValues, "paid = ?", new String[]{Long.toString(17592186059247L)});
                        sQLiteDatabase.update(TableDefine.DB_TABLE_PA_SUBSCRIBE, contentValues, "paid = ?", new String[]{Long.toString(17592186061416L)});
                        sQLiteDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues2, "paid = ?", new String[]{Long.toString(17592186059247L)});
                        sQLiteDatabase.update(TableDefine.DB_TABLE_CHAT_SESSION, contentValues2, "paid = ?", new String[]{Long.toString(17592186061416L)});
                    }
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:45->46", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version46And47Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version46And47Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    LogUtils.d(DBVersionManager.TAG, "---Version46And47Handler---");
                    sQLiteDatabase.execSQL(TableDefine.SQL_CREATE_STUDIO_USE_PA_MESSAGE);
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:46->47", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version48And49Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version48And49Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    sQLiteDatabase.execSQL("ALTER TABLE paSubscribe ADD COLUMN has_reject_menu INTEGER DEFAULT 0 ");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:48->49", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class Version49And50Handler implements VersionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DBVersionManager this$0;

        public Version49And50Handler(DBVersionManager dBVersionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dBVersionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = dBVersionManager;
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
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN last_msg_bduid LONG DEFAULT 0 ");
                    sQLiteDatabase.execSQL("ALTER TABLE chatrecord ADD COLUMN last_msg_name TEXT ");
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.this$0.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(LogUtils.TAG, "onUpgrade:48->49", e2);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface VersionHandler {
        void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3);

        void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3);
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

    public DBVersionManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    /* JADX WARN: Code restructure failed: missing block: B:12:0x008a, code lost:
        if (r5 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x008d, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int createTable(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65541, this, sQLiteDatabase)) != null) {
            return invokeL.intValue;
        }
        int i2 = -1;
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
                i2 = 0;
                sQLiteDatabase.setTransactionSuccessful();
                LogUtils.d(TAG, "create table ok");
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(LogUtils.TAG, "createTable:", e2);
            }
        } finally {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00c1, code lost:
        if (r6 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00c4, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int dropTable(SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65542, this, sQLiteDatabase)) != null) {
            return invokeL.intValue;
        }
        int i2 = -1;
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
                Utility.clearCache(this.mContext);
                SyncAllMessage.getInstance(this.mContext).clearCache();
                Utility.writeIntData(this.mContext, Utility.getJumpToRecentKey(this.mContext), 1);
                Context context = this.mContext;
                Utility.writeLongData(context, Constants.KEY_PA_SUBSCRIBE_SYNC_TIME + AccountManager.getAppid(this.mContext) + AccountManager.getUid(this.mContext), -1L);
                i2 = 0;
                sQLiteDatabase.setTransactionSuccessful();
                LogUtils.d(TAG, "drop table ok");
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(LogUtils.TAG, "dropTable:", e2);
            }
        } finally {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
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
        if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
            createDb(sQLiteDatabase);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) || i2 == i3) {
            return;
        }
        if (i2 == 22 && i3 <= 21) {
            new Version21And22Handler(this).onDowngrade(sQLiteDatabase, i2, i3);
            i2 = 21;
        }
        if (i2 != 21 || i3 > 20) {
            return;
        }
        new DefaultHandler(this).onDowngrade(sQLiteDatabase, i2, i3);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        IMTrack.CrashBuilder crashBuilder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, i2, i3) == null) || i2 == i3) {
            return;
        }
        if (i3 >= 21 && i2 > 12) {
            if (i2 == 21 && i3 >= 22) {
                new Version21And22Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 22;
            }
            if (i2 == 22 && i3 >= 23) {
                new Version22And223Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 23;
            }
            if (i2 == 23 && i3 >= 24) {
                new Version23And24Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 24;
            }
            if (i2 == 24 && i3 >= 25) {
                new Version24And25Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 25;
            }
            if (i2 == 25 && i3 >= 26) {
                new Version25And26Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 26;
            }
            if (i2 == 26 && i3 >= 27) {
                new Version26And27Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 27;
            }
            if (i2 == 28 && i3 >= 29) {
                new Version28And29Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 29;
            }
            if (i2 == 29 && i3 >= 30) {
                new Version29And30Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 30;
            }
            if (i2 == 30 && i3 >= 31) {
                new Version30And31Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 31;
            }
            if (i2 == 31 && i3 >= 32) {
                new Version31And32Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 32;
            }
            if (i2 == 32 && i3 >= 33) {
                new Version32And33Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 33;
            }
            if (i2 == 33 && i3 >= 34) {
                new Version33And34Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 34;
            }
            if (i2 == 34 && i3 >= 35) {
                new Version34And35Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 35;
            }
            if (i2 == 35 && i3 >= 36) {
                new Version35And36Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 36;
            }
            if (i2 == 36 && i3 >= 37) {
                new Version36And37Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 37;
            }
            if (i2 == 37 && i3 >= 38) {
                new Version37And38Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 38;
            }
            if (i2 == 38 && i3 >= 39) {
                new Version38And39Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 39;
            }
            if (i2 == 39 && i3 >= 40) {
                new Version39And40Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 40;
            }
            if (i2 == 40 && i3 >= 41) {
                new Version40And41Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 41;
            }
            if (i2 == 41 && i3 >= 42) {
                new Version41And42Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 42;
            }
            if (i2 == 42 && i3 >= 43) {
                new Version42And43Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 43;
            }
            if (i2 == 43 && i3 >= 44) {
                new Version43And44Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 44;
            }
            if (i2 == 44 && i3 >= 45) {
                new Version44And45Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 45;
            }
            if (i2 == 45 && i3 >= 46) {
                new Version45And46Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 46;
            }
            if (i2 == 46 && i3 >= 47) {
                new Version46And47Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 47;
            }
            if (i2 <= 48 && i3 >= 49) {
                new Version48And49Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
                i2 = 49;
            }
            if (i2 <= 49 && i3 >= 50) {
                new Version49And50Handler(this).onUpgrade(sQLiteDatabase, i2, i3);
            }
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("SELECT * FROM sqlite_master WHERE name='dialog_record' ", null);
                    if (cursor.getCount() == 0) {
                        createDb(sQLiteDatabase);
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                            return;
                        } catch (Exception e2) {
                            e = e2;
                            crashBuilder = new IMTrack.CrashBuilder(this.mContext);
                            crashBuilder.exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "close curse exception");
                            return;
                        }
                    }
                    return;
                } catch (Exception e3) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e3)).build();
                    LogUtils.e(TAG, "database exception, check table dialog_record exist");
                    if (cursor != null) {
                        try {
                            cursor.close();
                            return;
                        } catch (Exception e4) {
                            e = e4;
                            crashBuilder = new IMTrack.CrashBuilder(this.mContext);
                            crashBuilder.exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "close curse exception");
                            return;
                        }
                    }
                    return;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e5) {
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e5)).build();
                        LogUtils.e(TAG, "close curse exception");
                    }
                }
                throw th;
            }
        }
        new DefaultHandler(this).onUpgrade(sQLiteDatabase, i2, i3);
    }
}
