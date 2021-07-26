package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f1735a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f1736b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1454276270, "Lcom/alipay/apmobilesecuritysdk/d/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1454276270, "Lcom/alipay/apmobilesecuritysdk/d/e;");
                return;
            }
        }
        f1736b = new String[]{"AD1", "AD2", "AD3", "AD8", "AD9", "AD10", "AD11", "AD12", "AD14", "AD15", "AD16", "AD18", "AD20", "AD21", "AD23", "AD24", "AD26", "AD27", "AD28", "AD29", "AD30", "AD31", "AD34", "AA1", "AA2", "AA3", "AA4", "AC4", "AC10", "AE1", "AE2", "AE3", "AE4", "AE5", "AE6", "AE7", "AE8", "AE9", "AE10", "AE11", "AE12", "AE13", "AE14", "AE15"};
    }

    public static String a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, map)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                String str = (String) arrayList.get(i2);
                String str2 = map.get(str);
                String str3 = "";
                if (str2 == null) {
                    str2 = "";
                }
                StringBuilder sb = new StringBuilder();
                if (i2 != 0) {
                    str3 = "&";
                }
                sb.append(str3);
                sb.append(str);
                sb.append("=");
                sb.append(str2);
                stringBuffer.append(sb.toString());
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Map<String, String> map2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, map)) == null) {
            synchronized (e.class) {
                if (f1735a == null) {
                    c(context, map);
                }
                f1735a.putAll(d.a());
                map2 = f1735a;
            }
            return map2;
        }
        return (Map) invokeLL.objValue;
    }

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (e.class) {
                f1735a = null;
            }
        }
    }

    public static synchronized String b(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        String[] strArr;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, map)) == null) {
            synchronized (e.class) {
                a(context, map);
                TreeMap treeMap = new TreeMap();
                for (String str : f1736b) {
                    if (f1735a.containsKey(str)) {
                        treeMap.put(str, f1735a.get(str));
                    }
                }
                a2 = com.alipay.security.mobile.module.a.a.b.a(a(treeMap));
            }
            return a2;
        }
        return (String) invokeLL.objValue;
    }

    public static synchronized void c(Context context, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, map) == null) {
            synchronized (e.class) {
                TreeMap treeMap = new TreeMap();
                f1735a = treeMap;
                treeMap.putAll(b.a(context, map));
                f1735a.putAll(d.a(context));
                f1735a.putAll(c.a(context));
                f1735a.putAll(a.a(context, map));
            }
        }
    }
}
