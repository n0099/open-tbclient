package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.b.c.e;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void zo() {
        e dY = com.baidu.swan.apps.w.e.GF().dY(com.baidu.swan.apps.w.e.GF().Ac());
        if (dY != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            dY.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void dG(String str) {
        Z("sanFullData2Console", str);
    }

    public static void dH(String str) {
        Z("sanIncData2Console", str);
    }

    private static void Z(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        com.baidu.swan.apps.w.e.GF().a(com.baidu.swan.apps.w.e.GF().Gl().xv(), new com.baidu.swan.apps.m.a.b(str, hashMap));
    }
}
