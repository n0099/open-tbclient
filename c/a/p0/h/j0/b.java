package c.a.p0.h.j0;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(c.a.p0.a.l0.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, aVar) == null) && aVar != null && aVar.o().hasEventListener("audiointerruptionbegin") && c.a.p0.h.c.j.b.h().i()) {
            aVar.S(new JSEvent("audiointerruptionbegin"));
        }
    }

    public static void b(c.a.p0.a.l0.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, aVar) == null) && aVar != null && aVar.o().hasEventListener("audiointerruptionend")) {
            aVar.S(new JSEvent("audiointerruptionend"));
        }
    }
}
