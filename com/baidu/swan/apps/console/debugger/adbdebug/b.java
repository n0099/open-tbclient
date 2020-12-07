package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.ap.u;
/* loaded from: classes25.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static String cKv = "";

    public static String aoh() {
        return cKv;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String anZ() {
        return a.aog().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        cKv = u.g(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.mU(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.mV(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("adb_debug_path", cKv);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.aob());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.aoa());
    }
}
