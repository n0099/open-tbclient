package c.a.p0.q.j.i;

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
    public static String f11080b = "0";

    /* renamed from: c  reason: collision with root package name */
    public static long f11081c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1792590623, "Lc/a/p0/q/j/i/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1792590623, "Lc/a/p0/q/j/i/n;");
                return;
            }
        }
        c.a.p0.q.a b2 = c.a.p0.q.c.b();
        if (b2 != null) {
            f11080b = b2.i().getString("key_h2_heart_beat_version", "0");
        }
    }

    public static long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            c.a.p0.q.a b2 = c.a.p0.q.c.b();
            return b2 != null ? b2.i().getInt("key_h2_heart_beat_timespan", i2) : i2;
        }
        return invokeI.longValue;
    }

    public static long b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            c.a.p0.q.a b2 = c.a.p0.q.c.b();
            return b2 != null ? b2.i().getInt("key_h2_heart_beat_timeout", i2) : i2;
        }
        return invokeI.longValue;
    }
}
