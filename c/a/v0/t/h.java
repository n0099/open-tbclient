package c.a.v0.t;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> boolean a(List<T> list, List<T> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, list, list2)) == null) {
            if (e(list2) || list == null) {
                return false;
            }
            return list.addAll(list2);
        }
        return invokeLL.booleanValue;
    }

    public static <T> int b(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return list.size();
        }
        return invokeL.intValue;
    }

    public static <T> T c(List<T> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, list, i2)) == null) {
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return list.get(i2);
        }
        return (T) invokeLI.objValue;
    }

    public static <T> T d(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            return (T) c(list, list.size() - 1);
        }
        return (T) invokeL.objValue;
    }

    public static <T> boolean e(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) ? b(list) <= 0 : invokeL.booleanValue;
    }

    public static <T> boolean f(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, map)) == null) ? map == null || map.isEmpty() : invokeL.booleanValue;
    }

    public static <T> T g(List<T> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, null, list, i2)) == null) {
            if (e(list) || list == null || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return list.remove(i2);
        }
        return (T) invokeLI.objValue;
    }

    public static <T> void h(List<T> list, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65543, null, list, i2, i3) == null) || e(list) || i2 < 0 || i3 < 0 || i2 > b(list) - 1 || i3 > b(list) - 1) {
            return;
        }
        Collections.swap(list, i2, i3);
    }
}
