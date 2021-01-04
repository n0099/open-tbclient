package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.ao.u;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes9.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static String Rd;

    public static String apP() {
        return Rd;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String apm() {
        return b.apt().getPath();
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
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.apo());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.apn());
    }

    public static void apQ() {
        e aMk = e.aMk();
        if (aMk != null) {
            com.baidu.swan.apps.ao.e.N(aMk.getActivity());
            System.exit(0);
        }
    }
}
