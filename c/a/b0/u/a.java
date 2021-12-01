package c.a.b0.u;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(List<T> list, T t, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65536, null, list, t, i2) == null) && !f(list) && e(list, i2)) {
            try {
                list.add(i2, t);
            } catch (Exception e2) {
                l(e2);
            }
        }
    }

    public static <T> boolean b(List<T> list, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, list, t)) == null) {
            if (f(list)) {
                return false;
            }
            try {
                return list.add(t);
            } catch (Exception e2) {
                l(e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.Collection<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void c(Collection<T> collection, Collection<T> collection2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, collection, collection2) == null) || collection2 == 0 || collection == null) {
            return;
        }
        collection.addAll(collection2);
    }

    @Nullable
    public static <T> T d(List<T> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, list, i2)) == null) {
            if (!g(list) && e(list, i2)) {
                try {
                    return list.get(i2);
                } catch (Exception e2) {
                    l(e2);
                    return null;
                }
            }
            return null;
        }
        return (T) invokeLI.objValue;
    }

    public static <T> boolean e(List<T> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, list, i2)) == null) {
            if (!f(list) && i2 >= 0) {
                try {
                    return i2 < list.size();
                } catch (Exception e2) {
                    l(e2);
                    return false;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static boolean f(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) ? obj == null : invokeL.booleanValue;
    }

    public static <T> boolean g(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, list)) == null) ? f(list) || list.isEmpty() : invokeL.booleanValue;
    }

    public static <K, V> boolean h(Map<K, V> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, map)) == null) ? f(map) || map.isEmpty() : invokeL.booleanValue;
    }

    @Nullable
    public static <T> T i(List<T> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, list, i2)) == null) {
            if (!g(list) && e(list, i2)) {
                try {
                    return list.remove(i2);
                } catch (Exception e2) {
                    l(e2);
                    return null;
                }
            }
            return null;
        }
        return (T) invokeLI.objValue;
    }

    public static <T> boolean j(List<T> list, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, list, t)) == null) {
            if (g(list)) {
                return false;
            }
            try {
                return list.remove(t);
            } catch (Exception e2) {
                l(e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static <T> int k(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, list)) == null) {
            if (f(list) || list.isEmpty()) {
                return 0;
            }
            return list.size();
        }
        return invokeL.intValue;
    }

    public static void l(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, exc) == null) {
        }
    }
}
