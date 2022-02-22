package c.a.s0.j.j0;

import android.text.TextUtils;
import c.a.s0.a.d2.e;
import c.a.s0.q.j.m.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i2, long j2, long j3);

        void b(int i2);

        void success();
    }

    public static void a(String str, a aVar) {
        e L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, str, aVar) == null) || aVar == null || TextUtils.isEmpty(str) || (L = e.L()) == null) {
            return;
        }
        if (c.a.s0.j.j0.a.b().d(str)) {
            aVar.success();
            return;
        }
        String a2 = c.a.s0.j.j0.a.b().a(str);
        if (TextUtils.isEmpty(a2)) {
            aVar.b(2112);
        } else {
            c.a.s0.q.b.h(new g(L.f5779f, L.j0(), a2, 1), new c.a.s0.j.j0.e.a(L.f5779f, L.j0(), c.a.s0.j.j0.a.b().c(str, 2), aVar));
        }
    }
}
