package com.baidu.searchbox.pms.db;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean deleteLatestPackageFile(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            Map<String, PackageInfo> finishedPackageInfo = getFinishedPackageInfo(str, str2);
            PackageInfo packageInfo = (finishedPackageInfo == null || finishedPackageInfo.size() <= 0) ? null : finishedPackageInfo.get(str2);
            if (packageInfo != null) {
                PackageControl packageControl = PackageControl.getInstance();
                return packageControl.deleteFinishedItem(str, str2, "" + packageInfo.updateVersion);
            }
            return PackageControl.getInstance().deleteFinishedItem(str, str2, null);
        }
        return invokeLL.booleanValue;
    }

    public static List<PackageInfo> getFinishedPackageFiles(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) ? PackageControl.getInstance().queryFinishedItems(str, str2, str3) : (List) invokeLLL.objValue;
    }

    public static Map<String, PackageInfo> getFinishedPackageInfo(String str, String str2) {
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

    public static PackageInfo getLastPackageFile(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, str3)) == null) {
            List<PackageInfo> finishedPackageFiles = getFinishedPackageFiles(str, str2, str3);
            if (finishedPackageFiles == null || finishedPackageFiles.size() <= 0) {
                return null;
            }
            return finishedPackageFiles.get(0);
        }
        return (PackageInfo) invokeLLL.objValue;
    }

    public static int resetUpdateVersion(String str, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, list)) == null) ? PackageControl.getInstance().resetFinishedUpdateVersion(str, list) : invokeLL.intValue;
    }

    @NonNull
    public static Map<String, PackageInfo> getFinishedPackageFiles(@NonNull String str, @Nullable List<String> list) {
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
}
