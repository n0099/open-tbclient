package b.a.p0.h.o0.h;

import androidx.annotation.NonNull;
import b.a.p0.a.a2.e;
import b.a.p0.a.k;
import b.a.p0.h.o0.h.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10712a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-547255459, "Lb/a/p0/h/o0/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-547255459, "Lb/a/p0/h/o0/h/d;");
                return;
            }
        }
        f10712a = k.f6397a;
    }

    public static void a(@NonNull e eVar, @NonNull a.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, eVar, eVar2) == null) {
            long l = eVar.K().l("launch_time", 0L);
            if (l <= 0) {
                boolean z = f10712a;
                return;
            }
            b.a.p0.a.j2.p.e eVar3 = new b.a.p0.a.j2.p.e();
            eVar3.f6383a = b.a.p0.a.j2.k.m(eVar.K().F());
            eVar3.f6388f = eVar.getAppId();
            eVar3.f6385c = eVar.K().S();
            eVar3.f6384b = "startup";
            eVar3.f6389g = eVar2.f10708a;
            eVar3.f6387e = eVar2.f10709b;
            eVar3.a("na_start", Long.valueOf(l));
            eVar3.a("h5_start", Long.valueOf(eVar2.f10710c));
            eVar3.a("h5_finish", Long.valueOf(eVar2.f10711d));
            b.a.p0.a.j2.k.u("1235", eVar3);
        }
    }
}
