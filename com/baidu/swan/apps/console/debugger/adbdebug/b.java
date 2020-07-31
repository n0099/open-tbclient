package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.aq.u;
/* loaded from: classes7.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static String bWL = "";

    public static String XM() {
        return bWL;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String XE() {
        return a.XL().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void p(Bundle bundle) {
        bWL = u.f(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.jf(u.f(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.jg(u.f(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void q(Bundle bundle) {
        bundle.putString("adb_debug_path", bWL);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.XG());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.XF());
    }
}
