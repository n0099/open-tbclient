package com.baidu.nps.pm;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class BundleInfoGroupManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BundleInfoGroupManager() {
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

    public static Map<String, BundleInfoGroup> toBundleInfoGroups(List<BundleInfo> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, list, j)) == null) {
            HashMap hashMap = new HashMap();
            if (list == null) {
                return null;
            }
            for (BundleInfo bundleInfo : list) {
                BundleInfoGroup bundleInfoGroup = (BundleInfoGroup) hashMap.get(bundleInfo.getPackageName());
                if (bundleInfoGroup == null) {
                    bundleInfoGroup = new BundleInfoGroup(j);
                    hashMap.put(bundleInfo.getPackageName(), bundleInfoGroup);
                }
                bundleInfoGroup.updateBundleByType(bundleInfo.getType(), bundleInfo);
            }
            return hashMap;
        }
        return (Map) invokeLJ.objValue;
    }
}
