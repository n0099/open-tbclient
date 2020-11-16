package com.baidu.swan.apps.env.b;

import com.baidu.swan.apps.env.b.a;
import com.facebook.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public class b {
    public static final Set<String> cQM = i.N("zeus");
    public static final Set<String> cQN = new HashSet(cQM);
    private static final Set<String> cQO = new HashSet(cQN);
    private static final Map<String, a> cQP = new HashMap();
    private static boolean cQQ = false;

    public static a nQ(String str) {
        asL();
        return cQP.get(str);
    }

    private static void asL() {
        if (!cQQ) {
            for (String str : cQO) {
                if ("zeus".equals(str)) {
                    cQP.put(str, asM());
                }
            }
        }
        cQQ = true;
    }

    private static a asM() {
        return new a.C0436a().nP("zeus").a(com.baidu.swan.apps.t.a.awF().ahN()).ff(com.baidu.swan.apps.t.a.awF().ahL()).asK();
    }
}
