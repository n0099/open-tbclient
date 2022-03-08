package com.baidu.appsearchlib;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
/* loaded from: classes3.dex */
public class Md5Util {
    public static /* synthetic */ Interceptable $ic;
    public static MessageDigest md5;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-874499776, "Lcom/baidu/appsearchlib/Md5Util;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-874499776, "Lcom/baidu/appsearchlib/Md5Util;");
                return;
            }
        }
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e2) {
            System.out.println(e2.getMessage());
        }
    }

    public Md5Util() {
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

    public static String getMd5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            byte[] digest = md5.digest(str.getBytes());
            StringBuilder sb = new StringBuilder(40);
            for (byte b2 : digest) {
                int i2 = b2 & 255;
                if ((i2 >> 4) == 0) {
                    sb.append("0");
                    sb.append(Integer.toHexString(i2));
                } else {
                    sb.append(Integer.toHexString(i2));
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
