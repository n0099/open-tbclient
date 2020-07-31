package com.baidu.swan.apps.scheme.actions.k;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.console.v8inspector.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String cKH;

    public static void a(final com.baidu.swan.apps.core.g.a aVar, final com.baidu.swan.apps.adaptation.b.c cVar, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (com.baidu.swan.apps.ae.a.a.apg() || com.baidu.swan.apps.console.v8inspector.a.getStatus() == 2) {
            com.baidu.swan.apps.console.c.i("FirstPageAction", "in adb/wireless debug mode");
            WebView.setWebContentsDebuggingEnabled(true);
            final com.baidu.swan.apps.console.v8inspector.a aVar2 = new com.baidu.swan.apps.console.v8inspector.a(com.baidu.swan.apps.t.a.ahj());
            final com.baidu.swan.apps.res.widget.dialog.g ard = new g.a(com.baidu.swan.apps.runtime.d.arr().arp()).fi(a.h.aiapps_debug_start_inspect).fh(a.h.aiapps_debug_inspect_waiting).a(new com.baidu.swan.apps.view.c.a()).fh(false).c(a.h.aiapps_debug_inspect_skip, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.actions.k.c.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    com.baidu.swan.apps.console.v8inspector.a.this.stop();
                    com.baidu.swan.apps.console.v8inspector.a.setStatus(0);
                    c.b(aVar, cVar, bVar, fVar);
                }
            }).ard();
            com.baidu.swan.apps.performance.i.anX().f(new UbcFlowEvent("fist_page_action_reg_callback").eI(true));
            aVar2.a(new a.InterfaceC0334a() { // from class: com.baidu.swan.apps.scheme.actions.k.c.2
                @Override // com.baidu.swan.apps.console.v8inspector.a.InterfaceC0334a
                public void onConnected() {
                    c.b(com.baidu.swan.apps.core.g.a.this, cVar, bVar, fVar);
                    ard.dismiss();
                }
            });
            aVar2.start();
            return;
        }
        b(aVar, cVar, bVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.anX().f(new UbcFlowEvent("fist_page_action_dostart").eI(true));
        com.baidu.swan.apps.v.f akr = com.baidu.swan.apps.v.f.akr();
        if (fVar.cnl == null) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("loadInfo.mConfigData is null.")));
                return;
            }
            return;
        }
        String a = a(akr, bVar, fVar.cnl);
        String op = fVar.cnl.op(a);
        SwanAppActivity akb = akr.akb();
        if (akb == null || akb.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        com.baidu.swan.apps.core.h.b.acH().a(aVar, cVar, bVar, fVar.cnl, fVar);
        aVar.attachActivity(akb);
        cVar.attachActivity(akb);
        com.baidu.swan.apps.core.d.f Sc = akr.Sc();
        if (Sc != null) {
            com.baidu.swan.apps.model.b bB = com.baidu.swan.apps.model.b.bB(a, akr.ajY());
            com.baidu.swan.apps.core.slave.b.a(al.N(bB.mBaseUrl, bB.mPage, bB.mParams), cVar);
            a(Sc, a);
            com.baidu.swan.apps.statistic.h.auw();
            com.baidu.swan.apps.z.e.mI(cVar.UR());
            if (!TextUtils.isEmpty(op)) {
                com.baidu.swan.apps.performance.i.nh(op);
            }
            com.baidu.swan.apps.statistic.h.j(true, bVar.ajg());
            com.baidu.swan.apps.view.c RY = akb.RY();
            if (DEBUG) {
                Log.i("FirstPageAction", "startFirstPage:: loadingView=" + RY);
            }
            if (RY != null) {
                RY.im(1);
            }
            com.baidu.swan.apps.runtime.d arr = com.baidu.swan.apps.runtime.d.arr();
            if (arr.apU() && TextUtils.equals(arr.getAppId(), bVar.getAppId())) {
                arr.arn().fr(true);
            }
            com.baidu.swan.apps.core.d.YV();
        }
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, String str) {
        if (fVar != null) {
            fVar.jO(com.baidu.sapi2.outsdk.c.l).ag(com.baidu.swan.apps.core.d.f.cck, com.baidu.swan.apps.core.d.f.cck).abj().a("normal", com.baidu.swan.apps.model.b.bB(str, com.baidu.swan.apps.v.f.akr().ajY()), true).commit();
        }
    }

    public static String a(com.baidu.swan.apps.v.f fVar, com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        String ajZ = fVar.ajZ();
        if (TextUtils.isEmpty(ajZ)) {
            if (bVar.ajA()) {
                ajZ = swanAppConfigData.ox(bVar.ajB());
            } else {
                ajZ = fVar.aka();
            }
        }
        cKH = ajZ;
        return ajZ;
    }

    public static String asT() {
        return cKH;
    }
}
