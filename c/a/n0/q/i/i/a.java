package c.a.n0.q.i.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.q.h.h;
import c.a.n0.q.h.i;
import c.a.n0.q.i.l.c;
import c.a.n0.q.i.l.d;
import c.a.n0.q.i.l.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull c.a.n0.q.i.l.b bVar, @Nullable List<h> list, @Nullable List<i> list2, @NonNull c.a.n0.q.e.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, bVar, list, list2, iVar) == null) {
            c.a.n0.q.i.i.g.i b2 = c.a.n0.q.i.i.c.a.b(bVar, iVar);
            if (list != null && !list.isEmpty()) {
                c.a.n0.q.i.i.c.a.a(b2, c.a.n0.q.i.i.g.h.h(list, iVar));
            }
            if (list2 != null && !list2.isEmpty()) {
                c.a.n0.q.i.i.c.a.a(b2, c.a.n0.q.i.i.g.h.e(list2, iVar));
            }
            b2.e();
        }
    }

    public static void b(c cVar, c.a.n0.q.e.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, cVar, iVar) == null) {
            c.a.n0.q.i.i.c.a.c(cVar, iVar);
        }
    }

    public static void c(d dVar, c.a.n0.q.e.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, dVar, iVar) == null) {
            c.a.n0.q.i.i.c.a.d(dVar, iVar);
        }
    }

    public static void d(e eVar, c.a.n0.q.e.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, eVar, iVar) == null) {
            c.a.n0.q.i.i.c.a.e(eVar, iVar);
        }
    }

    public static void e(c.a.n0.q.j.k.a aVar, c.a.n0.q.e.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, iVar) == null) {
            c.a.n0.q.i.i.c.a.f(aVar, iVar);
        }
    }

    public static synchronized void f(List<i> list, c.a.n0.q.e.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, list, iVar) == null) {
            synchronized (a.class) {
                c.a.n0.q.i.i.c.a.g(list, iVar);
            }
        }
    }
}
