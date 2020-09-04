package com.baidu.swan.apps.env.b;

import com.baidu.swan.apps.env.b.a;
import com.facebook.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class b {
    public static final Set<String> cpT = i.N("zeus");
    public static final Set<String> cpU = new HashSet(cpT);
    private static final Set<String> cpV = new HashSet(cpU);
    private static final Map<String, a> cpW = new HashMap();
    private static boolean cpX = false;

    public static a mk(String str) {
        alC();
        return cpW.get(str);
    }

    private static void alC() {
        if (!cpX) {
            for (String str : cpV) {
                if ("zeus".equals(str)) {
                    cpW.put(str, alD());
                }
            }
        }
        cpX = true;
    }

    private static a alD() {
        return new a.C0400a().mj("zeus").a(com.baidu.swan.apps.t.a.apx().aaG()).em(com.baidu.swan.apps.t.a.apx().aaE()).alB();
    }
}
