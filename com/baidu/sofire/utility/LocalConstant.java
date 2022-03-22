package com.baidu.sofire.utility;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class LocalConstant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTIVE_PLUGIN_ID = 100028;
    public static final String APP_CALLBACK_CLASS = "SofireCallback";
    public static final String Ac_Action = "teac";
    public static final String BACK_UP_DIR = ".b";
    public static final String BAIDU_TEXT = "baidu";
    public static final String CHECK_PKG_NAME = "com.baidu.sofire";
    public static final String DB_NAME = "tpgcc.db";
    public static final String DEFAULT_ACTION = "com.baidu.action.SOFIRE.VIEW";
    public static final String DEFAULT_CATEGORY = "com.baidu.category.SOFIRE";
    public static final String DEFAULT_ZID = "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
    public static final String ENGINE_IMPL_CLASS_FULL_PATH = "com.baidu.sofire.engine.EngineImpl";
    public static final String FILES_ROOT_DIR = ".tmp";
    public static final String FILE_NAME_LOCAL = "sofire_local.cfg";
    public static final String H = "2s3neoRGrtMfJHEASAvJDkdImW3sImg0pRReW5cWEQQB2HfrzauSCia/ssvfdE6q";
    public static final String KEY_AWAKEUP_PUSH_TAG = "agbal_push";
    public static final int NEXTSUFFIX = 10000000;
    public static final String PACKAGE_SEARCHBOX = "com.baidu.searchbox";
    public static final String PLATFORM_ID = "1";
    public static final String PLATFORM_NAME = "sofire";
    public static final String PLUGIN_DATA_DIR_MID = "/.";
    public static final String PREF_NAME = "leroadcfg";
    public static final String PUSH_EVENT_ACTION = "com.baidu.sofire.push.action.PUSH_EVENT";
    public static final int PUSH_PLUGIN_ID = 100019;
    public static final String SELF_PKG_NAME = "com.baidu.sofire";
    public static final String SO_NAME = "fire";
    public static final String TABLE_NAME_CRASH = "tbch";
    public static final String TABLE_NAME_PLUGIN = "pgn";
    public static final String TVSHIELD_PLATFORM_NAME = "tvshield";
    public static final String URL_PLATFORM_ID = "100";
    public static final boolean USE_DEVICE_INFO_CALLBACK = false;
    public static final String V = "3.5.9.3";
    public static final int X39_ID = 100067;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1933453090, "Lcom/baidu/sofire/utility/LocalConstant;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1933453090, "Lcom/baidu/sofire/utility/LocalConstant;");
        }
    }

    public LocalConstant() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
