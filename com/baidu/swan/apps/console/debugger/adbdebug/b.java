package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.ap.u;
/* loaded from: classes8.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static String ccu = "";

    public static String adS() {
        return ccu;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String adK() {
        return a.adR().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        ccu = u.g(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.kF(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.kG(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("adb_debug_path", ccu);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.adM());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.adL());
    }
}
