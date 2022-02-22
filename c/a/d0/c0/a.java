package c.a.d0.c0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> int a(T[] tArr, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tArr, t)) == null) {
            if (tArr == null) {
                return -1;
            }
            int length = tArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (tArr[i2] == t) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }
}
