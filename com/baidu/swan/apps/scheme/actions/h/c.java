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
        com.baidu.swan.apps.w.e Ea = com.baidu.swan.apps.w.e.Ea();
        final String a = a(Ea);
        final SwanAppActivity DM = Ea.DM();
        if (DM == null || DM.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        aVar.v(DM);
        com.baidu.swan.apps.core.i.a aVar2 = new com.baidu.swan.apps.core.i.a();
        aVar2.atj = gVar.axc.aOq;
        gVar.axc.aOq = null;
        aVar2.atk = gVar.axb;
        aVar2.atl = cVar.wd();
        aVar2.atm = a;
        aVar2.ato = String.valueOf(com.baidu.swan.apps.console.a.wH());
        aVar2.atp = aVar2.a(com.baidu.swan.apps.ae.b.IV(), a);
        Bundle bundle = bVar.axT;
        if (bundle != null) {
            String string = bundle.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                aVar2.atn = string;
            }
        }
        com.baidu.swan.apps.performance.f.FQ().f(new UbcFlowEvent("master_dispatch_start"));
        com.baidu.swan.apps.y.f.EP().fm("master_dispatch_start");
        Ea.a(com.baidu.swan.apps.core.i.a.a(aVar2));
        com.baidu.swan.apps.ae.a.d eO = Ea.eO(y.hG(a));
        cVar.v(DM);
        com.baidu.swan.apps.core.i.b bVar2 = new com.baidu.swan.apps.core.i.b();
        bVar2.atk = gVar.axb;
        bVar2.atq = a;
        bVar2.atr = eO.aOL;
        bVar2.ato = String.valueOf(com.baidu.swan.apps.console.a.wH());
        com.baidu.swan.apps.performance.f.FQ().f(new UbcFlowEvent("slave_dispatch_start"));
        com.baidu.swan.apps.y.f.EP().fm("slave_dispatch_start");
        Ea.a(cVar.wd(), com.baidu.swan.apps.core.i.b.a(bVar2));
        if (DEBUG) {
            Log.d("FirstPageAction", "app path: " + aVar2.atk);
            Log.d("FirstPageAction", "webviewId: " + cVar.wd());
            Log.d("FirstPageAction", "pageUrl: " + a);
            Log.d("FirstPageAction", "pagePath: " + bVar2.atq);
            Log.d("FirstPageAction", "onReachBottomDistance: " + bVar2.atr);
            Log.d("FirstPageAction", "sConsole:" + bVar2.ato);
        }
        if (Ea.uy() != null) {
            com.baidu.swan.apps.model.b ap = com.baidu.swan.apps.model.b.ap(a, Ea.DJ());
            com.baidu.swan.apps.core.h.b.b(aa.x(ap.mBaseUrl, ap.axL, ap.mParams), cVar);
            aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.h.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.a(SwanAppActivity.this, a);
                    SwanAppActivity.this.uv().ev(1);
                }
            });
            com.baidu.swan.apps.statistic.c.g(true, bVar.axJ);
            com.baidu.swan.apps.statistic.c.a(bVar, "clientready");
        }
    }

    public static void a(SwanAppActivity swanAppActivity, String str) {
        swanAppActivity.uy().ea("init").A(com.baidu.swan.apps.core.c.e.aqP, com.baidu.swan.apps.core.c.e.aqP).yX().a("normal", com.baidu.swan.apps.model.b.ap(str, com.baidu.swan.apps.w.e.Ea().DJ()), true).commit();
    }

    public static String a(com.baidu.swan.apps.w.e eVar) {
        String DK = eVar.DK();
        if (TextUtils.isEmpty(DK)) {
            return eVar.DL();
        }
        return DK;
    }
}
