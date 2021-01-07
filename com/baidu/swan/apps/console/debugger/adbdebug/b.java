package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.ao.u;
/* loaded from: classes9.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static String cPq = "";

    public static String apv() {
        return cPq;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String apn() {
        return a.apu().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        cPq = u.g(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.mN(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.mO(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("adb_debug_path", cPq);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.app());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.apo());
    }
}
