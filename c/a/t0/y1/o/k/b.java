package c.a.t0.y1.o.k;

import android.graphics.Color;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) ? i2 == Integer.MAX_VALUE : invokeI.booleanValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null) {
                if (str.length() != 0) {
                    try {
                        if (!str.startsWith("#")) {
                            str = "#" + str;
                        }
                    } catch (Exception unused) {
                        return Integer.MAX_VALUE;
                    }
                }
                return Color.parseColor(str);
            }
            return Integer.MAX_VALUE;
        }
        return invokeL.intValue;
    }
}
