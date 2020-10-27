package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void ale() {
        e ns = f.axo().ns(f.axo().aml());
        if (ns != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            ns.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void mz(String str) {
        bu("sanFullData2Console", str);
    }

    public static void mA(String str) {
        bu("sanIncData2Console", str);
    }

    private static void bu(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.axo().a(f.axo().awR().agj(), new com.baidu.swan.apps.event.a.b(str, hashMap));
    }
}
