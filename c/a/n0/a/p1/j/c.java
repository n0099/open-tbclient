package c.a.n0.a.p1.j;

import androidx.annotation.NonNull;
import c.a.n0.a.d2.n;
import c.a.n0.a.v0.e.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class c extends c.a.n0.a.d2.s.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            b.a V = c.a.n0.a.t1.d.J().r().V();
            c.a.n0.a.d2.s.f fVar = new c.a.n0.a.d2.s.f();
            fVar.f4188b = str;
            fVar.a = n.n(V.G());
            fVar.f4192f = V.H();
            fVar.f4189c = V.T();
            n.x("1045", fVar);
        }
    }
}
