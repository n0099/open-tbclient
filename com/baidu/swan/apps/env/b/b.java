package com.baidu.swan.apps.env.b;

import com.baidu.swan.apps.env.b.a;
import com.facebook.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public class b {
    public static final Set<String> cEh = i.N("zeus");
    public static final Set<String> cEi = new HashSet(cEh);
    private static final Set<String> cEj = new HashSet(cEi);
    private static final Map<String, a> cEk = new HashMap();
    private static boolean cEl = false;

    public static a np(String str) {
        aoX();
        return cEk.get(str);
    }

    private static void aoX() {
        if (!cEl) {
            for (String str : cEj) {
                if ("zeus".equals(str)) {
                    cEk.put(str, aoY());
                }
            }
        }
        cEl = true;
    }

    private static a aoY() {
        return new a.C0412a().no("zeus").a(com.baidu.swan.apps.t.a.asT().aeb()).eG(com.baidu.swan.apps.t.a.asT().adZ()).aoW();
    }
}
