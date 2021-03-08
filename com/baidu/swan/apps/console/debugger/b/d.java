package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.ao.u;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes8.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static String Su;

    public static String amw() {
        return Su;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String alT() {
        return b.ama().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        Su = u.g(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.mb(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.mc(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", Su);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.alV());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.alU());
    }

    public static void amx() {
        e aIN = e.aIN();
        if (aIN != null) {
            com.baidu.swan.apps.ao.e.H(aIN.getActivity());
            System.exit(0);
        }
    }
}
