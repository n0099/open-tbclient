package c.a.n0.q.i.i.c;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.q.h.e;
import c.a.n0.q.h.g;
import c.a.n0.q.h.j;
import c.a.n0.q.i.i.g.d;
import c.a.n0.q.i.i.g.f;
import c.a.n0.q.i.i.g.h;
import c.a.n0.q.i.i.g.i;
import c.a.n0.q.i.l.b;
import c.a.n0.q.i.l.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull i iVar, @NonNull List<f<T>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, iVar, list) == null) {
            for (f<T> fVar : list) {
                iVar.c(d.b().a(fVar));
            }
        }
    }

    @NonNull
    public static i b(b bVar, c.a.n0.q.e.i iVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bVar, iVar)) == null) {
            List<f<b.a>> f2 = h.f(bVar.a, iVar);
            i iVar2 = new i(iVar);
            for (f<b.a> fVar : f2) {
                iVar2.c(d.b().a(fVar));
            }
            return iVar2;
        }
        return (i) invokeLL.objValue;
    }

    public static synchronized void c(c cVar, c.a.n0.q.e.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cVar, iVar) == null) {
            synchronized (a.class) {
                f<e> d2 = h.d(cVar.f9204d, iVar);
                f<g> g2 = h.g(cVar.a, iVar);
                f<c.a.n0.q.h.c> c2 = h.c(cVar.f9206f, iVar);
                List<f<c.a.n0.q.h.h>> h2 = h.h(cVar.f9202b, iVar);
                List<f<c.a.n0.q.h.i>> e2 = h.e(cVar.f9203c, iVar);
                i iVar2 = new i(iVar);
                iVar2.c(d.b().a(d2));
                iVar2.c(d.b().a(g2));
                iVar2.c(d.b().a(c2));
                a(iVar2, h2);
                a(iVar2, e2);
                iVar2.e();
            }
        }
    }

    public static synchronized void d(c.a.n0.q.i.l.d dVar, c.a.n0.q.e.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, dVar, iVar) == null) {
            synchronized (a.class) {
                f<c.a.n0.q.h.i> i = h.i(dVar.a, iVar);
                i iVar2 = new i(iVar);
                iVar2.c(d.b().a(i));
                iVar2.e();
            }
        }
    }

    public static synchronized void e(c.a.n0.q.i.l.e eVar, c.a.n0.q.e.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, eVar, iVar) == null) {
            synchronized (a.class) {
                List<f<c.a.n0.q.h.h>> h2 = h.h(eVar.a, iVar);
                i iVar2 = new i(iVar);
                for (f<c.a.n0.q.h.h> fVar : h2) {
                    iVar2.c(d.b().a(fVar));
                }
                iVar2.e();
            }
        }
    }

    public static synchronized void f(c.a.n0.q.j.k.a aVar, c.a.n0.q.e.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, aVar, iVar) == null) {
            synchronized (a.class) {
                f<e> d2 = h.d(aVar.f9270b, iVar);
                f<e> d3 = h.d(aVar.a, iVar);
                f<c.a.n0.q.h.c> c2 = h.c(aVar.f9271c, iVar);
                i iVar2 = new i(iVar);
                if (d2 != null) {
                    iVar2.c(d.b().a(d2));
                }
                if (d3 != null) {
                    iVar2.c(d.b().a(d3));
                }
                if (c2 != null) {
                    iVar2.c(d.b().a(c2));
                }
                if (aVar.f9272d != null) {
                    for (j jVar : aVar.f9272d) {
                        f<j> j = h.j(jVar, iVar);
                        if (j != null) {
                            iVar2.c(d.b().a(j));
                        }
                    }
                }
                if (aVar.f9273e != null) {
                    for (c.a.n0.q.h.i iVar3 : aVar.f9273e) {
                        f<c.a.n0.q.h.i> i = h.i(iVar3, iVar);
                        if (i != null) {
                            iVar2.c(d.b().a(i));
                        }
                    }
                }
                iVar2.e();
            }
        }
    }

    public static synchronized void g(List<c.a.n0.q.h.i> list, c.a.n0.q.e.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, iVar) == null) {
            synchronized (a.class) {
                List<f<c.a.n0.q.h.i>> e2 = h.e(list, iVar);
                i iVar2 = new i(iVar);
                a(iVar2, e2);
                iVar2.e();
            }
        }
    }
}
