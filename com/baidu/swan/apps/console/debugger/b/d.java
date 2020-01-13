package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes10.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String uM;

    public static String JH() {
        return uM;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String Je() {
        return b.Jl().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        uM = r.e(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.gk(r.e(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.gl(r.e(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", uM);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.Jg());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.Jf());
    }

    public static void JI() {
        e aap = e.aap();
        if (aap != null) {
            com.baidu.swan.apps.as.c.S(aap.getActivity());
            System.exit(0);
        }
    }
}
