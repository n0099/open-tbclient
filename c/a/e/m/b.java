package c.a.e.m;

import androidx.core.view.InputDeviceCompat;
import c.a.t0.j3.l0.e;
import c.a.t0.j3.l0.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(c.a.e.m.g.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, aVar, str) == null) {
            c.a.t0.j3.l0.c f2 = g.f(aVar);
            f2.c(str);
            f2.j(aVar.f3527h);
            e.b().d(f2);
        }
    }

    public static void b(c.a.e.m.g.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, aVar, i2) == null) {
            c.a.t0.j3.l0.c f2 = g.f(aVar);
            f2.j(aVar.f3527h);
            f2.l(aVar.f3525f);
            f2.n(i2);
            e.b().d(f2);
        }
    }

    public static void c(c.a.e.m.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            e.b().d(g.q(aVar));
        }
    }

    public static void d(c.a.e.m.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            e.b().d(g.p(aVar));
        }
    }

    public static void e(c.a.e.m.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar) == null) {
            c.a.t0.j3.l0.c f2 = g.f(aVar);
            f2.j(aVar.f3527h);
            e.b().d(f2);
        }
    }

    public static void f(c.a.e.m.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, aVar) == null) {
            e.b().d(g.q(aVar));
        }
    }

    public static void g(c.a.e.m.g.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65542, null, aVar, i2) == null) {
            c.a.t0.j3.l0.c n = g.n(aVar);
            n.i(706);
            boolean z = i2 == 1000;
            n.c(z ? "APP" : "URL");
            if (!z) {
                n.l(i2);
            }
            n.h("DEEPLINK");
            e.b().d(n);
        }
    }
}
