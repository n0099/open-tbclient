package c.a.p0.a.h0.q.d;

import androidx.annotation.NonNull;
import c.a.p0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1090099951, "Lc/a/p0/a/h0/q/d/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1090099951, "Lc/a/p0/a/h0/q/d/e;");
                return;
            }
        }
        a = k.a;
    }

    @NonNull
    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            c b2 = b(c());
            if (a) {
                String str = "prelink strategy - " + b2.getClass().getSimpleName();
            }
            return b2;
        }
        return (c) invokeV.objValue;
    }

    public static c b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 == 0) {
                return new a();
            }
            if (i2 > 0) {
                return new d(i2);
            }
            if (i2 == -1) {
                return new b();
            }
            return new a();
        }
        return (c) invokeI.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c.a.p0.a.c1.a.g0().getSwitch("swan_prelink_policy_when_prefetch", 0);
            if (a) {
                String str = "swan_prelink_policy_when_prefetch = 0";
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
