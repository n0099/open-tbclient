package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void anE() {
        e nH = f.azO().nH(f.azO().aoL());
        if (nH != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            nH.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void mO(String str) {
        bu("sanFullData2Console", str);
    }

    public static void mP(String str) {
        bu("sanIncData2Console", str);
    }

    private static void bu(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.azO().a(f.azO().azr().aiJ(), new com.baidu.swan.apps.event.a.b(str, hashMap));
    }
}
