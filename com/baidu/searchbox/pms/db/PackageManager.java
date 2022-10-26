package com.baidu.searchbox.pms.db;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class PackageManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PackageManager() {
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

    public static boolean deleteLatestPackageFile(String str, String str2) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            Map finishedPackageInfo = getFinishedPackageInfo(str, str2);
            if (finishedPackageInfo != null && finishedPackageInfo.size() > 0) {
                packageInfo = (PackageInfo) finishedPackageInfo.get(str2);
            } else {
                packageInfo = null;
            }
            if (packageInfo != null) {
                return PackageControl.getInstance().deleteFinishedItem(str, str2, "" + packageInfo.updateVersion);
            }
            return PackageControl.getInstance().deleteFinishedItem(str, str2, null);
        }
        return invokeLL.booleanValue;
    }

    public static Map getFinishedPackageFiles(String str, List list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, list)) == null) {
            HashMap hashMap = new HashMap();
            List<PackageInfo> queryFinishedItems = PackageControl.getInstance().queryFinishedItems(str, list);
            if (queryFinishedItems != null && queryFinishedItems.size() > 0) {
                for (PackageInfo packageInfo : queryFinishedItems) {
                    if (!hashMap.containsKey(packageInfo.packageName)) {
                        hashMap.put(packageInfo.packageName, packageInfo);
                    } else if (packageInfo.updateVersion > ((PackageInfo) hashMap.get(packageInfo.packageName)).updateVersion) {
                        hashMap.put(packageInfo.packageName, packageInfo);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static Map getFinishedPackageInfo(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            List<PackageInfo> finishedPackageFiles = getFinishedPackageFiles(str, str2, null);
            if (finishedPackageFiles != null && finishedPackageFiles.size() > 0) {
                for (PackageInfo packageInfo : finishedPackageFiles) {
                    if (!hashMap.containsKey(packageInfo.packageName)) {
                        hashMap.put(packageInfo.packageName, packageInfo);
                    } else if (packageInfo.updateVersion > ((PackageInfo) hashMap.get(packageInfo.packageName)).updateVersion) {
                        hashMap.put(packageInfo.packageName, packageInfo);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static List getFinishedPackageFiles(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            return PackageControl.getInstance().queryFinishedItems(str, str2, str3);
        }
        return (List) invokeLLL.objValue;
    }

    public static PackageInfo getLastPackageFile(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, str, str2, str3)) == null) {
            List finishedPackageFiles = getFinishedPackageFiles(str, str2, str3);
            if (finishedPackageFiles != null && finishedPackageFiles.size() > 0) {
                return (PackageInfo) finishedPackageFiles.get(0);
            }
            return null;
        }
        return (PackageInfo) invokeLLL.objValue;
    }

    public static int resetUpdateVersion(String str, List list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, list)) == null) {
            return PackageControl.getInstance().resetFinishedUpdateVersion(str, list);
        }
        return invokeLL.intValue;
    }
}
