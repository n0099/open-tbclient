package c.i.b.a.i0;

import android.annotation.TargetApi;
import android.os.Trace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, str) == null) || v.f33729a < 18) {
            return;
        }
        b(str);
    }

    @TargetApi(18)
    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            Trace.beginSection(str);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || v.f33729a < 18) {
            return;
        }
        d();
    }

    @TargetApi(18)
    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            Trace.endSection();
        }
    }
}
