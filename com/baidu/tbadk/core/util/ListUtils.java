package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class ListUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ListUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <T> boolean add(List<T> list, int i, T t) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, list, i, t)) == null) {
            if (list != null && i <= list.size() && i >= 0) {
                list.add(i, t);
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static <T> boolean addAll(List<T> list, int i, List<T> list2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, list, i, list2)) == null) {
            if (list != null && i <= list.size() && i >= 0 && list2 != null && list2.size() > 0) {
                list.addAll(i, list2);
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static <T> void removeSubList(List<T> list, int i, int i2) {
        int count;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65549, null, list, i, i2) == null) && (count = getCount(list)) > 0 && i >= 0 && i2 <= count) {
            clear(list.subList(i, i2));
        }
    }

    public static <T> List<T> subList(List<T> list, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65550, null, list, i, i2)) == null) {
            int count = getCount(list);
            if (count <= 0 || i < 0 || i2 > count) {
                return null;
            }
            return list.subList(i, i2);
        }
        return (List) invokeLII.objValue;
    }

    public static <T> boolean add(List<T> list, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, list, t)) == null) {
            if (list == null) {
                return false;
            }
            return list.add(t);
        }
        return invokeLL.booleanValue;
    }

    public static <T> ArrayList<T> convertJSONArrayToList(ArrayList<T> arrayList, JSONArray jSONArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, arrayList, jSONArray)) == null) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(jSONArray.opt(i));
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static <T> boolean equalList(List<T> list, List<T> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, list, list2)) == null) {
            if (list == list2) {
                return true;
            }
            if (list != null && list2 != null && list.size() == list2.size() && list.containsAll(list2)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static <T> T getItem(List<T> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, list, i)) == null) {
            if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
                return null;
            }
            return list.get(i);
        }
        return (T) invokeLI.objValue;
    }

    public static <T> int getPosition(List<T> list, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, list, t)) == null) {
            if (list != null && !list.isEmpty() && t != null) {
                return list.indexOf(t);
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static <T> T remove(List<T> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, list, i)) == null) {
            if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
                return null;
            }
            return list.remove(i);
        }
        return (T) invokeLI.objValue;
    }

    public static <T> List<T> trimToSize(List<T> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, list, i)) == null) {
            int count = getCount(list);
            int min = Math.min(count, i);
            if (min > 0 && min < count) {
                return subList(list, 0, min);
            }
            return list;
        }
        return (List) invokeLI.objValue;
    }

    public static <T> void clear(List<T> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) != null) || list == null) {
            return;
        }
        list.clear();
    }

    public static <T> int getCount(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, list)) == null) {
            if (list != null && !list.isEmpty()) {
                return list.size();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static <T> boolean isEmpty(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, list)) == null) {
            if (getCount(list) <= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static <T> boolean isNotEmpty(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, list)) == null) {
            return !isEmpty(list);
        }
        return invokeL.booleanValue;
    }
}
