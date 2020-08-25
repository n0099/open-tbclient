package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes8.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static String Pp;

    public static String aen() {
        return Pp;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String adK() {
        return b.adR().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        Pp = u.g(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.kF(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.kG(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", Pp);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.adM());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.adL());
    }

    public static void aeo() {
        e azI = e.azI();
        if (azI != null) {
            com.baidu.swan.apps.ap.e.K(azI.getActivity());
            System.exit(0);
        }
    }
}
