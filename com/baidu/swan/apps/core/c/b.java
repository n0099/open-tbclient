package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
/* loaded from: classes25.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void aqe() {
        e oj = f.aCp().oj(f.aCp().arl());
        if (oj != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            oj.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void np(String str) {
        bA("sanFullData2Console", str);
    }

    public static void nq(String str) {
        bA("sanIncData2Console", str);
    }

    private static void bA(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.aCp().a(f.aCp().aBS().alj(), new com.baidu.swan.apps.event.a.b(str, hashMap));
    }
}
