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
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String dqr;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (com.baidu.swan.apps.ad.a.a.aCr() || com.baidu.swan.apps.console.v8inspector.a.getStatus() == 2) {
            com.baidu.swan.apps.console.c.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            final com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.aua());
            final com.baidu.swan.apps.res.widget.dialog.g aEB = new g.a(com.baidu.swan.apps.runtime.d.aEQ().aEO()).hV(a.h.aiapps_debug_start_inspect).hU(a.h.aiapps_debug_inspect_waiting).a(new com.baidu.swan.apps.view.c.a()).gi(false).c(a.h.aiapps_debug_inspect_skip, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.apps.console.v8inspector.a.this.stop();
                    com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    c.b(aVar, cVar, bVar, fVar);
                }
            }).aEB();
            com.baidu.swan.apps.performance.i.aBg().f(new UbcFlowEvent("fist_page_action_reg_callback").fJ(true));
            aVar2.a(new a.InterfaceC0401a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0401a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                    aEB.dismiss();
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aBg().f(new UbcFlowEvent("fist_page_action_dostart").fJ(true));
        com.baidu.swan.apps.v.f axo = com.baidu.swan.apps.v.f.axo();
        if (fVar.cRu == null) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String a2 = a(axo, bVar, fVar.cRu);
        String rL = fVar.cRu.rL(a2);
        SwanAppActivity awY = axo.awY();
        if (awY == null || awY.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        com.baidu.swan.apps.core.h.b.aov().a(aVar, cVar, bVar, fVar.cRu, fVar);
        aVar.attachActivity(awY);
        cVar.attachActivity(awY);
        com.baidu.swan.apps.core.d.f adm = axo.adm();
        if (adm != null) {
            com.baidu.swan.apps.model.b cb = com.baidu.swan.apps.model.b.cb(a2, axo.awV());
            com.baidu.swan.apps.core.slave.b.a(ak.Y(cb.mBaseUrl, cb.mPage, cb.mParams), cVar);
            a(adm, a2);
            com.baidu.swan.apps.statistic.h.aHS();
            com.baidu.swan.apps.y.e.qg(cVar.agj());
            if (!TextUtils.isEmpty(rL)) {
                com.baidu.swan.apps.performance.i.qE(rL);
            }
            com.baidu.swan.apps.statistic.h.l(true, bVar.awd());
            com.baidu.swan.apps.view.c adi = awY.adi();
            if (DEBUG) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + adi);
            }
            if (adi != null) {
                adi.ln(1);
            }
            com.baidu.swan.apps.runtime.d aEQ = com.baidu.swan.apps.runtime.d.aEQ();
            if (aEQ.aDd() && TextUtils.equals(aEQ.getAppId(), bVar.getAppId())) {
                aEQ.aEM().gs(true);
            }
            com.baidu.swan.apps.core.f.et(false);
        }
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, String str) {
        if (fVar != null) {
            fVar.mM(OneKeyLoginSdkCall.l).al(com.baidu.swan.apps.core.d.f.cFb, com.baidu.swan.apps.core.d.f.cFb).amK().a("normal", com.baidu.swan.apps.model.b.cb(str, com.baidu.swan.apps.v.f.axo().awV()), true).commit();
        }
    }

    public static String a(com.baidu.swan.apps.v.f fVar, com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        String awW = fVar.awW();
        if (TextUtils.isEmpty(awW)) {
            if (bVar.awx()) {
                awW = swanAppConfigData.rT(bVar.awy());
            } else {
                awW = fVar.awX();
            }
        }
        dqr = awW;
        return awW;
    }

    public static String aGn() {
        return dqr;
    }
}
