package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.as.r;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static String vd;

    public static String LY() {
        return vd;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String Lv() {
        return b.LC().getPath();
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
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.Lx());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.Lw());
    }

    public static void LZ() {
        e acF = e.acF();
        if (acF != null) {
            com.baidu.swan.apps.as.c.T(acF.getActivity());
            System.exit(0);
        }
    }
}
