package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String vd;

    public static String LW() {
        return vd;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String Lt() {
        return b.LA().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        vd = r.e(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.gA(r.e(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.gB(r.e(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", vd);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.Lv());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.Lu());
    }

    public static void LX() {
        e acD = e.acD();
        if (acD != null) {
            com.baidu.swan.apps.as.c.T(acD.getActivity());
            System.exit(0);
        }
    }
}
