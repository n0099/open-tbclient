package com.baidu.mobads.sdk.internal;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class XAdSDKPorxyConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG_MODE;
    public static final String DUMMY_ADSERV_VERSION = "4.1.30";
    public static final int LOG_LEVEL;
    public static String REMOTE_VERSION = null;
    public static final String REMOTE_VERSION_DEFAULT = "0.0";
    public static final boolean UNITTEST_MODE = false;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2143369136, "Lcom/baidu/mobads/sdk/internal/XAdSDKPorxyConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2143369136, "Lcom/baidu/mobads/sdk/internal/XAdSDKPorxyConfig;");
                return;
            }
        }
        boolean booleanValue = XAdSDKProxyVersion.DEBUG.booleanValue();
        DEBUG_MODE = booleanValue;
        LOG_LEVEL = booleanValue ? 2 : 4;
        REMOTE_VERSION = REMOTE_VERSION_DEFAULT;
    }

    public XAdSDKPorxyConfig() {
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
