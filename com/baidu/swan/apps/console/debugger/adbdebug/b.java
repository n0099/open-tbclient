package com.baidu.swan.apps.console.debugger.adbdebug;

import android.os.Bundle;
import com.baidu.swan.apps.aq.s;
/* loaded from: classes11.dex */
public class b implements com.baidu.swan.apps.console.debugger.a {
    private static String bRg = "";

    public static String Wa() {
        return bRg;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String VS() {
        return a.VZ().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void p(Bundle bundle) {
        bRg = s.f(bundle, "adb_debug_path");
        com.baidu.swan.apps.console.debugger.b.iN(s.f(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.iO(s.f(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void q(Bundle bundle) {
        bundle.putString("adb_debug_path", bRg);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.VU());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.VT());
    }
}
