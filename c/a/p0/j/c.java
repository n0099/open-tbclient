package c.a.p0.j;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f11710b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f11711c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f11712d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<c.a.p0.a.p.e.b, b> f11713a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1884885190, "Lc/a/p0/j/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1884885190, "Lc/a/p0/j/c;");
                return;
            }
        }
        f11710b = k.f7085a;
        f11711c = c.class.getSimpleName();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a.a();
        this.f11713a = new HashMap();
    }

    public static c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f11712d == null) {
                synchronized (c.class) {
                    if (f11712d == null) {
                        f11712d = new c();
                    }
                }
            }
            return f11712d;
        }
        return (c) invokeV.objValue;
    }

    public static void d(c.a.p0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            synchronized (c.class) {
                if (f11712d != null) {
                    f11712d.c(bVar).i();
                }
            }
        }
    }

    public static void e(c.a.p0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar) == null) {
            synchronized (c.class) {
                if (f11712d != null) {
                    f11712d.f(bVar);
                } else {
                    boolean z = f11710b;
                }
            }
        }
    }

    public static void h(c.a.p0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar) == null) {
            synchronized (c.class) {
                if (f11712d != null) {
                    f11712d.c(bVar).l();
                }
            }
        }
    }

    public boolean a(Context context, c.a.p0.a.h1.c.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, cVar)) == null) {
            c.a.p0.a.e0.d.g("map", "map create start");
            if (q0.m(cVar.f4666g) != null && cVar.isValid()) {
                c.a.p0.a.p.e.d B = c.a.p0.a.g1.f.V().B(cVar.f4666g);
                if (!(B instanceof c.a.p0.a.p.e.b)) {
                    c.a.p0.a.e0.d.b("map", "WebViewManager is null");
                    return false;
                }
                b c2 = c((c.a.p0.a.p.e.b) B);
                if (c2.d(cVar.f4665f) != null) {
                    c.a.p0.a.e0.d.b("map", "map with id " + cVar.f4665f + " exist");
                    return false;
                }
                c.a.p0.j.n.c M = c.a.p0.j.n.c.M(context, cVar);
                if (M == null) {
                    c.a.p0.a.e0.d.b("map", "map with id " + cVar.f4665f + " model is invalid");
                    return false;
                }
                c.a.p0.a.c0.b.c w = M.w();
                if (!w.a()) {
                    c.a.p0.a.e0.d.b("map", "map with id " + cVar.f4665f + " create fail: " + w.f4671b);
                    return false;
                } else if (c2.g(M)) {
                    c.a.p0.a.e0.d.g("map", "map with id " + cVar.f4665f + " init start");
                    c.a.p0.j.k.f.f.a(context, M, cVar, c2);
                    c.a.p0.a.e0.d.g("map", "map with id " + cVar.f4665f + " init end");
                    c.a.p0.a.e0.d.g("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            c.a.p0.a.e0.d.b("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized b c(c.a.p0.a.p.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            synchronized (this) {
                if (bVar == null) {
                    return null;
                }
                b bVar2 = this.f11713a.get(bVar);
                if (bVar2 == null) {
                    bVar2 = new b();
                    this.f11713a.put(bVar, bVar2);
                }
                return bVar2;
            }
        }
        return (b) invokeL.objValue;
    }

    public final synchronized void f(c.a.p0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            synchronized (this) {
                if (bVar == null) {
                    return;
                }
                b remove = this.f11713a.remove(bVar);
                if (remove != null) {
                    remove.j();
                }
            }
        }
    }

    public boolean g(c.a.p0.a.h1.c.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            c.a.p0.a.e0.d.g("map", "map remove start");
            if (q0.m(cVar.f4666g) == null) {
                c.a.p0.a.e0.d.b("map", "webView is null or mapModel is null");
                return false;
            }
            c.a.p0.a.p.e.d B = c.a.p0.a.g1.f.V().B(cVar.f4666g);
            if (!(B instanceof c.a.p0.a.p.e.b)) {
                c.a.p0.a.e0.d.b("map", "WebViewManager is null");
                return false;
            }
            b c2 = c((c.a.p0.a.p.e.b) B);
            c.a.p0.j.n.c d2 = c2.d(cVar.f4665f);
            if (d2 == null) {
                c.a.p0.a.e0.d.b("map", "remove map with id " + cVar.f4665f + " not exist");
                return false;
            } else if (c2.k(cVar.f4665f)) {
                c.a.p0.a.e0.d.g("map", "map remove end");
                if (c.a.p0.a.c0.d.a.a(cVar) == null) {
                    c.a.p0.a.c0.g.a.a("map", "remove with a null map component");
                }
                c.a.p0.a.c0.b.c C = d2.C();
                boolean a2 = C.a();
                if (!a2) {
                    String str = f11711c;
                    c.a.p0.a.e0.d.b(str, "map remove fail: " + C.f4671b);
                }
                return a2;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean i(Context context, c.a.p0.a.h1.c.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, cVar)) == null) {
            c.a.p0.a.e0.d.g("map", "map update start");
            if (q0.m(cVar.f4666g) == null) {
                c.a.p0.a.e0.d.b("map", "webView is null or mapModel is null");
                return false;
            }
            c.a.p0.a.p.e.d B = c.a.p0.a.g1.f.V().B(cVar.f4666g);
            if (B != null && (B instanceof c.a.p0.a.p.e.b)) {
                b c2 = c((c.a.p0.a.p.e.b) B);
                c.a.p0.j.n.c d2 = c2.d(cVar.f4665f);
                if (d2 == null) {
                    c.a.p0.a.e0.d.b("map", "remove map with id " + cVar.f4665f + " not exist");
                    return false;
                }
                d2.H();
                c.a.p0.j.k.f.f.b(context, d2, cVar, c2, true);
                c.a.p0.a.e0.d.g("map", "map update end");
                if (c.a.p0.a.c0.d.a.a(cVar) == null) {
                    c.a.p0.a.c0.g.a.a("map", "update with a null map component");
                }
                c.a.p0.a.c0.b.c G = d2.G(cVar);
                boolean a2 = G.a();
                if (!a2) {
                    String str = f11711c;
                    c.a.p0.a.e0.d.b(str, "map update fail: " + G.f4671b);
                }
                return a2;
            }
            c.a.p0.a.e0.d.b("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
