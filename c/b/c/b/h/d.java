package c.b.c.b.h;

import c.b.c.b.h.j;
import c.b.c.b.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            String[] k = l.e.k("/proc/self/task/" + i2 + "/stat");
            if (k == null) {
                return -1L;
            }
            return (Long.parseLong(k[11]) * j.a.a()) + (Long.parseLong(k[12]) * j.a.a());
        }
        return invokeI.longValue;
    }
}
