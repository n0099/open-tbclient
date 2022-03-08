package c.a.p0.m;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.p2.q0;
import c.a.p0.a.w0.f;
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
    public static final boolean f10815b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f10816c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f10817d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<c.a.p0.a.f.e.b, b> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1884974563, "Lc/a/p0/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1884974563, "Lc/a/p0/m/c;");
                return;
            }
        }
        f10815b = c.a.p0.a.a.a;
        f10816c = c.class.getSimpleName();
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
        this.a = new HashMap();
    }

    public static c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f10817d == null) {
                synchronized (c.class) {
                    if (f10817d == null) {
                        f10817d = new c();
                    }
                }
            }
            return f10817d;
        }
        return (c) invokeV.objValue;
    }

    public static void d(c.a.p0.a.f.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            synchronized (c.class) {
                if (f10817d != null) {
                    f10817d.c(bVar).h();
                }
            }
        }
    }

    public static void e(c.a.p0.a.f.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar) == null) {
            synchronized (c.class) {
                if (f10817d != null) {
                    f10817d.f(bVar);
                } else {
                    boolean z = f10815b;
                }
            }
        }
    }

    public static void h(c.a.p0.a.f.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, bVar) == null) {
            synchronized (c.class) {
                if (f10817d != null) {
                    f10817d.c(bVar).k();
                }
            }
        }
    }

    public boolean a(Context context, c.a.p0.a.y0.c.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, cVar)) == null) {
            c.a.p0.a.u.d.i("map", "map create start");
            if (q0.m(cVar.f7284g) != null && cVar.isValid()) {
                c.a.p0.a.f.e.d A = f.U().A(cVar.f7284g);
                if (!(A instanceof c.a.p0.a.f.e.b)) {
                    c.a.p0.a.u.d.c("map", "WebViewManager is null");
                    return false;
                }
                b c2 = c((c.a.p0.a.f.e.b) A);
                if (c2.d(cVar.f7283f) != null) {
                    c.a.p0.a.u.d.c("map", "map with id " + cVar.f7283f + " exist");
                    return false;
                }
                c.a.p0.m.i.c K = c.a.p0.m.i.c.K(context, cVar);
                if (K == null) {
                    c.a.p0.a.u.d.c("map", "map with id " + cVar.f7283f + " model is invalid");
                    return false;
                }
                c.a.p0.a.s.b.c insert = K.insert();
                if (!insert.a()) {
                    c.a.p0.a.u.d.c("map", "map with id " + cVar.f7283f + " create fail: " + insert.f7288b);
                    return false;
                } else if (c2.insert(K)) {
                    c.a.p0.a.u.d.i("map", "map with id " + cVar.f7283f + " init start");
                    c.a.p0.m.f.f.f.a(context, K, cVar, c2);
                    c.a.p0.a.u.d.i("map", "map with id " + cVar.f7283f + " init end");
                    c.a.p0.a.u.d.i("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            c.a.p0.a.u.d.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized b c(c.a.p0.a.f.e.b bVar) {
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

    public final synchronized void f(c.a.p0.a.f.e.b bVar) {
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

    public boolean g(c.a.p0.a.y0.c.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            c.a.p0.a.u.d.i("map", "map remove start");
            if (q0.m(cVar.f7284g) == null) {
                c.a.p0.a.u.d.c("map", "webView is null or mapModel is null");
                return false;
            }
            c.a.p0.a.f.e.d A = f.U().A(cVar.f7284g);
            if (!(A instanceof c.a.p0.a.f.e.b)) {
                c.a.p0.a.u.d.c("map", "WebViewManager is null");
                return false;
            }
            b c2 = c((c.a.p0.a.f.e.b) A);
            c.a.p0.m.i.c d2 = c2.d(cVar.f7283f);
            if (d2 == null) {
                c.a.p0.a.u.d.c("map", "remove map with id " + cVar.f7283f + " not exist");
                return false;
            } else if (c2.j(cVar.f7283f)) {
                c.a.p0.a.u.d.i("map", "map remove end");
                if (c.a.p0.a.s.d.a.a(cVar) == null) {
                    c.a.p0.a.s.g.a.a("map", "remove with a null map component");
                }
                c.a.p0.a.s.b.c B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = f10816c;
                    c.a.p0.a.u.d.c(str, "map remove fail: " + B.f7288b);
                }
                return a;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, c.a.p0.a.y0.c.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, cVar)) == null) {
            c.a.p0.a.u.d.i("map", "map update start");
            if (q0.m(cVar.f7284g) == null) {
                c.a.p0.a.u.d.c("map", "webView is null or mapModel is null");
                return false;
            }
            c.a.p0.a.f.e.d A = f.U().A(cVar.f7284g);
            if (A != null && (A instanceof c.a.p0.a.f.e.b)) {
                b c2 = c((c.a.p0.a.f.e.b) A);
                c.a.p0.m.i.c d2 = c2.d(cVar.f7283f);
                if (d2 == null) {
                    c.a.p0.a.u.d.c("map", "remove map with id " + cVar.f7283f + " not exist");
                    return false;
                }
                d2.F();
                c.a.p0.m.f.f.f.b(context, d2, cVar, c2, true);
                c.a.p0.a.u.d.i("map", "map update end");
                if (c.a.p0.a.s.d.a.a(cVar) == null) {
                    c.a.p0.a.s.g.a.a("map", "update with a null map component");
                }
                c.a.p0.a.s.b.c update = d2.update((c.a.p0.m.i.c) cVar);
                boolean a = update.a();
                if (!a) {
                    String str = f10816c;
                    c.a.p0.a.u.d.c(str, "map update fail: " + update.f7288b);
                }
                return a;
            }
            c.a.p0.a.u.d.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
