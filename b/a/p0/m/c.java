package b.a.p0.m;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.z2.q0;
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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f11587b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f11588c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f11589d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<b.a.p0.a.p.e.b, b> f11590a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-613041374, "Lb/a/p0/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-613041374, "Lb/a/p0/m/c;");
                return;
            }
        }
        f11587b = b.a.p0.a.k.f6863a;
        f11588c = c.class.getSimpleName();
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
        this.f11590a = new HashMap();
    }

    public static c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f11589d == null) {
                synchronized (c.class) {
                    if (f11589d == null) {
                        f11589d = new c();
                    }
                }
            }
            return f11589d;
        }
        return (c) invokeV.objValue;
    }

    public static void d(b.a.p0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            synchronized (c.class) {
                if (f11589d != null) {
                    f11589d.c(bVar).h();
                }
            }
        }
    }

    public static void e(b.a.p0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar) == null) {
            synchronized (c.class) {
                if (f11589d != null) {
                    f11589d.f(bVar);
                } else {
                    boolean z = f11587b;
                }
            }
        }
    }

    public static void h(b.a.p0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar) == null) {
            synchronized (c.class) {
                if (f11589d != null) {
                    f11589d.c(bVar).k();
                }
            }
        }
    }

    public boolean a(Context context, b.a.p0.a.i1.c.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, cVar)) == null) {
            b.a.p0.a.e0.d.i("map", "map create start");
            if (q0.m(cVar.f4197g) != null && cVar.isValid()) {
                b.a.p0.a.p.e.d A = b.a.p0.a.g1.f.U().A(cVar.f4197g);
                if (!(A instanceof b.a.p0.a.p.e.b)) {
                    b.a.p0.a.e0.d.c("map", "WebViewManager is null");
                    return false;
                }
                b c2 = c((b.a.p0.a.p.e.b) A);
                if (c2.d(cVar.f4196f) != null) {
                    b.a.p0.a.e0.d.c("map", "map with id " + cVar.f4196f + " exist");
                    return false;
                }
                b.a.p0.m.o.c K = b.a.p0.m.o.c.K(context, cVar);
                if (K == null) {
                    b.a.p0.a.e0.d.c("map", "map with id " + cVar.f4196f + " model is invalid");
                    return false;
                }
                b.a.p0.a.c0.b.c insert = K.insert();
                if (!insert.a()) {
                    b.a.p0.a.e0.d.c("map", "map with id " + cVar.f4196f + " create fail: " + insert.f4201b);
                    return false;
                } else if (c2.insert(K)) {
                    b.a.p0.a.e0.d.i("map", "map with id " + cVar.f4196f + " init start");
                    b.a.p0.m.l.f.f.a(context, K, cVar, c2);
                    b.a.p0.a.e0.d.i("map", "map with id " + cVar.f4196f + " init end");
                    b.a.p0.a.e0.d.i("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            b.a.p0.a.e0.d.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized b c(b.a.p0.a.p.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            synchronized (this) {
                if (bVar == null) {
                    return null;
                }
                b bVar2 = this.f11590a.get(bVar);
                if (bVar2 == null) {
                    bVar2 = new b();
                    this.f11590a.put(bVar, bVar2);
                }
                return bVar2;
            }
        }
        return (b) invokeL.objValue;
    }

    public final synchronized void f(b.a.p0.a.p.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            synchronized (this) {
                if (bVar == null) {
                    return;
                }
                b remove = this.f11590a.remove(bVar);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean g(b.a.p0.a.i1.c.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            b.a.p0.a.e0.d.i("map", "map remove start");
            if (q0.m(cVar.f4197g) == null) {
                b.a.p0.a.e0.d.c("map", "webView is null or mapModel is null");
                return false;
            }
            b.a.p0.a.p.e.d A = b.a.p0.a.g1.f.U().A(cVar.f4197g);
            if (!(A instanceof b.a.p0.a.p.e.b)) {
                b.a.p0.a.e0.d.c("map", "WebViewManager is null");
                return false;
            }
            b c2 = c((b.a.p0.a.p.e.b) A);
            b.a.p0.m.o.c d2 = c2.d(cVar.f4196f);
            if (d2 == null) {
                b.a.p0.a.e0.d.c("map", "remove map with id " + cVar.f4196f + " not exist");
                return false;
            } else if (c2.j(cVar.f4196f)) {
                b.a.p0.a.e0.d.i("map", "map remove end");
                if (b.a.p0.a.c0.d.a.a(cVar) == null) {
                    b.a.p0.a.c0.g.a.a("map", "remove with a null map component");
                }
                b.a.p0.a.c0.b.c B = d2.B();
                boolean a2 = B.a();
                if (!a2) {
                    String str = f11588c;
                    b.a.p0.a.e0.d.c(str, "map remove fail: " + B.f4201b);
                }
                return a2;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, b.a.p0.a.i1.c.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, cVar)) == null) {
            b.a.p0.a.e0.d.i("map", "map update start");
            if (q0.m(cVar.f4197g) == null) {
                b.a.p0.a.e0.d.c("map", "webView is null or mapModel is null");
                return false;
            }
            b.a.p0.a.p.e.d A = b.a.p0.a.g1.f.U().A(cVar.f4197g);
            if (A != null && (A instanceof b.a.p0.a.p.e.b)) {
                b c2 = c((b.a.p0.a.p.e.b) A);
                b.a.p0.m.o.c d2 = c2.d(cVar.f4196f);
                if (d2 == null) {
                    b.a.p0.a.e0.d.c("map", "remove map with id " + cVar.f4196f + " not exist");
                    return false;
                }
                d2.F();
                b.a.p0.m.l.f.f.b(context, d2, cVar, c2, true);
                b.a.p0.a.e0.d.i("map", "map update end");
                if (b.a.p0.a.c0.d.a.a(cVar) == null) {
                    b.a.p0.a.c0.g.a.a("map", "update with a null map component");
                }
                b.a.p0.a.c0.b.c update = d2.update((b.a.p0.m.o.c) cVar);
                boolean a2 = update.a();
                if (!a2) {
                    String str = f11588c;
                    b.a.p0.a.e0.d.c(str, "map update fail: " + update.f4201b);
                }
                return a2;
            }
            b.a.p0.a.e0.d.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
