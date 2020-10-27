package com.baidu.swan.apps.env.b;

import com.baidu.swan.apps.env.b.a;
import com.facebook.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class b {
    public static final Set<String> cMD = i.N("zeus");
    public static final Set<String> cME = new HashSet(cMD);
    private static final Set<String> cMF = new HashSet(cME);
    private static final Map<String, a> cMG = new HashMap();
    private static boolean cMH = false;

    public static a nI(String str) {
        aqS();
        return cMG.get(str);
    }

    private static void aqS() {
        if (!cMH) {
            for (String str : cMF) {
                if ("zeus".equals(str)) {
                    cMG.put(str, aqT());
                }
            }
        }
        cMH = true;
    }

    private static a aqT() {
        return new a.C0426a().nH("zeus").a(com.baidu.swan.apps.t.a.auN().afV()).eT(com.baidu.swan.apps.t.a.auN().afT()).aqR();
    }
}
