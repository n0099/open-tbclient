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
    public static String dwm;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (com.baidu.swan.apps.ad.a.a.aER() || com.baidu.swan.apps.console.v8inspector.a.getStatus() == 2) {
            com.baidu.swan.apps.console.c.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            final com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.awA());
            final com.baidu.swan.apps.res.widget.dialog.g aHb = new g.a(com.baidu.swan.apps.runtime.d.aHq().aHo()).mo33if(a.h.aiapps_debug_start_inspect).ie(a.h.aiapps_debug_inspect_waiting).a(new com.baidu.swan.apps.view.c.a()).gr(false).c(a.h.aiapps_debug_inspect_skip, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.apps.console.v8inspector.a.this.stop();
                    com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    c.b(aVar, cVar, bVar, fVar);
                }
            }).aHb();
            com.baidu.swan.apps.performance.i.aDG().f(new UbcFlowEvent("fist_page_action_reg_callback").fS(true));
            aVar2.a(new a.InterfaceC0413a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0413a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                    aHb.dismiss();
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aDG().f(new UbcFlowEvent("fist_page_action_dostart").fS(true));
        com.baidu.swan.apps.v.f azO = com.baidu.swan.apps.v.f.azO();
        if (fVar.cXn == null) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String a2 = a(azO, bVar, fVar.cXn);
        String rZ = fVar.cXn.rZ(a2);
        SwanAppActivity azy = azO.azy();
        if (azy == null || azy.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        com.baidu.swan.apps.core.h.b.aqW().a(aVar, cVar, bVar, fVar.cXn, fVar);
        aVar.attachActivity(azy);
        cVar.attachActivity(azy);
        com.baidu.swan.apps.core.d.f afM = azO.afM();
        if (afM != null) {
            com.baidu.swan.apps.model.b cb = com.baidu.swan.apps.model.b.cb(a2, azO.azv());
            com.baidu.swan.apps.core.slave.b.a(ak.Y(cb.mBaseUrl, cb.mPage, cb.mParams), cVar);
            a(afM, a2);
            com.baidu.swan.apps.statistic.h.aKs();
            com.baidu.swan.apps.y.e.qu(cVar.aiJ());
            if (!TextUtils.isEmpty(rZ)) {
                com.baidu.swan.apps.performance.i.qS(rZ);
            }
            com.baidu.swan.apps.statistic.h.l(true, bVar.ayD());
            com.baidu.swan.apps.view.c afI = azy.afI();
            if (DEBUG) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + afI);
            }
            if (afI != null) {
                afI.lx(1);
            }
            com.baidu.swan.apps.runtime.d aHq = com.baidu.swan.apps.runtime.d.aHq();
            if (aHq.aFD() && TextUtils.equals(aHq.getAppId(), bVar.getAppId())) {
                aHq.aHm().gB(true);
            }
            com.baidu.swan.apps.core.f.eC(false);
        }
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, String str) {
        if (fVar != null) {
            fVar.nb(OneKeyLoginSdkCall.l).al(com.baidu.swan.apps.core.d.f.cKU, com.baidu.swan.apps.core.d.f.cKU).apl().a("normal", com.baidu.swan.apps.model.b.cb(str, com.baidu.swan.apps.v.f.azO().azv()), true).commit();
        }
    }

    public static String a(com.baidu.swan.apps.v.f fVar, com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        String azw = fVar.azw();
        if (TextUtils.isEmpty(azw)) {
            if (bVar.ayX()) {
                azw = swanAppConfigData.sh(bVar.ayY());
            } else {
                azw = fVar.azx();
            }
        }
        dwm = azw;
        return azw;
    }

    public static String aIN() {
        return dwm;
    }
}
