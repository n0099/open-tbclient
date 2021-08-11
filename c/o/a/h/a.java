package c.o.a.h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.internal.ImmutableList;
import com.squareup.wire2.internal.MutableOnWriteList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(List<?> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, list) == null) {
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (list.get(i2) == null) {
                        throw new NullPointerException("Element at index " + i2 + " is null");
                    }
                }
                return;
            }
            throw new NullPointerException("list == null");
        }
    }

    public static void b(Map<?, ?> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, map) == null) {
            if (map != null) {
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    if (entry.getKey() != null) {
                        if (entry.getValue() == null) {
                            throw new NullPointerException("Value for key " + entry.getKey() + " is null");
                        }
                    } else {
                        throw new NullPointerException("map.containsKey(null)");
                    }
                }
                return;
            }
            throw new NullPointerException("map == null");
        }
    }

    public static <T> List<T> c(String str, List<T> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, list)) == null) {
            if (list != null) {
                if (list != Collections.emptyList() && !(list instanceof ImmutableList)) {
                    return new ArrayList(list);
                }
                return new MutableOnWriteList(list);
            }
            throw new NullPointerException(str + " == null");
        }
        return (List) invokeLL.objValue;
    }

    public static <K, V> Map<K, V> d(String str, Map<K, V> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, map)) == null) {
            if (map != null) {
                return new LinkedHashMap(map);
            }
            throw new NullPointerException(str + " == null");
        }
        return (Map) invokeLL.objValue;
    }

    public static int e(Object obj, Object obj2, Object obj3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, obj2, obj3)) == null) {
            return (obj != null ? 1 : 0) + (obj2 != null ? 1 : 0) + (obj3 == null ? 0 : 1);
        }
        return invokeLLL.intValue;
    }

    public static boolean f(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    public static <T> List<T> g(String str, List<T> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, list)) == null) {
            if (list != null) {
                if (list instanceof MutableOnWriteList) {
                    list = ((MutableOnWriteList) list).mutableList;
                }
                if (list == Collections.emptyList() || (list instanceof ImmutableList)) {
                    return list;
                }
                ImmutableList immutableList = new ImmutableList(list);
                if (immutableList.contains(null)) {
                    throw new IllegalArgumentException(str + ".contains(null)");
                }
                return immutableList;
            }
            throw new NullPointerException(str + " == null");
        }
        return (List) invokeLL.objValue;
    }

    public static <K, V> Map<K, V> h(String str, Map<K, V> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, map)) == null) {
            if (map != null) {
                if (map.isEmpty()) {
                    return Collections.emptyMap();
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(map);
                if (!linkedHashMap.containsKey(null)) {
                    if (!linkedHashMap.containsValue(null)) {
                        return Collections.unmodifiableMap(linkedHashMap);
                    }
                    throw new IllegalArgumentException(str + ".containsValue(null)");
                }
                throw new IllegalArgumentException(str + ".containsKey(null)");
            }
            throw new NullPointerException(str + " == null");
        }
        return (Map) invokeLL.objValue;
    }

    public static <T> List<T> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new MutableOnWriteList(Collections.emptyList()) : (List) invokeV.objValue;
    }

    public static <K, V> Map<K, V> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new LinkedHashMap() : (Map) invokeV.objValue;
    }

    public static <T> void k(List<T> list, ProtoAdapter<T> protoAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, list, protoAdapter) == null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                list.set(i2, protoAdapter.redact(list.get(i2)));
            }
        }
    }
}
