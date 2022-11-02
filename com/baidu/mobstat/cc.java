package com.baidu.mobstat;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class cc {
    public static /* synthetic */ Interceptable $ic;
    public static Object a;
    public static Class<?> b;
    public static Method c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581658834, "Lcom/baidu/mobstat/cc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581658834, "Lcom/baidu/mobstat/cc;");
                return;
            }
        }
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            a = cls.newInstance();
            c = b.getMethod("getOAID", Context.class);
        } catch (Exception unused) {
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            return a(context, c);
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, Method method) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, method)) == null) {
            Object obj = a;
            if (obj != null && method != null) {
                try {
                    Object invoke = method.invoke(obj, context);
                    if (invoke != null) {
                        return (String) invoke;
                    }
                    return null;
                } catch (Exception e) {
                    Log.e("IdentifierManager", "invoke exception!", e);
                    return null;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
