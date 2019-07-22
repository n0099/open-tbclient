package com.baidu.swan.apps.scheme.actions.i;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(com.baidu.swan.apps.core.g.a aVar, com.baidu.swan.apps.b.c.c cVar, com.baidu.swan.apps.v.b.b bVar, e.g gVar) {
        com.baidu.swan.apps.w.e GF = com.baidu.swan.apps.w.e.GF();
        String a = a(GF);
        SwanAppActivity Gr = GF.Gr();
        if (Gr == null || Gr.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        aVar.y(Gr);
        com.baidu.swan.apps.core.j.a aVar2 = new com.baidu.swan.apps.core.j.a();
        aVar2.aub = gVar.ayq.aRe;
        gVar.ayq.aRe = null;
        aVar2.auc = gVar.ayp;
        aVar2.aud = cVar.xv();
        aVar2.aue = a;
        aVar2.aug = String.valueOf(com.baidu.swan.apps.console.a.yd());
        aVar2.auh = aVar2.a(com.baidu.swan.apps.ae.b.Md(), a);
        boolean z = DEBUG || com.baidu.swan.apps.w.e.GF().Gm();
        aVar2.aui = z;
        Bundle FK = bVar.FK();
        if (FK != null) {
            String string = FK.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                aVar2.auf = string;
            }
        }
        com.baidu.swan.apps.performance.f.IL().f(new UbcFlowEvent("master_dispatch_start"));
        com.baidu.swan.apps.y.f.Hy().fD("master_dispatch_start");
        aVar.a(aVar2);
        GF.a(com.baidu.swan.apps.core.j.a.b(aVar2));
        com.baidu.swan.apps.ae.a.d fd = GF.fd(aa.iq(a));
        cVar.y(Gr);
        com.baidu.swan.apps.core.j.b bVar2 = new com.baidu.swan.apps.core.j.b();
        bVar2.auc = gVar.ayp;
        bVar2.auj = a;
        bVar2.auk = fd.aRz;
        bVar2.aug = String.valueOf(com.baidu.swan.apps.console.a.yd());
        bVar2.aui = z;
        com.baidu.swan.apps.performance.f.IL().f(new UbcFlowEvent("slave_dispatch_start"));
        com.baidu.swan.apps.y.f.Hy().fD("slave_dispatch_start");
        cVar.a(bVar2);
        GF.a(cVar.xv(), com.baidu.swan.apps.core.j.b.b(bVar2));
        if (DEBUG) {
            Log.d("FirstPageAction", "app path: " + aVar2.auc);
            Log.d("FirstPageAction", "webviewId: " + cVar.xv());
            Log.d("FirstPageAction", "pageUrl: " + a);
            Log.d("FirstPageAction", "pagePath: " + bVar2.auj);
            Log.d("FirstPageAction", "onReachBottomDistance: " + bVar2.auk);
            Log.d("FirstPageAction", "sConsole:" + bVar2.aug);
        }
        if (GF.vJ() != null) {
            com.baidu.swan.apps.model.b aq = com.baidu.swan.apps.model.b.aq(a, GF.Go());
            com.baidu.swan.apps.core.i.b.a(ac.x(aq.mBaseUrl, aq.azs, aq.mParams), cVar);
            a(Gr, a);
            Gr.vG().eK(1);
            com.baidu.swan.apps.statistic.e.f(true, bVar.FG());
        }
    }

    public static void a(SwanAppActivity swanAppActivity, String str) {
        swanAppActivity.vJ().dS("init").B(com.baidu.swan.apps.core.d.e.ary, com.baidu.swan.apps.core.d.e.ary).AB().a("normal", com.baidu.swan.apps.model.b.aq(str, com.baidu.swan.apps.w.e.GF().Go()), true).commit();
    }

    public static String a(com.baidu.swan.apps.w.e eVar) {
        String Gp = eVar.Gp();
        if (TextUtils.isEmpty(Gp)) {
            return eVar.Gq();
        }
        return Gp;
    }
}
