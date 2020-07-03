package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.w.f;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void YO() {
        e jW = f.ajb().jW(f.ajb().ZH());
        if (jW != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            jW.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void jm(String str) {
        aZ("sanFullData2Console", str);
    }

    public static void jn(String str) {
        aZ("sanIncData2Console", str);
    }

    private static void aZ(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.ajb().a(f.ajb().aiE().Up(), new com.baidu.swan.apps.event.a.b(str, hashMap));
    }
}
