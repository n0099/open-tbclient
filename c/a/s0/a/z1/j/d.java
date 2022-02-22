package c.a.s0.a.z1.j;

import androidx.annotation.NonNull;
import c.a.s0.a.f1.e.b;
import c.a.s0.a.n2.n;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class d extends c.a.s0.a.n2.s.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            b.a V = c.a.s0.a.d2.d.J().r().V();
            c.a.s0.a.n2.s.f fVar = new c.a.s0.a.n2.s.f();
            fVar.f8219b = str;
            fVar.a = n.n(V.G());
            fVar.f8223f = V.H();
            fVar.f8220c = V.T();
            n.x("1088", fVar);
        }
    }
}
