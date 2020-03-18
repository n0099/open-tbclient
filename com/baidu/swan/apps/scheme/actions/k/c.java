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
        if (com.baidu.swan.apps.ah.a.a.aaG()) {
            com.baidu.swan.apps.console.c.v("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.w.a.TZ());
            com.baidu.swan.apps.performance.f.ZY().f(new UbcFlowEvent("fist_page_action_reg_callback").dh(true));
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
        com.baidu.swan.apps.performance.f.ZY().f(new UbcFlowEvent("fist_page_action_dostart").dh(true));
        com.baidu.swan.apps.y.f WV = com.baidu.swan.apps.y.f.WV();
        String a = a(WV, bVar, fVar);
        String kR = fVar.bxM.kR(a);
        final SwanAppActivity WG = WV.WG();
        if (WG == null || WG.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        aVar.H(WG);
        com.baidu.swan.apps.core.k.a aVar2 = new com.baidu.swan.apps.core.k.a();
        aVar2.appConfig = fVar.bxM.bPY;
        fVar.bxM.bPY = null;
        aVar2.appPath = fVar.bxL;
        aVar2.bst = cVar.IU();
        aVar2.bsu = a;
        aVar2.bsw = String.valueOf(com.baidu.swan.apps.console.a.Lu());
        aVar2.bsx = aVar2.b(com.baidu.swan.apps.runtime.e.acI(), a);
        aVar2.bsz = kR;
        boolean z = DEBUG || com.baidu.swan.apps.y.f.WV().WA();
        aVar2.bsy = z;
        aVar2.bsA = cVar.IQ();
        if (com.baidu.swan.apps.ah.a.a.aaG()) {
            aVar2.bsB = com.baidu.swan.apps.console.debugger.b.LC();
        }
        Bundle VR = bVar.VR();
        if (VR != null) {
            String string = VR.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                aVar2.bsv = string;
            }
        }
        if (DEBUG) {
            Log.d("FirstPageAction", aVar2.toString());
        }
        com.baidu.swan.apps.performance.f.ZY().f(new UbcFlowEvent("master_dispatch_start"));
        com.baidu.swan.apps.an.a.aeK().lB("master_dispatch_start");
        aVar.a(aVar2);
        WV.a(com.baidu.swan.apps.core.k.a.a(aVar2, null));
        com.baidu.swan.apps.core.k.d.Qz().cC(aVar2.bsA);
        if (com.baidu.swan.apps.ah.a.a.kn(bVar.Wb())) {
            com.baidu.swan.apps.console.debugger.a.d.LQ();
            com.baidu.swan.apps.console.debugger.a.d.LL().gC("appready");
        }
        com.baidu.swan.apps.runtime.config.c iR = WV.iR(ag.delAllParamsFromUrl(a));
        cVar.H(WG);
        com.baidu.swan.apps.core.k.b bVar2 = new com.baidu.swan.apps.core.k.b();
        bVar2.appPath = fVar.bxL;
        bVar2.bsC = a;
        bVar2.bsD = iR.bsD;
        bVar2.bsz = kR;
        bVar2.bsw = String.valueOf(com.baidu.swan.apps.console.a.Lu());
        bVar2.bsy = z;
        bVar2.bsA = cVar.IQ();
        if (com.baidu.swan.apps.ah.a.a.aaG()) {
            bVar2.bsB = com.baidu.swan.apps.console.debugger.b.LB();
        }
        if (com.baidu.swan.apps.ah.a.a.kn(bVar.Wb())) {
            com.baidu.swan.apps.console.debugger.a.d.LL().gC("pageready");
        }
        if (DEBUG) {
            Log.d("FirstPageAction", bVar2.toString());
        }
        com.baidu.swan.apps.performance.f.ZY().f(new UbcFlowEvent("slave_dispatch_start"));
        com.baidu.swan.apps.an.a.aeK().lB("slave_dispatch_start");
        cVar.a(bVar2);
        y.agV();
        WV.a(cVar.IU(), com.baidu.swan.apps.core.k.b.b(bVar2));
        com.baidu.swan.apps.statistic.c.bm(cVar.IU(), bVar2.bsC);
        if (DEBUG) {
            Log.d("FirstPageAction", "app path: " + aVar2.appPath);
            Log.d("FirstPageAction", "webviewId: " + cVar.IU());
            Log.d("FirstPageAction", "pageUrl: " + a);
            Log.d("FirstPageAction", "pagePath: " + bVar2.bsC);
            Log.d("FirstPageAction", "onReachBottomDistance: " + bVar2.bsD);
            Log.d("FirstPageAction", "sConsole:" + bVar2.bsw);
        }
        if (WV.GH() != null) {
            com.baidu.swan.apps.model.b aW = com.baidu.swan.apps.model.b.aW(a, WV.WD());
            com.baidu.swan.apps.core.slave.b.a(ai.J(aW.mBaseUrl, aW.mPage, aW.mParams), cVar);
            a(WG, a);
            com.baidu.swan.apps.ac.e.jB(cVar.IU());
            if (!TextUtils.isEmpty(kR)) {
                com.baidu.swan.apps.performance.f.jV(kR);
            }
            com.baidu.swan.apps.statistic.f.h(true, bVar.VM());
            com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.view.c GD = SwanAppActivity.this.GD();
                    if (c.DEBUG) {
                        Log.i("FirstPageAction", "startFirstPage:: loadingView=" + GD);
                    }
                    if (GD != null) {
                        GD.hk(1);
                    }
                }
            });
            com.baidu.swan.apps.runtime.d acF = com.baidu.swan.apps.runtime.d.acF();
            if (acF.abm() && TextUtils.equals(acF.getAppId(), bVar.getAppId())) {
                acF.acC().dO(true);
            }
        }
    }

    public static void a(SwanAppActivity swanAppActivity, String str) {
        com.baidu.swan.apps.y.f WV = com.baidu.swan.apps.y.f.WV();
        if (swanAppActivity.GH() != null) {
            swanAppActivity.GH().ha("init").Y(com.baidu.swan.apps.core.d.e.bou, com.baidu.swan.apps.core.d.e.bou).OA().a("normal", com.baidu.swan.apps.model.b.aW(str, WV.WD()), true).commit();
        }
    }

    private static String a(com.baidu.swan.apps.y.f fVar, com.baidu.swan.apps.x.b.b bVar, e.f fVar2) {
        String WE = fVar.WE();
        if (TextUtils.isEmpty(WE)) {
            if (bVar.Wg()) {
                return fVar2.bxM.kY(bVar.Wh());
            }
            return fVar.WF();
        }
        return WE;
    }
}
