package c.a.n0.a.k1.l;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f5367b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5368c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-774974772, "Lc/a/n0/a/k1/l/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-774974772, "Lc/a/n0/a/k1/l/f;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        f5367b = c("swan_perf_stat_rectify", 0);
        f5368c = c("swan_perf_stat_overlay_rectify", 0);
        if (a) {
            Log.d("SwanRectifyAbSwitcher", "670 data rectify on - " + f5367b);
            Log.d("SwanRectifyAbSwitcher", "670 data overlay rectify on - " + f5368c);
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f5368c : invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f5367b : invokeV.booleanValue;
    }

    public static boolean c(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) {
            c.a.n0.a.s0.a.g0().getSwitch(str, i);
            if (a) {
                Log.d("SwanRectifyAbSwitcher", str + " - " + i);
            }
            return i == 1;
        }
        return invokeLI.booleanValue;
    }
}
