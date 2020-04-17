package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String NV;

    public static String TP() {
        return NV;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String Tm() {
        return b.Tt().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        NV = r.e(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.hM(r.e(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.hN(r.e(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", NV);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.To());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.Tn());
    }

    public static void TQ() {
        e akN = e.akN();
        if (akN != null) {
            com.baidu.swan.apps.as.c.P(akN.getActivity());
            System.exit(0);
        }
    }
}
