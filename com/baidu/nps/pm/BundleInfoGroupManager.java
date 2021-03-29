package com.baidu.nps.pm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class BundleInfoGroupManager {
    public static Map<String, BundleInfoGroup> toBundleInfoGroups(List<BundleInfo> list, long j) {
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
}
