package c.a.w.e.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> int a(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return list.size();
        }
        return invokeL.intValue;
    }

    public static <T> T b(List<T> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, list, i2)) == null) {
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return list.get(i2);
        }
        return (T) invokeLI.objValue;
    }

    public static <T> boolean c(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) ? a(list) <= 0 : invokeL.booleanValue;
    }
}
