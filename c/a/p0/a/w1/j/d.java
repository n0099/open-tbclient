package c.a.p0.a.w1.j;

import androidx.annotation.NonNull;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.j2.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d extends c.a.p0.a.j2.p.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            b.a L = c.a.p0.a.a2.d.g().r().L();
            c.a.p0.a.j2.p.f fVar = new c.a.p0.a.j2.p.f();
            fVar.f7064b = str;
            fVar.f7063a = k.m(L.G());
            fVar.f7068f = L.H();
            fVar.f7065c = L.T();
            k.u("1088", fVar);
        }
    }
}
