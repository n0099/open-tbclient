package com.baidu.swan.apps.env.b;

import com.baidu.swan.apps.env.b.a;
import com.facebook.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class b {
    public static final Set<String> cZV = i.R("zeus");
    public static final Set<String> cZW = new HashSet(cZV);
    private static final Set<String> cZX = new HashSet(cZW);
    private static final Map<String, a> cZY = new HashMap();
    private static boolean cZZ = false;

    public static a nx(String str) {
        atQ();
        return cZY.get(str);
    }

    private static void atQ() {
        if (!cZZ) {
            for (String str : cZX) {
                if ("zeus".equals(str)) {
                    cZY.put(str, atR());
                }
            }
        }
        cZZ = true;
    }

    private static a atR() {
        return new a.C0420a().nw("zeus").a(com.baidu.swan.apps.t.a.axJ().aiK()).fB(com.baidu.swan.apps.t.a.axJ().aiI()).atP();
    }
}
