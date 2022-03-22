package com.baidu.sofire;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class BuildConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APPLICATION_ID = "com.baidu.sofire";
    public static final String APP_CALLBACK_CLASS = "SofireCallback";
    public static final String BACK_UP_DIR = ".b";
    public static final String BUILD_TYPE = "release";
    public static final String CONFIG_NAME = "re_po_rt";
    public static final String CONFIG_NAME_2 = "leroadcfg";
    public static final String DATABASE_REPORT_NAME = "d.db";
    public static final String DB_NAME = "tpgcc.db";
    public static final boolean DEBUG = false;
    public static final String DEFAULT_ACTION = "com.baidu.action.SOFIRE.VIEW";
    public static final String DEFAULT_CATEGORY = "com.baidu.category.SOFIRE";
    public static final String FILES_ROOT_DIR = ".tmp";
    public static final String FILE_NAME_LOCAL = "sofire_local.cfg";
    public static final String FLAVOR = "sofireFace";
    public static final boolean HOST_VERIFY_ENABLE = true;
    public static final String H_D = "tks3FEsSkDWCR6pDeGfz9k2FBC+sQXHesB9QvZGtRRuCadeVlNrhOcU1VTxbDyGA";
    public static final String H_R = "2s3neoRGrtMfJHEASAvJDkdImW3sImg0pRReW5cWEQQB2HfrzauSCia/ssvfdE6q";
    public static final boolean LOG_ENABLE = false;
    public static final String MIN_FACE_SDK_VERSION = "4.1.1";
    public static final boolean ONLINE_SERVER = true;
    public static final String PLATFORM_ID = "1";
    public static final String PLATFORM_NAME = "sofire";
    public static final String PLUGIN_DATA_DIR_MID = "/.";
    public static final String PREF_NAME = "leroadcfg";
    public static final String REQUEST_PLUGIN_REPORT = "p/1/r";
    public static final boolean REQUEST_REMOTE_ZID = false;
    public static final String SELF_PKG_NAME = "com.baidu.sofire";
    public static final String SO_NAME = "fire";
    public static final String TABLE_NAME_CRASH = "tbch";
    public static final String TABLE_NAME_PLUGIN = "pgn";
    public static final String TABLE_REPORT = "r";
    public static final int TDID_SEED = 1;
    public static final String URL_PLATFORM_ID = "100";
    public static final int VERSION_CODE = 1;
    public static final String VERSION_NAME = "1.0";
    public transient /* synthetic */ FieldHolder $fh;

    public BuildConfig() {
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
}
