package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void anX() {
        e np = f.aAo().np(f.aAo().apk());
        if (np != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            np.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void mw(String str) {
        bs("sanFullData2Console", str);
    }

    public static void mx(String str) {
        bs("sanIncData2Console", str);
    }

    private static void bs(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.aAo().a(f.aAo().azR().ajb(), new com.baidu.swan.apps.event.a.b(str, hashMap));
    }
}
