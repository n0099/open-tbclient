package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.as.r;
/* loaded from: classes9.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String beK = "";

    public static String IQ() {
        return beK;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String II() {
        return a.IP().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        beK = r.e(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.gh(r.e(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.gi(r.e(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("adb_debug_path", beK);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.IK());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.IJ());
    }
}
