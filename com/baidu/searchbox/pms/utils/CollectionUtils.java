package com.baidu.searchbox.pms.utils;

import com.baidu.searchbox.pms.bean.PackageParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class CollectionUtils {
    public static List<String> convertToPackageNameList(List<PackageParams> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (PackageParams packageParams : list) {
            arrayList.add(packageParams.packageName);
        }
        return arrayList;
    }

    public static List<PackageParams> convertToPackageParamsList(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            arrayList.add(new PackageParams(str));
        }
        return arrayList;
    }

    public static boolean isEmpty(Collection collection) {
        if (collection != null && collection.size() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(Map map) {
        if (map != null && map.size() != 0) {
            return false;
        }
        return true;
    }
}
