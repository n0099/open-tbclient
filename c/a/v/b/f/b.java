package c.a.v.b.f;

import c.a.v.e.g.j;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, c.a.v.b.d.c.f> f30034a;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f30035b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(688511246, "Lc/a/v/b/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(688511246, "Lc/a/v/b/f/b;");
                return;
            }
        }
        f30034a = new HashMap();
        f30035b = new ArrayList();
    }

    public static void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || f30034a.isEmpty() || c.a.v.e.g.d.c(list)) {
            return;
        }
        Iterator<Map.Entry<String, c.a.v.b.d.c.f>> it = f30034a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, c.a.v.b.d.c.f> next = it.next();
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
            if (f30034a.isEmpty()) {
                return "";
            }
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, c.a.v.b.d.c.f> entry : f30034a.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    c.a.v.b.d.c.f value = entry.getValue();
                    if (value != null && (a2 = value.a()) != null) {
                        jSONArray.put(a2);
                        f30035b.add(key);
                    }
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void c(String str, boolean z, boolean z2) {
        c.a.v.b.d.c.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || j.a(str)) {
            return;
        }
        if (f30034a.containsKey(str)) {
            fVar = f30034a.get(str);
        } else {
            fVar = new c.a.v.b.d.c.f();
            f30034a.put(str, fVar);
        }
        fVar.f30001a = str;
        if (z2) {
            fVar.f30003c = 1;
            fVar.f30005e = System.currentTimeMillis() / 1000;
        }
        if (z) {
            fVar.f30002b = 1;
            fVar.f30004d = System.currentTimeMillis() / 1000;
        }
    }
}
