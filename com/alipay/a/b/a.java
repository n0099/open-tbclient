package com.alipay.a.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Class<?> a(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, type)) == null) {
            while (!(type instanceof Class)) {
                if (!(type instanceof ParameterizedType)) {
                    throw new IllegalArgumentException("TODO");
                }
                type = ((ParameterizedType) type).getRawType();
            }
            return (Class) type;
        }
        return (Class) invokeL.objValue;
    }

    public static boolean a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) ? cls.isPrimitive() || cls.equals(String.class) || cls.equals(Integer.class) || cls.equals(Long.class) || cls.equals(Double.class) || cls.equals(Float.class) || cls.equals(Boolean.class) || cls.equals(Short.class) || cls.equals(Character.class) || cls.equals(Byte.class) || cls.equals(Void.class) : invokeL.booleanValue;
    }
}
