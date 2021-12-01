package c.a.p0.a.u1.l;

import c.a.p0.a.k;
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
    public static final boolean f8581b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f8582c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-231707116, "Lc/a/p0/a/u1/l/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-231707116, "Lc/a/p0/a/u1/l/f;");
                return;
            }
        }
        a = k.a;
        f8581b = c("swan_perf_stat_rectify", 0);
        f8582c = c("swan_perf_stat_overlay_rectify", 0);
        if (a) {
            String str = "670 data rectify on - " + f8581b;
            String str2 = "670 data overlay rectify on - " + f8582c;
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f8582c : invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f8581b : invokeV.booleanValue;
    }

    public static boolean c(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i2)) == null) {
            c.a.p0.a.c1.a.g0().getSwitch(str, i2);
            if (a) {
                String str2 = str + " - " + i2;
            }
            return i2 == 1;
        }
        return invokeLI.booleanValue;
    }
}
