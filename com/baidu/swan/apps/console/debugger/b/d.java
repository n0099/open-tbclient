package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes9.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String uJ;

    public static String Jl() {
        return uJ;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String II() {
        return b.IP().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        uJ = r.e(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.gh(r.e(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.gi(r.e(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", uJ);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.IK());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.IJ());
    }

    public static void Jm() {
        e ZS = e.ZS();
        if (ZS != null) {
            com.baidu.swan.apps.as.c.R(ZS.getActivity());
            System.exit(0);
        }
    }
}
