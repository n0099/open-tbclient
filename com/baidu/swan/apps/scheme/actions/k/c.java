package com.baidu.swan.apps.scheme.actions.k;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.y;
import com.baidu.swan.apps.console.v8inspector.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.t.e;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.x.b.b bVar, final e.f fVar) {
        if (com.baidu.swan.apps.ah.a.a.aiL()) {
            com.baidu.swan.apps.console.c.v("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.w.a.abO());
            com.baidu.swan.apps.performance.f.aid().f(new UbcFlowEvent("fist_page_action_reg_callback").ed(true));
            aVar2.a(new a.InterfaceC0268a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0268a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.x.b.b bVar, e.f fVar) {
        com.baidu.swan.apps.performance.f.aid().f(new UbcFlowEvent("fist_page_action_dostart").ed(true));
        com.baidu.swan.apps.y.f aeK = com.baidu.swan.apps.y.f.aeK();
        String a = a(aeK, bVar, fVar);
        String me = fVar.bVS.me(a);
        final SwanAppActivity aev = aeK.aev();
        if (aev == null || aev.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        aVar.D(aev);
        com.baidu.swan.apps.core.k.a aVar2 = new com.baidu.swan.apps.core.k.a();
        aVar2.appConfig = fVar.bVS.coK;
        fVar.bVS.coK = null;
        aVar2.appPath = fVar.bVR;
        aVar2.bQz = cVar.QG();
        aVar2.bQA = a;
        aVar2.bQC = String.valueOf(com.baidu.swan.apps.console.a.Ti());
        aVar2.bQD = aVar2.b(com.baidu.swan.apps.runtime.e.akN(), a);
        aVar2.bQF = me;
        boolean z = DEBUG || com.baidu.swan.apps.y.f.aeK().aep();
        aVar2.bQE = z;
        aVar2.bQG = cVar.QC();
        if (com.baidu.swan.apps.ah.a.a.aiL()) {
            aVar2.bQH = com.baidu.swan.apps.console.debugger.b.Tq();
        }
        Bundle adG = bVar.adG();
        if (adG != null) {
            String string = adG.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                aVar2.bQB = string;
            }
        }
        if (DEBUG) {
            Log.d("FirstPageAction", aVar2.toString());
        }
        com.baidu.swan.apps.performance.f.aid().f(new UbcFlowEvent("master_dispatch_start"));
        com.baidu.swan.apps.an.a.amP().mO("master_dispatch_start");
        aVar.a(aVar2);
        aeK.a(com.baidu.swan.apps.core.k.a.a(aVar2, null));
        com.baidu.swan.apps.core.k.d.Yo().dy(aVar2.bQG);
        if (com.baidu.swan.apps.ah.a.a.lA(bVar.adQ())) {
            com.baidu.swan.apps.console.debugger.a.d.TE();
            com.baidu.swan.apps.console.debugger.a.d.Tz().hP("appready");
        }
        com.baidu.swan.apps.runtime.config.c ke = aeK.ke(ag.delAllParamsFromUrl(a));
        cVar.D(aev);
        com.baidu.swan.apps.core.k.b bVar2 = new com.baidu.swan.apps.core.k.b();
        bVar2.appPath = fVar.bVR;
        bVar2.bQI = a;
        bVar2.bQJ = ke.bQJ;
        bVar2.bQF = me;
        bVar2.bQC = String.valueOf(com.baidu.swan.apps.console.a.Ti());
        bVar2.bQE = z;
        bVar2.bQG = cVar.QC();
        if (com.baidu.swan.apps.ah.a.a.aiL()) {
            bVar2.bQH = com.baidu.swan.apps.console.debugger.b.Tp();
        }
        if (com.baidu.swan.apps.ah.a.a.lA(bVar.adQ())) {
            com.baidu.swan.apps.console.debugger.a.d.Tz().hP("pageready");
        }
        if (DEBUG) {
            Log.d("FirstPageAction", bVar2.toString());
        }
        com.baidu.swan.apps.performance.f.aid().f(new UbcFlowEvent("slave_dispatch_start"));
        com.baidu.swan.apps.an.a.amP().mO("slave_dispatch_start");
        cVar.a(bVar2);
        y.apc();
        aeK.a(cVar.QG(), com.baidu.swan.apps.core.k.b.b(bVar2));
        com.baidu.swan.apps.statistic.c.bw(cVar.QG(), bVar2.bQI);
        if (DEBUG) {
            Log.d("FirstPageAction", "app path: " + aVar2.appPath);
            Log.d("FirstPageAction", "webviewId: " + cVar.QG());
            Log.d("FirstPageAction", "pageUrl: " + a);
            Log.d("FirstPageAction", "pagePath: " + bVar2.bQI);
            Log.d("FirstPageAction", "onReachBottomDistance: " + bVar2.bQJ);
            Log.d("FirstPageAction", "sConsole:" + bVar2.bQC);
        }
        if (aeK.Ou() != null) {
            com.baidu.swan.apps.model.b bg = com.baidu.swan.apps.model.b.bg(a, aeK.aes());
            com.baidu.swan.apps.core.slave.b.a(ai.J(bg.mBaseUrl, bg.mPage, bg.mParams), cVar);
            a(aev, a);
            com.baidu.swan.apps.ac.e.kO(cVar.QG());
            if (!TextUtils.isEmpty(me)) {
                com.baidu.swan.apps.performance.f.li(me);
            }
            com.baidu.swan.apps.statistic.f.i(true, bVar.adB());
            com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.view.c Oq = SwanAppActivity.this.Oq();
                    if (c.DEBUG) {
                        Log.i("FirstPageAction", "startFirstPage:: loadingView=" + Oq);
                    }
                    if (Oq != null) {
                        Oq.hr(1);
                    }
                }
            });
            com.baidu.swan.apps.runtime.d akK = com.baidu.swan.apps.runtime.d.akK();
            if (akK.ajr() && TextUtils.equals(akK.getAppId(), bVar.getAppId())) {
                akK.akH().eK(true);
            }
        }
    }

    public static void a(SwanAppActivity swanAppActivity, String str) {
        com.baidu.swan.apps.y.f aeK = com.baidu.swan.apps.y.f.aeK();
        if (swanAppActivity.Ou() != null) {
            swanAppActivity.Ou().io("init").ab(com.baidu.swan.apps.core.d.e.bMB, com.baidu.swan.apps.core.d.e.bMB).Wo().a("normal", com.baidu.swan.apps.model.b.bg(str, aeK.aes()), true).commit();
        }
    }

    private static String a(com.baidu.swan.apps.y.f fVar, com.baidu.swan.apps.x.b.b bVar, e.f fVar2) {
        String aet = fVar.aet();
        if (TextUtils.isEmpty(aet)) {
            if (bVar.adV()) {
                return fVar2.bVS.ml(bVar.adW());
            }
            return fVar.aeu();
        }
        return aet;
    }
}
