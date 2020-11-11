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
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cOA;

    private b() {
        this.cOA = false;
    }

    public static b aqW() {
        return a.cOB;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.swan.apps.adaptation.b.d] */
    public synchronized void a(@NonNull com.baidu.swan.apps.core.g.a aVar, @NonNull c cVar, @NonNull com.baidu.swan.apps.u.c.b bVar, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.f fVar) {
        boolean z = true;
        synchronized (this) {
            if (DEBUG) {
                Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                Log.d("SwanPrelink", "start dispatch launch event");
            }
            if (!this.cOA) {
                String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.azO(), bVar, swanAppConfigData);
                String rZ = swanAppConfigData.rZ(a2);
                com.baidu.swan.apps.core.turbo.a aVar2 = new com.baidu.swan.apps.core.turbo.a();
                aVar2.appConfig = swanAppConfigData.dtL;
                swanAppConfigData.dtL = null;
                if (fVar != null && !TextUtils.isEmpty(fVar.cXm)) {
                    aVar2.appPath = fVar.cXm;
                } else {
                    aVar2.appPath = d.C0464d.bN(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                aVar2.cPR = cVar.aiJ();
                aVar2.pageUrl = a2;
                aVar2.cPT = String.valueOf(com.baidu.swan.apps.console.a.alv());
                aVar2.cPU = com.baidu.swan.apps.core.turbo.a.b(e.aHu(), a2);
                aVar2.pageType = rZ;
                if (!DEBUG && !f.azO().azs()) {
                    z = false;
                }
                aVar2.cPV = z;
                aVar2.cPW = cVar.aiE();
                if (com.baidu.swan.apps.ad.a.a.aER()) {
                    aVar2.cPX = com.baidu.swan.apps.console.debugger.b.alD();
                }
                Bundle ayI = bVar.ayI();
                if (ayI != null) {
                    String string = ayI.getString("extraData");
                    if (!TextUtils.isEmpty(string)) {
                        aVar2.cPS = string;
                    }
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", aVar2.toString());
                }
                i.aDG().f(new UbcFlowEvent("master_dispatch_start"));
                com.baidu.swan.apps.ak.a.aJS().sS("master_dispatch_start");
                aVar.a(aVar2);
                com.baidu.swan.apps.core.turbo.d.arI().b(com.baidu.swan.apps.core.turbo.a.b(aVar2));
                com.baidu.swan.apps.core.turbo.d.arI().fa(aVar2.cPW);
                if (com.baidu.swan.apps.ad.a.a.rr(bVar.ayS())) {
                    com.baidu.swan.apps.console.debugger.a.d.alR();
                    com.baidu.swan.apps.console.debugger.a.d.alM().mw("appready");
                }
                com.baidu.swan.apps.runtime.config.c pL = f.azO().pL(j.sK(ai.delAllParamsFromUrl(a2)));
                com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
                if (fVar != null && !TextUtils.isEmpty(fVar.cXm)) {
                    bVar2.appPath = fVar.cXm;
                } else {
                    bVar2.appPath = d.C0464d.bN(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                bVar2.cPY = a2;
                bVar2.cPZ = pL.cPZ;
                bVar2.pageType = rZ;
                bVar2.cPU = aVar2.cPU;
                bVar2.cPT = String.valueOf(bVar.ayP());
                bVar2.cPV = z;
                bVar2.cPW = cVar.aiE();
                if (com.baidu.swan.apps.ad.a.a.aER()) {
                    bVar2.cPX = com.baidu.swan.apps.console.debugger.b.alC();
                }
                if (com.baidu.swan.apps.ad.a.a.rr(bVar.ayS())) {
                    com.baidu.swan.apps.console.debugger.a.d.alM().mw("pageready");
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", bVar2.toString());
                }
                i.aDG().f(new UbcFlowEvent("slave_dispatch_start"));
                com.baidu.swan.apps.ak.a.aJS().sS("slave_dispatch_start");
                cVar.a(bVar2);
                ab.aMH();
                cVar.aiH().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, a2);
                cVar.kx(a2);
                com.baidu.swan.apps.core.turbo.d.arI().a(cVar.aiJ(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
                com.baidu.swan.apps.statistic.e.cx(cVar.aiJ(), bVar2.cPY);
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", "app path: " + aVar2.appPath);
                    Log.d("AppLaunchMessenger", "webviewId: " + cVar.aiJ());
                    Log.d("AppLaunchMessenger", "pageUrl: " + a2);
                    Log.d("AppLaunchMessenger", "pagePath: " + bVar2.cPY);
                    Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar2.cPZ);
                    Log.d("AppLaunchMessenger", "sConsole:" + bVar2.cPT);
                }
                a(swanAppConfigData);
                this.cOA = true;
            }
        }
    }

    private void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        com.baidu.swan.apps.core.i.a.aqY().b(swanAppConfigData);
    }

    public synchronized void reset() {
        this.cOA = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final b cOB = new b();
    }
}
