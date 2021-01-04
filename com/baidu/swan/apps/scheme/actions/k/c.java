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
    public static String dKj;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (com.baidu.swan.apps.ad.a.a.aIK() || com.baidu.swan.apps.console.v8inspector.a.getStatus() == 2) {
            com.baidu.swan.apps.console.c.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            final com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.aAr());
            final com.baidu.swan.apps.res.widget.dialog.g aLx = new g.a(com.baidu.swan.apps.runtime.d.aMg().aMe()).iu(a.h.aiapps_debug_start_inspect).it(a.h.aiapps_debug_inspect_waiting).a(new com.baidu.swan.apps.view.c.a()).gV(false).c(a.h.aiapps_debug_inspect_skip, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.apps.console.v8inspector.a.this.stop();
                    com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    c.b(aVar, cVar, bVar, fVar);
                }
            }).aLx();
            com.baidu.swan.apps.performance.i.aHz().f(new UbcFlowEvent("fist_page_action_reg_callback").gt(true));
            aVar2.a(new a.InterfaceC0415a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0415a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                    aLx.dismiss();
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aHz().f(new UbcFlowEvent("fist_page_action_dostart").gt(true));
        com.baidu.swan.apps.v.f aDG = com.baidu.swan.apps.v.f.aDG();
        if (fVar.dht == null) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String a2 = a(aDG, bVar, fVar.dht);
        String sy = fVar.dht.sy(a2);
        SwanAppActivity aDq = aDG.aDq();
        if (aDq == null || aDq.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        com.baidu.swan.apps.core.h.b.auN().a(aVar, cVar, bVar, fVar.dht, fVar);
        aVar.attachActivity(aDq);
        cVar.attachActivity(aDq);
        com.baidu.swan.apps.core.d.f ajs = aDG.ajs();
        if (ajs != null) {
            com.baidu.swan.apps.model.b cg = com.baidu.swan.apps.model.b.cg(a2, aDG.aDn());
            com.baidu.swan.apps.core.slave.b.a(ak.ae(cg.mBaseUrl, cg.mPage, cg.mParams), cVar);
            a(ajs, a2);
            com.baidu.swan.apps.statistic.h.aPh();
            com.baidu.swan.apps.y.e.qP(cVar.amt());
            if (!TextUtils.isEmpty(sy)) {
                com.baidu.swan.apps.performance.i.rm(sy);
            }
            com.baidu.swan.apps.statistic.h.l(true, bVar.aCv());
            com.baidu.swan.apps.view.c ajo = aDq.ajo();
            if (DEBUG) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + ajo);
            }
            if (ajo != null) {
                ajo.lY(1);
            }
            com.baidu.swan.apps.runtime.d aMg = com.baidu.swan.apps.runtime.d.aMg();
            if (aMg.aJw() && TextUtils.equals(aMg.getAppId(), bVar.getAppId())) {
                aMg.aMc().hl(true);
            }
            com.baidu.swan.apps.core.f.fd(false);
        }
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, String str) {
        if (fVar != null) {
            fVar.nv(OneKeyLoginSdkCall.l).ai(com.baidu.swan.apps.core.d.f.cVa, com.baidu.swan.apps.core.d.f.cVa).atc().a("normal", com.baidu.swan.apps.model.b.cg(str, com.baidu.swan.apps.v.f.aDG().aDn()), true).commit();
        }
    }

    public static String a(com.baidu.swan.apps.v.f fVar, com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        String aDo = fVar.aDo();
        if (TextUtils.isEmpty(aDo)) {
            if (bVar.aCP()) {
                aDo = swanAppConfigData.sH(bVar.aCQ());
            } else {
                aDo = fVar.aDp();
            }
        }
        dKj = aDo;
        return aDo;
    }

    public static String aND() {
        return dKj;
    }
}
