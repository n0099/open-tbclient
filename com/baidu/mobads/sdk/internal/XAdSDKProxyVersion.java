package com.baidu.mobads.sdk.internal;

import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class XAdSDKProxyVersion {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BAIDU_AD_SDK_VERSION = "";
    public static final Boolean DEBUG;
    public static final int MAJOR_VERSION_NUMBER = 0;
    public static final int MINOR_VERSION_NUMBER = 0;
    public static final Boolean MODIFIED;
    public static final String REAL_RELEASE_TAG = "";
    public static final String RELEASE_TAG = "9.042";
    public static final String SVN_REVISION_FINAL = "";
    public static final String SVN_TREE = "";
    public static final String TIME_STAMP = "";
    public static final String URL = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2098156198, "Lcom/baidu/mobads/sdk/internal/XAdSDKProxyVersion;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2098156198, "Lcom/baidu/mobads/sdk/internal/XAdSDKProxyVersion;");
                return;
            }
        }
        Boolean bool = Boolean.FALSE;
        DEBUG = bool;
        MODIFIED = bool;
    }

    public XAdSDKProxyVersion() {
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
