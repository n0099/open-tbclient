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
        if (com.baidu.swan.apps.ah.a.a.aiK()) {
            com.baidu.swan.apps.console.c.v("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.w.a.abN());
            com.baidu.swan.apps.performance.f.aic().f(new UbcFlowEvent("fist_page_action_reg_callback").ed(true));
            aVar2.a(new a.InterfaceC0289a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0289a
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
        com.baidu.swan.apps.performance.f.aic().f(new UbcFlowEvent("fist_page_action_dostart").ed(true));
        com.baidu.swan.apps.y.f aeJ = com.baidu.swan.apps.y.f.aeJ();
        String a = a(aeJ, bVar, fVar);
        String me = fVar.bVY.me(a);
        final SwanAppActivity aeu = aeJ.aeu();
        if (aeu == null || aeu.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        aVar.D(aeu);
        com.baidu.swan.apps.core.k.a aVar2 = new com.baidu.swan.apps.core.k.a();
        aVar2.appConfig = fVar.bVY.coQ;
        fVar.bVY.coQ = null;
        aVar2.appPath = fVar.bVX;
        aVar2.bQE = cVar.QF();
        aVar2.bQF = a;
        aVar2.bQH = String.valueOf(com.baidu.swan.apps.console.a.Th());
        aVar2.bQI = aVar2.b(com.baidu.swan.apps.runtime.e.akM(), a);
        aVar2.bQK = me;
        boolean z = DEBUG || com.baidu.swan.apps.y.f.aeJ().aeo();
        aVar2.bQJ = z;
        aVar2.bQL = cVar.QB();
        if (com.baidu.swan.apps.ah.a.a.aiK()) {
            aVar2.bQM = com.baidu.swan.apps.console.debugger.b.Tp();
        }
        Bundle adF = bVar.adF();
        if (adF != null) {
            String string = adF.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                aVar2.bQG = string;
            }
        }
        if (DEBUG) {
            Log.d("FirstPageAction", aVar2.toString());
        }
        com.baidu.swan.apps.performance.f.aic().f(new UbcFlowEvent("master_dispatch_start"));
        com.baidu.swan.apps.an.a.amO().mO("master_dispatch_start");
        aVar.a(aVar2);
        aeJ.a(com.baidu.swan.apps.core.k.a.a(aVar2, null));
        com.baidu.swan.apps.core.k.d.Yn().dy(aVar2.bQL);
        if (com.baidu.swan.apps.ah.a.a.lA(bVar.adP())) {
            com.baidu.swan.apps.console.debugger.a.d.TD();
            com.baidu.swan.apps.console.debugger.a.d.Ty().hP("appready");
        }
        com.baidu.swan.apps.runtime.config.c ke = aeJ.ke(ag.delAllParamsFromUrl(a));
        cVar.D(aeu);
        com.baidu.swan.apps.core.k.b bVar2 = new com.baidu.swan.apps.core.k.b();
        bVar2.appPath = fVar.bVX;
        bVar2.bQN = a;
        bVar2.bQO = ke.bQO;
        bVar2.bQK = me;
        bVar2.bQH = String.valueOf(com.baidu.swan.apps.console.a.Th());
        bVar2.bQJ = z;
        bVar2.bQL = cVar.QB();
        if (com.baidu.swan.apps.ah.a.a.aiK()) {
            bVar2.bQM = com.baidu.swan.apps.console.debugger.b.To();
        }
        if (com.baidu.swan.apps.ah.a.a.lA(bVar.adP())) {
            com.baidu.swan.apps.console.debugger.a.d.Ty().hP("pageready");
        }
        if (DEBUG) {
            Log.d("FirstPageAction", bVar2.toString());
        }
        com.baidu.swan.apps.performance.f.aic().f(new UbcFlowEvent("slave_dispatch_start"));
        com.baidu.swan.apps.an.a.amO().mO("slave_dispatch_start");
        cVar.a(bVar2);
        y.apb();
        aeJ.a(cVar.QF(), com.baidu.swan.apps.core.k.b.b(bVar2));
        com.baidu.swan.apps.statistic.c.bw(cVar.QF(), bVar2.bQN);
        if (DEBUG) {
            Log.d("FirstPageAction", "app path: " + aVar2.appPath);
            Log.d("FirstPageAction", "webviewId: " + cVar.QF());
            Log.d("FirstPageAction", "pageUrl: " + a);
            Log.d("FirstPageAction", "pagePath: " + bVar2.bQN);
            Log.d("FirstPageAction", "onReachBottomDistance: " + bVar2.bQO);
            Log.d("FirstPageAction", "sConsole:" + bVar2.bQH);
        }
        if (aeJ.Ot() != null) {
            com.baidu.swan.apps.model.b bg = com.baidu.swan.apps.model.b.bg(a, aeJ.aer());
            com.baidu.swan.apps.core.slave.b.a(ai.J(bg.mBaseUrl, bg.mPage, bg.mParams), cVar);
            a(aeu, a);
            com.baidu.swan.apps.ac.e.kO(cVar.QF());
            if (!TextUtils.isEmpty(me)) {
                com.baidu.swan.apps.performance.f.li(me);
            }
            com.baidu.swan.apps.statistic.f.i(true, bVar.adA());
            com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.view.c Op = SwanAppActivity.this.Op();
                    if (c.DEBUG) {
                        Log.i("FirstPageAction", "startFirstPage:: loadingView=" + Op);
                    }
                    if (Op != null) {
                        Op.hr(1);
                    }
                }
            });
            com.baidu.swan.apps.runtime.d akJ = com.baidu.swan.apps.runtime.d.akJ();
            if (akJ.ajq() && TextUtils.equals(akJ.getAppId(), bVar.getAppId())) {
                akJ.akG().eK(true);
            }
        }
    }

    public static void a(SwanAppActivity swanAppActivity, String str) {
        com.baidu.swan.apps.y.f aeJ = com.baidu.swan.apps.y.f.aeJ();
        if (swanAppActivity.Ot() != null) {
            swanAppActivity.Ot().io(com.baidu.sapi2.outsdk.c.l).ab(com.baidu.swan.apps.core.d.e.bMG, com.baidu.swan.apps.core.d.e.bMG).Wn().a("normal", com.baidu.swan.apps.model.b.bg(str, aeJ.aer()), true).commit();
        }
    }

    private static String a(com.baidu.swan.apps.y.f fVar, com.baidu.swan.apps.x.b.b bVar, e.f fVar2) {
        String aes = fVar.aes();
        if (TextUtils.isEmpty(aes)) {
            if (bVar.adU()) {
                return fVar2.bVY.ml(bVar.adV());
            }
            return fVar.aet();
        }
        return aes;
    }
}
