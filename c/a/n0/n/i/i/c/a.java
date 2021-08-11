package c.a.n0.n.i.i.c;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.n.f.g;
import c.a.n0.n.i.i.g.d;
import c.a.n0.n.i.i.g.f;
import c.a.n0.n.i.i.g.h;
import c.a.n0.n.i.i.g.i;
import c.a.n0.n.i.l.a;
import c.a.n0.n.i.l.b;
import c.a.n0.n.i.l.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static i a(c.a.n0.n.i.l.a aVar, g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, aVar, gVar)) == null) {
            List<f<a.C0613a>> e2 = h.e(aVar.f11681a, gVar);
            i iVar = new i(gVar);
            for (f<a.C0613a> fVar : e2) {
                iVar.c(d.b().a(fVar));
            }
            return iVar;
        }
        return (i) invokeLL.objValue;
    }

    public static synchronized void b(b bVar, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bVar, gVar) == null) {
            synchronized (a.class) {
                f<c.a.n0.n.h.d> d2 = h.d(bVar.f11691c, gVar);
                f<c.a.n0.n.h.f> f2 = h.f(bVar.f11689a, gVar);
                f<c.a.n0.n.h.b> c2 = h.c(bVar.f11693e, gVar);
                List<f<c.a.n0.n.h.g>> g2 = h.g(bVar.f11690b, gVar);
                i iVar = new i(gVar);
                iVar.c(d.b().a(d2));
                iVar.c(d.b().a(f2));
                iVar.c(d.b().a(c2));
                for (f<c.a.n0.n.h.g> fVar : g2) {
                    iVar.c(d.b().a(fVar));
                }
                iVar.e();
            }
        }
    }

    public static synchronized void c(c cVar, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cVar, gVar) == null) {
            synchronized (a.class) {
                f<c.a.n0.n.h.h> h2 = h.h(cVar.f11694a, gVar);
                i iVar = new i(gVar);
                iVar.c(d.b().a(h2));
                iVar.e();
            }
        }
    }

    public static synchronized void d(c.a.n0.n.i.l.d dVar, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, dVar, gVar) == null) {
            synchronized (a.class) {
                List<f<c.a.n0.n.h.g>> g2 = h.g(dVar.f11695a, gVar);
                i iVar = new i(gVar);
                for (f<c.a.n0.n.h.g> fVar : g2) {
                    iVar.c(d.b().a(fVar));
                }
                iVar.e();
            }
        }
    }

    public static synchronized void e(c.a.n0.n.j.k.a aVar, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, gVar) == null) {
            synchronized (a.class) {
                f<c.a.n0.n.h.d> d2 = h.d(aVar.f11775b, gVar);
                f<c.a.n0.n.h.d> d3 = h.d(aVar.f11774a, gVar);
                f<c.a.n0.n.h.b> c2 = h.c(aVar.f11776c, gVar);
                i iVar = new i(gVar);
                if (d2 != null) {
                    iVar.c(d.b().a(d2));
                }
                if (d3 != null) {
                    iVar.c(d.b().a(d3));
                }
                if (c2 != null) {
                    iVar.c(d.b().a(c2));
                }
                if (aVar.f11777d != null) {
                    for (c.a.n0.n.h.i iVar2 : aVar.f11777d) {
                        f<c.a.n0.n.h.i> i2 = h.i(iVar2, gVar);
                        if (i2 != null) {
                            iVar.c(d.b().a(i2));
                        }
                    }
                }
                if (aVar.f11778e != null) {
                    for (c.a.n0.n.h.h hVar : aVar.f11778e) {
                        f<c.a.n0.n.h.h> h2 = h.h(hVar, gVar);
                        if (h2 != null) {
                            iVar.c(d.b().a(h2));
                        }
                    }
                }
                iVar.e();
            }
        }
    }
}
