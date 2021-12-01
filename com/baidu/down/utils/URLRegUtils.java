package com.baidu.down.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public final class URLRegUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String DEFAULT_HOST_REG = "^http[s]?:\\/\\/(.*(gdown|appdown|app.dcdn)\\.baidu\\.com|.*baijincdn.cn)(:\\d+)?(\\/.*|)$";
    public static final String TAG = "URLRegUtils";
    public static String mDomainNameToIpReg;
    public static String mRetryHostReg;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2114799828, "Lcom/baidu/down/utils/URLRegUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2114799828, "Lcom/baidu/down/utils/URLRegUtils;");
        }
    }

    public URLRegUtils() {
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

    public static boolean matchDomainNameToIpReg(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(mDomainNameToIpReg)) {
                mDomainNameToIpReg = DEFAULT_HOST_REG;
            }
            return Pattern.matches(mDomainNameToIpReg, str);
        }
        return invokeL.booleanValue;
    }

    public static boolean matchRetryHostReg(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(mRetryHostReg)) {
                mRetryHostReg = DEFAULT_HOST_REG;
            }
            return Pattern.matches(mRetryHostReg, str);
        }
        return invokeL.booleanValue;
    }

    public static void setURLReg(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            mRetryHostReg = str;
            mDomainNameToIpReg = str2;
        }
    }
}
