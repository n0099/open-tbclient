package b.a.p0.q.j.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.q.i.h;
import b.a.p0.q.i.i;
import b.a.p0.q.j.l.c;
import b.a.p0.q.j.l.d;
import b.a.p0.q.j.l.e;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull b.a.p0.q.j.l.b bVar, @Nullable List<h> list, @Nullable List<i> list2, @NonNull b.a.p0.q.f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, bVar, list, list2, iVar) == null) {
            b.a.p0.q.j.i.g.i b2 = b.a.p0.q.j.i.c.a.b(bVar, iVar);
            if (list != null && !list.isEmpty()) {
                b.a.p0.q.j.i.c.a.a(b2, b.a.p0.q.j.i.g.h.h(list, iVar));
            }
            if (list2 != null && !list2.isEmpty()) {
                b.a.p0.q.j.i.c.a.a(b2, b.a.p0.q.j.i.g.h.e(list2, iVar));
            }
            b2.e();
        }
    }

    public static void b(c cVar, b.a.p0.q.f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, cVar, iVar) == null) {
            b.a.p0.q.j.i.c.a.c(cVar, iVar);
        }
    }

    public static void c(d dVar, b.a.p0.q.f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, dVar, iVar) == null) {
            b.a.p0.q.j.i.c.a.d(dVar, iVar);
        }
    }

    public static void d(e eVar, b.a.p0.q.f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, eVar, iVar) == null) {
            b.a.p0.q.j.i.c.a.e(eVar, iVar);
        }
    }

    public static void e(b.a.p0.q.k.k.a aVar, b.a.p0.q.f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar, iVar) == null) {
            b.a.p0.q.j.i.c.a.f(aVar, iVar);
        }
    }

    public static synchronized void f(List<i> list, b.a.p0.q.f.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, list, iVar) == null) {
            synchronized (a.class) {
                b.a.p0.q.j.i.c.a.g(list, iVar);
            }
        }
    }
}
