package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.aq.s;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static String Oh;

    public static String Wv() {
        return Oh;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String VS() {
        return b.VZ().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void p(Bundle bundle) {
        Oh = s.f(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.iN(s.f(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.iO(s.f(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void q(Bundle bundle) {
        bundle.putString("extraWSUrl", Oh);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.VU());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.VT());
    }

    public static void Ww() {
        e aoF = e.aoF();
        if (aoF != null) {
            com.baidu.swan.apps.aq.d.N(aoF.getActivity());
            System.exit(0);
        }
    }
}
