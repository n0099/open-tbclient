package com.baidu.swan.apps.core.h;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.ap.ab;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.swan.apps.v.f;
import java.io.File;
/* loaded from: classes3.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cnV;

    private b() {
        this.cnV = false;
    }

    public static b ajQ() {
        return a.cnW;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.swan.apps.adaptation.b.d] */
    public synchronized void a(@NonNull com.baidu.swan.apps.core.g.a aVar, @NonNull c cVar, @NonNull com.baidu.swan.apps.u.c.b bVar, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.f fVar) {
        boolean z = true;
        synchronized (this) {
            if (DEBUG) {
                Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                Log.d("SwanPrelink", "start dispatch launch event");
            }
            if (!this.cnV) {
                String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.asJ(), bVar, swanAppConfigData);
                String qG = swanAppConfigData.qG(a2);
                com.baidu.swan.apps.core.turbo.a aVar2 = new com.baidu.swan.apps.core.turbo.a();
                aVar2.appConfig = swanAppConfigData.cTg;
                swanAppConfigData.cTg = null;
                if (fVar != null && !TextUtils.isEmpty(fVar.cwS)) {
                    aVar2.appPath = fVar.cwS;
                } else {
                    aVar2.appPath = d.C0421d.bB(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                aVar2.cpn = cVar.abD();
                aVar2.pageUrl = a2;
                aVar2.cpp = String.valueOf(com.baidu.swan.apps.console.a.aeq());
                aVar2.cpq = com.baidu.swan.apps.core.turbo.a.b(e.aAr(), a2);
                aVar2.pageType = qG;
                if (!DEBUG && !f.asJ().asn()) {
                    z = false;
                }
                aVar2.cpr = z;
                aVar2.cps = cVar.aby();
                if (com.baidu.swan.apps.ad.a.a.axM()) {
                    aVar2.cpt = com.baidu.swan.apps.console.debugger.b.aey();
                }
                Bundle arC = bVar.arC();
                if (arC != null) {
                    String string = arC.getString("extraData");
                    if (!TextUtils.isEmpty(string)) {
                        aVar2.cpo = string;
                    }
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", aVar2.toString());
                }
                i.awB().f(new UbcFlowEvent("master_dispatch_start"));
                com.baidu.swan.apps.ak.a.aCP().ry("master_dispatch_start");
                aVar.a(aVar2);
                com.baidu.swan.apps.core.turbo.d.akC().b(com.baidu.swan.apps.core.turbo.a.b(aVar2));
                com.baidu.swan.apps.core.turbo.d.akC().ei(aVar2.cps);
                if (com.baidu.swan.apps.ad.a.a.pY(bVar.arM())) {
                    com.baidu.swan.apps.console.debugger.a.d.aeM();
                    com.baidu.swan.apps.console.debugger.a.d.aeH().lc("appready");
                }
                com.baidu.swan.apps.runtime.config.c os = f.asJ().os(j.rq(ai.delAllParamsFromUrl(a2)));
                com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
                if (fVar != null && !TextUtils.isEmpty(fVar.cwS)) {
                    bVar2.appPath = fVar.cwS;
                } else {
                    bVar2.appPath = d.C0421d.bB(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                bVar2.cpv = a2;
                bVar2.cpw = os.cpw;
                bVar2.pageType = qG;
                bVar2.cpq = aVar2.cpq;
                bVar2.cpp = String.valueOf(bVar.arJ());
                bVar2.cpr = z;
                bVar2.cps = cVar.aby();
                if (com.baidu.swan.apps.ad.a.a.axM()) {
                    bVar2.cpt = com.baidu.swan.apps.console.debugger.b.aex();
                }
                if (com.baidu.swan.apps.ad.a.a.pY(bVar.arM())) {
                    com.baidu.swan.apps.console.debugger.a.d.aeH().lc("pageready");
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", bVar2.toString());
                }
                i.awB().f(new UbcFlowEvent("slave_dispatch_start"));
                com.baidu.swan.apps.ak.a.aCP().ry("slave_dispatch_start");
                cVar.a(bVar2);
                ab.aFE();
                cVar.abB().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, a2);
                cVar.jd(a2);
                com.baidu.swan.apps.core.turbo.d.akC().a(cVar.abD(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
                com.baidu.swan.apps.statistic.e.cl(cVar.abD(), bVar2.cpv);
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", "app path: " + aVar2.appPath);
                    Log.d("AppLaunchMessenger", "webviewId: " + cVar.abD());
                    Log.d("AppLaunchMessenger", "pageUrl: " + a2);
                    Log.d("AppLaunchMessenger", "pagePath: " + bVar2.cpv);
                    Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar2.cpw);
                    Log.d("AppLaunchMessenger", "sConsole:" + bVar2.cpp);
                }
                a(swanAppConfigData);
                this.cnV = true;
            }
        }
    }

    private void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        com.baidu.swan.apps.core.i.a.ajS().b(swanAppConfigData);
    }

    public synchronized void reset() {
        this.cnV = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        private static final b cnW = new b();
    }
}
