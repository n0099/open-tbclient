package c.a.s0.j.p0.h;

import androidx.annotation.NonNull;
import c.a.s0.a.d2.e;
import c.a.s0.a.k;
import c.a.s0.a.n2.n;
import c.a.s0.j.p0.h.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.v8.NodeJS;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(897020572, "Lc/a/s0/j/p0/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(897020572, "Lc/a/s0/j/p0/h/d;");
                return;
            }
        }
        a = k.a;
    }

    public static void a(@NonNull e eVar, @NonNull a.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, eVar, eVar2) == null) {
            long l = eVar.V().l("launch_time", 0L);
            if (l <= 0) {
                boolean z = a;
                return;
            }
            c.a.s0.a.n2.s.e eVar3 = new c.a.s0.a.n2.s.e();
            eVar3.a = n.n(eVar.V().G());
            eVar3.f8223f = eVar.getAppId();
            eVar3.f8220c = eVar.V().T();
            eVar3.f8219b = NodeJS.STARTUP_SCRIPT_NAME;
            eVar3.f8224g = eVar2.a;
            eVar3.f8222e = eVar2.f11471b;
            eVar3.a("na_start", Long.valueOf(l));
            eVar3.a("h5_start", Long.valueOf(eVar2.f11472c));
            eVar3.a("h5_finish", Long.valueOf(eVar2.f11473d));
            n.x("1235", eVar3);
        }
    }
}
