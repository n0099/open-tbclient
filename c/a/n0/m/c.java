package c.a.n0.m;

import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.q0;
import c.a.n0.a.w0.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f9021b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f9022c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f9023d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<c.a.n0.a.f.e.b, b> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(109967201, "Lc/a/n0/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(109967201, "Lc/a/n0/m/c;");
                return;
            }
        }
        f9021b = c.a.n0.a.a.a;
        f9022c = c.class.getSimpleName();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a.a();
        this.a = new HashMap();
    }

    public static c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f9023d == null) {
                synchronized (c.class) {
                    if (f9023d == null) {
                        f9023d = new c();
                    }
                }
            }
            return f9023d;
        }
        return (c) invokeV.objValue;
    }

    public static void d(c.a.n0.a.f.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            synchronized (c.class) {
                if (f9023d != null) {
                    f9023d.c(bVar).h();
                }
            }
        }
    }

    public static void e(c.a.n0.a.f.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar) == null) {
            synchronized (c.class) {
                if (f9023d != null) {
                    f9023d.f(bVar);
                } else if (f9021b) {
                    Log.v(f9022c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(c.a.n0.a.f.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, bVar) == null) {
            synchronized (c.class) {
                if (f9023d != null) {
                    f9023d.c(bVar).k();
                }
            }
        }
    }

    public boolean a(Context context, c.a.n0.a.y0.c.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, cVar)) == null) {
            c.a.n0.a.u.d.i("map", "map create start");
            if (q0.m(cVar.f6097c) != null && cVar.isValid()) {
                c.a.n0.a.f.e.d A = f.U().A(cVar.f6097c);
                if (!(A instanceof c.a.n0.a.f.e.b)) {
                    c.a.n0.a.u.d.c("map", "WebViewManager is null");
                    return false;
                }
                b c2 = c((c.a.n0.a.f.e.b) A);
                if (c2.d(cVar.f6096b) != null) {
                    c.a.n0.a.u.d.c("map", "map with id " + cVar.f6096b + " exist");
                    return false;
                }
                c.a.n0.m.i.c K = c.a.n0.m.i.c.K(context, cVar);
                if (K == null) {
                    c.a.n0.a.u.d.c("map", "map with id " + cVar.f6096b + " model is invalid");
                    return false;
                }
                c.a.n0.a.s.b.c insert = K.insert();
                if (!insert.a()) {
                    c.a.n0.a.u.d.c("map", "map with id " + cVar.f6096b + " create fail: " + insert.f6103b);
                    return false;
                } else if (c2.insert(K)) {
                    c.a.n0.a.u.d.i("map", "map with id " + cVar.f6096b + " init start");
                    c.a.n0.m.f.f.f.a(context, K, cVar, c2);
                    c.a.n0.a.u.d.i("map", "map with id " + cVar.f6096b + " init end");
                    c.a.n0.a.u.d.i("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            c.a.n0.a.u.d.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized b c(c.a.n0.a.f.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            synchronized (this) {
                if (bVar == null) {
                    return null;
                }
                b bVar2 = this.a.get(bVar);
                if (bVar2 == null) {
                    bVar2 = new b();
                    this.a.put(bVar, bVar2);
                }
                return bVar2;
            }
        }
        return (b) invokeL.objValue;
    }

    public final synchronized void f(c.a.n0.a.f.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            synchronized (this) {
                if (bVar == null) {
                    return;
                }
                b remove = this.a.remove(bVar);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean g(c.a.n0.a.y0.c.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            c.a.n0.a.u.d.i("map", "map remove start");
            if (q0.m(cVar.f6097c) == null) {
                c.a.n0.a.u.d.c("map", "webView is null or mapModel is null");
                return false;
            }
            c.a.n0.a.f.e.d A = f.U().A(cVar.f6097c);
            if (!(A instanceof c.a.n0.a.f.e.b)) {
                c.a.n0.a.u.d.c("map", "WebViewManager is null");
                return false;
            }
            b c2 = c((c.a.n0.a.f.e.b) A);
            c.a.n0.m.i.c d2 = c2.d(cVar.f6096b);
            if (d2 == null) {
                c.a.n0.a.u.d.c("map", "remove map with id " + cVar.f6096b + " not exist");
                return false;
            } else if (c2.j(cVar.f6096b)) {
                c.a.n0.a.u.d.i("map", "map remove end");
                if (c.a.n0.a.s.d.a.a(cVar) == null) {
                    c.a.n0.a.s.g.a.a("map", "remove with a null map component");
                }
                c.a.n0.a.s.b.c B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = f9022c;
                    c.a.n0.a.u.d.c(str, "map remove fail: " + B.f6103b);
                }
                return a;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, c.a.n0.a.y0.c.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, cVar)) == null) {
            c.a.n0.a.u.d.i("map", "map update start");
            if (q0.m(cVar.f6097c) == null) {
                c.a.n0.a.u.d.c("map", "webView is null or mapModel is null");
                return false;
            }
            c.a.n0.a.f.e.d A = f.U().A(cVar.f6097c);
            if (A != null && (A instanceof c.a.n0.a.f.e.b)) {
                b c2 = c((c.a.n0.a.f.e.b) A);
                c.a.n0.m.i.c d2 = c2.d(cVar.f6096b);
                if (d2 == null) {
                    c.a.n0.a.u.d.c("map", "remove map with id " + cVar.f6096b + " not exist");
                    return false;
                }
                d2.F();
                c.a.n0.m.f.f.f.b(context, d2, cVar, c2, true);
                c.a.n0.a.u.d.i("map", "map update end");
                if (c.a.n0.a.s.d.a.a(cVar) == null) {
                    c.a.n0.a.s.g.a.a("map", "update with a null map component");
                }
                c.a.n0.a.s.b.c update = d2.update((c.a.n0.m.i.c) cVar);
                boolean a = update.a();
                if (!a) {
                    String str = f9022c;
                    c.a.n0.a.u.d.c(str, "map update fail: " + update.f6103b);
                }
                return a;
            }
            c.a.n0.a.u.d.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
