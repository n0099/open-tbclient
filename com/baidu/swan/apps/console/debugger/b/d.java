package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes7.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static String Qg;

    public static String alu() {
        return Qg;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String akR() {
        return b.akY().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        Qg = u.g(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.mn(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.mo(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", Qg);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.akT());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.akS());
    }

    public static void alv() {
        e aGM = e.aGM();
        if (aGM != null) {
            com.baidu.swan.apps.ap.e.M(aGM.getActivity());
            System.exit(0);
        }
    }
}
