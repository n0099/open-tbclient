package b.a.p0.h.j0;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(b.a.p0.a.l0.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, aVar) == null) && aVar != null && aVar.n().hasEventListener("audiointerruptionbegin") && b.a.p0.h.c.j.b.h().i()) {
            aVar.i0(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(b.a.p0.a.l0.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, aVar) == null) && aVar != null && aVar.n().hasEventListener("audiointerruptionend")) {
            aVar.i0(new JSEvent("audiointerruptionend"));
        }
    }
}
