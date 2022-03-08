package c.q.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes3.dex */
public class e2 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            boolean z = a;
            if (z) {
                return z;
            }
            String[] split = System.getenv("PATH").split(":");
            int length = split.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    str = null;
                    break;
                }
                str = split[i2] + "/su";
                if (new File(str).exists()) {
                    break;
                }
                i2++;
            }
            boolean z2 = str != null;
            a = z2;
            return z2;
        }
        return invokeV.booleanValue;
    }
}
