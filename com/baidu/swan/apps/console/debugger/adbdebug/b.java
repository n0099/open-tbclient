package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.as.r;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String bjO = "";

    public static String LD() {
        return bjO;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String Lv() {
        return a.LC().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        bjO = r.e(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.gA(r.e(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.gB(r.e(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("adb_debug_path", bjO);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.Lx());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.Lw());
    }
}
