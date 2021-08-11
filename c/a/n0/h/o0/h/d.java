package c.a.n0.h.o0.h;

import androidx.annotation.NonNull;
import c.a.n0.a.a2.e;
import c.a.n0.a.k;
import c.a.n0.h.o0.h.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11238a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1315955074, "Lc/a/n0/h/o0/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1315955074, "Lc/a/n0/h/o0/h/d;");
                return;
            }
        }
        f11238a = k.f6803a;
    }

    public static void a(@NonNull e eVar, @NonNull a.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, eVar, eVar2) == null) {
            long l = eVar.L().l("launch_time", 0L);
            if (l <= 0) {
                boolean z = f11238a;
                return;
            }
            c.a.n0.a.j2.p.e eVar3 = new c.a.n0.a.j2.p.e();
            eVar3.f6789a = c.a.n0.a.j2.k.m(eVar.L().G());
            eVar3.f6794f = eVar.getAppId();
            eVar3.f6791c = eVar.L().T();
            eVar3.f6790b = "startup";
            eVar3.f6795g = eVar2.f11234a;
            eVar3.f6793e = eVar2.f11235b;
            eVar3.a("na_start", Long.valueOf(l));
            eVar3.a("h5_start", Long.valueOf(eVar2.f11236c));
            eVar3.a("h5_finish", Long.valueOf(eVar2.f11237d));
            c.a.n0.a.j2.k.u("1235", eVar3);
        }
    }
}
