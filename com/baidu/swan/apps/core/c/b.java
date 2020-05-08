package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.y.f;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void Vc() {
        e iI = f.aeJ().iI(f.aeJ().VP());
        if (iI != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            iI.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void id(String str) {
        aH("sanFullData2Console", str);
    }

    public static void ie(String str) {
        aH("sanIncData2Console", str);
    }

    private static void aH(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.aeJ().a(f.aeJ().aen().QF(), new com.baidu.swan.apps.n.a.b(str, hashMap));
    }
}
