package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.ap.u;
/* loaded from: classes10.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static String cqQ = "";

    public static String ahn() {
        return cqQ;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String ahf() {
        return a.ahm().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        cqQ = u.g(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.lL(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.lM(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("adb_debug_path", cqQ);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.ahh());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.ahg());
    }
}
