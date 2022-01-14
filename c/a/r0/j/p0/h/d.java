package c.a.r0.j.p0.h;

import androidx.annotation.NonNull;
import c.a.r0.a.d2.e;
import c.a.r0.a.k;
import c.a.r0.a.n2.n;
import c.a.r0.j.p0.h.a;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(767937853, "Lc/a/r0/j/p0/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(767937853, "Lc/a/r0/j/p0/h/d;");
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
            c.a.r0.a.n2.s.e eVar3 = new c.a.r0.a.n2.s.e();
            eVar3.a = n.n(eVar.V().G());
            eVar3.f7981f = eVar.getAppId();
            eVar3.f7978c = eVar.V().T();
            eVar3.f7977b = NodeJS.STARTUP_SCRIPT_NAME;
            eVar3.f7982g = eVar2.a;
            eVar3.f7980e = eVar2.f11229b;
            eVar3.a("na_start", Long.valueOf(l));
            eVar3.a("h5_start", Long.valueOf(eVar2.f11230c));
            eVar3.a("h5_finish", Long.valueOf(eVar2.f11231d));
            n.x("1235", eVar3);
        }
    }
}
