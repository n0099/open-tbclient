package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.ao.u;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes9.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static String QZ;

    public static String amt() {
        return QZ;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String alQ() {
        return b.alX().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        QZ = u.g(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.lU(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.lV(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", QZ);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.alS());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.alR());
    }

    public static void amu() {
        e aIK = e.aIK();
        if (aIK != null) {
            com.baidu.swan.apps.ao.e.H(aIK.getActivity());
            System.exit(0);
        }
    }
}
