package com.baidu.b.a.c.b;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    public static List<com.baidu.b.a.c.a.a> ab(String str, String str2) {
        return a.rG().aa(str, str2);
    }

    public static Map<String, com.baidu.b.a.c.a.a> ac(String str, String str2) {
        HashMap hashMap = new HashMap();
        List<com.baidu.b.a.c.a.a> ab = ab(str, str2);
        if (ab != null && ab.size() > 0) {
            for (com.baidu.b.a.c.a.a aVar : ab) {
                if (!hashMap.containsKey(aVar.packageName)) {
                    hashMap.put(aVar.packageName, aVar);
                } else if (aVar.Zx > ((com.baidu.b.a.c.a.a) hashMap.get(aVar.packageName)).Zx) {
                    hashMap.put(aVar.packageName, aVar);
                }
            }
        }
        return hashMap;
    }

    public static boolean ad(String str, String str2) {
        Map<String, com.baidu.b.a.c.a.a> ac = ac(str, str2);
        com.baidu.b.a.c.a.a aVar = (ac == null || ac.size() <= 0) ? null : ac.get(str2);
        if (aVar != null) {
            return a.rG().k(str, str2, "" + aVar.Zx);
        }
        return a.rG().k(str, str2, null);
    }
}
