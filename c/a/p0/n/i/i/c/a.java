package c.a.p0.n.i.i.c;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.n.f.g;
import c.a.p0.n.i.i.g.d;
import c.a.p0.n.i.i.g.f;
import c.a.p0.n.i.i.g.h;
import c.a.p0.n.i.i.g.i;
import c.a.p0.n.i.l.a;
import c.a.p0.n.i.l.b;
import c.a.p0.n.i.l.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static i a(c.a.p0.n.i.l.a aVar, g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, aVar, gVar)) == null) {
            List<f<a.C0623a>> e2 = h.e(aVar.f11955a, gVar);
            i iVar = new i(gVar);
            for (f<a.C0623a> fVar : e2) {
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
                f<c.a.p0.n.h.d> d2 = h.d(bVar.f11965c, gVar);
                f<c.a.p0.n.h.f> f2 = h.f(bVar.f11963a, gVar);
                f<c.a.p0.n.h.b> c2 = h.c(bVar.f11967e, gVar);
                List<f<c.a.p0.n.h.g>> g2 = h.g(bVar.f11964b, gVar);
                i iVar = new i(gVar);
                iVar.c(d.b().a(d2));
                iVar.c(d.b().a(f2));
                iVar.c(d.b().a(c2));
                for (f<c.a.p0.n.h.g> fVar : g2) {
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
                f<c.a.p0.n.h.h> h2 = h.h(cVar.f11968a, gVar);
                i iVar = new i(gVar);
                iVar.c(d.b().a(h2));
                iVar.e();
            }
        }
    }

    public static synchronized void d(c.a.p0.n.i.l.d dVar, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, dVar, gVar) == null) {
            synchronized (a.class) {
                List<f<c.a.p0.n.h.g>> g2 = h.g(dVar.f11969a, gVar);
                i iVar = new i(gVar);
                for (f<c.a.p0.n.h.g> fVar : g2) {
                    iVar.c(d.b().a(fVar));
                }
                iVar.e();
            }
        }
    }

    public static synchronized void e(c.a.p0.n.j.k.a aVar, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, gVar) == null) {
            synchronized (a.class) {
                f<c.a.p0.n.h.d> d2 = h.d(aVar.f12049b, gVar);
                f<c.a.p0.n.h.d> d3 = h.d(aVar.f12048a, gVar);
                f<c.a.p0.n.h.b> c2 = h.c(aVar.f12050c, gVar);
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
                if (aVar.f12051d != null) {
                    for (c.a.p0.n.h.i iVar2 : aVar.f12051d) {
                        f<c.a.p0.n.h.i> i2 = h.i(iVar2, gVar);
                        if (i2 != null) {
                            iVar.c(d.b().a(i2));
                        }
                    }
                }
                if (aVar.f12052e != null) {
                    for (c.a.p0.n.h.h hVar : aVar.f12052e) {
                        f<c.a.p0.n.h.h> h2 = h.h(hVar, gVar);
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
