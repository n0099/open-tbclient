package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void ZG() {
        e kq = f.akr().kq(f.akr().aaL());
        if (kq != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            kq.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void jB(String str) {
        bb("sanFullData2Console", str);
    }

    public static void jC(String str) {
        bb("sanIncData2Console", str);
    }

    private static void bb(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.akr().a(f.akr().ajU().UR(), new com.baidu.swan.apps.event.a.b(str, hashMap));
    }
}
