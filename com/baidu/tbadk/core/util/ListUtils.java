package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
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

    public static <T> boolean addAll(List<T> list, int i2, List<T> list2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, list, i2, list2)) == null) {
            if (list == null || i2 > list.size() || i2 < 0 || list2 == null || list2.size() <= 0) {
                return false;
            }
            list.addAll(i2, list2);
            return true;
        }
        return invokeLIL.booleanValue;
    }

    public static <T> void clear(List<T> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) == null) || list == null) {
            return;
        }
        list.clear();
    }

    public static <T> ArrayList<T> convertJSONArrayToList(ArrayList<T> arrayList, JSONArray jSONArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, arrayList, jSONArray)) == null) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(jSONArray.opt(i2));
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static <T> boolean equalList(List<T> list, List<T> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, list, list2)) == null) {
            if (list == list2) {
                return true;
            }
            return list != null && list2 != null && list.size() == list2.size() && list.containsAll(list2);
        }
        return invokeLL.booleanValue;
    }

    public static <T> int getCount(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, list)) == null) {
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return list.size();
        }
        return invokeL.intValue;
    }

    public static <T> T getItem(List<T> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, list, i2)) == null) {
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return list.get(i2);
        }
        return (T) invokeLI.objValue;
    }

    public static <T> int getPosition(List<T> list, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, list, t)) == null) {
            if (list == null || list.isEmpty() || t == null) {
                return -1;
            }
            return list.indexOf(t);
        }
        return invokeLL.intValue;
    }

    public static <T> boolean isEmpty(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, list)) == null) ? getCount(list) <= 0 : invokeL.booleanValue;
    }

    public static <T> T remove(List<T> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, list, i2)) == null) {
            if (list == null || list.isEmpty() || i2 < 0 || i2 >= list.size()) {
                return null;
            }
            return list.remove(i2);
        }
        return (T) invokeLI.objValue;
    }

    public static <T> void removeSubList(List<T> list, int i2, int i3) {
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65548, null, list, i2, i3) == null) || (count = getCount(list)) <= 0 || i2 < 0 || i3 > count) {
            return;
        }
        clear(list.subList(i2, i3));
    }

    public static <T> List<T> subList(List<T> list, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65549, null, list, i2, i3)) == null) {
            int count = getCount(list);
            if (count > 0 && i2 >= 0 && i3 <= count) {
                return list.subList(i2, i3);
            }
            return null;
        }
        return (List) invokeLII.objValue;
    }

    public static <T> List<T> trimToSize(List<T> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, list, i2)) == null) {
            int count = getCount(list);
            int min = Math.min(count, i2);
            return (min <= 0 || min >= count) ? list : subList(list, 0, min);
        }
        return (List) invokeLI.objValue;
    }

    public static <T> boolean add(List<T> list, int i2, T t) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, list, i2, t)) == null) {
            if (list == null || i2 > list.size() || i2 < 0) {
                return false;
            }
            list.add(i2, t);
            return true;
        }
        return invokeLIL.booleanValue;
    }
}
