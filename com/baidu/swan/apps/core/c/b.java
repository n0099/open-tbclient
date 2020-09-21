package com.baidu.swan.apps.core.c;

import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void agz() {
        e mn = f.asJ().mn(f.asJ().ahG());
        if (mn != null) {
            com.baidu.swan.apps.console.c.i("ConsoleMessageHelper", "send full San request");
            mn.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void lu(String str) {
        bi("sanFullData2Console", str);
    }

    public static void lv(String str) {
        bi("sanIncData2Console", str);
    }

    private static void bi(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        f.asJ().a(f.asJ().asl().abD(), new com.baidu.swan.apps.event.a.b(str, hashMap));
    }
}
