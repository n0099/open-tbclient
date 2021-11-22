package b.a.q0.c1;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f12830a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = f12830a;
            if (j > currentTimeMillis) {
                f12830a = currentTimeMillis;
                return false;
            } else if (currentTimeMillis - j < 500) {
                return true;
            } else {
                f12830a = currentTimeMillis;
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
