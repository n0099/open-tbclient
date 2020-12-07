package com.baidu.swan.apps.env.b;

import com.baidu.swan.apps.env.b.a;
import com.facebook.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes25.dex */
public class b {
    public static final Set<String> cXF = i.N("zeus");
    public static final Set<String> cXG = new HashSet(cXF);
    private static final Set<String> cXH = new HashSet(cXG);
    private static final Map<String, a> cXI = new HashMap();
    private static boolean cXJ = false;

    public static a oz(String str) {
        avT();
        return cXI.get(str);
    }

    private static void avT() {
        if (!cXJ) {
            for (String str : cXH) {
                if ("zeus".equals(str)) {
                    cXI.put(str, avU());
                }
            }
        }
        cXJ = true;
    }

    private static a avU() {
        return new a.C0448a().oy("zeus").a(com.baidu.swan.apps.t.a.azN().akV()).fu(com.baidu.swan.apps.t.a.azN().akT()).avS();
    }
}
