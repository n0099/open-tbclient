package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void afP() {
        e lT = f.arY().lT(f.arY().agW());
        if (lT != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            lT.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void la(String str) {
        bi("sanFullData2Console", str);
    }

    public static void lb(String str) {
        bi("sanIncData2Console", str);
    }

    private static void bi(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.arY().a(f.arY().arB().aaU(), new com.baidu.swan.apps.event.a.b(str, hashMap));
    }
}
