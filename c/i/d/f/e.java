package c.i.d.f;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.RoundingMode;
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(boolean z, double d2, RoundingMode roundingMode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Boolean.valueOf(z), Double.valueOf(d2), roundingMode}) == null) || z) {
            return;
        }
        throw new ArithmeticException("rounded value is out of range for input " + d2 + " and rounding mode " + roundingMode);
    }

    public static void b(boolean z, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Boolean.valueOf(z), str, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || z) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + SmallTailInfo.EMOTION_SUFFIX);
    }

    public static int c(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            if (i2 > 0) {
                return i2;
            }
            throw new IllegalArgumentException(str + " (" + i2 + ") must be > 0");
        }
        return invokeLI.intValue;
    }

    public static void d(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65539, null, z) == null) && !z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
