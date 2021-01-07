package com.baidu.swan.apps.env.b;

import com.baidu.swan.apps.env.b.a;
import com.facebook.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class b {
    public static final Set<String> dcA = i.R("zeus");
    public static final Set<String> dcB = new HashSet(dcA);
    private static final Set<String> dcC = new HashSet(dcB);
    private static final Map<String, a> dcD = new HashMap();
    private static boolean dcE = false;

    public static a os(String str) {
        axm();
        return dcD.get(str);
    }

    private static void axm() {
        if (!dcE) {
            for (String str : dcC) {
                if ("zeus".equals(str)) {
                    dcD.put(str, axn());
                }
            }
        }
        dcE = true;
    }

    private static a axn() {
        return new a.C0440a().or("zeus").a(com.baidu.swan.apps.t.a.aBf().amg()).fD(com.baidu.swan.apps.t.a.aBf().ame()).axl();
    }
}
