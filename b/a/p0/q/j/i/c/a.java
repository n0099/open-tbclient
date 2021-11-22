package b.a.p0.q.j.i.c;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.q.i.e;
import b.a.p0.q.i.g;
import b.a.p0.q.i.j;
import b.a.p0.q.j.i.g.d;
import b.a.p0.q.j.i.g.f;
import b.a.p0.q.j.i.g.h;
import b.a.p0.q.j.i.g.i;
import b.a.p0.q.j.l.b;
import b.a.p0.q.j.l.c;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
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
    public static i b(b bVar, b.a.p0.q.f.i iVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bVar, iVar)) == null) {
            List<f<b.a>> f2 = h.f(bVar.f11846a, iVar);
            i iVar2 = new i(iVar);
            for (f<b.a> fVar : f2) {
                iVar2.c(d.b().a(fVar));
            }
            return iVar2;
        }
        return (i) invokeLL.objValue;
    }

    public static synchronized void c(c cVar, b.a.p0.q.f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cVar, iVar) == null) {
            synchronized (a.class) {
                f<e> d2 = h.d(cVar.f11858d, iVar);
                f<g> g2 = h.g(cVar.f11855a, iVar);
                f<b.a.p0.q.i.c> c2 = h.c(cVar.f11860f, iVar);
                List<f<b.a.p0.q.i.h>> h2 = h.h(cVar.f11856b, iVar);
                List<f<b.a.p0.q.i.i>> e2 = h.e(cVar.f11857c, iVar);
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

    public static synchronized void d(b.a.p0.q.j.l.d dVar, b.a.p0.q.f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, dVar, iVar) == null) {
            synchronized (a.class) {
                f<b.a.p0.q.i.i> i2 = h.i(dVar.f11861a, iVar);
                i iVar2 = new i(iVar);
                iVar2.c(d.b().a(i2));
                iVar2.e();
            }
        }
    }

    public static synchronized void e(b.a.p0.q.j.l.e eVar, b.a.p0.q.f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, eVar, iVar) == null) {
            synchronized (a.class) {
                List<f<b.a.p0.q.i.h>> h2 = h.h(eVar.f11862a, iVar);
                i iVar2 = new i(iVar);
                for (f<b.a.p0.q.i.h> fVar : h2) {
                    iVar2.c(d.b().a(fVar));
                }
                iVar2.e();
            }
        }
    }

    public static synchronized void f(b.a.p0.q.k.k.a aVar, b.a.p0.q.f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, aVar, iVar) == null) {
            synchronized (a.class) {
                f<e> d2 = h.d(aVar.f11957b, iVar);
                f<e> d3 = h.d(aVar.f11956a, iVar);
                f<b.a.p0.q.i.c> c2 = h.c(aVar.f11958c, iVar);
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
                if (aVar.f11959d != null) {
                    for (j jVar : aVar.f11959d) {
                        f<j> j = h.j(jVar, iVar);
                        if (j != null) {
                            iVar2.c(d.b().a(j));
                        }
                    }
                }
                if (aVar.f11960e != null) {
                    for (b.a.p0.q.i.i iVar3 : aVar.f11960e) {
                        f<b.a.p0.q.i.i> i2 = h.i(iVar3, iVar);
                        if (i2 != null) {
                            iVar2.c(d.b().a(i2));
                        }
                    }
                }
                iVar2.e();
            }
        }
    }

    public static synchronized void g(List<b.a.p0.q.i.i> list, b.a.p0.q.f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, list, iVar) == null) {
            synchronized (a.class) {
                List<f<b.a.p0.q.i.i>> e2 = h.e(list, iVar);
                i iVar2 = new i(iVar);
                a(iVar2, e2);
                iVar2.e();
            }
        }
    }
}
