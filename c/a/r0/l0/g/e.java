package c.a.r0.l0.g;

import android.os.Trace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes2.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65536, null) == null) && c.a.q0.r.e.e()) {
            Trace.endSection();
        }
    }

    public static final void b(String name) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, name) == null) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (c.a.q0.r.e.e()) {
                Trace.beginSection(name);
            }
        }
    }
}
