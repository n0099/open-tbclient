package c.a.o0.a.n0.i;

import c.a.o0.a.k;
import c.a.o0.a.k2.g.h;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7467a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1987900311, "Lc/a/o0/a/n0/i/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1987900311, "Lc/a/o0/a/n0/i/a;");
                return;
            }
        }
        f7467a = k.f7049a;
    }

    public static String a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, str)) == null) {
            return "frame_type_" + i2 + "_" + str;
        }
        return (String) invokeIL.objValue;
    }

    public static long b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            long j2 = h.a().getLong(a(i2, "launch_time"), 0L);
            if (f7467a) {
                String str = "frame_type : " + i2 + " , launch time : " + j2;
            }
            return j2;
        }
        return invokeI.longValue;
    }

    public static void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            String a2 = a(i2, "launch_time");
            long currentTimeMillis = System.currentTimeMillis();
            h.a().putLong(a2, currentTimeMillis);
            if (f7467a) {
                String str = "frame_type : " + i2 + " , launch time : " + currentTimeMillis;
            }
        }
    }
}
