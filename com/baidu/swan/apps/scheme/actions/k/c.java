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
        if (com.baidu.swan.apps.ah.a.a.aaB()) {
            com.baidu.swan.apps.console.c.v("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.w.a.TU());
            com.baidu.swan.apps.performance.f.ZT().f(new UbcFlowEvent("fist_page_action_reg_callback").dg(true));
            aVar2.a(new a.InterfaceC0238a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0238a
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
        com.baidu.swan.apps.performance.f.ZT().f(new UbcFlowEvent("fist_page_action_dostart").dg(true));
        com.baidu.swan.apps.y.f WQ = com.baidu.swan.apps.y.f.WQ();
        String a = a(WQ, bVar, fVar);
        String kS = fVar.bxz.kS(a);
        final SwanAppActivity WB = WQ.WB();
        if (WB == null || WB.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        aVar.H(WB);
        com.baidu.swan.apps.core.k.a aVar2 = new com.baidu.swan.apps.core.k.a();
        aVar2.appConfig = fVar.bxz.bPL;
        fVar.bxz.bPL = null;
        aVar2.appPath = fVar.bxy;
        aVar2.bsf = cVar.IP();
        aVar2.bsg = a;
        aVar2.bsi = String.valueOf(com.baidu.swan.apps.console.a.Lp());
        aVar2.bsj = aVar2.b(com.baidu.swan.apps.runtime.e.acD(), a);
        aVar2.bsl = kS;
        boolean z = DEBUG || com.baidu.swan.apps.y.f.WQ().Wv();
        aVar2.bsk = z;
        aVar2.bsm = cVar.IL();
        if (com.baidu.swan.apps.ah.a.a.aaB()) {
            aVar2.bsn = com.baidu.swan.apps.console.debugger.b.Lx();
        }
        Bundle VM = bVar.VM();
        if (VM != null) {
            String string = VM.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                aVar2.bsh = string;
            }
        }
        if (DEBUG) {
            Log.d("FirstPageAction", aVar2.toString());
        }
        com.baidu.swan.apps.performance.f.ZT().f(new UbcFlowEvent("master_dispatch_start"));
        com.baidu.swan.apps.an.a.aeF().lC("master_dispatch_start");
        aVar.a(aVar2);
        WQ.a(com.baidu.swan.apps.core.k.a.a(aVar2, null));
        com.baidu.swan.apps.core.k.d.Qu().cB(aVar2.bsm);
        if (com.baidu.swan.apps.ah.a.a.ko(bVar.VW())) {
            com.baidu.swan.apps.console.debugger.a.d.LL();
            com.baidu.swan.apps.console.debugger.a.d.LG().gD("appready");
        }
        com.baidu.swan.apps.runtime.config.c iS = WQ.iS(ag.delAllParamsFromUrl(a));
        cVar.H(WB);
        com.baidu.swan.apps.core.k.b bVar2 = new com.baidu.swan.apps.core.k.b();
        bVar2.appPath = fVar.bxy;
        bVar2.bso = a;
        bVar2.bsp = iS.bsp;
        bVar2.bsl = kS;
        bVar2.bsi = String.valueOf(com.baidu.swan.apps.console.a.Lp());
        bVar2.bsk = z;
        bVar2.bsm = cVar.IL();
        if (com.baidu.swan.apps.ah.a.a.aaB()) {
            bVar2.bsn = com.baidu.swan.apps.console.debugger.b.Lw();
        }
        if (com.baidu.swan.apps.ah.a.a.ko(bVar.VW())) {
            com.baidu.swan.apps.console.debugger.a.d.LG().gD("pageready");
        }
        if (DEBUG) {
            Log.d("FirstPageAction", bVar2.toString());
        }
        com.baidu.swan.apps.performance.f.ZT().f(new UbcFlowEvent("slave_dispatch_start"));
        com.baidu.swan.apps.an.a.aeF().lC("slave_dispatch_start");
        cVar.a(bVar2);
        y.agQ();
        WQ.a(cVar.IP(), com.baidu.swan.apps.core.k.b.b(bVar2));
        com.baidu.swan.apps.statistic.c.bn(cVar.IP(), bVar2.bso);
        if (DEBUG) {
            Log.d("FirstPageAction", "app path: " + aVar2.appPath);
            Log.d("FirstPageAction", "webviewId: " + cVar.IP());
            Log.d("FirstPageAction", "pageUrl: " + a);
            Log.d("FirstPageAction", "pagePath: " + bVar2.bso);
            Log.d("FirstPageAction", "onReachBottomDistance: " + bVar2.bsp);
            Log.d("FirstPageAction", "sConsole:" + bVar2.bsi);
        }
        if (WQ.GA() != null) {
            com.baidu.swan.apps.model.b aX = com.baidu.swan.apps.model.b.aX(a, WQ.Wy());
            com.baidu.swan.apps.core.slave.b.a(ai.J(aX.mBaseUrl, aX.mPage, aX.mParams), cVar);
            a(WB, a);
            com.baidu.swan.apps.ac.e.jC(cVar.IP());
            if (!TextUtils.isEmpty(kS)) {
                com.baidu.swan.apps.performance.f.jW(kS);
            }
            com.baidu.swan.apps.statistic.f.h(true, bVar.VH());
            com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.view.c Gw = SwanAppActivity.this.Gw();
                    if (c.DEBUG) {
                        Log.i("FirstPageAction", "startFirstPage:: loadingView=" + Gw);
                    }
                    if (Gw != null) {
                        Gw.hk(1);
                    }
                }
            });
            com.baidu.swan.apps.runtime.d acA = com.baidu.swan.apps.runtime.d.acA();
            if (acA.abh() && TextUtils.equals(acA.getAppId(), bVar.getAppId())) {
                acA.acx().dN(true);
            }
        }
    }

    public static void a(SwanAppActivity swanAppActivity, String str) {
        com.baidu.swan.apps.y.f WQ = com.baidu.swan.apps.y.f.WQ();
        if (swanAppActivity.GA() != null) {
            swanAppActivity.GA().hb("init").Y(com.baidu.swan.apps.core.d.e.bog, com.baidu.swan.apps.core.d.e.bog).Ov().a("normal", com.baidu.swan.apps.model.b.aX(str, WQ.Wy()), true).commit();
        }
    }

    private static String a(com.baidu.swan.apps.y.f fVar, com.baidu.swan.apps.x.b.b bVar, e.f fVar2) {
        String Wz = fVar.Wz();
        if (TextUtils.isEmpty(Wz)) {
            if (bVar.Wb()) {
                return fVar2.bxz.kZ(bVar.Wc());
            }
            return fVar.WA();
        }
        return Wz;
    }
}
