package com.alipay.a.a;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static List<i> f35475a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1272175197, "Lcom/alipay/a/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1272175197, "Lcom/alipay/a/a/e;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        f35475a = arrayList;
        arrayList.add(new l());
        f35475a.add(new d());
        f35475a.add(new c());
        f35475a.add(new h());
        f35475a.add(new k());
        f35475a.add(new b());
        f35475a.add(new a());
        f35475a.add(new g());
    }

    public static final <T> T a(Object obj, Type type) {
        InterceptResult invokeLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, type)) == null) {
            for (i iVar : f35475a) {
                if (iVar.a(com.alipay.a.b.a.a(type)) && (t = (T) iVar.a(obj, type)) != null) {
                    return t;
                }
            }
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public static final Object a(String str, Type type) {
        InterceptResult invokeLL;
        Object bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, type)) == null) {
            if (str == null || str.length() == 0) {
                return null;
            }
            String trim = str.trim();
            if (trim.startsWith(PreferencesUtil.LEFT_MOUNT) && trim.endsWith(PreferencesUtil.RIGHT_MOUNT)) {
                bVar = new org.json.alipay.a(trim);
            } else if (!trim.startsWith(StringUtil.ARRAY_START) || !trim.endsWith("}")) {
                return a((Object) trim, type);
            } else {
                bVar = new org.json.alipay.b(trim);
            }
            return a(bVar, type);
        }
        return invokeLL.objValue;
    }
}
