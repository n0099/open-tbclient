package com.baidu.swan.apps.scheme.actions.i;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.b.c.c cVar, com.baidu.swan.apps.v.b.b bVar, e.g gVar) {
        com.baidu.swan.apps.w.e GJ = com.baidu.swan.apps.w.e.GJ();
        String a = a(GJ);
        SwanAppActivity Gv = GJ.Gv();
        if (Gv == null || Gv.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        aVar.y(Gv);
        com.baidu.swan.apps.core.j.a aVar2 = new com.baidu.swan.apps.core.j.a();
        aVar2.auz = gVar.ayO.aRC;
        gVar.ayO.aRC = null;
        aVar2.auA = gVar.ayN;
        aVar2.auB = cVar.xz();
        aVar2.auC = a;
        aVar2.auE = String.valueOf(com.baidu.swan.apps.console.a.yh());
        aVar2.auF = aVar2.a(com.baidu.swan.apps.ae.b.Mh(), a);
        boolean z = DEBUG || com.baidu.swan.apps.w.e.GJ().Gq();
        aVar2.auG = z;
        Bundle FO = bVar.FO();
        if (FO != null) {
            String string = FO.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                aVar2.auD = string;
            }
        }
        com.baidu.swan.apps.performance.f.IP().f(new UbcFlowEvent("master_dispatch_start"));
        com.baidu.swan.apps.y.f.HC().fF("master_dispatch_start");
        aVar.a(aVar2);
        GJ.a(com.baidu.swan.apps.core.j.a.b(aVar2));
        com.baidu.swan.apps.ae.a.d ff = GJ.ff(aa.is(a));
        cVar.y(Gv);
        com.baidu.swan.apps.core.j.b bVar2 = new com.baidu.swan.apps.core.j.b();
        bVar2.auA = gVar.ayN;
        bVar2.auH = a;
        bVar2.auI = ff.aRX;
        bVar2.auE = String.valueOf(com.baidu.swan.apps.console.a.yh());
        bVar2.auG = z;
        com.baidu.swan.apps.performance.f.IP().f(new UbcFlowEvent("slave_dispatch_start"));
        com.baidu.swan.apps.y.f.HC().fF("slave_dispatch_start");
        cVar.a(bVar2);
        GJ.a(cVar.xz(), com.baidu.swan.apps.core.j.b.b(bVar2));
        if (DEBUG) {
            Log.d("FirstPageAction", "app path: " + aVar2.auA);
            Log.d("FirstPageAction", "webviewId: " + cVar.xz());
            Log.d("FirstPageAction", "pageUrl: " + a);
            Log.d("FirstPageAction", "pagePath: " + bVar2.auH);
            Log.d("FirstPageAction", "onReachBottomDistance: " + bVar2.auI);
            Log.d("FirstPageAction", "sConsole:" + bVar2.auE);
        }
        if (GJ.vN() != null) {
            com.baidu.swan.apps.model.b aq = com.baidu.swan.apps.model.b.aq(a, GJ.Gs());
            com.baidu.swan.apps.core.i.b.a(ac.x(aq.mBaseUrl, aq.azQ, aq.mParams), cVar);
            a(Gv, a);
            Gv.vK().eL(1);
            com.baidu.swan.apps.statistic.e.f(true, bVar.FK());
        }
    }

    public static void a(SwanAppActivity swanAppActivity, String str) {
        swanAppActivity.vN().dU("init").B(com.baidu.swan.apps.core.d.e.arW, com.baidu.swan.apps.core.d.e.arW).AF().a("normal", com.baidu.swan.apps.model.b.aq(str, com.baidu.swan.apps.w.e.GJ().Gs()), true).commit();
    }

    public static String a(com.baidu.swan.apps.w.e eVar) {
        String Gt = eVar.Gt();
        if (TextUtils.isEmpty(Gt)) {
            return eVar.Gu();
        }
        return Gt;
    }
}
