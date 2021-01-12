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
    public static String dFx;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (com.baidu.swan.apps.ad.a.a.aER() || com.baidu.swan.apps.console.v8inspector.a.getStatus() == 2) {
            com.baidu.swan.apps.console.c.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            final com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.awy());
            final com.baidu.swan.apps.res.widget.dialog.g aHE = new g.a(com.baidu.swan.apps.runtime.d.aIn().aIl()).gO(a.h.aiapps_debug_start_inspect).gN(a.h.aiapps_debug_inspect_waiting).a(new com.baidu.swan.apps.view.c.a()).gR(false).c(a.h.aiapps_debug_inspect_skip, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.apps.console.v8inspector.a.this.stop();
                    com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    c.b(aVar, cVar, bVar, fVar);
                }
            }).aHE();
            com.baidu.swan.apps.performance.i.aDG().f(new UbcFlowEvent("fist_page_action_reg_callback").gp(true));
            aVar2.a(new a.InterfaceC0398a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0398a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                    aHE.dismiss();
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aDG().f(new UbcFlowEvent("fist_page_action_dostart").gp(true));
        com.baidu.swan.apps.v.f azN = com.baidu.swan.apps.v.f.azN();
        if (fVar.dcF == null) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String a2 = a(azN, bVar, fVar.dcF);
        String rm = fVar.dcF.rm(a2);
        SwanAppActivity azx = azN.azx();
        if (azx == null || azx.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        com.baidu.swan.apps.core.h.b.aqT().a(aVar, cVar, bVar, fVar.dcF, fVar);
        aVar.attachActivity(azx);
        cVar.attachActivity(azx);
        com.baidu.swan.apps.core.d.f afz = azN.afz();
        if (afz != null) {
            com.baidu.swan.apps.model.b cf = com.baidu.swan.apps.model.b.cf(a2, azN.azu());
            com.baidu.swan.apps.core.slave.b.a(ak.ad(cf.mBaseUrl, cf.mPage, cf.mParams), cVar);
            a(afz, a2);
            com.baidu.swan.apps.statistic.h.aLo();
            com.baidu.swan.apps.y.e.pE(cVar.aiA());
            if (!TextUtils.isEmpty(rm)) {
                com.baidu.swan.apps.performance.i.qb(rm);
            }
            com.baidu.swan.apps.statistic.h.l(true, bVar.ayC());
            com.baidu.swan.apps.view.c afv = azx.afv();
            if (DEBUG) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + afv);
            }
            if (afv != null) {
                afv.ks(1);
            }
            com.baidu.swan.apps.runtime.d aIn = com.baidu.swan.apps.runtime.d.aIn();
            if (aIn.aFD() && TextUtils.equals(aIn.getAppId(), bVar.getAppId())) {
                aIn.aIj().hh(true);
            }
            com.baidu.swan.apps.core.f.eZ(false);
        }
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, String str) {
        if (fVar != null) {
            fVar.mk(OneKeyLoginSdkCall.l).ai(com.baidu.swan.apps.core.d.f.cQo, com.baidu.swan.apps.core.d.f.cQo).aph().a("normal", com.baidu.swan.apps.model.b.cf(str, com.baidu.swan.apps.v.f.azN().azu()), true).commit();
        }
    }

    public static String a(com.baidu.swan.apps.v.f fVar, com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        String azv = fVar.azv();
        if (TextUtils.isEmpty(azv)) {
            if (bVar.ayW()) {
                azv = swanAppConfigData.rv(bVar.ayX());
            } else {
                azv = fVar.azw();
            }
        }
        dFx = azv;
        return azv;
    }

    public static String aJK() {
        return dFx;
    }
}
