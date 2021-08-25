package c.a.p0.b1;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static long f12886a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = f12886a;
            if (j2 > currentTimeMillis) {
                f12886a = currentTimeMillis;
                return false;
            } else if (currentTimeMillis - j2 < 500) {
                return true;
            } else {
                f12886a = currentTimeMillis;
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
