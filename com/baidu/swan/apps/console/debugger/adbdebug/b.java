package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.ao.u;
/* loaded from: classes9.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static String cMS = "";

    public static String alY() {
        return cMS;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String alQ() {
        return a.alX().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        cMS = u.g(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.lU(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.lV(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("adb_debug_path", cMS);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.alS());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.alR());
    }
}
