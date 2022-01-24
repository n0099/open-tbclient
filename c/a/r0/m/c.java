package c.a.r0.m;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.z2.q0;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f11490b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f11491c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f11492d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<c.a.r0.a.p.e.b, b> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-634985371, "Lc/a/r0/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-634985371, "Lc/a/r0/m/c;");
                return;
            }
        }
        f11490b = c.a.r0.a.k.a;
        f11491c = c.class.getSimpleName();
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
            if (f11492d == null) {
                synchronized (c.class) {
                    if (f11492d == null) {
                        f11492d = new c();
                    }
                }
            }
            return f11492d;
        }
        return (c) invokeV.objValue;
    }

    public static void d(c.a.r0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            synchronized (c.class) {
                if (f11492d != null) {
                    f11492d.c(bVar).h();
                }
            }
        }
    }

    public static void e(c.a.r0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar) == null) {
            synchronized (c.class) {
                if (f11492d != null) {
                    f11492d.f(bVar);
                } else {
                    boolean z = f11490b;
                }
            }
        }
    }

    public static void h(c.a.r0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, bVar) == null) {
            synchronized (c.class) {
                if (f11492d != null) {
                    f11492d.c(bVar).k();
                }
            }
        }
    }

    public boolean a(Context context, c.a.r0.a.i1.c.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, cVar)) == null) {
            c.a.r0.a.e0.d.i("map", "map create start");
            if (q0.m(cVar.f5451g) != null && cVar.isValid()) {
                c.a.r0.a.p.e.d A = c.a.r0.a.g1.f.U().A(cVar.f5451g);
                if (!(A instanceof c.a.r0.a.p.e.b)) {
                    c.a.r0.a.e0.d.c("map", "WebViewManager is null");
                    return false;
                }
                b c2 = c((c.a.r0.a.p.e.b) A);
                if (c2.d(cVar.f5450f) != null) {
                    c.a.r0.a.e0.d.c("map", "map with id " + cVar.f5450f + " exist");
                    return false;
                }
                c.a.r0.m.o.c K = c.a.r0.m.o.c.K(context, cVar);
                if (K == null) {
                    c.a.r0.a.e0.d.c("map", "map with id " + cVar.f5450f + " model is invalid");
                    return false;
                }
                c.a.r0.a.c0.b.c insert = K.insert();
                if (!insert.a()) {
                    c.a.r0.a.e0.d.c("map", "map with id " + cVar.f5450f + " create fail: " + insert.f5455b);
                    return false;
                } else if (c2.insert(K)) {
                    c.a.r0.a.e0.d.i("map", "map with id " + cVar.f5450f + " init start");
                    c.a.r0.m.l.f.f.a(context, K, cVar, c2);
                    c.a.r0.a.e0.d.i("map", "map with id " + cVar.f5450f + " init end");
                    c.a.r0.a.e0.d.i("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            c.a.r0.a.e0.d.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized b c(c.a.r0.a.p.e.b bVar) {
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

    public final synchronized void f(c.a.r0.a.p.e.b bVar) {
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

    public boolean g(c.a.r0.a.i1.c.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            c.a.r0.a.e0.d.i("map", "map remove start");
            if (q0.m(cVar.f5451g) == null) {
                c.a.r0.a.e0.d.c("map", "webView is null or mapModel is null");
                return false;
            }
            c.a.r0.a.p.e.d A = c.a.r0.a.g1.f.U().A(cVar.f5451g);
            if (!(A instanceof c.a.r0.a.p.e.b)) {
                c.a.r0.a.e0.d.c("map", "WebViewManager is null");
                return false;
            }
            b c2 = c((c.a.r0.a.p.e.b) A);
            c.a.r0.m.o.c d2 = c2.d(cVar.f5450f);
            if (d2 == null) {
                c.a.r0.a.e0.d.c("map", "remove map with id " + cVar.f5450f + " not exist");
                return false;
            } else if (c2.j(cVar.f5450f)) {
                c.a.r0.a.e0.d.i("map", "map remove end");
                if (c.a.r0.a.c0.d.a.a(cVar) == null) {
                    c.a.r0.a.c0.g.a.a("map", "remove with a null map component");
                }
                c.a.r0.a.c0.b.c B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = f11491c;
                    c.a.r0.a.e0.d.c(str, "map remove fail: " + B.f5455b);
                }
                return a;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, c.a.r0.a.i1.c.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, cVar)) == null) {
            c.a.r0.a.e0.d.i("map", "map update start");
            if (q0.m(cVar.f5451g) == null) {
                c.a.r0.a.e0.d.c("map", "webView is null or mapModel is null");
                return false;
            }
            c.a.r0.a.p.e.d A = c.a.r0.a.g1.f.U().A(cVar.f5451g);
            if (A != null && (A instanceof c.a.r0.a.p.e.b)) {
                b c2 = c((c.a.r0.a.p.e.b) A);
                c.a.r0.m.o.c d2 = c2.d(cVar.f5450f);
                if (d2 == null) {
                    c.a.r0.a.e0.d.c("map", "remove map with id " + cVar.f5450f + " not exist");
                    return false;
                }
                d2.F();
                c.a.r0.m.l.f.f.b(context, d2, cVar, c2, true);
                c.a.r0.a.e0.d.i("map", "map update end");
                if (c.a.r0.a.c0.d.a.a(cVar) == null) {
                    c.a.r0.a.c0.g.a.a("map", "update with a null map component");
                }
                c.a.r0.a.c0.b.c update = d2.update((c.a.r0.m.o.c) cVar);
                boolean a = update.a();
                if (!a) {
                    String str = f11491c;
                    c.a.r0.a.e0.d.c(str, "map update fail: " + update.f5455b);
                }
                return a;
            }
            c.a.r0.a.e0.d.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
