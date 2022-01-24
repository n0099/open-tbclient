package c.i.d.f;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.RoundingMode;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.i.d.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1683a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2075054705, "Lc/i/d/f/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2075054705, "Lc/i/d/f/a$a;");
                    return;
                }
            }
            int[] iArr = new int[RoundingMode.values().length];
            a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-471432468, "Lc/i/d/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-471432468, "Lc/i/d/f/a;");
                return;
            }
        }
        Math.log(2.0d);
    }

    public static boolean a(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2)})) == null) ? b.c(d2) && (d2 == 0.0d || 52 - Long.numberOfTrailingZeros(b.b(d2)) <= Math.getExponent(d2)) : invokeCommon.booleanValue;
    }

    public static double b(double d2, RoundingMode roundingMode) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d2), roundingMode})) == null) {
            if (b.c(d2)) {
                switch (C1683a.a[roundingMode.ordinal()]) {
                    case 1:
                        e.d(a(d2));
                        return d2;
                    case 2:
                        return (d2 >= 0.0d || a(d2)) ? d2 : ((long) d2) - 1;
                    case 3:
                        return (d2 <= 0.0d || a(d2)) ? d2 : ((long) d2) + 1;
                    case 4:
                        return d2;
                    case 5:
                        if (a(d2)) {
                            return d2;
                        }
                        return ((long) d2) + (d2 > 0.0d ? 1 : -1);
                    case 6:
                        return Math.rint(d2);
                    case 7:
                        double rint = Math.rint(d2);
                        return Math.abs(d2 - rint) == 0.5d ? d2 + Math.copySign(0.5d, d2) : rint;
                    case 8:
                        double rint2 = Math.rint(d2);
                        return Math.abs(d2 - rint2) == 0.5d ? d2 : rint2;
                    default:
                        throw new AssertionError();
                }
            }
            throw new ArithmeticException("input is infinite or NaN");
        }
        return invokeCommon.doubleValue;
    }

    public static long c(double d2, RoundingMode roundingMode) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Double.valueOf(d2), roundingMode})) == null) {
            double b2 = b(d2, roundingMode);
            e.a(((-9.223372036854776E18d) - b2 < 1.0d) & (b2 < 9.223372036854776E18d), d2, roundingMode);
            return (long) b2;
        }
        return invokeCommon.longValue;
    }
}
