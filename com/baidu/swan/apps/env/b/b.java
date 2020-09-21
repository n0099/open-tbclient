package com.baidu.swan.apps.env.b;

import com.baidu.swan.apps.env.b.a;
import com.facebook.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class b {
    public static final Set<String> crW = i.N("zeus");
    public static final Set<String> crX = new HashSet(crW);
    private static final Set<String> crY = new HashSet(crX);
    private static final Map<String, a> crZ = new HashMap();
    private static boolean csa = false;

    public static a mD(String str) {
        amm();
        return crZ.get(str);
    }

    private static void amm() {
        if (!csa) {
            for (String str : crY) {
                if ("zeus".equals(str)) {
                    crZ.put(str, amn());
                }
            }
        }
        csa = true;
    }

    private static a amn() {
        return new a.C0395a().mC("zeus").a(com.baidu.swan.apps.t.a.aqh().abp()).ek(com.baidu.swan.apps.t.a.aqh().abn()).aml();
    }
}
