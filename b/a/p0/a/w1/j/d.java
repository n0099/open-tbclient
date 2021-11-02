package b.a.p0.a.w1.j;

import androidx.annotation.NonNull;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.j2.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d extends b.a.p0.a.j2.p.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            b.a K = b.a.p0.a.a2.d.g().r().K();
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            fVar.f6384b = str;
            fVar.f6383a = k.m(K.F());
            fVar.f6388f = K.G();
            fVar.f6385c = K.S();
            k.u("1088", fVar);
        }
    }
}
