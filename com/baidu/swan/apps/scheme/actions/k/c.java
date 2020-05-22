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
    public static String cCV;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.v.b.b bVar, final e.f fVar) {
        if (com.baidu.swan.apps.af.a.a.amr() || com.baidu.swan.apps.console.v8inspector.a.getStatus() == 2) {
            com.baidu.swan.apps.console.c.v("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            final com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.u.a.aeR());
            final com.baidu.swan.apps.res.widget.dialog.g aon = new g.a(com.baidu.swan.apps.runtime.d.aoB().aoz()).eR(a.h.aiapps_debug_start_inspect).eQ(a.h.aiapps_debug_inspect_waiting).a(new com.baidu.swan.apps.view.c.a()).eT(false).c(a.h.aiapps_debug_inspect_skip, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.apps.console.v8inspector.a.this.stop();
                    com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    c.b(aVar, cVar, bVar, fVar);
                }
            }).aon();
            com.baidu.swan.apps.performance.g.alx().f(new UbcFlowEvent("fist_page_action_reg_callback").eu(true));
            aVar2.a(new a.InterfaceC0326a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0326a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                    aon.dismiss();
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.v.b.b bVar, e.f fVar) {
        com.baidu.swan.apps.performance.g.alx().f(new UbcFlowEvent("fist_page_action_dostart").eu(true));
        com.baidu.swan.apps.w.f ahV = com.baidu.swan.apps.w.f.ahV();
        if (fVar.cgt == null) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String a = a(ahV, bVar, fVar.cgt);
        String nz = fVar.cgt.nz(a);
        SwanAppActivity ahF = ahV.ahF();
        if (ahF == null || ahF.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        com.baidu.swan.apps.core.h.b.aaz().a(aVar, cVar, bVar, fVar.cgt, fVar);
        aVar.attachActivity(ahF);
        cVar.attachActivity(ahF);
        com.baidu.swan.apps.core.d.e QH = ahV.QH();
        if (QH != null) {
            com.baidu.swan.apps.model.b bx = com.baidu.swan.apps.model.b.bx(a, ahV.ahC());
            com.baidu.swan.apps.core.slave.b.a(aj.M(bx.mBaseUrl, bx.mPage, bx.mParams), cVar);
            a(QH, a);
            com.baidu.swan.apps.aa.e.mc(cVar.Tj());
            if (!TextUtils.isEmpty(nz)) {
                com.baidu.swan.apps.performance.g.mx(nz);
            }
            com.baidu.swan.apps.statistic.h.i(true, bVar.agK());
            com.baidu.swan.apps.view.c QD = ahF.QD();
            if (DEBUG) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + QD);
            }
            if (QD != null) {
                QD.hO(1);
            }
            com.baidu.swan.apps.runtime.d aoB = com.baidu.swan.apps.runtime.d.aoB();
            if (aoB.ane() && TextUtils.equals(aoB.getAppId(), bVar.getAppId())) {
                aoB.aox().fd(true);
            }
        }
    }

    public static void a(com.baidu.swan.apps.core.d.e eVar, String str) {
        if (eVar != null) {
            eVar.jp(com.baidu.sapi2.outsdk.c.l).ae(com.baidu.swan.apps.core.d.e.bVP, com.baidu.swan.apps.core.d.e.bVP).YZ().a("normal", com.baidu.swan.apps.model.b.bx(str, com.baidu.swan.apps.w.f.ahV().ahC()), true).commit();
        }
    }

    public static String a(com.baidu.swan.apps.w.f fVar, com.baidu.swan.apps.v.b.b bVar, SwanAppConfigData swanAppConfigData) {
        String ahD = fVar.ahD();
        if (TextUtils.isEmpty(ahD)) {
            if (bVar.ahe()) {
                ahD = swanAppConfigData.nH(bVar.ahf());
            } else {
                ahD = fVar.ahE();
            }
        }
        cCV = ahD;
        return ahD;
    }

    public static String apW() {
        return cCV;
    }
}
