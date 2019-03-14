package com.baidu.swan.apps.scheme.actions.h;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.y;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(com.baidu.swan.apps.core.f.a aVar, com.baidu.swan.apps.b.c.c cVar, com.baidu.swan.apps.v.b.b bVar, c.g gVar) {
        com.baidu.swan.apps.w.e Ec = com.baidu.swan.apps.w.e.Ec();
        final String a = a(Ec);
        final SwanAppActivity DO = Ec.DO();
        if (DO == null || DO.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        aVar.v(DO);
        com.baidu.swan.apps.core.i.a aVar2 = new com.baidu.swan.apps.core.i.a();
        aVar2.atf = gVar.awZ.aOn;
        gVar.awZ.aOn = null;
        aVar2.atg = gVar.awY;
        aVar2.ath = cVar.we();
        aVar2.ati = a;
        aVar2.atk = String.valueOf(com.baidu.swan.apps.console.a.wI());
        aVar2.atl = aVar2.a(com.baidu.swan.apps.ae.b.IX(), a);
        Bundle bundle = bVar.axQ;
        if (bundle != null) {
            String string = bundle.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                aVar2.atj = string;
            }
        }
        com.baidu.swan.apps.performance.f.FS().f(new UbcFlowEvent("master_dispatch_start"));
        com.baidu.swan.apps.y.f.ER().fl("master_dispatch_start");
        Ec.a(com.baidu.swan.apps.core.i.a.a(aVar2));
        com.baidu.swan.apps.ae.a.d eN = Ec.eN(y.hF(a));
        cVar.v(DO);
        com.baidu.swan.apps.core.i.b bVar2 = new com.baidu.swan.apps.core.i.b();
        bVar2.atg = gVar.awY;
        bVar2.atm = a;
        bVar2.atn = eN.aOI;
        bVar2.atk = String.valueOf(com.baidu.swan.apps.console.a.wI());
        com.baidu.swan.apps.performance.f.FS().f(new UbcFlowEvent("slave_dispatch_start"));
        com.baidu.swan.apps.y.f.ER().fl("slave_dispatch_start");
        Ec.a(cVar.we(), com.baidu.swan.apps.core.i.b.a(bVar2));
        if (DEBUG) {
            Log.d("FirstPageAction", "app path: " + aVar2.atg);
            Log.d("FirstPageAction", "webviewId: " + cVar.we());
            Log.d("FirstPageAction", "pageUrl: " + a);
            Log.d("FirstPageAction", "pagePath: " + bVar2.atm);
            Log.d("FirstPageAction", "onReachBottomDistance: " + bVar2.atn);
            Log.d("FirstPageAction", "sConsole:" + bVar2.atk);
        }
        if (Ec.uz() != null) {
            com.baidu.swan.apps.model.b ap = com.baidu.swan.apps.model.b.ap(a, Ec.DL());
            com.baidu.swan.apps.core.h.b.b(aa.x(ap.mBaseUrl, ap.axI, ap.mParams), cVar);
            aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.h.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.a(SwanAppActivity.this, a);
                    SwanAppActivity.this.uw().ew(1);
                }
            });
            com.baidu.swan.apps.statistic.c.g(true, bVar.axG);
            com.baidu.swan.apps.statistic.c.a(bVar, "clientready");
        }
    }

    public static void a(SwanAppActivity swanAppActivity, String str) {
        swanAppActivity.uz().dY("init").A(com.baidu.swan.apps.core.c.e.aqL, com.baidu.swan.apps.core.c.e.aqL).yY().a("normal", com.baidu.swan.apps.model.b.ap(str, com.baidu.swan.apps.w.e.Ec().DL()), true).commit();
    }

    public static String a(com.baidu.swan.apps.w.e eVar) {
        String DM = eVar.DM();
        if (TextUtils.isEmpty(DM)) {
            return eVar.DN();
        }
        return DM;
    }
}
