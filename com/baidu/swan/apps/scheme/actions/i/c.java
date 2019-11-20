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
        com.baidu.swan.apps.w.e LE = com.baidu.swan.apps.w.e.LE();
        String a = a(LE);
        SwanAppActivity Lq = LE.Lq();
        if (Lq == null || Lq.isFinishing()) {
            if (DEBUG) {
                Log.e("FirstPageAction", Log.getStackTraceString(new Exception("activity is invalid.")));
                return;
            }
            return;
        }
        aVar.x(Lq);
        com.baidu.swan.apps.core.j.a aVar2 = new com.baidu.swan.apps.core.j.a();
        aVar2.aNy = gVar.aRM.bko;
        gVar.aRM.bko = null;
        aVar2.aNz = gVar.aRL;
        aVar2.aNA = cVar.Cu();
        aVar2.aNB = a;
        aVar2.aND = String.valueOf(com.baidu.swan.apps.console.a.Dd());
        aVar2.aNE = aVar2.a(com.baidu.swan.apps.ae.b.Ra(), a);
        boolean z = DEBUG || com.baidu.swan.apps.w.e.LE().Ll();
        aVar2.aNF = z;
        Bundle KJ = bVar.KJ();
        if (KJ != null) {
            String string = KJ.getString("extraData");
            if (!TextUtils.isEmpty(string)) {
                aVar2.aNC = string;
            }
        }
        com.baidu.swan.apps.performance.f.NK().f(new UbcFlowEvent("master_dispatch_start"));
        com.baidu.swan.apps.y.f.Mx().gj("master_dispatch_start");
        aVar.a(aVar2);
        LE.a(com.baidu.swan.apps.core.j.a.b(aVar2));
        com.baidu.swan.apps.ae.a.d fM = LE.fM(aa.iV(a));
        cVar.x(Lq);
        com.baidu.swan.apps.core.j.b bVar2 = new com.baidu.swan.apps.core.j.b();
        bVar2.aNz = gVar.aRL;
        bVar2.aNG = a;
        bVar2.aNH = fM.bkJ;
        bVar2.aND = String.valueOf(com.baidu.swan.apps.console.a.Dd());
        bVar2.aNF = z;
        com.baidu.swan.apps.performance.f.NK().f(new UbcFlowEvent("slave_dispatch_start"));
        com.baidu.swan.apps.y.f.Mx().gj("slave_dispatch_start");
        cVar.a(bVar2);
        LE.a(cVar.Cu(), com.baidu.swan.apps.core.j.b.b(bVar2));
        if (DEBUG) {
            Log.d("FirstPageAction", "app path: " + aVar2.aNz);
            Log.d("FirstPageAction", "webviewId: " + cVar.Cu());
            Log.d("FirstPageAction", "pageUrl: " + a);
            Log.d("FirstPageAction", "pagePath: " + bVar2.aNG);
            Log.d("FirstPageAction", "onReachBottomDistance: " + bVar2.aNH);
            Log.d("FirstPageAction", "sConsole:" + bVar2.aND);
        }
        if (LE.AI() != null) {
            com.baidu.swan.apps.model.b ay = com.baidu.swan.apps.model.b.ay(a, LE.Ln());
            com.baidu.swan.apps.core.i.b.a(ac.B(ay.mBaseUrl, ay.aSM, ay.mParams), cVar);
            a(Lq, a);
            Lq.AF().fF(1);
            com.baidu.swan.apps.statistic.e.g(true, bVar.KF());
        }
    }

    public static void a(SwanAppActivity swanAppActivity, String str) {
        swanAppActivity.AI().eC("init").F(com.baidu.swan.apps.core.d.e.aKV, com.baidu.swan.apps.core.d.e.aKV).FB().a("normal", com.baidu.swan.apps.model.b.ay(str, com.baidu.swan.apps.w.e.LE().Ln()), true).commit();
    }

    public static String a(com.baidu.swan.apps.w.e eVar) {
        String Lo = eVar.Lo();
        if (TextUtils.isEmpty(Lo)) {
            return eVar.Lp();
        }
        return Lo;
    }
}
