package com.baidu.b.a.c.b;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    public static List<com.baidu.b.a.c.a.a> aa(String str, String str2) {
        return a.rC().Z(str, str2);
    }

    public static Map<String, com.baidu.b.a.c.a.a> ab(String str, String str2) {
        HashMap hashMap = new HashMap();
        List<com.baidu.b.a.c.a.a> aa = aa(str, str2);
        if (aa != null && aa.size() > 0) {
            for (com.baidu.b.a.c.a.a aVar : aa) {
                if (!hashMap.containsKey(aVar.packageName)) {
                    hashMap.put(aVar.packageName, aVar);
                } else if (aVar.Zo > ((com.baidu.b.a.c.a.a) hashMap.get(aVar.packageName)).Zo) {
                    hashMap.put(aVar.packageName, aVar);
                }
            }
        }
        return hashMap;
    }

    public static boolean ac(String str, String str2) {
        Map<String, com.baidu.b.a.c.a.a> ab = ab(str, str2);
        com.baidu.b.a.c.a.a aVar = (ab == null || ab.size() <= 0) ? null : ab.get(str2);
        if (aVar != null) {
            return a.rC().k(str, str2, "" + aVar.Zo);
        }
        return a.rC().k(str, str2, null);
    }
}
