package com.baidu.mobads.container;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class XAdSDKRemoteConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AD_LOGO_URL = "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
    public static final String BAIDU_LOGO_URL = "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
    public static boolean DEBUG_MODE = false;
    public static final String DZZB_ROOT = "https://mobads-logs.baidu.com/dz.zb";
    public static final String JS_NAMESPACE = "MobadsSdk";
    public static final String MOBADS_AS_PREF = "mobads://";
    public static final String REGULAR_MATCH_PROGRESS = "\\$\\{PROGRESS\\}";
    public static final String RES_MATERIAL_PREFIX = "__sdk_m_";
    public static final String SED = "mobads,";
    public static final String SERVER = "http://mobads.baidu.com";
    public static final String SHARED_PREFERENCE_ROLL_NAME = "__adsdk_roll__";
    public static final String SHARED_PREFERENCE_SPLASH_NAME = "__adsdk_splash__";
    public static final String URL_SUFFIX_NORMAL = "/ads/index.htm";
    public static final double VERSION;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1219379733, "Lcom/baidu/mobads/container/XAdSDKRemoteConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1219379733, "Lcom/baidu/mobads/container/XAdSDKRemoteConfig;");
                return;
            }
        }
        VERSION = XAdSDKRemoteVersion.getVersion();
        DEBUG_MODE = XAdSDKRemoteVersion.DEBUG.booleanValue();
    }

    public XAdSDKRemoteConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
