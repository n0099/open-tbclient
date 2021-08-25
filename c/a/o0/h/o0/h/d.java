package c.a.o0.h.o0.h;

import androidx.annotation.NonNull;
import c.a.o0.a.a2.e;
import c.a.o0.a.k;
import c.a.o0.h.o0.h.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11484a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1186872355, "Lc/a/o0/h/o0/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1186872355, "Lc/a/o0/h/o0/h/d;");
                return;
            }
        }
        f11484a = k.f7049a;
    }

    public static void a(@NonNull e eVar, @NonNull a.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, eVar, eVar2) == null) {
            long l = eVar.L().l("launch_time", 0L);
            if (l <= 0) {
                boolean z = f11484a;
                return;
            }
            c.a.o0.a.j2.p.e eVar3 = new c.a.o0.a.j2.p.e();
            eVar3.f7035a = c.a.o0.a.j2.k.m(eVar.L().G());
            eVar3.f7040f = eVar.getAppId();
            eVar3.f7037c = eVar.L().T();
            eVar3.f7036b = "startup";
            eVar3.f7041g = eVar2.f11480a;
            eVar3.f7039e = eVar2.f11481b;
            eVar3.a("na_start", Long.valueOf(l));
            eVar3.a("h5_start", Long.valueOf(eVar2.f11482c));
            eVar3.a("h5_finish", Long.valueOf(eVar2.f11483d));
            c.a.o0.a.j2.k.u("1235", eVar3);
        }
    }
}
