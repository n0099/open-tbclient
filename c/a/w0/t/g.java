package c.a.w0.t;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public abstract class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float a(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65536, null, str, f2)) == null) {
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

    public static int b(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i2)) == null) {
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

    public static long c(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, str, j2)) == null) {
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
