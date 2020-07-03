package com.baidu.swan.apps.scheme.actions.k;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.console.v8inspector.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String cHF;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.v.b.b bVar, final e.f fVar) {
        if (com.baidu.swan.apps.af.a.a.anx() || com.baidu.swan.apps.console.v8inspector.a.getStatus() == 2) {
            com.baidu.swan.apps.console.c.v("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            final com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.u.a.afX());
            final com.baidu.swan.apps.res.widget.dialog.g apu = new g.a(com.baidu.swan.apps.runtime.d.apI().apG()).fe(a.h.aiapps_debug_start_inspect).fd(a.h.aiapps_debug_inspect_waiting).a(new com.baidu.swan.apps.view.c.a()).eY(false).c(a.h.aiapps_debug_inspect_skip, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.apps.console.v8inspector.a.this.stop();
                    com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    c.b(aVar, cVar, bVar, fVar);
                }
            }).apu();
            com.baidu.swan.apps.performance.g.amD().f(new UbcFlowEvent("fist_page_action_reg_callback").ez(true));
            aVar2.a(new a.InterfaceC0332a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0332a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                    apu.dismiss();
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.v.b.b bVar, e.f fVar) {
        com.baidu.swan.apps.performance.g.amD().f(new UbcFlowEvent("fist_page_action_dostart").ez(true));
        com.baidu.swan.apps.w.f ajb = com.baidu.swan.apps.w.f.ajb();
        if (fVar.clh == null) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String a = a(ajb, bVar, fVar.clh);
        String nH = fVar.clh.nH(a);
        SwanAppActivity aiL = ajb.aiL();
        if (aiL == null || aiL.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        com.baidu.swan.apps.core.h.b.abF().a(aVar, cVar, bVar, fVar.clh, fVar);
        aVar.attachActivity(aiL);
        cVar.attachActivity(aiL);
        com.baidu.swan.apps.core.d.e RN = ajb.RN();
        if (RN != null) {
            com.baidu.swan.apps.model.b bz = com.baidu.swan.apps.model.b.bz(a, ajb.aiI());
            com.baidu.swan.apps.core.slave.b.a(aj.N(bz.mBaseUrl, bz.mPage, bz.mParams), cVar);
            a(RN, a);
            com.baidu.swan.apps.aa.e.mk(cVar.Up());
            if (!TextUtils.isEmpty(nH)) {
                com.baidu.swan.apps.performance.g.mF(nH);
            }
            com.baidu.swan.apps.statistic.h.j(true, bVar.ahQ());
            com.baidu.swan.apps.view.c RJ = aiL.RJ();
            if (DEBUG) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + RJ);
            }
            if (RJ != null) {
                RJ.ib(1);
            }
            com.baidu.swan.apps.runtime.d apI = com.baidu.swan.apps.runtime.d.apI();
            if (apI.aok() && TextUtils.equals(apI.getAppId(), bVar.getAppId())) {
                apI.apE().fi(true);
            }
        }
    }

    public static void a(com.baidu.swan.apps.core.d.e eVar, String str) {
        if (eVar != null) {
            eVar.jx(com.baidu.sapi2.outsdk.c.l).ag(com.baidu.swan.apps.core.d.e.caD, com.baidu.swan.apps.core.d.e.caD).aaf().a("normal", com.baidu.swan.apps.model.b.bz(str, com.baidu.swan.apps.w.f.ajb().aiI()), true).commit();
        }
    }

    public static String a(com.baidu.swan.apps.w.f fVar, com.baidu.swan.apps.v.b.b bVar, SwanAppConfigData swanAppConfigData) {
        String aiJ = fVar.aiJ();
        if (TextUtils.isEmpty(aiJ)) {
            if (bVar.aik()) {
                aiJ = swanAppConfigData.nP(bVar.ail());
            } else {
                aiJ = fVar.aiK();
            }
        }
        cHF = aiJ;
        return aiJ;
    }

    public static String arc() {
        return cHF;
    }
}
