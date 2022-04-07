package com.baidu.rtc.utils;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
import org.webrtc.Logging;
/* loaded from: classes2.dex */
public class CommonUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "CommonUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public CommonUtils() {
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

    public static String randomNumber(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, num)) == null) {
            Random random = new Random();
            StringBuilder sb = new StringBuilder(num.intValue());
            for (int i = 0; i < num.intValue(); i++) {
                sb.append("0123456789".charAt(random.nextInt(10)));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String randomString(Integer num) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, num)) == null) {
            Random random = new Random();
            StringBuilder sb = new StringBuilder(num.intValue());
            for (int i = 0; i < num.intValue(); i++) {
                sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(62)));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static long strToLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    return Long.valueOf(str).longValue();
                } catch (NumberFormatException e) {
                    Logging.e("CommonUtils", "number format fault:" + e.getMessage());
                }
            }
            return -1L;
        }
        return invokeL.longValue;
    }
}
