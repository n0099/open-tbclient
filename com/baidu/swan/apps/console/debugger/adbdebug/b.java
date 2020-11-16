package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.ap.u;
/* loaded from: classes7.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static String cDA = "";

    public static String akZ() {
        return cDA;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String akR() {
        return a.akY().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        cDA = u.g(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.mn(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.mo(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("adb_debug_path", cDA);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.akT());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.akS());
    }
}
