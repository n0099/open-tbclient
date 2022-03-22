package com.baidu.searchbox.aperf.bosuploader;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BaseUrlManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String ONLINE_URL = "https://mbd.baidu.com";
    public static final String TEST_URL = "http://10.104.73.35:8098";
    public static final String UPLOAD_URL_PATH = "/fetchlog/getbostoken";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-55686734, "Lcom/baidu/searchbox/aperf/bosuploader/BaseUrlManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-55686734, "Lcom/baidu/searchbox/aperf/bosuploader/BaseUrlManager;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public BaseUrlManager() {
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

    public static String getBaseUploadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? DEBUG ? "http://10.104.73.35:8098/fetchlog/getbostoken" : "https://mbd.baidu.com/fetchlog/getbostoken" : (String) invokeV.objValue;
    }
}
