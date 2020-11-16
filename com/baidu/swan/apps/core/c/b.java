package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void amW() {
        e nB = f.azg().nB(f.azg().aod());
        if (nB != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            nB.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void mI(String str) {
        bt("sanFullData2Console", str);
    }

    public static void mJ(String str) {
        bt("sanIncData2Console", str);
    }

    private static void bt(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.azg().a(f.azg().ayJ().aib(), new com.baidu.swan.apps.event.a.b(str, hashMap));
    }
}
