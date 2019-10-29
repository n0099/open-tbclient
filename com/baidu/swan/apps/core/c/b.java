package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.b.c.e;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void En() {
        e eH = com.baidu.swan.apps.w.e.LD().eH(com.baidu.swan.apps.w.e.LD().Fb());
        if (eH != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            eH.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void eq(String str) {
        ah("sanFullData2Console", str);
    }

    public static void er(String str) {
        ah("sanIncData2Console", str);
    }

    private static void ah(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        com.baidu.swan.apps.w.e.LD().a(com.baidu.swan.apps.w.e.LD().Lj().Ct(), new com.baidu.swan.apps.m.a.b(str, hashMap));
    }
}
