package c.a.y0.r;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public abstract class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static double a(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Double.valueOf(d2)})) == null) {
            if (str == null) {
                return d2;
            }
            try {
                return Double.parseDouble(str);
            } catch (Exception unused) {
                return d2;
            }
        }
        return invokeCommon.doubleValue;
    }

    public static float b(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, str, f2)) == null) {
            if (str == null) {
                return f2;
            }
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return f2;
            }
        }
        return invokeLF.floatValue;
    }

    public static int c(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            if (str == null) {
                return i2;
            }
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public static long d(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, str, j2)) == null) {
            if (str == null) {
                return j2;
            }
            try {
                return Long.parseLong(str);
            } catch (Exception unused) {
                return j2;
            }
        }
        return invokeLJ.longValue;
    }
}
