package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String NZ;

    public static String TO() {
        return NZ;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String Tl() {
        return b.Ts().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        NZ = r.e(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.hM(r.e(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.hN(r.e(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", NZ);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.Tn());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.Tm());
    }

    public static void TP() {
        e akM = e.akM();
        if (akM != null) {
            com.baidu.swan.apps.as.c.P(akM.getActivity());
            System.exit(0);
        }
    }
}
