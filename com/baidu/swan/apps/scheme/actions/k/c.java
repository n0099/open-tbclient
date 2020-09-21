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
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String cVI;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (com.baidu.swan.apps.ad.a.a.axM() || com.baidu.swan.apps.console.v8inspector.a.getStatus() == 2) {
            com.baidu.swan.apps.console.c.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            final com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.apu());
            final com.baidu.swan.apps.res.widget.dialog.g azY = new g.a(com.baidu.swan.apps.runtime.d.aAn().aAl()).hn(a.h.aiapps_debug_start_inspect).hm(a.h.aiapps_debug_inspect_waiting).a(new com.baidu.swan.apps.view.c.a()).fz(false).c(a.h.aiapps_debug_inspect_skip, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.apps.console.v8inspector.a.this.stop();
                    com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    c.b(aVar, cVar, bVar, fVar);
                }
            }).azY();
            com.baidu.swan.apps.performance.i.awB().f(new UbcFlowEvent("fist_page_action_reg_callback").fa(true));
            aVar2.a(new a.InterfaceC0370a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0370a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                    azY.dismiss();
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.awB().f(new UbcFlowEvent("fist_page_action_dostart").fa(true));
        com.baidu.swan.apps.v.f asJ = com.baidu.swan.apps.v.f.asJ();
        if (fVar.cwT == null) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String a = a(asJ, bVar, fVar.cwT);
        String qG = fVar.cwT.qG(a);
        SwanAppActivity ast = asJ.ast();
        if (ast == null || ast.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        com.baidu.swan.apps.core.h.b.ajQ().a(aVar, cVar, bVar, fVar.cwT, fVar);
        aVar.attachActivity(ast);
        cVar.attachActivity(ast);
        com.baidu.swan.apps.core.d.f YG = asJ.YG();
        if (YG != null) {
            com.baidu.swan.apps.model.b bP = com.baidu.swan.apps.model.b.bP(a, asJ.asq());
            com.baidu.swan.apps.core.slave.b.a(ak.Q(bP.mBaseUrl, bP.mPage, bP.mParams), cVar);
            a(YG, a);
            com.baidu.swan.apps.statistic.h.aDp();
            com.baidu.swan.apps.y.e.pb(cVar.abD());
            if (!TextUtils.isEmpty(qG)) {
                com.baidu.swan.apps.performance.i.pz(qG);
            }
            com.baidu.swan.apps.statistic.h.j(true, bVar.arx());
            com.baidu.swan.apps.view.c YC = ast.YC();
            if (DEBUG) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + YC);
            }
            if (YC != null) {
                YC.kF(1);
            }
            com.baidu.swan.apps.runtime.d aAn = com.baidu.swan.apps.runtime.d.aAn();
            if (aAn.ayA() && TextUtils.equals(aAn.getAppId(), bVar.getAppId())) {
                aAn.aAj().fJ(true);
            }
            com.baidu.swan.apps.core.f.dK(false);
        }
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, String str) {
        if (fVar != null) {
            fVar.lH(OneKeyLoginSdkCall.l).al(com.baidu.swan.apps.core.d.f.ckn, com.baidu.swan.apps.core.d.f.ckn).aif().a("normal", com.baidu.swan.apps.model.b.bP(str, com.baidu.swan.apps.v.f.asJ().asq()), true).commit();
        }
    }

    public static String a(com.baidu.swan.apps.v.f fVar, com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        String asr = fVar.asr();
        if (TextUtils.isEmpty(asr)) {
            if (bVar.arR()) {
                asr = swanAppConfigData.qO(bVar.arS());
            } else {
                asr = fVar.ass();
            }
        }
        cVI = asr;
        return asr;
    }

    public static String aBK() {
        return cVI;
    }
}
