package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.y.f;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void KA() {
        e hd = f.Uf().hd(f.Uf().Ln());
        if (hd != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            hd.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void gy(String str) {
        ao("sanFullData2Console", str);
    }

    public static void gz(String str) {
        ao("sanIncData2Console", str);
    }

    private static void ao(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.Uf().a(f.Uf().TJ().Ge(), new com.baidu.swan.apps.n.a.b(str, hashMap));
    }
}
