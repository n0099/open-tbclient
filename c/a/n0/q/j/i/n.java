package c.a.n0.q.j.i;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class n {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = true;

    /* renamed from: b  reason: collision with root package name */
    public static String f9255b = "0";

    /* renamed from: c  reason: collision with root package name */
    public static long f9256c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1091526045, "Lc/a/n0/q/j/i/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1091526045, "Lc/a/n0/q/j/i/n;");
                return;
            }
        }
        c.a.n0.q.a b2 = c.a.n0.q.c.b();
        if (b2 != null) {
            f9255b = b2.i().getString("key_h2_heart_beat_version", "0");
        }
    }

    public static long a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            c.a.n0.q.a b2 = c.a.n0.q.c.b();
            return b2 != null ? b2.i().getInt("key_h2_heart_beat_timespan", i) : i;
        }
        return invokeI.longValue;
    }

    public static long b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            c.a.n0.q.a b2 = c.a.n0.q.c.b();
            return b2 != null ? b2.i().getInt("key_h2_heart_beat_timeout", i) : i;
        }
        return invokeI.longValue;
    }
}
