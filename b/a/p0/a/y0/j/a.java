package b.a.p0.a.y0.j;

import androidx.annotation.NonNull;
import b.a.p0.a.a2.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.davemorrissey.labs.subscaleview.ImageSource;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (str.startsWith(ImageSource.FILE_SCHEME)) {
                str = str.substring(8);
            }
            e i2 = e.i();
            return (!b.a.p0.a.k2.b.E(str) || i2 == null) ? str : b.a.p0.a.k2.b.H(str, i2);
        }
        return (String) invokeL.objValue;
    }
}
