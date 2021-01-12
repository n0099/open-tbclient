package com.baidu.swan.apps.env.b;

import com.baidu.swan.apps.env.b.a;
import com.facebook.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class b {
    public static final Set<String> cXL = i.R("zeus");
    public static final Set<String> cXM = new HashSet(cXL);
    private static final Set<String> cXN = new HashSet(cXM);
    private static final Map<String, a> cXO = new HashMap();
    private static boolean cXP = false;

    public static a nf(String str) {
        ats();
        return cXO.get(str);
    }

    private static void ats() {
        if (!cXP) {
            for (String str : cXN) {
                if ("zeus".equals(str)) {
                    cXO.put(str, att());
                }
            }
        }
        cXP = true;
    }

    private static a att() {
        return new a.C0423a().ne("zeus").a(com.baidu.swan.apps.t.a.axl().aim()).fz(com.baidu.swan.apps.t.a.axl().aik()).atr();
    }
}
