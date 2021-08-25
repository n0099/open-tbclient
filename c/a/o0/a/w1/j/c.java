package c.a.o0.a.w1.j;

import androidx.annotation.NonNull;
import c.a.o0.a.f1.e.b;
import c.a.o0.a.j2.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class c extends c.a.o0.a.j2.p.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void onEvent(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            b.a L = c.a.o0.a.a2.d.g().r().L();
            c.a.o0.a.j2.p.f fVar = new c.a.o0.a.j2.p.f();
            fVar.f7036b = str;
            fVar.f7035a = k.m(L.G());
            fVar.f7040f = L.H();
            fVar.f7037c = L.T();
            k.u("1045", fVar);
        }
    }
}
