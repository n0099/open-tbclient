package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String vd;

    public static String Mb() {
        return vd;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String Ly() {
        return b.LF().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        vd = r.e(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.gz(r.e(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.gA(r.e(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", vd);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.LA());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.Lz());
    }

    public static void Mc() {
        e acI = e.acI();
        if (acI != null) {
            com.baidu.swan.apps.as.c.T(acI.getActivity());
            System.exit(0);
        }
    }
}
