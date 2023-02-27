package com.baidu.searchbox.pms.db;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.pms.bean.PackageInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class PackageManager {
    public static boolean deleteLatestPackageFile(String str, String str2) {
        PackageInfo packageInfo;
        Map<String, PackageInfo> finishedPackageInfo = getFinishedPackageInfo(str, str2);
        if (finishedPackageInfo != null && finishedPackageInfo.size() > 0) {
            packageInfo = finishedPackageInfo.get(str2);
        } else {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return PackageControl.getInstance().deleteFinishedItem(str, str2, "" + packageInfo.updateVersion);
        }
        return PackageControl.getInstance().deleteFinishedItem(str, str2, null);
    }

    public static List<PackageInfo> getFinishedPackageFiles(String str, String str2, String str3) {
        return PackageControl.getInstance().queryFinishedItems(str, str2, str3);
    }

    public static PackageInfo getLastPackageFile(String str, String str2, String str3) {
        List<PackageInfo> finishedPackageFiles = getFinishedPackageFiles(str, str2, str3);
        if (finishedPackageFiles != null && finishedPackageFiles.size() > 0) {
            return finishedPackageFiles.get(0);
        }
        return null;
    }

    @NonNull
    public static Map<String, PackageInfo> getFinishedPackageFiles(@NonNull String str, @Nullable List<String> list) {
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

    public static Map<String, PackageInfo> getFinishedPackageInfo(String str, String str2) {
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

    public static int resetUpdateVersion(String str, List<String> list) {
        return PackageControl.getInstance().resetFinishedUpdateVersion(str, list);
    }
}
