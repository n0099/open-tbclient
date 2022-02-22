package c.a.t0.d1;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = a;
            if (j2 > currentTimeMillis) {
                a = currentTimeMillis;
                return false;
            } else if (currentTimeMillis - j2 < 500) {
                return true;
            } else {
                a = currentTimeMillis;
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
