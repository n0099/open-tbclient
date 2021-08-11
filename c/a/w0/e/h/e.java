package c.a.w0.e.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(File file, Object obj) {
        InterceptResult invokeLL;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, file, obj)) == null) {
            synchronized (obj) {
                b2 = f.b(file);
            }
            return b2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean b(String str, File file, boolean z, Object obj) {
        InterceptResult invokeCommon;
        boolean e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, file, Boolean.valueOf(z), obj})) == null) {
            synchronized (obj) {
                e2 = f.e(str, file, z);
            }
            return e2;
        }
        return invokeCommon.booleanValue;
    }
}
