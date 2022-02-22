package c.a.y.b.f;

import c.a.y.g.g.j;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, c.a.y.b.d.c.f> a;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f26885b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1621974955, "Lc/a/y/b/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1621974955, "Lc/a/y/b/f/b;");
                return;
            }
        }
        a = new HashMap();
        f26885b = new ArrayList();
    }

    public static void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || a.isEmpty() || c.a.y.g.g.d.c(list)) {
            return;
        }
        Iterator<Map.Entry<String, c.a.y.b.d.c.f>> it = a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, c.a.y.b.d.c.f> next = it.next();
            if (next != null && list.contains(next.getKey())) {
                it.remove();
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a.isEmpty()) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, c.a.y.b.d.c.f> entry : a.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    c.a.y.b.d.c.f value = entry.getValue();
                    if (value != null && (a2 = value.a()) != null) {
                        jSONArray.put(a2);
                        f26885b.add(key);
                    }
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void c(String str, boolean z, boolean z2) {
        c.a.y.b.d.c.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || j.a(str)) {
            return;
        }
        if (a.containsKey(str)) {
            fVar = a.get(str);
        } else {
            fVar = new c.a.y.b.d.c.f();
            a.put(str, fVar);
        }
        fVar.a = str;
        if (z2) {
            fVar.f26859c = 1;
            fVar.f26861e = System.currentTimeMillis() / 1000;
        }
        if (z) {
            fVar.f26858b = 1;
            fVar.f26860d = System.currentTimeMillis() / 1000;
        }
    }
}
