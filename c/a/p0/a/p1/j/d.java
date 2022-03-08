package c.a.p0.a.p1.j;

import androidx.annotation.NonNull;
import c.a.p0.a.d2.n;
import c.a.p0.a.v0.e.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d extends c.a.p0.a.d2.s.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            b.a V = c.a.p0.a.t1.d.J().r().V();
            c.a.p0.a.d2.s.f fVar = new c.a.p0.a.d2.s.f();
            fVar.f4947b = str;
            fVar.a = n.n(V.G());
            fVar.f4951f = V.H();
            fVar.f4948c = V.T();
            n.x("1088", fVar);
        }
    }
}
