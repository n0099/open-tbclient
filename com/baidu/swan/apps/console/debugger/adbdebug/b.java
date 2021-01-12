package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.ao.u;
/* loaded from: classes8.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static String cKE = "";

    public static String alA() {
        return cKE;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String als() {
        return a.alz().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        cKE = u.g(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.lC(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.lD(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("adb_debug_path", cKE);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.alu());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.alt());
    }
}
