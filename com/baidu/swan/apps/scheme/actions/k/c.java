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
    public static String dhP;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (com.baidu.swan.apps.ad.a.a.aAx() || com.baidu.swan.apps.console.v8inspector.a.getStatus() == 2) {
            com.baidu.swan.apps.console.c.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            final com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.asf());
            final com.baidu.swan.apps.res.widget.dialog.g aCH = new g.a(com.baidu.swan.apps.runtime.d.aCW().aCU()).hK(a.h.aiapps_debug_start_inspect).hJ(a.h.aiapps_debug_inspect_waiting).a(new com.baidu.swan.apps.view.c.a()).fV(false).c(a.h.aiapps_debug_inspect_skip, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.apps.console.v8inspector.a.this.stop();
                    com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    c.b(aVar, cVar, bVar, fVar);
                }
            }).aCH();
            com.baidu.swan.apps.performance.i.azm().f(new UbcFlowEvent("fist_page_action_reg_callback").fw(true));
            aVar2.a(new a.InterfaceC0387a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0387a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                    aCH.dismiss();
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.azm().f(new UbcFlowEvent("fist_page_action_dostart").fw(true));
        com.baidu.swan.apps.v.f avu = com.baidu.swan.apps.v.f.avu();
        if (fVar.cIY == null) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String a2 = a(avu, bVar, fVar.cIY);
        String rs = fVar.cIY.rs(a2);
        SwanAppActivity ave = avu.ave();
        if (ave == null || ave.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        com.baidu.swan.apps.core.h.b.amB().a(aVar, cVar, bVar, fVar.cIY, fVar);
        aVar.attachActivity(ave);
        cVar.attachActivity(ave);
        com.baidu.swan.apps.core.d.f abs = avu.abs();
        if (abs != null) {
            com.baidu.swan.apps.model.b bU = com.baidu.swan.apps.model.b.bU(a2, avu.avb());
            com.baidu.swan.apps.core.slave.b.a(ak.R(bU.mBaseUrl, bU.mPage, bU.mParams), cVar);
            a(abs, a2);
            com.baidu.swan.apps.statistic.h.aFY();
            com.baidu.swan.apps.y.e.pN(cVar.aep());
            if (!TextUtils.isEmpty(rs)) {
                com.baidu.swan.apps.performance.i.ql(rs);
            }
            com.baidu.swan.apps.statistic.h.j(true, bVar.auj());
            com.baidu.swan.apps.view.c abo = ave.abo();
            if (DEBUG) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + abo);
            }
            if (abo != null) {
                abo.lc(1);
            }
            com.baidu.swan.apps.runtime.d aCW = com.baidu.swan.apps.runtime.d.aCW();
            if (aCW.aBj() && TextUtils.equals(aCW.getAppId(), bVar.getAppId())) {
                aCW.aCS().gf(true);
            }
            com.baidu.swan.apps.core.f.eg(false);
        }
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, String str) {
        if (fVar != null) {
            fVar.mt(OneKeyLoginSdkCall.l).ak(com.baidu.swan.apps.core.d.f.cwF, com.baidu.swan.apps.core.d.f.cwF).akQ().a("normal", com.baidu.swan.apps.model.b.bU(str, com.baidu.swan.apps.v.f.avu().avb()), true).commit();
        }
    }

    public static String a(com.baidu.swan.apps.v.f fVar, com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        String avc = fVar.avc();
        if (TextUtils.isEmpty(avc)) {
            if (bVar.auD()) {
                avc = swanAppConfigData.rA(bVar.auE());
            } else {
                avc = fVar.avd();
            }
        }
        dhP = avc;
        return avc;
    }

    public static String aEt() {
        return dhP;
    }
}
