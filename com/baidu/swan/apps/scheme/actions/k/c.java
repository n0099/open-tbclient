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
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.x.b.b bVar, final e.f fVar) {
        if (com.baidu.swan.apps.ah.a.a.XQ()) {
            com.baidu.swan.apps.console.c.v("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.w.a.Rk());
            com.baidu.swan.apps.performance.f.Xi().f(new UbcFlowEvent("fist_page_action_reg_callback").cU(true));
            aVar2.a(new a.InterfaceC0226a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0226a
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
        com.baidu.swan.apps.performance.f.Xi().f(new UbcFlowEvent("fist_page_action_dostart").cU(true));
        com.baidu.swan.apps.y.f Uf = com.baidu.swan.apps.y.f.Uf();
        String a = a(Uf, bVar, fVar);
        String kA = fVar.bsB.kA(a);
        final SwanAppActivity TQ = Uf.TQ();
        if (TQ == null || TQ.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        aVar.F(TQ);
        com.baidu.swan.apps.core.k.a aVar2 = new com.baidu.swan.apps.core.k.a();
        aVar2.appConfig = fVar.bsB.bKW;
        fVar.bsB.bKW = null;
        aVar2.appPath = fVar.bsA;
        aVar2.bni = cVar.Ge();
        aVar2.bnj = a;
        aVar2.bnl = String.valueOf(com.baidu.swan.apps.console.a.IE());
        aVar2.bnm = aVar2.b(com.baidu.swan.apps.runtime.e.ZS(), a);
        aVar2.bno = kA;
        boolean z = DEBUG || com.baidu.swan.apps.y.f.Uf().TK();
        aVar2.bnn = z;
        aVar2.bnp = cVar.Ga();
        if (com.baidu.swan.apps.ah.a.a.XQ()) {
            aVar2.bnq = com.baidu.swan.apps.console.debugger.b.IM();
        }
        Bundle Tb = bVar.Tb();
        if (Tb != null) {
            String string = Tb.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                aVar2.bnk = string;
            }
        }
        if (DEBUG) {
            Log.d("FirstPageAction", aVar2.toString());
        }
        com.baidu.swan.apps.performance.f.Xi().f(new UbcFlowEvent("master_dispatch_start"));
        com.baidu.swan.apps.an.a.abU().lk("master_dispatch_start");
        aVar.a(aVar2);
        Uf.a(com.baidu.swan.apps.core.k.a.a(aVar2, null));
        com.baidu.swan.apps.core.k.d.NK().cp(aVar2.bnp);
        if (com.baidu.swan.apps.ah.a.a.jW(bVar.Tl())) {
            com.baidu.swan.apps.console.debugger.a.d.Ja();
            com.baidu.swan.apps.console.debugger.a.d.IV().gk("appready");
        }
        com.baidu.swan.apps.runtime.config.c iA = Uf.iA(ag.delAllParamsFromUrl(a));
        cVar.F(TQ);
        com.baidu.swan.apps.core.k.b bVar2 = new com.baidu.swan.apps.core.k.b();
        bVar2.appPath = fVar.bsA;
        bVar2.bnr = a;
        bVar2.bns = iA.bns;
        bVar2.bno = kA;
        bVar2.bnl = String.valueOf(com.baidu.swan.apps.console.a.IE());
        bVar2.bnn = z;
        bVar2.bnp = cVar.Ga();
        if (com.baidu.swan.apps.ah.a.a.XQ()) {
            bVar2.bnq = com.baidu.swan.apps.console.debugger.b.IL();
        }
        if (com.baidu.swan.apps.ah.a.a.jW(bVar.Tl())) {
            com.baidu.swan.apps.console.debugger.a.d.IV().gk("pageready");
        }
        if (DEBUG) {
            Log.d("FirstPageAction", bVar2.toString());
        }
        com.baidu.swan.apps.performance.f.Xi().f(new UbcFlowEvent("slave_dispatch_start"));
        com.baidu.swan.apps.an.a.abU().lk("slave_dispatch_start");
        cVar.a(bVar2);
        y.aej();
        Uf.a(cVar.Ge(), com.baidu.swan.apps.core.k.b.b(bVar2));
        com.baidu.swan.apps.statistic.c.bd(cVar.Ge(), bVar2.bnr);
        if (DEBUG) {
            Log.d("FirstPageAction", "app path: " + aVar2.appPath);
            Log.d("FirstPageAction", "webviewId: " + cVar.Ge());
            Log.d("FirstPageAction", "pageUrl: " + a);
            Log.d("FirstPageAction", "pagePath: " + bVar2.bnr);
            Log.d("FirstPageAction", "onReachBottomDistance: " + bVar2.bns);
            Log.d("FirstPageAction", "sConsole:" + bVar2.bnl);
        }
        if (Uf.DP() != null) {
            com.baidu.swan.apps.model.b aN = com.baidu.swan.apps.model.b.aN(a, Uf.TN());
            com.baidu.swan.apps.core.slave.b.a(ai.I(aN.mBaseUrl, aN.mPage, aN.mParams), cVar);
            a(TQ, a);
            com.baidu.swan.apps.ac.e.jk(cVar.Ge());
            if (!TextUtils.isEmpty(kA)) {
                com.baidu.swan.apps.performance.f.jE(kA);
            }
            com.baidu.swan.apps.statistic.f.g(true, bVar.SW());
            com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.view.c DL = SwanAppActivity.this.DL();
                    if (c.DEBUG) {
                        Log.i("FirstPageAction", "startFirstPage:: loadingView=" + DL);
                    }
                    if (DL != null) {
                        DL.gT(1);
                    }
                }
            });
            com.baidu.swan.apps.runtime.d ZP = com.baidu.swan.apps.runtime.d.ZP();
            if (ZP.Yw() && TextUtils.equals(ZP.getAppId(), bVar.getAppId())) {
                ZP.ZM().dB(true);
            }
        }
    }

    public static void a(SwanAppActivity swanAppActivity, String str) {
        com.baidu.swan.apps.y.f Uf = com.baidu.swan.apps.y.f.Uf();
        if (swanAppActivity.DP() != null) {
            swanAppActivity.DP().gJ("init").U(com.baidu.swan.apps.core.d.e.bjh, com.baidu.swan.apps.core.d.e.bjh).LL().a("normal", com.baidu.swan.apps.model.b.aN(str, Uf.TN()), true).commit();
        }
    }

    private static String a(com.baidu.swan.apps.y.f fVar, com.baidu.swan.apps.x.b.b bVar, e.f fVar2) {
        String TO = fVar.TO();
        if (TextUtils.isEmpty(TO)) {
            if (bVar.Tq()) {
                return fVar2.bsB.kH(bVar.Tr());
            }
            return fVar.TP();
        }
        return TO;
    }
}
