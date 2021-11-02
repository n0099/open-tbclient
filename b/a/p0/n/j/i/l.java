package b.a.p0.n.j.i;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class l {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f11217a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f11218b = "0";

    /* renamed from: c  reason: collision with root package name */
    public static long f11219c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-648424957, "Lb/a/p0/n/j/i/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-648424957, "Lb/a/p0/n/j/i/l;");
                return;
            }
        }
        b.a.p0.n.a b2 = b.a.p0.n.c.b();
        if (b2 != null) {
            f11218b = b2.j().getString("key_h2_heart_beat_version", "0");
        }
    }

    public static long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            b.a.p0.n.a b2 = b.a.p0.n.c.b();
            return b2 != null ? b2.j().getInt("key_h2_heart_beat_timespan", i2) : i2;
        }
        return invokeI.longValue;
    }

    public static long b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            b.a.p0.n.a b2 = b.a.p0.n.c.b();
            return b2 != null ? b2.j().getInt("key_h2_heart_beat_timeout", i2) : i2;
        }
        return invokeI.longValue;
    }
}
