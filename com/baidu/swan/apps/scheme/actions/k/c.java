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
        if (com.baidu.swan.apps.ad.a.a.aIL() || com.baidu.swan.apps.console.v8inspector.a.getStatus() == 2) {
            com.baidu.swan.apps.console.c.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            final com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.aAs());
            final com.baidu.swan.apps.res.widget.dialog.g aLy = new g.a(com.baidu.swan.apps.runtime.d.aMh().aMf()).iu(a.h.aiapps_debug_start_inspect).it(a.h.aiapps_debug_inspect_waiting).a(new com.baidu.swan.apps.view.c.a()).gV(false).c(a.h.aiapps_debug_inspect_skip, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.apps.console.v8inspector.a.this.stop();
                    com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    c.b(aVar, cVar, bVar, fVar);
                }
            }).aLy();
            com.baidu.swan.apps.performance.i.aHA().f(new UbcFlowEvent("fist_page_action_reg_callback").gt(true));
            aVar2.a(new a.InterfaceC0415a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0415a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                    aLy.dismiss();
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aHA().f(new UbcFlowEvent("fist_page_action_dostart").gt(true));
        com.baidu.swan.apps.v.f aDH = com.baidu.swan.apps.v.f.aDH();
        if (fVar.dht == null) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String a2 = a(aDH, bVar, fVar.dht);
        String sy = fVar.dht.sy(a2);
        SwanAppActivity aDr = aDH.aDr();
        if (aDr == null || aDr.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        com.baidu.swan.apps.core.h.b.auO().a(aVar, cVar, bVar, fVar.dht, fVar);
        aVar.attachActivity(aDr);
        cVar.attachActivity(aDr);
        com.baidu.swan.apps.core.d.f ajt = aDH.ajt();
        if (ajt != null) {
            com.baidu.swan.apps.model.b cg = com.baidu.swan.apps.model.b.cg(a2, aDH.aDo());
            com.baidu.swan.apps.core.slave.b.a(ak.ae(cg.mBaseUrl, cg.mPage, cg.mParams), cVar);
            a(ajt, a2);
            com.baidu.swan.apps.statistic.h.aPi();
            com.baidu.swan.apps.y.e.qP(cVar.amu());
            if (!TextUtils.isEmpty(sy)) {
                com.baidu.swan.apps.performance.i.rm(sy);
            }
            com.baidu.swan.apps.statistic.h.l(true, bVar.aCw());
            com.baidu.swan.apps.view.c ajp = aDr.ajp();
            if (DEBUG) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + ajp);
            }
            if (ajp != null) {
                ajp.lY(1);
            }
            com.baidu.swan.apps.runtime.d aMh = com.baidu.swan.apps.runtime.d.aMh();
            if (aMh.aJx() && TextUtils.equals(aMh.getAppId(), bVar.getAppId())) {
                aMh.aMd().hl(true);
            }
            com.baidu.swan.apps.core.f.fd(false);
        }
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, String str) {
        if (fVar != null) {
            fVar.nv(OneKeyLoginSdkCall.l).ai(com.baidu.swan.apps.core.d.f.cVa, com.baidu.swan.apps.core.d.f.cVa).atd().a("normal", com.baidu.swan.apps.model.b.cg(str, com.baidu.swan.apps.v.f.aDH().aDo()), true).commit();
        }
    }

    public static String a(com.baidu.swan.apps.v.f fVar, com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        String aDp = fVar.aDp();
        if (TextUtils.isEmpty(aDp)) {
            if (bVar.aCQ()) {
                aDp = swanAppConfigData.sH(bVar.aCR());
            } else {
                aDp = fVar.aDq();
            }
        }
        dKj = aDp;
        return aDp;
    }

    public static String aNE() {
        return dKj;
    }
}
