package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void anw() {
        e mQ = f.azN().mQ(f.azN().aoI());
        if (mQ != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            mQ.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void lX(String str) {
        by("sanFullData2Console", str);
    }

    public static void lY(String str) {
        by("sanIncData2Console", str);
    }

    private static void by(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.azN().a(f.azN().azq().aiA(), new com.baidu.swan.apps.event.a.b(str, hashMap));
    }
}
