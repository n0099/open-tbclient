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
        if (com.baidu.swan.apps.ah.a.a.aaD()) {
            com.baidu.swan.apps.console.c.v("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.w.a.TW());
            com.baidu.swan.apps.performance.f.ZV().f(new UbcFlowEvent("fist_page_action_reg_callback").dg(true));
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
        com.baidu.swan.apps.performance.f.ZV().f(new UbcFlowEvent("fist_page_action_dostart").dg(true));
        com.baidu.swan.apps.y.f WS = com.baidu.swan.apps.y.f.WS();
        String a = a(WS, bVar, fVar);
        String kS = fVar.bxA.kS(a);
        final SwanAppActivity WD = WS.WD();
        if (WD == null || WD.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        aVar.H(WD);
        com.baidu.swan.apps.core.k.a aVar2 = new com.baidu.swan.apps.core.k.a();
        aVar2.appConfig = fVar.bxA.bPM;
        fVar.bxA.bPM = null;
        aVar2.appPath = fVar.bxz;
        aVar2.bsg = cVar.IR();
        aVar2.bsh = a;
        aVar2.bsj = String.valueOf(com.baidu.swan.apps.console.a.Lr());
        aVar2.bsk = aVar2.b(com.baidu.swan.apps.runtime.e.acF(), a);
        aVar2.bsm = kS;
        boolean z = DEBUG || com.baidu.swan.apps.y.f.WS().Wx();
        aVar2.bsl = z;
        aVar2.bsn = cVar.IN();
        if (com.baidu.swan.apps.ah.a.a.aaD()) {
            aVar2.bso = com.baidu.swan.apps.console.debugger.b.Lz();
        }
        Bundle VO = bVar.VO();
        if (VO != null) {
            String string = VO.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                aVar2.bsi = string;
            }
        }
        if (DEBUG) {
            Log.d("FirstPageAction", aVar2.toString());
        }
        com.baidu.swan.apps.performance.f.ZV().f(new UbcFlowEvent("master_dispatch_start"));
        com.baidu.swan.apps.an.a.aeH().lC("master_dispatch_start");
        aVar.a(aVar2);
        WS.a(com.baidu.swan.apps.core.k.a.a(aVar2, null));
        com.baidu.swan.apps.core.k.d.Qw().cB(aVar2.bsn);
        if (com.baidu.swan.apps.ah.a.a.ko(bVar.VY())) {
            com.baidu.swan.apps.console.debugger.a.d.LN();
            com.baidu.swan.apps.console.debugger.a.d.LI().gD("appready");
        }
        com.baidu.swan.apps.runtime.config.c iS = WS.iS(ag.delAllParamsFromUrl(a));
        cVar.H(WD);
        com.baidu.swan.apps.core.k.b bVar2 = new com.baidu.swan.apps.core.k.b();
        bVar2.appPath = fVar.bxz;
        bVar2.bsp = a;
        bVar2.bsq = iS.bsq;
        bVar2.bsm = kS;
        bVar2.bsj = String.valueOf(com.baidu.swan.apps.console.a.Lr());
        bVar2.bsl = z;
        bVar2.bsn = cVar.IN();
        if (com.baidu.swan.apps.ah.a.a.aaD()) {
            bVar2.bso = com.baidu.swan.apps.console.debugger.b.Ly();
        }
        if (com.baidu.swan.apps.ah.a.a.ko(bVar.VY())) {
            com.baidu.swan.apps.console.debugger.a.d.LI().gD("pageready");
        }
        if (DEBUG) {
            Log.d("FirstPageAction", bVar2.toString());
        }
        com.baidu.swan.apps.performance.f.ZV().f(new UbcFlowEvent("slave_dispatch_start"));
        com.baidu.swan.apps.an.a.aeH().lC("slave_dispatch_start");
        cVar.a(bVar2);
        y.agS();
        WS.a(cVar.IR(), com.baidu.swan.apps.core.k.b.b(bVar2));
        com.baidu.swan.apps.statistic.c.bn(cVar.IR(), bVar2.bsp);
        if (DEBUG) {
            Log.d("FirstPageAction", "app path: " + aVar2.appPath);
            Log.d("FirstPageAction", "webviewId: " + cVar.IR());
            Log.d("FirstPageAction", "pageUrl: " + a);
            Log.d("FirstPageAction", "pagePath: " + bVar2.bsp);
            Log.d("FirstPageAction", "onReachBottomDistance: " + bVar2.bsq);
            Log.d("FirstPageAction", "sConsole:" + bVar2.bsj);
        }
        if (WS.GC() != null) {
            com.baidu.swan.apps.model.b aX = com.baidu.swan.apps.model.b.aX(a, WS.WA());
            com.baidu.swan.apps.core.slave.b.a(ai.J(aX.mBaseUrl, aX.mPage, aX.mParams), cVar);
            a(WD, a);
            com.baidu.swan.apps.ac.e.jC(cVar.IR());
            if (!TextUtils.isEmpty(kS)) {
                com.baidu.swan.apps.performance.f.jW(kS);
            }
            com.baidu.swan.apps.statistic.f.h(true, bVar.VJ());
            com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.view.c Gy = SwanAppActivity.this.Gy();
                    if (c.DEBUG) {
                        Log.i("FirstPageAction", "startFirstPage:: loadingView=" + Gy);
                    }
                    if (Gy != null) {
                        Gy.hk(1);
                    }
                }
            });
            com.baidu.swan.apps.runtime.d acC = com.baidu.swan.apps.runtime.d.acC();
            if (acC.abj() && TextUtils.equals(acC.getAppId(), bVar.getAppId())) {
                acC.acz().dN(true);
            }
        }
    }

    public static void a(SwanAppActivity swanAppActivity, String str) {
        com.baidu.swan.apps.y.f WS = com.baidu.swan.apps.y.f.WS();
        if (swanAppActivity.GC() != null) {
            swanAppActivity.GC().hb("init").Y(com.baidu.swan.apps.core.d.e.boh, com.baidu.swan.apps.core.d.e.boh).Ox().a("normal", com.baidu.swan.apps.model.b.aX(str, WS.WA()), true).commit();
        }
    }

    private static String a(com.baidu.swan.apps.y.f fVar, com.baidu.swan.apps.x.b.b bVar, e.f fVar2) {
        String WB = fVar.WB();
        if (TextUtils.isEmpty(WB)) {
            if (bVar.Wd()) {
                return fVar2.bxA.kZ(bVar.We());
            }
            return fVar.WC();
        }
        return WB;
    }
}
