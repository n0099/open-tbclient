package c.a.q0.s.l;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Integer> f14031a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1643903678, "Lc/a/q0/s/l/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1643903678, "Lc/a/q0/s/l/f;");
                return;
            }
        }
        f14031a = new HashMap<>();
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            String str = TbadkCoreApplication.getCurrentAccount() + TNCManager.TNC_PROBE_HEADER_SECEPTOR + i2;
            if (f14031a.containsKey(str)) {
                return f14031a.get(str).intValue();
            }
            f14031a.put(str, 1);
            return 1;
        }
        return invokeI.intValue;
    }

    public static void b(PersonPrivateData personPrivateData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, personPrivateData) == null) || personPrivateData == null) {
            return;
        }
        String str = TbadkCoreApplication.getCurrentAccount() + TNCManager.TNC_PROBE_HEADER_SECEPTOR + 2;
        int w = personPrivateData.w();
        if (f14031a.containsKey(str)) {
            return;
        }
        f14031a.put(str, Integer.valueOf(w));
    }

    public static void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, null, i2, i3) == null) {
            f14031a.put(TbadkCoreApplication.getCurrentAccount() + TNCManager.TNC_PROBE_HEADER_SECEPTOR + i2, Integer.valueOf(i3));
        }
    }
}
