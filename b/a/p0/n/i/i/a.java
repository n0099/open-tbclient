package b.a.p0.n.i.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.n.h.g;
import b.a.p0.n.i.i.g.d;
import b.a.p0.n.i.i.g.f;
import b.a.p0.n.i.i.g.h;
import b.a.p0.n.i.i.g.i;
import b.a.p0.n.i.l.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull b.a.p0.n.i.l.a aVar, @Nullable List<g> list, @NonNull b.a.p0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, aVar, list, gVar) == null) {
            i a2 = b.a.p0.n.i.i.c.a.a(aVar, gVar);
            if (list != null && !list.isEmpty()) {
                for (f<g> fVar : h.g(list, gVar)) {
                    a2.c(d.b().a(fVar));
                }
            }
            a2.e();
        }
    }

    public static void b(b.a.p0.n.i.l.b bVar, b.a.p0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bVar, gVar) == null) {
            b.a.p0.n.i.i.c.a.b(bVar, gVar);
        }
    }

    public static void c(c cVar, b.a.p0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, cVar, gVar) == null) {
            b.a.p0.n.i.i.c.a.c(cVar, gVar);
        }
    }

    public static void d(b.a.p0.n.i.l.d dVar, b.a.p0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, dVar, gVar) == null) {
            b.a.p0.n.i.i.c.a.d(dVar, gVar);
        }
    }

    public static void e(b.a.p0.n.j.k.a aVar, b.a.p0.n.f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, gVar) == null) {
            b.a.p0.n.i.i.c.a.e(aVar, gVar);
        }
    }
}
