package b.a.p0.j.p0.h;

import androidx.annotation.NonNull;
import b.a.p0.a.d2.e;
import b.a.p0.a.k;
import b.a.p0.a.n2.n;
import b.a.p0.j.p0.h.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11429a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1020306592, "Lb/a/p0/j/p0/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1020306592, "Lb/a/p0/j/p0/h/d;");
                return;
            }
        }
        f11429a = k.f6863a;
    }

    public static void a(@NonNull e eVar, @NonNull a.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, eVar, eVar2) == null) {
            long l = eVar.V().l("launch_time", 0L);
            if (l <= 0) {
                boolean z = f11429a;
                return;
            }
            b.a.p0.a.n2.s.e eVar3 = new b.a.p0.a.n2.s.e();
            eVar3.f7379a = n.n(eVar.V().G());
            eVar3.f7384f = eVar.getAppId();
            eVar3.f7381c = eVar.V().T();
            eVar3.f7380b = "startup";
            eVar3.f7385g = eVar2.f11425a;
            eVar3.f7383e = eVar2.f11426b;
            eVar3.a("na_start", Long.valueOf(l));
            eVar3.a("h5_start", Long.valueOf(eVar2.f11427c));
            eVar3.a("h5_finish", Long.valueOf(eVar2.f11428d));
            n.x("1235", eVar3);
        }
    }
}
