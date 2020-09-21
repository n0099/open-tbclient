package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.ap.u;
/* loaded from: classes3.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static String ceA = "";

    public static String aeC() {
        return ceA;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String aeu() {
        return a.aeB().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        ceA = u.g(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.kZ(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.la(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("adb_debug_path", ceA);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.aew());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.aev());
    }
}
