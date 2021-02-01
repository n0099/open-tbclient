package com.baidu.swan.apps.core.h;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.ao.ab;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.swan.apps.v.f;
import java.io.File;
/* loaded from: classes9.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cWg;

    private b() {
        this.cWg = false;
    }

    public static b arr() {
        return a.cWh;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.swan.apps.adaptation.b.d] */
    public synchronized void a(@NonNull com.baidu.swan.apps.core.g.a aVar, @NonNull c cVar, @NonNull com.baidu.swan.apps.u.c.b bVar, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.f fVar) {
        boolean z = true;
        synchronized (this) {
            if (DEBUG) {
                Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                Log.d("SwanPrelink", "start dispatch launch event");
            }
            if (!this.cWg) {
                String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.aAl(), bVar, swanAppConfigData);
                String rF = swanAppConfigData.rF(a2);
                com.baidu.swan.apps.core.turbo.a aVar2 = new com.baidu.swan.apps.core.turbo.a();
                aVar2.appConfig = swanAppConfigData.dFa;
                swanAppConfigData.dFa = null;
                if (fVar != null && !TextUtils.isEmpty(fVar.deR)) {
                    aVar2.appPath = fVar.deR;
                } else {
                    aVar2.appPath = d.C0446d.bL(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                aVar2.cXx = cVar.aiY();
                aVar2.pageUrl = a2;
                aVar2.cXy = String.valueOf(com.baidu.swan.apps.console.a.alL());
                aVar2.cXz = com.baidu.swan.apps.core.turbo.a.b(e.aIK(), a2);
                aVar2.pageType = rF;
                if (!DEBUG && !f.aAl().azP()) {
                    z = false;
                }
                aVar2.cXA = z;
                aVar2.cXB = cVar.aiT();
                if (com.baidu.swan.apps.ad.a.a.aFm()) {
                    aVar2.cXC = com.baidu.swan.apps.console.debugger.b.alU();
                }
                Bundle azf = bVar.azf();
                if (azf != null) {
                    String string = azf.getString("extraData");
                    if (!TextUtils.isEmpty(string)) {
                        aVar2.extraData = string;
                    }
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", aVar2.toString());
                }
                i.aEb().f(new UbcFlowEvent("master_dispatch_start"));
                com.baidu.swan.apps.aj.a.aLi().sz("master_dispatch_start");
                aVar.a(aVar2);
                com.baidu.swan.apps.core.turbo.d.ase().b(com.baidu.swan.apps.core.turbo.a.b(aVar2));
                com.baidu.swan.apps.core.turbo.d.ase().fz(aVar2.cXB);
                if (com.baidu.swan.apps.ad.a.a.qS(bVar.azp())) {
                    com.baidu.swan.apps.console.debugger.a.d.ami();
                    com.baidu.swan.apps.console.debugger.a.d.amd().lX("appready");
                }
                com.baidu.swan.apps.runtime.config.c pm = f.aAl().pm(j.sq(ai.delAllParamsFromUrl(a2)));
                com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
                if (fVar != null && !TextUtils.isEmpty(fVar.deR)) {
                    bVar2.appPath = fVar.deR;
                } else {
                    bVar2.appPath = d.C0446d.bL(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                bVar2.cXD = a2;
                bVar2.cXE = pm.cXE;
                bVar2.pageType = rF;
                bVar2.cXz = aVar2.cXz;
                bVar2.cXy = String.valueOf(bVar.azm());
                bVar2.cXA = z;
                bVar2.cXB = cVar.aiT();
                if (com.baidu.swan.apps.ad.a.a.aFm()) {
                    bVar2.cXC = com.baidu.swan.apps.console.debugger.b.alT();
                }
                if (com.baidu.swan.apps.ad.a.a.qS(bVar.azp())) {
                    com.baidu.swan.apps.console.debugger.a.d.amd().lX("pageready");
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", bVar2.toString());
                }
                i.aEb().f(new UbcFlowEvent("slave_dispatch_start"));
                com.baidu.swan.apps.aj.a.aLi().sz("slave_dispatch_start");
                cVar.a(bVar2);
                ab.aNX();
                cVar.aiW().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, a2);
                cVar.jY(a2);
                com.baidu.swan.apps.core.turbo.d.ase().a(cVar.aiY(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
                com.baidu.swan.apps.statistic.e.cv(cVar.aiY(), bVar2.cXD);
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", "app path: " + aVar2.appPath);
                    Log.d("AppLaunchMessenger", "webviewId: " + cVar.aiY());
                    Log.d("AppLaunchMessenger", "pageUrl: " + a2);
                    Log.d("AppLaunchMessenger", "pagePath: " + bVar2.cXD);
                    Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar2.cXE);
                    Log.d("AppLaunchMessenger", "sConsole:" + bVar2.cXy);
                }
                a(swanAppConfigData);
                this.cWg = true;
            }
        }
    }

    private void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        com.baidu.swan.apps.core.i.a.art().b(swanAppConfigData);
    }

    public synchronized void reset() {
        this.cWg = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static final b cWh = new b();
    }
}
