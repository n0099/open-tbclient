package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void ajk() {
        e mZ = f.avu().mZ(f.avu().akr());
        if (mZ != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            mZ.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void mg(String str) {
        bn("sanFullData2Console", str);
    }

    public static void mh(String str) {
        bn("sanIncData2Console", str);
    }

    private static void bn(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.avu().a(f.avu().auX().aep(), new com.baidu.swan.apps.event.a.b(str, hashMap));
    }
}
