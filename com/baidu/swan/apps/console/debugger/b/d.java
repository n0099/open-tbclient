package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes10.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static String Qf;

    public static String amc() {
        return Qf;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String alz() {
        return b.alG().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        Qf = u.g(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.mt(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.mu(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", Qf);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.alB());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.alA());
    }

    public static void amd() {
        e aHu = e.aHu();
        if (aHu != null) {
            com.baidu.swan.apps.ap.e.N(aHu.getActivity());
            System.exit(0);
        }
    }
}
