package com.alipay.a.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public static List<j> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1272175228, "Lcom/alipay/a/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1272175228, "Lcom/alipay/a/a/f;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(new l());
        a.add(new d());
        a.add(new c());
        a.add(new h());
        a.add(new b());
        a.add(new a());
        a.add(new g());
    }

    public static String a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Object b2 = b(obj);
            if (com.alipay.a.b.a.a(b2.getClass())) {
                return org.json.alipay.b.c(b2.toString());
            }
            if (Collection.class.isAssignableFrom(b2.getClass())) {
                return new org.json.alipay.a((Collection) ((List) b2)).toString();
            }
            if (Map.class.isAssignableFrom(b2.getClass())) {
                return new org.json.alipay.b((Map) b2).toString();
            }
            throw new IllegalArgumentException("Unsupported Class : " + b2.getClass());
        }
        return (String) invokeL.objValue;
    }

    public static Object b(Object obj) {
        InterceptResult invokeL;
        Object a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            for (j jVar : a) {
                if (jVar.a(obj.getClass()) && (a2 = jVar.a(obj)) != null) {
                    return a2;
                }
            }
            throw new IllegalArgumentException("Unsupported Class : " + obj.getClass());
        }
        return invokeL.objValue;
    }
}
