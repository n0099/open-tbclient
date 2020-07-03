package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.aq.s;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static String bVU = "";

    public static String Xg() {
        return bVU;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String WY() {
        return a.Xf().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void p(Bundle bundle) {
        bVU = s.f(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.iV(s.f(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.iW(s.f(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void q(Bundle bundle) {
        bundle.putString("adb_debug_path", bVU);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.Xa());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.WZ());
    }
}
