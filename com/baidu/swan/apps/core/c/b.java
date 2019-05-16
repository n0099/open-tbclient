package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.b.c.e;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void yH() {
        e dU = com.baidu.swan.apps.w.e.FV().dU(com.baidu.swan.apps.w.e.FV().zv());
        if (dU != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            dU.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void dC(String str) {
        Z("sanFullData2Console", str);
    }

    public static void dD(String str) {
        Z("sanIncData2Console", str);
    }

    private static void Z(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        com.baidu.swan.apps.w.e.FV().a(com.baidu.swan.apps.w.e.FV().FB().wU(), new com.baidu.swan.apps.m.a.b(str, hashMap));
    }
}
