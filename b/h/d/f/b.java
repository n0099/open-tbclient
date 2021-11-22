package b.h.d.f;

import b.h.d.a.n;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static double a(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Double.valueOf(d2)})) == null) {
            n.d(!Double.isNaN(d2));
            if (d2 > 0.0d) {
                return d2;
            }
            return 0.0d;
        }
        return invokeCommon.doubleValue;
    }

    public static long b(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2)})) == null) {
            n.e(c(d2), "not a normal value");
            int exponent = Math.getExponent(d2);
            long doubleToRawLongBits = Double.doubleToRawLongBits(d2) & 4503599627370495L;
            return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | 4503599627370496L;
        }
        return invokeCommon.longValue;
    }

    public static boolean c(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d2)})) == null) ? Math.getExponent(d2) <= 1023 : invokeCommon.booleanValue;
    }
}
