package c.i.b.a.i0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65536, null, i2, i3)) == null) {
            for (int i4 = 1; i4 <= 2; i4++) {
                int i5 = (i2 + i4) % 3;
                if (b(i5, i3)) {
                    return i5;
                }
            }
            return i2;
        }
        return invokeII.intValue;
    }

    public static boolean b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i2, i3)) == null) {
            if (i2 != 0) {
                return i2 != 1 ? i2 == 2 && (i3 & 2) != 0 : (i3 & 1) != 0;
            }
            return true;
        }
        return invokeII.booleanValue;
    }
}
