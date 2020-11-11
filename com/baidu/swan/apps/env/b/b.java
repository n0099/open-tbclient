package com.baidu.swan.apps.env.b;

import com.baidu.swan.apps.env.b.a;
import com.facebook.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class b {
    public static final Set<String> cSw = i.N("zeus");
    public static final Set<String> cSx = new HashSet(cSw);
    private static final Set<String> cSy = new HashSet(cSx);
    private static final Map<String, a> cSz = new HashMap();
    private static boolean cSA = false;

    public static a nW(String str) {
        att();
        return cSz.get(str);
    }

    private static void att() {
        if (!cSA) {
            for (String str : cSy) {
                if ("zeus".equals(str)) {
                    cSz.put(str, atu());
                }
            }
        }
        cSA = true;
    }

    private static a atu() {
        return new a.C0438a().nV("zeus").a(com.baidu.swan.apps.t.a.axn().aiv()).fc(com.baidu.swan.apps.t.a.axn().ait()).ats();
    }
}
