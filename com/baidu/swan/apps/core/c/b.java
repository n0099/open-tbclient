package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.y.f;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void Nq() {
        e hu = f.WV().hu(f.WV().Oc());
        if (hu != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            hu.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void gP(String str) {
        ay("sanFullData2Console", str);
    }

    public static void gQ(String str) {
        ay("sanIncData2Console", str);
    }

    private static void ay(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.WV().a(f.WV().Wz().IU(), new com.baidu.swan.apps.n.a.b(str, hashMap));
    }
}
