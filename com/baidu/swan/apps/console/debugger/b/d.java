package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes25.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static String Ra;

    public static String aoC() {
        return Ra;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String anZ() {
        return b.aog().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        Ra = u.g(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.mU(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.mV(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", Ra);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.aob());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.aoa());
    }

    public static void aoD() {
        e aJU = e.aJU();
        if (aJU != null) {
            com.baidu.swan.apps.ap.e.M(aJU.getActivity());
            System.exit(0);
        }
    }
}
