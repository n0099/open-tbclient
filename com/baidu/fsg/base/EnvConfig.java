package com.baidu.fsg.base;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class EnvConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static String DEFAULT_ENVIRONMENT = "ONLINE";
    public static final String ENVIRONMENT_ONLINE = "ONLINE";
    public static final String ENVIRONMENT_PRELINE = "PRELINE";
    public static final String ENVIRONMENT_QA = "QA";
    public static final String ENVIRONMENT_RD = "RD";
    public static final String a = "https://jrws.baidu.com";

    /* renamed from: b  reason: collision with root package name */
    public static final String f34599b = "https://jrws.baidu.com";

    /* renamed from: c  reason: collision with root package name */
    public static String f34600c = "https://jrws.baidu.com";

    /* renamed from: d  reason: collision with root package name */
    public static EnvConfig f34601d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1474745607, "Lcom/baidu/fsg/base/EnvConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1474745607, "Lcom/baidu/fsg/base/EnvConfig;");
        }
    }

    public EnvConfig() {
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

    public static synchronized EnvConfig a() {
        InterceptResult invokeV;
        EnvConfig envConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (EnvConfig.class) {
                EnvConfig envConfig2 = f34601d;
                if (envConfig2 == null && envConfig2 == null) {
                    f34601d = new EnvConfig();
                }
                envConfig = f34601d;
            }
            return envConfig;
        }
        return (EnvConfig) invokeV.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            f34600c = "https://jrws.baidu.com";
            DEFAULT_ENVIRONMENT = "ONLINE";
        }
    }

    public static synchronized EnvConfig getInstance() {
        InterceptResult invokeV;
        EnvConfig a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (EnvConfig.class) {
                a2 = c.a();
            }
            return a2;
        }
        return (EnvConfig) invokeV.objValue;
    }

    public static synchronized EnvConfig getInstance(Context context) {
        InterceptResult invokeL;
        EnvConfig a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            synchronized (EnvConfig.class) {
                a2 = c.a();
            }
            return a2;
        }
        return (EnvConfig) invokeL.objValue;
    }

    public String getEnvironment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? DEFAULT_ENVIRONMENT : (String) invokeV.objValue;
    }

    public String getRimHttpsHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f34600c : (String) invokeV.objValue;
    }

    public void initEnv() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b();
        }
    }
}
