package c.a.r0.k1.m;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 6) {
                    if (i2 != 8) {
                        if (i2 != 30) {
                            switch (i2) {
                                case 10:
                                    return 6;
                                case 11:
                                    return 7;
                                case 12:
                                    return 8;
                                default:
                                    return 1;
                            }
                        }
                        return -9;
                    }
                    return 5;
                }
                return -1;
            }
            return -2;
        }
        return invokeI.intValue;
    }
}
