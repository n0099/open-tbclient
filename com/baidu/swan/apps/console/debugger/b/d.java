package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.aq.u;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes7.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static String OJ;

    public static String Yh() {
        return OJ;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String XE() {
        return b.XL().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void p(Bundle bundle) {
        OJ = u.f(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.jf(u.f(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.jg(u.f(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void q(Bundle bundle) {
        bundle.putString("extraWSUrl", OJ);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.XG());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.XF());
    }

    public static void Yi() {
        e arv = e.arv();
        if (arv != null) {
            com.baidu.swan.apps.aq.e.M(arv.getActivity());
            System.exit(0);
        }
    }
}
