package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void arr() {
        e ob = f.aDH().ob(f.aDH().asE());
        if (ob != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            ob.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void ni(String str) {
        bz("sanFullData2Console", str);
    }

    public static void nj(String str) {
        bz("sanIncData2Console", str);
    }

    private static void bz(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.aDH().a(f.aDH().aDk().amu(), new com.baidu.swan.apps.event.a.b(str, hashMap));
    }
}
