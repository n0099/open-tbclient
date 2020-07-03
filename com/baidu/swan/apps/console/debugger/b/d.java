package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.aq.s;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static String OJ;

    public static String XB() {
        return OJ;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String WY() {
        return b.Xf().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void p(Bundle bundle) {
        OJ = s.f(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.iV(s.f(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.iW(s.f(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void q(Bundle bundle) {
        bundle.putString("extraWSUrl", OJ);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.Xa());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.WZ());
    }

    public static void XC() {
        e apM = e.apM();
        if (apM != null) {
            com.baidu.swan.apps.aq.d.N(apM.getActivity());
            System.exit(0);
        }
    }
}
