package com.baidu.swan.apps.scheme.actions.k;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.console.v8inspector.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
/* loaded from: classes25.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String dBE;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (com.baidu.swan.apps.ad.a.a.aHr() || com.baidu.swan.apps.console.v8inspector.a.getStatus() == 2) {
            com.baidu.swan.apps.console.c.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            final com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.aza());
            final com.baidu.swan.apps.res.widget.dialog.g aJB = new g.a(com.baidu.swan.apps.runtime.d.aJQ().aJO()).iz(a.h.aiapps_debug_start_inspect).iy(a.h.aiapps_debug_inspect_waiting).a(new com.baidu.swan.apps.view.c.a()).gJ(false).c(a.h.aiapps_debug_inspect_skip, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.apps.console.v8inspector.a.this.stop();
                    com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    c.b(aVar, cVar, bVar, fVar);
                }
            }).aJB();
            com.baidu.swan.apps.performance.i.aGg().f(new UbcFlowEvent("fist_page_action_reg_callback").gk(true));
            aVar2.a(new a.InterfaceC0423a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0423a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                    aJB.dismiss();
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aGg().f(new UbcFlowEvent("fist_page_action_dostart").gk(true));
        com.baidu.swan.apps.v.f aCp = com.baidu.swan.apps.v.f.aCp();
        if (fVar.dcA == null) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String a2 = a(aCp, bVar, fVar.dcA);
        String sB = fVar.dcA.sB(a2);
        SwanAppActivity aBZ = aCp.aBZ();
        if (aBZ == null || aBZ.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        com.baidu.swan.apps.core.h.b.atw().a(aVar, cVar, bVar, fVar.dcA, fVar);
        aVar.attachActivity(aBZ);
        cVar.attachActivity(aBZ);
        com.baidu.swan.apps.core.d.f aim = aCp.aim();
        if (aim != null) {
            com.baidu.swan.apps.model.b ch = com.baidu.swan.apps.model.b.ch(a2, aCp.aBW());
            com.baidu.swan.apps.core.slave.b.a(ak.ab(ch.mBaseUrl, ch.mPage, ch.mParams), cVar);
            a(aim, a2);
            com.baidu.swan.apps.statistic.h.aMR();
            com.baidu.swan.apps.y.e.qV(cVar.alj());
            if (!TextUtils.isEmpty(sB)) {
                com.baidu.swan.apps.performance.i.rt(sB);
            }
            com.baidu.swan.apps.statistic.h.l(true, bVar.aBe());
            com.baidu.swan.apps.view.c aii = aBZ.aii();
            if (DEBUG) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + aii);
            }
            if (aii != null) {
                aii.lR(1);
            }
            com.baidu.swan.apps.runtime.d aJQ = com.baidu.swan.apps.runtime.d.aJQ();
            if (aJQ.aId() && TextUtils.equals(aJQ.getAppId(), bVar.getAppId())) {
                aJQ.aJM().gT(true);
            }
            com.baidu.swan.apps.core.f.eU(false);
        }
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, String str) {
        if (fVar != null) {
            fVar.nC(OneKeyLoginSdkCall.l).an(com.baidu.swan.apps.core.d.f.cQd, com.baidu.swan.apps.core.d.f.cQd).arK().a("normal", com.baidu.swan.apps.model.b.ch(str, com.baidu.swan.apps.v.f.aCp().aBW()), true).commit();
        }
    }

    public static String a(com.baidu.swan.apps.v.f fVar, com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        String aBX = fVar.aBX();
        if (TextUtils.isEmpty(aBX)) {
            if (bVar.aBy()) {
                aBX = swanAppConfigData.sK(bVar.aBz());
            } else {
                aBX = fVar.aBY();
            }
        }
        dBE = aBX;
        return aBX;
    }

    public static String aLn() {
        return dBE;
    }
}
