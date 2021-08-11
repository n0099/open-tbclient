package com.baidu.rtc.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes5.dex */
public class CommonUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CommonUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            for (int i2 = 0; i2 < num.intValue(); i2++) {
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
            for (int i2 = 0; i2 < num.intValue(); i2++) {
                sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(62)));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
