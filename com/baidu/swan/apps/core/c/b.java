package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.y.f;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void Nl() {
        e hv = f.WQ().hv(f.WQ().NX());
        if (hv != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            hv.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void gQ(String str) {
        az("sanFullData2Console", str);
    }

    public static void gR(String str) {
        az("sanIncData2Console", str);
    }

    private static void az(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.WQ().a(f.WQ().Wu().IP(), new com.baidu.swan.apps.n.a.b(str, hashMap));
    }
}
