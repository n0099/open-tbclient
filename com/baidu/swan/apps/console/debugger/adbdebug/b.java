package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.as.r;
/* loaded from: classes10.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bfA = "";

    public static String Jm() {
        return bfA;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String Je() {
        return a.Jl().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        bfA = r.e(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.gk(r.e(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.gl(r.e(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("adb_debug_path", bfA);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.Jg());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.Jf());
    }
}
