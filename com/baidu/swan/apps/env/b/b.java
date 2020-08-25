package com.baidu.swan.apps.env.b;

import com.baidu.swan.apps.env.b.a;
import com.facebook.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class b {
    public static final Set<String> cpP = i.N("zeus");
    public static final Set<String> cpQ = new HashSet(cpP);
    private static final Set<String> cpR = new HashSet(cpQ);
    private static final Map<String, a> cpS = new HashMap();
    private static boolean cpT = false;

    public static a mj(String str) {
        alC();
        return cpS.get(str);
    }

    private static void alC() {
        if (!cpT) {
            for (String str : cpR) {
                if ("zeus".equals(str)) {
                    cpS.put(str, alD());
                }
            }
        }
        cpT = true;
    }

    private static a alD() {
        return new a.C0400a().mi("zeus").a(com.baidu.swan.apps.t.a.apx().aaG()).el(com.baidu.swan.apps.t.a.apx().aaE()).alB();
    }
}
