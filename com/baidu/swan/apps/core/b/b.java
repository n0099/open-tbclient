package com.baidu.swan.apps.core.b;

import com.baidu.swan.apps.b.c.e;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void xQ() {
        e ee = com.baidu.swan.apps.w.e.Ec().ee(com.baidu.swan.apps.w.e.Ec().yB());
        if (ee != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            ee.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void dN(String str) {
        ad("sanFullData2Console", str);
    }

    public static void dO(String str) {
        ad("sanIncData2Console", str);
    }

    private static void ad(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        com.baidu.swan.apps.w.e.Ec().a(com.baidu.swan.apps.w.e.Ec().DI().we(), new com.baidu.swan.apps.m.a.b(str, hashMap));
    }
}
