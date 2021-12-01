package c.a.r0.w1.o.k;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(List<T> list, T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, list, t) == null) || h(list)) {
            return;
        }
        try {
            list.add(t);
        } catch (Exception e2) {
            BdLog.e(e2);
            l(e2);
        }
    }

    public static <T> void b(List<T> list, T t, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65537, null, list, t, i2) == null) || h(list) || i2 < 0 || i2 > list.size()) {
            return;
        }
        try {
            list.add(i2, t);
        } catch (Exception e2) {
            BdLog.e(e2);
            l(e2);
        }
    }

    public static void c(List list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || e(list)) {
            return;
        }
        try {
            list.clear();
        } catch (Exception e2) {
            BdLog.e(e2);
            l(e2);
        }
    }

    public static <T> T d(List<T> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, list, i2)) == null) {
            if (!e(list) && g(list, i2)) {
                try {
                    return list.get(i2);
                } catch (Exception e2) {
                    BdLog.e(e2);
                    l(e2);
                    return null;
                }
            }
            return null;
        }
        return (T) invokeLI.objValue;
    }

    public static boolean e(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (h(list) || list.isEmpty()) {
                BdLog.e("list is empty");
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, map)) == null) {
            if (h(map) || map.isEmpty()) {
                BdLog.e("map is empty");
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(List list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, list, i2)) == null) ? !h(list) && i2 >= 0 && i2 < list.size() : invokeLI.booleanValue;
    }

    public static boolean h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) ? obj == null : invokeL.booleanValue;
    }

    public static void i(List list, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65544, null, list, i2) == null) && !e(list) && g(list, i2)) {
            try {
                list.remove(i2);
            } catch (Exception e2) {
                BdLog.e(e2);
                l(e2);
            }
        }
    }

    public static <T> boolean j(List<T> list, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, list, t)) == null) {
            if (e(list)) {
                return false;
            }
            try {
                return list.remove(t);
            } catch (Exception e2) {
                BdLog.e(e2);
                l(e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static int k(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, list)) == null) {
            if (!h(list) && !list.isEmpty()) {
                try {
                    return list.size();
                } catch (Exception e2) {
                    BdLog.e(e2);
                    l(e2);
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void l(Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, exc) == null) && BdBaseApplication.getInst().isDebugMode() && (exc instanceof RuntimeException)) {
            throw ((RuntimeException) exc);
        }
    }
}
