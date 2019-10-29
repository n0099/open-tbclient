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
        com.baidu.swan.apps.w.e LD = com.baidu.swan.apps.w.e.LD();
        String a = a(LD);
        SwanAppActivity Lp = LD.Lp();
        if (Lp == null || Lp.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        aVar.x(Lp);
        com.baidu.swan.apps.core.j.a aVar2 = new com.baidu.swan.apps.core.j.a();
        aVar2.aNQ = gVar.aSe.bkG;
        gVar.aSe.bkG = null;
        aVar2.aNR = gVar.aSd;
        aVar2.aNS = cVar.Ct();
        aVar2.aNT = a;
        aVar2.aNV = String.valueOf(com.baidu.swan.apps.console.a.Dc());
        aVar2.aNW = aVar2.a(com.baidu.swan.apps.ae.b.QZ(), a);
        boolean z = DEBUG || com.baidu.swan.apps.w.e.LD().Lk();
        aVar2.aNX = z;
        Bundle KI = bVar.KI();
        if (KI != null) {
            String string = KI.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                aVar2.aNU = string;
            }
        }
        com.baidu.swan.apps.performance.f.NJ().f(new UbcFlowEvent("master_dispatch_start"));
        com.baidu.swan.apps.y.f.Mw().gj("master_dispatch_start");
        aVar.a(aVar2);
        LD.a(com.baidu.swan.apps.core.j.a.b(aVar2));
        com.baidu.swan.apps.ae.a.d fM = LD.fM(aa.iV(a));
        cVar.x(Lp);
        com.baidu.swan.apps.core.j.b bVar2 = new com.baidu.swan.apps.core.j.b();
        bVar2.aNR = gVar.aSd;
        bVar2.aNY = a;
        bVar2.aNZ = fM.blb;
        bVar2.aNV = String.valueOf(com.baidu.swan.apps.console.a.Dc());
        bVar2.aNX = z;
        com.baidu.swan.apps.performance.f.NJ().f(new UbcFlowEvent("slave_dispatch_start"));
        com.baidu.swan.apps.y.f.Mw().gj("slave_dispatch_start");
        cVar.a(bVar2);
        LD.a(cVar.Ct(), com.baidu.swan.apps.core.j.b.b(bVar2));
        if (DEBUG) {
            Log.d("FirstPageAction", "app path: " + aVar2.aNR);
            Log.d("FirstPageAction", "webviewId: " + cVar.Ct());
            Log.d("FirstPageAction", "pageUrl: " + a);
            Log.d("FirstPageAction", "pagePath: " + bVar2.aNY);
            Log.d("FirstPageAction", "onReachBottomDistance: " + bVar2.aNZ);
            Log.d("FirstPageAction", "sConsole:" + bVar2.aNV);
        }
        if (LD.AH() != null) {
            com.baidu.swan.apps.model.b ay = com.baidu.swan.apps.model.b.ay(a, LD.Lm());
            com.baidu.swan.apps.core.i.b.a(ac.B(ay.mBaseUrl, ay.aTe, ay.mParams), cVar);
            a(Lp, a);
            Lp.AE().fG(1);
            com.baidu.swan.apps.statistic.e.g(true, bVar.KE());
        }
    }

    public static void a(SwanAppActivity swanAppActivity, String str) {
        swanAppActivity.AH().eC("init").H(com.baidu.swan.apps.core.d.e.aLn, com.baidu.swan.apps.core.d.e.aLn).FA().a("normal", com.baidu.swan.apps.model.b.ay(str, com.baidu.swan.apps.w.e.LD().Lm()), true).commit();
    }

    public static String a(com.baidu.swan.apps.w.e eVar) {
        String Ln = eVar.Ln();
        if (TextUtils.isEmpty(Ln)) {
            return eVar.Lo();
        }
        return Ln;
    }
}
