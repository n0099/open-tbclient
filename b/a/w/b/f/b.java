package b.a.w.b.f;

import b.a.w.e.g.j;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, b.a.w.b.d.c.f> f29247a;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f29248b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1992728434, "Lb/a/w/b/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1992728434, "Lb/a/w/b/f/b;");
                return;
            }
        }
        f29247a = new HashMap();
        f29248b = new ArrayList();
    }

    public static void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || f29247a.isEmpty() || b.a.w.e.g.d.c(list)) {
            return;
        }
        Iterator<Map.Entry<String, b.a.w.b.d.c.f>> it = f29247a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, b.a.w.b.d.c.f> next = it.next();
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
            if (f29247a.isEmpty()) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, b.a.w.b.d.c.f> entry : f29247a.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    b.a.w.b.d.c.f value = entry.getValue();
                    if (value != null && (a2 = value.a()) != null) {
                        jSONArray.put(a2);
                        f29248b.add(key);
                    }
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void c(String str, boolean z, boolean z2) {
        b.a.w.b.d.c.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || j.a(str)) {
            return;
        }
        if (f29247a.containsKey(str)) {
            fVar = f29247a.get(str);
        } else {
            fVar = new b.a.w.b.d.c.f();
            f29247a.put(str, fVar);
        }
        fVar.f29216a = str;
        if (z2) {
            fVar.f29218c = 1;
            fVar.f29220e = System.currentTimeMillis() / 1000;
        }
        if (z) {
            fVar.f29217b = 1;
            fVar.f29219d = System.currentTimeMillis() / 1000;
        }
    }
}
