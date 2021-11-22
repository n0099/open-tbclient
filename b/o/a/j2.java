package b.o.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class j2 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f34186a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            boolean z = f34186a;
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
            f34186a = z2;
            return z2;
        }
        return invokeV.booleanValue;
    }
}
