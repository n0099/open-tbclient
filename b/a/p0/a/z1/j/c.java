package b.a.p0.a.z1.j;

import androidx.annotation.NonNull;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.n2.n;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class c extends b.a.p0.a.n2.s.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            b.a V = b.a.p0.a.d2.d.J().r().V();
            b.a.p0.a.n2.s.f fVar = new b.a.p0.a.n2.s.f();
            fVar.f7380b = str;
            fVar.f7379a = n.n(V.G());
            fVar.f7384f = V.H();
            fVar.f7381c = V.T();
            n.x("1045", fVar);
        }
    }
}
