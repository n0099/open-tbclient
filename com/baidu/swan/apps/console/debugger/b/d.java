package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.ao.u;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes9.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static String Rd;

    public static String apQ() {
        return Rd;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String apn() {
        return b.apu().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        Rd = u.g(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.mN(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.mO(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", Rd);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.app());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.apo());
    }

    public static void apR() {
        e aMl = e.aMl();
        if (aMl != null) {
            com.baidu.swan.apps.ao.e.N(aMl.getActivity());
            System.exit(0);
        }
    }
}
