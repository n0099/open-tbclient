package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.ap.u;
/* loaded from: classes10.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static String czr = "";

    public static String ajh() {
        return czr;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String aiZ() {
        return a.ajg().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        czr = u.g(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.me(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.mf(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("adb_debug_path", czr);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.ajb());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.aja());
    }
}
