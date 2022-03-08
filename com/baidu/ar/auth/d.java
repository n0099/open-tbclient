package com.baidu.ar.auth;

import android.content.Context;
import com.baidu.ar.h.n;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static int jB;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1869303858, "Lcom/baidu/ar/auth/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1869303858, "Lcom/baidu/ar/auth/d;");
        }
    }

    public static boolean cx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (jB == 0) {
                try {
                    Class.forName("com.baidu.aip.auth.Auth");
                    com.baidu.ar.libloader.a.require("aip-native-auth");
                    jB = 1;
                } catch (Throwable unused) {
                    jB = -1;
                }
            }
            return jB == 1;
        }
        return invokeV.booleanValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            Object aV = n.aV("com.baidu.aip.auth.Auth");
            return aV != null ? (String) n.a(aV, "com.baidu.aip.auth.Auth", "getToken", context, Context.class) : "";
        }
        return (String) invokeL.objValue;
    }
}
