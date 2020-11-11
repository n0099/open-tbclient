package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.ap.u;
/* loaded from: classes10.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static String cFk = "";

    public static String alH() {
        return cFk;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String alz() {
        return a.alG().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        cFk = u.g(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.mt(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.mu(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("adb_debug_path", cFk);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.alB());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.alA());
    }
}
