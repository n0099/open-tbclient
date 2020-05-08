package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.as.r;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bIp = "";

    public static String Tt() {
        return bIp;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String Tl() {
        return a.Ts().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        bIp = r.e(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.hM(r.e(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.hN(r.e(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("adb_debug_path", bIp);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.Tn());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.Tm());
    }
}
