package com.baidu.swan.apps.core.h;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.aq.z;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.swan.apps.w.f;
import java.io.File;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cdQ;

    private b() {
        this.cdQ = false;
    }

    public static b abF() {
        return a.cdR;
    }

    public synchronized void a(@NonNull com.baidu.swan.apps.core.g.a aVar, @NonNull c cVar, @NonNull com.baidu.swan.apps.v.b.b bVar, @NonNull SwanAppConfigData swanAppConfigData, @Nullable e.f fVar) {
        boolean z = true;
        synchronized (this) {
            if (DEBUG) {
                Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                Log.d("SwanPrelink", "start dispatch launch event");
            }
            if (!this.cdQ) {
                String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.ajb(), bVar, swanAppConfigData);
                String nH = swanAppConfigData.nH(a2);
                com.baidu.swan.apps.core.turbo.a aVar2 = new com.baidu.swan.apps.core.turbo.a();
                aVar2.appConfig = swanAppConfigData.cFn;
                swanAppConfigData.cFn = null;
                if (fVar != null && !TextUtils.isEmpty(fVar.clg)) {
                    aVar2.appPath = fVar.clg;
                } else {
                    aVar2.appPath = e.d.bm(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                aVar2.cfg = cVar.Up();
                aVar2.cfh = a2;
                aVar2.cfj = String.valueOf(com.baidu.swan.apps.console.a.WU());
                aVar2.cfk = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.apM(), a2);
                aVar2.pageType = nH;
                if (!DEBUG && !f.ajb().aiF()) {
                    z = false;
                }
                aVar2.cfl = z;
                aVar2.cfm = cVar.Ul();
                if (com.baidu.swan.apps.af.a.a.anx()) {
                    aVar2.cfn = com.baidu.swan.apps.console.debugger.b.Xc();
                }
                Bundle ahV = bVar.ahV();
                if (ahV != null) {
                    String string = ahV.getString("extraData");
                    if (!TextUtils.isEmpty(string)) {
                        aVar2.cfi = string;
                    }
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", aVar2.toString());
                }
                g.amD().f(new UbcFlowEvent("master_dispatch_start"));
                com.baidu.swan.apps.al.a.arZ().ow("master_dispatch_start");
                aVar.a(aVar2);
                d.acr().a(com.baidu.swan.apps.core.turbo.a.b(aVar2));
                d.acr().dS(aVar2.cfm);
                if (com.baidu.swan.apps.af.a.a.mZ(bVar.aif())) {
                    com.baidu.swan.apps.console.debugger.a.d.Xq();
                    com.baidu.swan.apps.console.debugger.a.d.Xl().iY("appready");
                }
                com.baidu.swan.apps.runtime.config.c ly = f.ajb().ly(j.oq(ah.delAllParamsFromUrl(a2)));
                com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
                if (fVar != null && !TextUtils.isEmpty(fVar.clg)) {
                    bVar2.appPath = fVar.clg;
                } else {
                    bVar2.appPath = e.d.bm(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                bVar2.cfo = a2;
                bVar2.cfp = ly.cfp;
                bVar2.pageType = nH;
                bVar2.cfk = aVar2.cfk;
                bVar2.cfj = String.valueOf(bVar.aic());
                bVar2.cfl = z;
                bVar2.cfm = cVar.Ul();
                if (com.baidu.swan.apps.af.a.a.anx()) {
                    bVar2.cfn = com.baidu.swan.apps.console.debugger.b.Xb();
                }
                if (com.baidu.swan.apps.af.a.a.mZ(bVar.aif())) {
                    com.baidu.swan.apps.console.debugger.a.d.Xl().iY("pageready");
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", bVar2.toString());
                }
                g.amD().f(new UbcFlowEvent("slave_dispatch_start"));
                com.baidu.swan.apps.al.a.arZ().ow("slave_dispatch_start");
                cVar.a(bVar2);
                z.auI();
                d.acr().a(cVar.Up(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
                com.baidu.swan.apps.statistic.e.bT(cVar.Up(), bVar2.cfo);
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", "app path: " + aVar2.appPath);
                    Log.d("AppLaunchMessenger", "webviewId: " + cVar.Up());
                    Log.d("AppLaunchMessenger", "pageUrl: " + a2);
                    Log.d("AppLaunchMessenger", "pagePath: " + bVar2.cfo);
                    Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar2.cfp);
                    Log.d("AppLaunchMessenger", "sConsole:" + bVar2.cfj);
                }
                a(swanAppConfigData);
                this.cdQ = true;
            }
        }
    }

    private void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        com.baidu.swan.apps.core.i.a.abH().b(swanAppConfigData);
    }

    public synchronized void reset() {
        this.cdQ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final b cdR = new b();
    }
}
