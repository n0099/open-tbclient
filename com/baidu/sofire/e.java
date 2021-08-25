package com.baidu.sofire;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Field;
/* loaded from: classes6.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Class<?> cls, Object obj, Object obj2) {
        InterceptResult invokeLLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, cls, obj, obj2)) == null) {
            if (obj == null || obj2 == null) {
                return false;
            }
            while (cls != null && cls != Object.class) {
                for (Field field : cls.getDeclaredFields()) {
                    try {
                        field.setAccessible(true);
                        field.set(obj2, field.get(obj));
                    } catch (Throwable unused) {
                        com.baidu.sofire.utility.c.a();
                    }
                }
                cls = cls.getSuperclass();
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
