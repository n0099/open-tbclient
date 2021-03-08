package com.baidu.swan.apps.env.b;

import com.baidu.swan.apps.env.b.a;
import com.facebook.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class b {
    public static final Set<String> dby = i.Q("zeus");
    public static final Set<String> dbz = new HashSet(dby);
    private static final Set<String> dbA = new HashSet(dbz);
    private static final Map<String, a> dbB = new HashMap();
    private static boolean dbC = false;

    public static a nE(String str) {
        atT();
        return dbB.get(str);
    }

    private static void atT() {
        if (!dbC) {
            for (String str : dbA) {
                if ("zeus".equals(str)) {
                    dbB.put(str, atU());
                }
            }
        }
        dbC = true;
    }

    private static a atU() {
        return new a.C0426a().nD("zeus").a(com.baidu.swan.apps.t.a.axM().aiN()).fB(com.baidu.swan.apps.t.a.axM().aiL()).atS();
    }
}
