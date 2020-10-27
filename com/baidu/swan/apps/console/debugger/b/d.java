package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes10.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static String Qf;

    public static String ajC() {
        return Qf;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String aiZ() {
        return b.ajg().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        Qf = u.g(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.me(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.mf(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", Qf);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.ajb());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.aja());
    }

    public static void ajD() {
        e aEU = e.aEU();
        if (aEU != null) {
            com.baidu.swan.apps.ap.e.N(aEU.getActivity());
            System.exit(0);
        }
    }
}
