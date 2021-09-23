package c.a.p0.h.i0;

import android.text.TextUtils;
import c.a.p0.a.a2.e;
import c.a.p0.n.i.m.f;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i2, long j2, long j3);

        void b(int i2);

        void success();
    }

    public static void a(String str, a aVar) {
        e i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, str, aVar) == null) || aVar == null || TextUtils.isEmpty(str) || (i2 = e.i()) == null) {
            return;
        }
        if (c.a.p0.h.i0.a.b().d(str)) {
            aVar.success();
            return;
        }
        String a2 = c.a.p0.h.i0.a.b().a(str);
        if (TextUtils.isEmpty(a2)) {
            aVar.b(2112);
        } else {
            c.a.p0.n.b.f(new f(i2.f4566f, i2.Z(), a2, 1), new c.a.p0.h.i0.e.a(i2.f4566f, i2.Z(), c.a.p0.h.i0.a.b().c(str, 2), aVar));
        }
    }
}
