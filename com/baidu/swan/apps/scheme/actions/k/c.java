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
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String cTI;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (com.baidu.swan.apps.ad.a.a.axd() || com.baidu.swan.apps.console.v8inspector.a.getStatus() == 2) {
            com.baidu.swan.apps.console.c.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            final com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.aoJ());
            final com.baidu.swan.apps.res.widget.dialog.g azp = new g.a(com.baidu.swan.apps.runtime.d.azE().azC()).he(a.h.aiapps_debug_start_inspect).hd(a.h.aiapps_debug_inspect_waiting).a(new com.baidu.swan.apps.view.c.a()).fB(false).c(a.h.aiapps_debug_inspect_skip, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.apps.console.v8inspector.a.this.stop();
                    com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    c.b(aVar, cVar, bVar, fVar);
                }
            }).azp();
            com.baidu.swan.apps.performance.i.avS().f(new UbcFlowEvent("fist_page_action_reg_callback").fc(true));
            aVar2.a(new a.InterfaceC0375a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0375a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                    azp.dismiss();
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.avS().f(new UbcFlowEvent("fist_page_action_dostart").fc(true));
        com.baidu.swan.apps.v.f arY = com.baidu.swan.apps.v.f.arY();
        if (fVar.cuS == null) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String a = a(arY, bVar, fVar.cuS);
        String qn = fVar.cuS.qn(a);
        SwanAppActivity arI = arY.arI();
        if (arI == null || arI.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        com.baidu.swan.apps.core.h.b.ajg().a(aVar, cVar, bVar, fVar.cuS, fVar);
        aVar.attachActivity(arI);
        cVar.attachActivity(arI);
        com.baidu.swan.apps.core.d.f XX = arY.XX();
        if (XX != null) {
            com.baidu.swan.apps.model.b bP = com.baidu.swan.apps.model.b.bP(a, arY.arF());
            com.baidu.swan.apps.core.slave.b.a(ak.Q(bP.mBaseUrl, bP.mPage, bP.mParams), cVar);
            a(XX, a);
            com.baidu.swan.apps.statistic.h.aCF();
            com.baidu.swan.apps.y.e.oI(cVar.aaU());
            if (!TextUtils.isEmpty(qn)) {
                com.baidu.swan.apps.performance.i.pg(qn);
            }
            com.baidu.swan.apps.statistic.h.j(true, bVar.aqN());
            com.baidu.swan.apps.view.c XT = arI.XT();
            if (DEBUG) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + XT);
            }
            if (XT != null) {
                XT.ku(1);
            }
            com.baidu.swan.apps.runtime.d azE = com.baidu.swan.apps.runtime.d.azE();
            if (azE.axR() && TextUtils.equals(azE.getAppId(), bVar.getAppId())) {
                azE.azA().fL(true);
            }
            com.baidu.swan.apps.core.f.dM(false);
        }
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, String str) {
        if (fVar != null) {
            fVar.lo(OneKeyLoginSdkCall.l).al(com.baidu.swan.apps.core.d.f.cim, com.baidu.swan.apps.core.d.f.cim).ahv().a("normal", com.baidu.swan.apps.model.b.bP(str, com.baidu.swan.apps.v.f.arY().arF()), true).commit();
        }
    }

    public static String a(com.baidu.swan.apps.v.f fVar, com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        String arG = fVar.arG();
        if (TextUtils.isEmpty(arG)) {
            if (bVar.arh()) {
                arG = swanAppConfigData.qv(bVar.ari());
            } else {
                arG = fVar.arH();
            }
        }
        cTI = arG;
        return arG;
    }

    public static String aBb() {
        return cTI;
    }
}
