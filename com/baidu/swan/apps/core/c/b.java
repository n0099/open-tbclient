package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.y.f;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void KW() {
        e hg = f.UC().hg(f.UC().LJ());
        if (hg != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            hg.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void gB(String str) {
        ap("sanFullData2Console", str);
    }

    public static void gC(String str) {
        ap("sanIncData2Console", str);
    }

    private static void ap(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.UC().a(f.UC().Ug().GA(), new com.baidu.swan.apps.n.a.b(str, hashMap));
    }
}
