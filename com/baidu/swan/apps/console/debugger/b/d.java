package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes10.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static String Qe;

    public static String ahI() {
        return Qe;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String ahf() {
        return b.ahm().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        Qe = u.g(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.lL(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.lM(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", Qe);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.ahh());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.ahg());
    }

    public static void ahJ() {
        e aDa = e.aDa();
        if (aDa != null) {
            com.baidu.swan.apps.ap.e.N(aDa.getActivity());
            System.exit(0);
        }
    }
}
