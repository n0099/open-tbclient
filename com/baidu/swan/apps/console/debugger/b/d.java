package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.ao.u;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes8.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static String Rb;

    public static String alV() {
        return Rb;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String als() {
        return b.alz().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        Rb = u.g(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.lC(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.lD(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", Rb);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.alu());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.alt());
    }

    public static void alW() {
        e aIr = e.aIr();
        if (aIr != null) {
            com.baidu.swan.apps.ao.e.N(aIr.getActivity());
            System.exit(0);
        }
    }
}
