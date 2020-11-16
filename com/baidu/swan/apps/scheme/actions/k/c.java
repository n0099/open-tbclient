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
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String duF;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (com.baidu.swan.apps.ad.a.a.aEj() || com.baidu.swan.apps.console.v8inspector.a.getStatus() == 2) {
            com.baidu.swan.apps.console.c.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            final com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.avS());
            final com.baidu.swan.apps.res.widget.dialog.g aGt = new g.a(com.baidu.swan.apps.runtime.d.aGI().aGG()).ib(a.h.aiapps_debug_start_inspect).ia(a.h.aiapps_debug_inspect_waiting).a(new com.baidu.swan.apps.view.c.a()).gu(false).c(a.h.aiapps_debug_inspect_skip, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.apps.console.v8inspector.a.this.stop();
                    com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    c.b(aVar, cVar, bVar, fVar);
                }
            }).aGt();
            com.baidu.swan.apps.performance.i.aCY().f(new UbcFlowEvent("fist_page_action_reg_callback").fV(true));
            aVar2.a(new a.InterfaceC0411a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0411a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                    aGt.dismiss();
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aCY().f(new UbcFlowEvent("fist_page_action_dostart").fV(true));
        com.baidu.swan.apps.v.f azg = com.baidu.swan.apps.v.f.azg();
        if (fVar.cVD == null) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String a2 = a(azg, bVar, fVar.cVD);
        String rT = fVar.cVD.rT(a2);
        SwanAppActivity ayQ = azg.ayQ();
        if (ayQ == null || ayQ.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        com.baidu.swan.apps.core.h.b.aqo().a(aVar, cVar, bVar, fVar.cVD, fVar);
        aVar.attachActivity(ayQ);
        cVar.attachActivity(ayQ);
        com.baidu.swan.apps.core.d.f afe = azg.afe();
        if (afe != null) {
            com.baidu.swan.apps.model.b ca = com.baidu.swan.apps.model.b.ca(a2, azg.ayN());
            com.baidu.swan.apps.core.slave.b.a(ak.Y(ca.mBaseUrl, ca.mPage, ca.mParams), cVar);
            a(afe, a2);
            com.baidu.swan.apps.statistic.h.aJK();
            com.baidu.swan.apps.y.e.qo(cVar.aib());
            if (!TextUtils.isEmpty(rT)) {
                com.baidu.swan.apps.performance.i.qM(rT);
            }
            com.baidu.swan.apps.statistic.h.m(true, bVar.axV());
            com.baidu.swan.apps.view.c afa = ayQ.afa();
            if (DEBUG) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + afa);
            }
            if (afa != null) {
                afa.lt(1);
            }
            com.baidu.swan.apps.runtime.d aGI = com.baidu.swan.apps.runtime.d.aGI();
            if (aGI.aEV() && TextUtils.equals(aGI.getAppId(), bVar.getAppId())) {
                aGI.aGE().gE(true);
            }
            com.baidu.swan.apps.core.f.eF(false);
        }
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, String str) {
        if (fVar != null) {
            fVar.mV(OneKeyLoginSdkCall.l).al(com.baidu.swan.apps.core.d.f.cJk, com.baidu.swan.apps.core.d.f.cJk).aoC().a("normal", com.baidu.swan.apps.model.b.ca(str, com.baidu.swan.apps.v.f.azg().ayN()), true).commit();
        }
    }

    public static String a(com.baidu.swan.apps.v.f fVar, com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        String ayO = fVar.ayO();
        if (TextUtils.isEmpty(ayO)) {
            if (bVar.ayp()) {
                ayO = swanAppConfigData.sc(bVar.ayq());
            } else {
                ayO = fVar.ayP();
            }
        }
        duF = ayO;
        return ayO;
    }

    public static String aIf() {
        return duF;
    }
}
