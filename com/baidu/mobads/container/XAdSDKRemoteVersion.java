package com.baidu.mobads.container;

import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class XAdSDKRemoteVersion {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BAIDU_AD_SDK_VERSION = "";
    public static final Boolean DEBUG;
    public static final String RELEASE_TAG = "9.042";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2036120839, "Lcom/baidu/mobads/container/XAdSDKRemoteVersion;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2036120839, "Lcom/baidu/mobads/container/XAdSDKRemoteVersion;");
                return;
            }
        }
        DEBUG = Boolean.FALSE;
    }

    public XAdSDKRemoteVersion() {
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

    public static int getMajorVersionNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return Integer.valueOf("9.042".split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX)[0]).intValue();
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static double getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                return Double.parseDouble("9.042");
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        return invokeV.doubleValue;
    }
}
