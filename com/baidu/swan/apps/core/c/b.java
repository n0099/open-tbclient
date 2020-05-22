package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.w.f;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void XI() {
        e jO = f.ahV().jO(f.ahV().YB());
        if (jO != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            jO.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void je(String str) {
        aX("sanFullData2Console", str);
    }

    public static void jf(String str) {
        aX("sanIncData2Console", str);
    }

    private static void aX(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.ahV().a(f.ahV().ahy().Tj(), new com.baidu.swan.apps.event.a.b(str, hashMap));
    }
}
