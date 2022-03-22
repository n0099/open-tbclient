package c.a.n0.j.p0.h;

import android.util.Log;
import androidx.annotation.NonNull;
import c.a.n0.a.d2.n;
import c.a.n0.a.t1.e;
import c.a.n0.j.p0.h.a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.v8.NodeJS;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(251606977, "Lc/a/n0/j/p0/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(251606977, "Lc/a/n0/j/p0/h/d;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static void a(@NonNull e eVar, @NonNull a.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, eVar, eVar2) == null) {
            long l = eVar.V().l("launch_time", 0L);
            if (l <= 0) {
                if (a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            c.a.n0.a.d2.s.e eVar3 = new c.a.n0.a.d2.s.e();
            eVar3.a = n.n(eVar.V().G());
            eVar3.f4192f = eVar.getAppId();
            eVar3.f4189c = eVar.V().T();
            eVar3.f4188b = NodeJS.STARTUP_SCRIPT_NAME;
            eVar3.f4193g = eVar2.a;
            eVar3.f4191e = eVar2.f8913b;
            eVar3.a("na_start", Long.valueOf(l));
            eVar3.a("h5_start", Long.valueOf(eVar2.f8914c));
            eVar3.a("h5_finish", Long.valueOf(eVar2.f8915d));
            n.x("1235", eVar3);
        }
    }
}
