package b.i.d.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class n0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i2, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)})) == null) {
            int max = Math.max(i2, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max > ((int) (d2 * highestOneBit))) {
                int i3 = highestOneBit << 1;
                if (i3 > 0) {
                    return i3;
                }
                return 1073741824;
            }
            return highestOneBit;
        }
        return invokeCommon.intValue;
    }

    public static boolean b(int i2, int i3, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d2)})) == null) ? ((double) i2) > d2 * ((double) i3) && i3 < 1073741824 : invokeCommon.booleanValue;
    }

    public static int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? (int) (Integer.rotateLeft((int) (i2 * (-862048943)), 15) * 461845907) : invokeI.intValue;
    }

    public static int d(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            return c(obj == null ? 0 : obj.hashCode());
        }
        return invokeL.intValue;
    }
}
