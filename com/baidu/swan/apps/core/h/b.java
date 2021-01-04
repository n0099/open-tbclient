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
    private boolean cYF;

    private b() {
        this.cYF = false;
    }

    public static b auN() {
        return a.cYG;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.swan.apps.adaptation.b.d] */
    public synchronized void a(@NonNull com.baidu.swan.apps.core.g.a aVar, @NonNull c cVar, @NonNull com.baidu.swan.apps.u.c.b bVar, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.f fVar) {
        boolean z = true;
        synchronized (this) {
            if (DEBUG) {
                Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                Log.d("SwanPrelink", "start dispatch launch event");
            }
            if (!this.cYF) {
                String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.aDG(), bVar, swanAppConfigData);
                String sy = swanAppConfigData.sy(a2);
                com.baidu.swan.apps.core.turbo.a aVar2 = new com.baidu.swan.apps.core.turbo.a();
                aVar2.appConfig = swanAppConfigData.dHI;
                swanAppConfigData.dHI = null;
                if (fVar != null && !TextUtils.isEmpty(fVar.dhs)) {
                    aVar2.appPath = fVar.dhs;
                } else {
                    aVar2.appPath = d.C0466d.bS(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                aVar2.cZW = cVar.amt();
                aVar2.pageUrl = a2;
                aVar2.cZY = String.valueOf(com.baidu.swan.apps.console.a.apg());
                aVar2.cZZ = com.baidu.swan.apps.core.turbo.a.b(e.aMk(), a2);
                aVar2.pageType = sy;
                if (!DEBUG && !f.aDG().aDk()) {
                    z = false;
                }
                aVar2.daa = z;
                aVar2.dab = cVar.amo();
                if (com.baidu.swan.apps.ad.a.a.aIK()) {
                    aVar2.dac = com.baidu.swan.apps.console.debugger.b.apq();
                }
                Bundle aCA = bVar.aCA();
                if (aCA != null) {
                    String string = aCA.getString("extraData");
                    if (!TextUtils.isEmpty(string)) {
                        aVar2.cZX = string;
                    }
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", aVar2.toString());
                }
                i.aHz().f(new UbcFlowEvent("master_dispatch_start"));
                com.baidu.swan.apps.aj.a.aOI().tr("master_dispatch_start");
                aVar.a(aVar2);
                com.baidu.swan.apps.core.turbo.d.avA().b(com.baidu.swan.apps.core.turbo.a.b(aVar2));
                com.baidu.swan.apps.core.turbo.d.avA().fB(aVar2.dab);
                if (com.baidu.swan.apps.ad.a.a.rL(bVar.aCK())) {
                    com.baidu.swan.apps.console.debugger.a.d.apE();
                    com.baidu.swan.apps.console.debugger.a.d.apz().mQ("appready");
                }
                com.baidu.swan.apps.runtime.config.c qf = f.aDG().qf(j.tj(ai.delAllParamsFromUrl(a2)));
                com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
                if (fVar != null && !TextUtils.isEmpty(fVar.dhs)) {
                    bVar2.appPath = fVar.dhs;
                } else {
                    bVar2.appPath = d.C0466d.bS(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                bVar2.dad = a2;
                bVar2.dae = qf.dae;
                bVar2.pageType = sy;
                bVar2.cZZ = aVar2.cZZ;
                bVar2.cZY = String.valueOf(bVar.aCH());
                bVar2.daa = z;
                bVar2.dab = cVar.amo();
                if (com.baidu.swan.apps.ad.a.a.aIK()) {
                    bVar2.dac = com.baidu.swan.apps.console.debugger.b.app();
                }
                if (com.baidu.swan.apps.ad.a.a.rL(bVar.aCK())) {
                    com.baidu.swan.apps.console.debugger.a.d.apz().mQ("pageready");
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", bVar2.toString());
                }
                i.aHz().f(new UbcFlowEvent("slave_dispatch_start"));
                com.baidu.swan.apps.aj.a.aOI().tr("slave_dispatch_start");
                cVar.a(bVar2);
                ab.aRx();
                cVar.amr().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, a2);
                cVar.kR(a2);
                com.baidu.swan.apps.core.turbo.d.avA().a(cVar.amt(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
                com.baidu.swan.apps.statistic.e.cC(cVar.amt(), bVar2.dad);
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", "app path: " + aVar2.appPath);
                    Log.d("AppLaunchMessenger", "webviewId: " + cVar.amt());
                    Log.d("AppLaunchMessenger", "pageUrl: " + a2);
                    Log.d("AppLaunchMessenger", "pagePath: " + bVar2.dad);
                    Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar2.dae);
                    Log.d("AppLaunchMessenger", "sConsole:" + bVar2.cZY);
                }
                a(swanAppConfigData);
                this.cYF = true;
            }
        }
    }

    private void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        com.baidu.swan.apps.core.i.a.auP().b(swanAppConfigData);
    }

    public synchronized void reset() {
        this.cYF = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static final b cYG = new b();
    }
}
