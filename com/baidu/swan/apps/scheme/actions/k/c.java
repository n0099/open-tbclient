package com.baidu.swan.apps.scheme.actions.k;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.console.v8inspector.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String dHB;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (com.baidu.swan.apps.ad.a.a.aFm() || com.baidu.swan.apps.console.v8inspector.a.getStatus() == 2) {
            com.baidu.swan.apps.console.c.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            final com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.awW());
            final com.baidu.swan.apps.res.widget.dialog.g aHX = new g.a(com.baidu.swan.apps.runtime.d.aIG().aIE()).gR(a.h.aiapps_debug_start_inspect).gQ(a.h.aiapps_debug_inspect_waiting).a(new com.baidu.swan.apps.view.c.a()).gT(false).c(a.h.aiapps_debug_inspect_skip, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.apps.console.v8inspector.a.this.stop();
                    com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    c.b(aVar, cVar, bVar, fVar);
                }
            }).aHX();
            com.baidu.swan.apps.performance.i.aEb().f(new UbcFlowEvent("fist_page_action_reg_callback").gr(true));
            aVar2.a(new a.InterfaceC0395a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0395a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                    aHX.dismiss();
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aEb().f(new UbcFlowEvent("fist_page_action_dostart").gr(true));
        com.baidu.swan.apps.v.f aAl = com.baidu.swan.apps.v.f.aAl();
        if (fVar.deS == null) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String a2 = a(aAl, bVar, fVar.deS);
        String rF = fVar.deS.rF(a2);
        SwanAppActivity azV = aAl.azV();
        if (azV == null || azV.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        com.baidu.swan.apps.core.h.b.arr().a(aVar, cVar, bVar, fVar.deS, fVar);
        aVar.attachActivity(azV);
        cVar.attachActivity(azV);
        com.baidu.swan.apps.core.d.f afX = aAl.afX();
        if (afX != null) {
            com.baidu.swan.apps.model.b bZ = com.baidu.swan.apps.model.b.bZ(a2, aAl.azS());
            com.baidu.swan.apps.core.slave.b.a(ak.ae(bZ.mBaseUrl, bZ.mPage, bZ.mParams), cVar);
            a(afX, a2);
            com.baidu.swan.apps.statistic.h.aLH();
            com.baidu.swan.apps.y.e.pW(cVar.aiY());
            if (!TextUtils.isEmpty(rF)) {
                com.baidu.swan.apps.performance.i.qt(rF);
            }
            com.baidu.swan.apps.statistic.h.p(true, bVar.aza());
            com.baidu.swan.apps.view.c afT = azV.afT();
            if (DEBUG) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + afT);
            }
            if (afT != null) {
                afT.kv(1);
            }
            com.baidu.swan.apps.runtime.d aIG = com.baidu.swan.apps.runtime.d.aIG();
            if (aIG.aFY() && TextUtils.equals(aIG.getAppId(), bVar.getAppId())) {
                aIG.aIC().hj(true);
            }
            com.baidu.swan.apps.core.f.fb(false);
        }
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, String str) {
        if (fVar != null) {
            fVar.mC(OneKeyLoginSdkCall.l).af(com.baidu.swan.apps.core.d.f.cSB, com.baidu.swan.apps.core.d.f.cSB).apG().a("normal", com.baidu.swan.apps.model.b.bZ(str, com.baidu.swan.apps.v.f.aAl().azS()), true).commit();
        }
    }

    public static String a(com.baidu.swan.apps.v.f fVar, com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        String azT = fVar.azT();
        if (TextUtils.isEmpty(azT)) {
            if (bVar.azu()) {
                azT = swanAppConfigData.rO(bVar.azv());
            } else {
                azT = fVar.azU();
            }
        }
        dHB = azT;
        return azT;
    }

    public static String aKd() {
        return dHB;
    }
}
