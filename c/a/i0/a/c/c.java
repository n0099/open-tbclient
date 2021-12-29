package c.a.i0.a.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Calendar;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Long l, Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, l, l2)) == null) {
            if (l == null || l2 == null) {
                return false;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(l.longValue());
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(l2.longValue());
            return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        return invokeLL.booleanValue;
    }
}
