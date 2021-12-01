package c.a.p0.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.q.f.i;
import c.a.p0.q.j.f;
import c.a.p0.q.j.g;
import c.a.p0.q.j.m.h;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1885093696, "Lc/a/p0/q/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1885093696, "Lc/a/p0/q/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(@NonNull JSONObject jSONObject, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, jSONObject, map) == null) || map == null) {
            return;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean b(h hVar, i iVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, hVar, iVar)) == null) {
            if (iVar == null) {
                return true;
            }
            if (hVar == null) {
                iVar.D(new c.a.p0.q.i.b(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized void c(c.a.p0.q.j.m.d dVar, i iVar) {
        g M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, dVar, iVar) == null) {
            synchronized (b.class) {
                if (b(dVar, iVar)) {
                    return;
                }
                if (TextUtils.isEmpty(dVar.g())) {
                    iVar.D(new c.a.p0.q.i.b(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i2 = c.a.p0.q.j.b.i(dVar);
                if (iVar.C() != null) {
                    i2.putAll(iVar.C());
                }
                iVar.E();
                if (dVar.n() == 1 && dVar.h() == 2101) {
                    M = c.b().n();
                } else {
                    M = c.b().M();
                }
                M.j(f.e(), i2, iVar.u(), new c.a.p0.q.j.k.c(dVar.g(), iVar, dVar));
            }
        }
    }

    public static synchronized void d(c.a.p0.q.j.m.a aVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, aVar, iVar) == null) {
            synchronized (b.class) {
                if (b(aVar, iVar)) {
                    return;
                }
                if (aVar.f() != null && !aVar.f().isEmpty()) {
                    HashMap<String, String> f2 = c.a.p0.q.j.b.f(aVar);
                    if (iVar.C() != null && f2 != null) {
                        f2.putAll(iVar.C());
                    }
                    JSONObject d2 = c.a.p0.q.j.b.d(aVar);
                    if (d2 == null) {
                        iVar.D(new c.a.p0.q.i.b(2100, "构造请求body失败"));
                        return;
                    }
                    a(d2, iVar.z());
                    iVar.E();
                    c.b().M().a(f.d(), f2, iVar.u(), d2, new c.a.p0.q.j.k.a(iVar, aVar));
                    return;
                }
                iVar.D(new c.a.p0.q.i.b(2100, "pkg List为空"));
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable c.a.p0.q.f.c cVar) {
        a b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, list, str, cVar) == null) || (b2 = c.b()) == null) {
            return;
        }
        if (PMSConstants.a(b2)) {
            c.a.p0.q.k.j.b.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b2.M().a(f.c(), hashMap, null, jSONObject, new c.a.p0.q.f.d(cVar));
    }

    public static synchronized void f(c.a.p0.q.j.m.c cVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, cVar, iVar) == null) {
            synchronized (b.class) {
                if (b(cVar, iVar)) {
                    return;
                }
                if (cVar.f() != null && !cVar.f().isEmpty()) {
                    HashMap<String, String> f2 = c.a.p0.q.j.b.f(cVar);
                    if (iVar.C() != null && f2 != null) {
                        f2.putAll(iVar.C());
                    }
                    JSONObject e2 = c.a.p0.q.j.b.e(cVar);
                    if (e2 == null) {
                        iVar.D(new c.a.p0.q.i.b(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(c.b())) {
                        c.a.p0.q.k.j.b.e().f();
                    }
                    a(e2, iVar.z());
                    iVar.E();
                    c.b().M().a(f.d(), f2, iVar.u(), e2, new c.a.p0.q.j.k.b(iVar, cVar));
                    return;
                }
                iVar.D(new c.a.p0.q.i.b(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(c.a.p0.q.j.m.e eVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, eVar, iVar) == null) {
            synchronized (b.class) {
                if (b(eVar, iVar)) {
                    return;
                }
                HashMap<String, String> j2 = c.a.p0.q.j.b.j(eVar);
                if (iVar.C() != null) {
                    j2.putAll(iVar.C());
                }
                iVar.E();
                c.b().M().j(f.f(), j2, iVar.u(), new c.a.p0.q.j.k.d(iVar, eVar));
            }
        }
    }

    public static synchronized void h(c.a.p0.q.j.m.g gVar, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, gVar, iVar) == null) {
            synchronized (b.class) {
                if (b(gVar, iVar)) {
                    return;
                }
                if (TextUtils.isEmpty(gVar.f())) {
                    iVar.D(new c.a.p0.q.i.b(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(gVar.k())) {
                    iVar.D(new c.a.p0.q.i.b(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k2 = c.a.p0.q.j.b.k(gVar);
                    if (iVar.C() != null) {
                        k2.putAll(iVar.C());
                    }
                    iVar.E();
                    c.b().M().j(f.e(), k2, iVar.u(), new c.a.p0.q.j.k.e(gVar.f(), iVar, gVar));
                }
            }
        }
    }

    public static JSONObject i(@Nullable c.a.p0.q.k.c<JSONArray> cVar, @Nullable c.a.p0.q.k.c<JSONObject> cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, cVar, cVar2)) == null) ? c.a.p0.q.k.f.a(cVar, cVar2) : (JSONObject) invokeLL.objValue;
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (b.class) {
                c2 = c.a.p0.q.j.i.g.d.b().c(str);
            }
            return c2;
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean k(String str) {
        InterceptResult invokeL;
        boolean d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (b.class) {
                d2 = c.a.p0.q.j.i.g.d.b().d(str);
            }
            return d2;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void l(c.a.p0.q.j.m.i iVar, i iVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, iVar, iVar2) == null) {
            synchronized (b.class) {
                m(iVar, iVar2, null);
            }
        }
    }

    public static synchronized void m(c.a.p0.q.j.m.i iVar, i iVar2, i iVar3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, iVar, iVar2, iVar3) == null) {
            synchronized (b.class) {
                n(iVar, iVar2, iVar3, null);
            }
        }
    }

    public static synchronized void n(c.a.p0.q.j.m.i iVar, i iVar2, i iVar3, @Nullable c.a.p0.q.l.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, iVar, iVar2, iVar3, aVar) == null) {
            synchronized (b.class) {
                if (b(iVar, iVar2)) {
                    return;
                }
                if (PMSConstants.a(c.b())) {
                    c.a.p0.q.k.j.b.e().f();
                }
                c.a.p0.q.k.c<JSONArray> g2 = aVar == null ? null : aVar.g();
                i o = aVar == null ? null : aVar.o();
                HashMap hashMap = new HashMap();
                if (iVar2.C() != null) {
                    hashMap.putAll(iVar2.C());
                }
                iVar2.E();
                c.b().M().a(f.g(), hashMap, iVar2.u(), i(g2, null), new c.a.p0.q.j.k.f(iVar2, iVar, iVar3, o));
            }
        }
    }

    public static synchronized void o(c.a.p0.q.l.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, aVar) == null) {
            synchronized (b.class) {
                if (aVar == null) {
                    return;
                }
                i o = aVar.o();
                if (o == null) {
                    return;
                }
                h request = aVar.getRequest();
                if (request == null) {
                    o.D(new c.a.p0.q.i.b(2100, "request对象为空"));
                    return;
                }
                Map<String, String> C = o.C();
                if (o.C() != null) {
                    C = new HashMap(C);
                }
                o.E();
                c.b().M().a(f.g(), C, o.u(), i(aVar.g(), null), new c.a.p0.q.j.k.f(o, request, null, o));
            }
        }
    }
}
