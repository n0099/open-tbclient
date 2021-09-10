package c.a.p0.n;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.n.i.f;
import c.a.p0.n.i.m.g;
import c.a.p0.n.i.m.h;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1885004323, "Lc/a/p0/n/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1885004323, "Lc/a/p0/n/b;");
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

    public static boolean a(g gVar, c.a.p0.n.f.g gVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, gVar, gVar2)) == null) {
            if (gVar2 == null) {
                return true;
            }
            if (gVar == null) {
                gVar2.B(new c.a.p0.n.h.a(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized void b(c.a.p0.n.i.m.c cVar, c.a.p0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, cVar, gVar) == null) {
            synchronized (b.class) {
                if (a(cVar, gVar)) {
                    return;
                }
                if (TextUtils.isEmpty(cVar.g())) {
                    gVar.B(new c.a.p0.n.h.a(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> e2 = c.a.p0.n.i.b.e(cVar);
                if (gVar.A() != null) {
                    e2.putAll(gVar.A());
                }
                gVar.C();
                c.b().H().c(f.d(), e2, gVar.s(), new c.a.p0.n.i.k.b(cVar.g(), gVar, cVar));
            }
        }
    }

    public static synchronized void c(c.a.p0.n.i.m.c cVar, c.a.p0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cVar, gVar) == null) {
            synchronized (b.class) {
                if (a(cVar, gVar)) {
                    return;
                }
                String g2 = cVar.g();
                if (TextUtils.isEmpty(g2)) {
                    gVar.B(new c.a.p0.n.h.a(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> e2 = c.a.p0.n.i.b.e(cVar);
                Map<String, String> A = gVar.A();
                if (A != null) {
                    e2.putAll(A);
                }
                gVar.C();
                c.b().n().c(f.d(), e2, gVar.s(), new c.a.p0.n.i.k.b(g2, gVar, cVar));
            }
        }
    }

    public static synchronized void d(c.a.p0.n.i.m.b bVar, c.a.p0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, bVar, gVar) == null) {
            synchronized (b.class) {
                if (a(bVar, gVar)) {
                    return;
                }
                if (bVar.f() != null && !bVar.f().isEmpty()) {
                    HashMap<String, String> b2 = c.a.p0.n.i.b.b(bVar);
                    if (gVar.A() != null && b2 != null) {
                        b2.putAll(gVar.A());
                    }
                    JSONObject a2 = c.a.p0.n.i.b.a(bVar);
                    if (a2 == null) {
                        gVar.B(new c.a.p0.n.h.a(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(c.b())) {
                        c.a.p0.n.j.j.b.c().d();
                    }
                    if (gVar.x() != null) {
                        try {
                            for (Map.Entry<String, String> entry : gVar.x().entrySet()) {
                                a2.put(entry.getKey(), entry.getValue());
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    gVar.C();
                    c.b().H().a(f.c(), b2, gVar.s(), a2, new c.a.p0.n.i.k.a(gVar, bVar));
                    return;
                }
                gVar.B(new c.a.p0.n.h.a(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void e(c.a.p0.n.i.m.d dVar, c.a.p0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, dVar, gVar) == null) {
            synchronized (b.class) {
                if (a(dVar, gVar)) {
                    return;
                }
                HashMap<String, String> f2 = c.a.p0.n.i.b.f(dVar);
                if (gVar.A() != null) {
                    f2.putAll(gVar.A());
                }
                gVar.C();
                c.b().H().c(f.e(), f2, gVar.s(), new c.a.p0.n.i.k.c(gVar, dVar));
            }
        }
    }

    public static synchronized void f(c.a.p0.n.i.m.f fVar, c.a.p0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, fVar, gVar) == null) {
            synchronized (b.class) {
                if (a(fVar, gVar)) {
                    return;
                }
                if (TextUtils.isEmpty(fVar.f())) {
                    gVar.B(new c.a.p0.n.h.a(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(fVar.k())) {
                    gVar.B(new c.a.p0.n.h.a(2100, "分包名为空"));
                } else {
                    HashMap<String, String> g2 = c.a.p0.n.i.b.g(fVar);
                    if (gVar.A() != null) {
                        g2.putAll(gVar.A());
                    }
                    gVar.C();
                    c.b().H().c(f.d(), g2, gVar.s(), new c.a.p0.n.i.k.d(fVar.f(), gVar, fVar));
                }
            }
        }
    }

    public static JSONObject g(@Nullable c.a.p0.n.j.c<JSONArray> cVar, @Nullable c.a.p0.n.j.c<JSONObject> cVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, cVar, cVar2)) == null) ? c.a.p0.n.j.f.a(cVar, cVar2) : (JSONObject) invokeLL.objValue;
    }

    public static synchronized boolean h(String str) {
        InterceptResult invokeL;
        boolean c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            synchronized (b.class) {
                c2 = c.a.p0.n.i.i.g.d.b().c(str);
            }
            return c2;
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean i(String str) {
        InterceptResult invokeL;
        boolean d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            synchronized (b.class) {
                d2 = c.a.p0.n.i.i.g.d.b().d(str);
            }
            return d2;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void j(h hVar, c.a.p0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, hVar, gVar) == null) {
            synchronized (b.class) {
                k(hVar, gVar, null);
            }
        }
    }

    public static synchronized void k(h hVar, c.a.p0.n.f.g gVar, c.a.p0.n.f.g gVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, hVar, gVar, gVar2) == null) {
            synchronized (b.class) {
                l(hVar, gVar, gVar2, null);
            }
        }
    }

    public static synchronized void l(h hVar, c.a.p0.n.f.g gVar, c.a.p0.n.f.g gVar2, @Nullable c.a.p0.n.k.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65549, null, hVar, gVar, gVar2, aVar) == null) {
            synchronized (b.class) {
                if (a(hVar, gVar)) {
                    return;
                }
                if (PMSConstants.a(c.b())) {
                    c.a.p0.n.j.j.b.c().d();
                }
                c.a.p0.n.j.c<JSONArray> g2 = aVar == null ? null : aVar.g();
                c.a.p0.n.f.g o = aVar == null ? null : aVar.o();
                HashMap hashMap = new HashMap();
                if (gVar.A() != null) {
                    hashMap.putAll(gVar.A());
                }
                gVar.C();
                c.b().H().a(f.f(), hashMap, gVar.s(), g(g2, null), new c.a.p0.n.i.k.e(gVar, hVar, gVar2, o));
            }
        }
    }

    public static synchronized void m(c.a.p0.n.k.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, aVar) == null) {
            synchronized (b.class) {
                if (aVar == null) {
                    return;
                }
                c.a.p0.n.f.g o = aVar.o();
                if (o == null) {
                    return;
                }
                g request = aVar.getRequest();
                if (request == null) {
                    o.B(new c.a.p0.n.h.a(2100, "request对象为空"));
                    return;
                }
                Map<String, String> A = o.A();
                if (o.A() != null) {
                    A = new HashMap(A);
                }
                o.C();
                c.b().H().a(f.f(), A, o.s(), g(aVar.g(), null), new c.a.p0.n.i.k.e(o, request, null, o));
            }
        }
    }
}
