package c.a.n0.a.w1.j;

import androidx.annotation.NonNull;
import c.a.n0.a.f1.e.b;
import c.a.n0.a.j2.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class c extends c.a.n0.a.j2.p.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            b.a L = c.a.n0.a.a2.d.g().r().L();
            c.a.n0.a.j2.p.f fVar = new c.a.n0.a.j2.p.f();
            fVar.f6790b = str;
            fVar.f6789a = k.m(L.G());
            fVar.f6794f = L.H();
            fVar.f6791c = L.T();
            k.u("1045", fVar);
        }
    }
}
