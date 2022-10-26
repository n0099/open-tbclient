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

    public static boolean add(List list, int i, Object obj) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, list, i, obj)) == null) {
            if (list != null && i <= list.size() && i >= 0) {
                list.add(i, obj);
                return true;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static boolean addAll(List list, int i, List list2) {
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

    public static void removeSubList(List list, int i, int i2) {
        int count;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65548, null, list, i, i2) == null) && (count = getCount(list)) > 0 && i >= 0 && i2 <= count) {
            clear(list.subList(i, i2));
        }
    }

    public static List subList(List list, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65549, null, list, i, i2)) == null) {
            int count = getCount(list);
            if (count <= 0 || i < 0 || i2 > count) {
                return null;
            }
            return list.subList(i, i2);
        }
        return (List) invokeLII.objValue;
    }

    public static boolean add(List list, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, list, obj)) == null) {
            if (list == null) {
                return false;
            }
            return list.add(obj);
        }
        return invokeLL.booleanValue;
    }

    public static ArrayList convertJSONArrayToList(ArrayList arrayList, JSONArray jSONArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, arrayList, jSONArray)) == null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
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

    public static boolean equalList(List list, List list2) {
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

    public static Object getItem(List list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, list, i)) == null) {
            if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
                return null;
            }
            return list.get(i);
        }
        return invokeLI.objValue;
    }

    public static int getPosition(List list, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, list, obj)) == null) {
            if (list != null && !list.isEmpty() && obj != null) {
                return list.indexOf(obj);
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static Object remove(List list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, list, i)) == null) {
            if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
                return null;
            }
            return list.remove(i);
        }
        return invokeLI.objValue;
    }

    public static List trimToSize(List list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, list, i)) == null) {
            int count = getCount(list);
            int min = Math.min(count, i);
            if (min > 0 && min < count) {
                return subList(list, 0, min);
            }
            return list;
        }
        return (List) invokeLI.objValue;
    }

    public static void clear(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) != null) || list == null) {
            return;
        }
        list.clear();
    }

    public static int getCount(List list) {
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

    public static boolean isEmpty(List list) {
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
}
