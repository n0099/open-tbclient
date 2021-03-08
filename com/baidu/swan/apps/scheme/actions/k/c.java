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
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String dJc;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (com.baidu.swan.apps.ad.a.a.aFp() || com.baidu.swan.apps.console.v8inspector.a.getStatus() == 2) {
            com.baidu.swan.apps.console.c.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            final com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.awZ());
            final com.baidu.swan.apps.res.widget.dialog.g aIa = new g.a(com.baidu.swan.apps.runtime.d.aIJ().aIH()).gS(a.h.aiapps_debug_start_inspect).gR(a.h.aiapps_debug_inspect_waiting).a(new com.baidu.swan.apps.view.c.a()).gT(false).c(a.h.aiapps_debug_inspect_skip, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.apps.console.v8inspector.a.this.stop();
                    com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    c.b(aVar, cVar, bVar, fVar);
                }
            }).aIa();
            com.baidu.swan.apps.performance.i.aEe().f(new UbcFlowEvent("fist_page_action_reg_callback").gr(true));
            aVar2.a(new a.InterfaceC0401a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0401a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                    aIa.dismiss();
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aEe().f(new UbcFlowEvent("fist_page_action_dostart").gr(true));
        com.baidu.swan.apps.v.f aAo = com.baidu.swan.apps.v.f.aAo();
        if (fVar.dgt == null) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String a2 = a(aAo, bVar, fVar.dgt);
        String rM = fVar.dgt.rM(a2);
        SwanAppActivity azY = aAo.azY();
        if (azY == null || azY.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        com.baidu.swan.apps.core.h.b.aru().a(aVar, cVar, bVar, fVar.dgt, fVar);
        aVar.attachActivity(azY);
        cVar.attachActivity(azY);
        com.baidu.swan.apps.core.d.f aga = aAo.aga();
        if (aga != null) {
            com.baidu.swan.apps.model.b bZ = com.baidu.swan.apps.model.b.bZ(a2, aAo.azV());
            com.baidu.swan.apps.core.slave.b.a(ak.ae(bZ.mBaseUrl, bZ.mPage, bZ.mParams), cVar);
            a(aga, a2);
            com.baidu.swan.apps.statistic.h.aLK();
            com.baidu.swan.apps.y.e.qd(cVar.ajb());
            if (!TextUtils.isEmpty(rM)) {
                com.baidu.swan.apps.performance.i.qA(rM);
            }
            com.baidu.swan.apps.statistic.h.p(true, bVar.azd());
            com.baidu.swan.apps.view.c afW = azY.afW();
            if (DEBUG) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + afW);
            }
            if (afW != null) {
                afW.kw(1);
            }
            com.baidu.swan.apps.runtime.d aIJ = com.baidu.swan.apps.runtime.d.aIJ();
            if (aIJ.aGb() && TextUtils.equals(aIJ.getAppId(), bVar.getAppId())) {
                aIJ.aIF().hj(true);
            }
            com.baidu.swan.apps.core.f.fb(false);
        }
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, String str) {
        if (fVar != null) {
            fVar.mJ(OneKeyLoginSdkCall.l).af(com.baidu.swan.apps.core.d.f.cUb, com.baidu.swan.apps.core.d.f.cUb).apJ().a("normal", com.baidu.swan.apps.model.b.bZ(str, com.baidu.swan.apps.v.f.aAo().azV()), true).commit();
        }
    }

    public static String a(com.baidu.swan.apps.v.f fVar, com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        String azW = fVar.azW();
        if (TextUtils.isEmpty(azW)) {
            if (bVar.azx()) {
                azW = swanAppConfigData.rV(bVar.azy());
            } else {
                azW = fVar.azX();
            }
        }
        dJc = azW;
        return azW;
    }

    public static String aKg() {
        return dJc;
    }
}
