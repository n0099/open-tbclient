package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.ao.u;
/* loaded from: classes8.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static String cOs = "";

    public static String amb() {
        return cOs;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String alT() {
        return a.ama().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        cOs = u.g(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.mb(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.mc(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("adb_debug_path", cOs);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.alV());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.alU());
    }
}
