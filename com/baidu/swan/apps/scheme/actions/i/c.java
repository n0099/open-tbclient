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
        com.baidu.swan.apps.w.e FV = com.baidu.swan.apps.w.e.FV();
        String a = a(FV);
        SwanAppActivity FH = FV.FH();
        if (FH == null || FH.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        aVar.v(FH);
        com.baidu.swan.apps.core.j.a aVar2 = new com.baidu.swan.apps.core.j.a();
        aVar2.aty = gVar.axJ.aQu;
        gVar.axJ.aQu = null;
        aVar2.atz = gVar.axI;
        aVar2.atA = cVar.wU();
        aVar2.atB = a;
        aVar2.atD = String.valueOf(com.baidu.swan.apps.console.a.xz());
        aVar2.atE = aVar2.a(com.baidu.swan.apps.ae.b.Lq(), a);
        boolean z = DEBUG || com.baidu.swan.apps.w.e.FV().FC();
        aVar2.atF = z;
        Bundle Fa = bVar.Fa();
        if (Fa != null) {
            String string = Fa.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                aVar2.atC = string;
            }
        }
        com.baidu.swan.apps.performance.f.HY().f(new UbcFlowEvent("master_dispatch_start"));
        com.baidu.swan.apps.y.f.GN().fy("master_dispatch_start");
        aVar.a(aVar2);
        FV.a(com.baidu.swan.apps.core.j.a.b(aVar2));
        com.baidu.swan.apps.ae.a.d eY = FV.eY(aa.ij(a));
        cVar.v(FH);
        com.baidu.swan.apps.core.j.b bVar2 = new com.baidu.swan.apps.core.j.b();
        bVar2.atz = gVar.axI;
        bVar2.atG = a;
        bVar2.atH = eY.aQP;
        bVar2.atD = String.valueOf(com.baidu.swan.apps.console.a.xz());
        bVar2.atF = z;
        com.baidu.swan.apps.performance.f.HY().f(new UbcFlowEvent("slave_dispatch_start"));
        com.baidu.swan.apps.y.f.GN().fy("slave_dispatch_start");
        cVar.a(bVar2);
        FV.a(cVar.wU(), com.baidu.swan.apps.core.j.b.b(bVar2));
        if (DEBUG) {
            Log.d("FirstPageAction", "app path: " + aVar2.atz);
            Log.d("FirstPageAction", "webviewId: " + cVar.wU());
            Log.d("FirstPageAction", "pageUrl: " + a);
            Log.d("FirstPageAction", "pagePath: " + bVar2.atG);
            Log.d("FirstPageAction", "onReachBottomDistance: " + bVar2.atH);
            Log.d("FirstPageAction", "sConsole:" + bVar2.atD);
        }
        if (FV.vi() != null) {
            com.baidu.swan.apps.model.b aq = com.baidu.swan.apps.model.b.aq(a, FV.FE());
            com.baidu.swan.apps.core.i.b.a(ac.x(aq.mBaseUrl, aq.ayL, aq.mParams), cVar);
            a(FH, a);
            FH.vf().eH(1);
            com.baidu.swan.apps.statistic.e.f(true, bVar.EW());
        }
    }

    public static void a(SwanAppActivity swanAppActivity, String str) {
        swanAppActivity.vi().dN("init").y(com.baidu.swan.apps.core.d.e.aqV, com.baidu.swan.apps.core.d.e.aqV).zU().a("normal", com.baidu.swan.apps.model.b.aq(str, com.baidu.swan.apps.w.e.FV().FE()), true).commit();
    }

    public static String a(com.baidu.swan.apps.w.e eVar) {
        String FF = eVar.FF();
        if (TextUtils.isEmpty(FF)) {
            return eVar.FG();
        }
        return FF;
    }
}
