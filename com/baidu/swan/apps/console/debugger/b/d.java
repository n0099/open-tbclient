package com.baidu.swan.apps.console.debugger.b;

import android.os.Bundle;
import com.baidu.swan.apps.ap.u;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes3.dex */
public class d implements com.baidu.swan.apps.console.debugger.a {
    private static String PM;

    public static String aeX() {
        return PM;
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public String aeu() {
        return b.aeB().getPath();
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void n(Bundle bundle) {
        PM = u.g(bundle, "extraWSUrl");
        com.baidu.swan.apps.console.debugger.b.kZ(u.g(bundle, "masterPreload"));
        com.baidu.swan.apps.console.debugger.b.la(u.g(bundle, "slavePreload"));
    }

    @Override // com.baidu.swan.apps.console.debugger.a
    public void o(Bundle bundle) {
        bundle.putString("extraWSUrl", PM);
        bundle.putString("slavePreload", com.baidu.swan.apps.console.debugger.b.aew());
        bundle.putString("masterPreload", com.baidu.swan.apps.console.debugger.b.aev());
    }

    public static void aeY() {
        e aAr = e.aAr();
        if (aAr != null) {
            com.baidu.swan.apps.ap.e.M(aAr.getActivity());
            System.exit(0);
        }
    }
}
