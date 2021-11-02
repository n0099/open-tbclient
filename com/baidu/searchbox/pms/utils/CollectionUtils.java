package com.baidu.searchbox.pms.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.bean.PackageParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class CollectionUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CollectionUtils() {
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

    public static List<String> convertToPackageNameList(List<PackageParams> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (PackageParams packageParams : list) {
                arrayList.add(packageParams.packageName);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<PackageParams> convertToPackageParamsList(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String str : list) {
                arrayList.add(new PackageParams(str));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static boolean isEmpty(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, collection)) == null) ? collection == null || collection.size() == 0 : invokeL.booleanValue;
    }

    public static boolean isEmpty(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, map)) == null) ? map == null || map.size() == 0 : invokeL.booleanValue;
    }
}
