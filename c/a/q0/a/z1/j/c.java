package c.a.q0.a.z1.j;

import androidx.annotation.NonNull;
import c.a.q0.a.f1.e.b;
import c.a.q0.a.n2.n;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class c extends c.a.q0.a.n2.s.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            b.a V = c.a.q0.a.d2.d.J().r().V();
            c.a.q0.a.n2.s.f fVar = new c.a.q0.a.n2.s.f();
            fVar.f7422b = str;
            fVar.a = n.n(V.G());
            fVar.f7426f = V.H();
            fVar.f7423c = V.T();
            n.x("1045", fVar);
        }
    }
}
