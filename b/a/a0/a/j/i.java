package b.a.a0.a.j;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, str, str2) == null) {
            if (str2.length() > 2001) {
                int i2 = 0;
                while (i2 < str2.length()) {
                    int i3 = i2 + 2001;
                    if (i3 < str2.length()) {
                        b(3, str, str2.substring(i2, i3));
                    } else {
                        b(3, str, str2.substring(i2));
                    }
                    i2 = i3;
                }
                return;
            }
            b(3, str, str2);
        }
    }

    public static void b(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65537, null, i2, str, str2) == null) {
        }
    }
}
