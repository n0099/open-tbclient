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
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.x.b.b bVar, final e.f fVar) {
        if (com.baidu.swan.apps.ah.a.a.Yn()) {
            com.baidu.swan.apps.console.c.v("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.w.a.RG());
            com.baidu.swan.apps.performance.f.XF().f(new UbcFlowEvent("fist_page_action_reg_callback").cZ(true));
            aVar2.a(new a.InterfaceC0228a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0228a
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
        com.baidu.swan.apps.performance.f.XF().f(new UbcFlowEvent("fist_page_action_dostart").cZ(true));
        com.baidu.swan.apps.y.f UC = com.baidu.swan.apps.y.f.UC();
        String a = a(UC, bVar, fVar);
        String kD = fVar.btp.kD(a);
        final SwanAppActivity Un = UC.Un();
        if (Un == null || Un.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        aVar.G(Un);
        com.baidu.swan.apps.core.k.a aVar2 = new com.baidu.swan.apps.core.k.a();
        aVar2.appConfig = fVar.btp.bLG;
        fVar.btp.bLG = null;
        aVar2.appPath = fVar.bto;
        aVar2.bnW = cVar.GA();
        aVar2.bnX = a;
        aVar2.bnZ = String.valueOf(com.baidu.swan.apps.console.a.Ja());
        aVar2.boa = aVar2.b(com.baidu.swan.apps.runtime.e.aap(), a);
        aVar2.boc = kD;
        boolean z = DEBUG || com.baidu.swan.apps.y.f.UC().Uh();
        aVar2.bob = z;
        aVar2.bod = cVar.Gw();
        if (com.baidu.swan.apps.ah.a.a.Yn()) {
            aVar2.boe = com.baidu.swan.apps.console.debugger.b.Ji();
        }
        Bundle Ty = bVar.Ty();
        if (Ty != null) {
            String string = Ty.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                aVar2.bnY = string;
            }
        }
        if (DEBUG) {
            Log.d("FirstPageAction", aVar2.toString());
        }
        com.baidu.swan.apps.performance.f.XF().f(new UbcFlowEvent("master_dispatch_start"));
        com.baidu.swan.apps.an.a.acr().ln("master_dispatch_start");
        aVar.a(aVar2);
        UC.a(com.baidu.swan.apps.core.k.a.a(aVar2, null));
        com.baidu.swan.apps.core.k.d.Og().cu(aVar2.bod);
        if (com.baidu.swan.apps.ah.a.a.jZ(bVar.TI())) {
            com.baidu.swan.apps.console.debugger.a.d.Jw();
            com.baidu.swan.apps.console.debugger.a.d.Jr().gn("appready");
        }
        com.baidu.swan.apps.runtime.config.c iD = UC.iD(ag.delAllParamsFromUrl(a));
        cVar.G(Un);
        com.baidu.swan.apps.core.k.b bVar2 = new com.baidu.swan.apps.core.k.b();
        bVar2.appPath = fVar.bto;
        bVar2.bof = a;
        bVar2.bog = iD.bog;
        bVar2.boc = kD;
        bVar2.bnZ = String.valueOf(com.baidu.swan.apps.console.a.Ja());
        bVar2.bob = z;
        bVar2.bod = cVar.Gw();
        if (com.baidu.swan.apps.ah.a.a.Yn()) {
            bVar2.boe = com.baidu.swan.apps.console.debugger.b.Jh();
        }
        if (com.baidu.swan.apps.ah.a.a.jZ(bVar.TI())) {
            com.baidu.swan.apps.console.debugger.a.d.Jr().gn("pageready");
        }
        if (DEBUG) {
            Log.d("FirstPageAction", bVar2.toString());
        }
        com.baidu.swan.apps.performance.f.XF().f(new UbcFlowEvent("slave_dispatch_start"));
        com.baidu.swan.apps.an.a.acr().ln("slave_dispatch_start");
        cVar.a(bVar2);
        y.aeC();
        UC.a(cVar.GA(), com.baidu.swan.apps.core.k.b.b(bVar2));
        com.baidu.swan.apps.statistic.c.be(cVar.GA(), bVar2.bof);
        if (DEBUG) {
            Log.d("FirstPageAction", "app path: " + aVar2.appPath);
            Log.d("FirstPageAction", "webviewId: " + cVar.GA());
            Log.d("FirstPageAction", "pageUrl: " + a);
            Log.d("FirstPageAction", "pagePath: " + bVar2.bof);
            Log.d("FirstPageAction", "onReachBottomDistance: " + bVar2.bog);
            Log.d("FirstPageAction", "sConsole:" + bVar2.bnZ);
        }
        if (UC.El() != null) {
            com.baidu.swan.apps.model.b aO = com.baidu.swan.apps.model.b.aO(a, UC.Uk());
            com.baidu.swan.apps.core.slave.b.a(ai.I(aO.mBaseUrl, aO.mPage, aO.mParams), cVar);
            a(Un, a);
            com.baidu.swan.apps.ac.e.jn(cVar.GA());
            if (!TextUtils.isEmpty(kD)) {
                com.baidu.swan.apps.performance.f.jH(kD);
            }
            com.baidu.swan.apps.statistic.f.g(true, bVar.Tt());
            com.baidu.swan.apps.runtime.d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.view.c Eh = SwanAppActivity.this.Eh();
                    if (c.DEBUG) {
                        Log.i("FirstPageAction", "startFirstPage:: loadingView=" + Eh);
                    }
                    if (Eh != null) {
                        Eh.gT(1);
                    }
                }
            });
            com.baidu.swan.apps.runtime.d aam = com.baidu.swan.apps.runtime.d.aam();
            if (aam.YT() && TextUtils.equals(aam.getAppId(), bVar.getAppId())) {
                aam.aaj().dG(true);
            }
        }
    }

    public static void a(SwanAppActivity swanAppActivity, String str) {
        com.baidu.swan.apps.y.f UC = com.baidu.swan.apps.y.f.UC();
        if (swanAppActivity.El() != null) {
            swanAppActivity.El().gM("init").Y(com.baidu.swan.apps.core.d.e.bjW, com.baidu.swan.apps.core.d.e.bjW).Mh().a("normal", com.baidu.swan.apps.model.b.aO(str, UC.Uk()), true).commit();
        }
    }

    private static String a(com.baidu.swan.apps.y.f fVar, com.baidu.swan.apps.x.b.b bVar, e.f fVar2) {
        String Ul = fVar.Ul();
        if (TextUtils.isEmpty(Ul)) {
            if (bVar.TN()) {
                return fVar2.btp.kK(bVar.TO());
            }
            return fVar.Um();
        }
        return Ul;
    }
}
