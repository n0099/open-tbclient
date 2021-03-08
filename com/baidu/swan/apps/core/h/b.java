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
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cXG;

    private b() {
        this.cXG = false;
    }

    public static b aru() {
        return a.cXH;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.swan.apps.adaptation.b.d] */
    public synchronized void a(@NonNull com.baidu.swan.apps.core.g.a aVar, @NonNull c cVar, @NonNull com.baidu.swan.apps.u.c.b bVar, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.f fVar) {
        boolean z = true;
        synchronized (this) {
            if (DEBUG) {
                Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                Log.d("SwanPrelink", "start dispatch launch event");
            }
            if (!this.cXG) {
                String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.aAo(), bVar, swanAppConfigData);
                String rM = swanAppConfigData.rM(a2);
                com.baidu.swan.apps.core.turbo.a aVar2 = new com.baidu.swan.apps.core.turbo.a();
                aVar2.appConfig = swanAppConfigData.dGB;
                swanAppConfigData.dGB = null;
                if (fVar != null && !TextUtils.isEmpty(fVar.dgs)) {
                    aVar2.appPath = fVar.dgs;
                } else {
                    aVar2.appPath = d.C0452d.bL(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                aVar2.cYX = cVar.ajb();
                aVar2.pageUrl = a2;
                aVar2.cYY = String.valueOf(com.baidu.swan.apps.console.a.alO());
                aVar2.cYZ = com.baidu.swan.apps.core.turbo.a.b(e.aIN(), a2);
                aVar2.pageType = rM;
                if (!DEBUG && !f.aAo().azS()) {
                    z = false;
                }
                aVar2.cZa = z;
                aVar2.cZb = cVar.aiW();
                if (com.baidu.swan.apps.ad.a.a.aFp()) {
                    aVar2.cZc = com.baidu.swan.apps.console.debugger.b.alX();
                }
                Bundle azi = bVar.azi();
                if (azi != null) {
                    String string = azi.getString("extraData");
                    if (!TextUtils.isEmpty(string)) {
                        aVar2.extraData = string;
                    }
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", aVar2.toString());
                }
                i.aEe().f(new UbcFlowEvent("master_dispatch_start"));
                com.baidu.swan.apps.aj.a.aLl().sG("master_dispatch_start");
                aVar.a(aVar2);
                com.baidu.swan.apps.core.turbo.d.ash().b(com.baidu.swan.apps.core.turbo.a.b(aVar2));
                com.baidu.swan.apps.core.turbo.d.ash().fz(aVar2.cZb);
                if (com.baidu.swan.apps.ad.a.a.qZ(bVar.azs())) {
                    com.baidu.swan.apps.console.debugger.a.d.aml();
                    com.baidu.swan.apps.console.debugger.a.d.amg().me("appready");
                }
                com.baidu.swan.apps.runtime.config.c pt = f.aAo().pt(j.sy(ai.delAllParamsFromUrl(a2)));
                com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
                if (fVar != null && !TextUtils.isEmpty(fVar.dgs)) {
                    bVar2.appPath = fVar.dgs;
                } else {
                    bVar2.appPath = d.C0452d.bL(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                bVar2.cZd = a2;
                bVar2.cZe = pt.cZe;
                bVar2.pageType = rM;
                bVar2.cYZ = aVar2.cYZ;
                bVar2.cYY = String.valueOf(bVar.azp());
                bVar2.cZa = z;
                bVar2.cZb = cVar.aiW();
                if (com.baidu.swan.apps.ad.a.a.aFp()) {
                    bVar2.cZc = com.baidu.swan.apps.console.debugger.b.alW();
                }
                if (com.baidu.swan.apps.ad.a.a.qZ(bVar.azs())) {
                    com.baidu.swan.apps.console.debugger.a.d.amg().me("pageready");
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", bVar2.toString());
                }
                i.aEe().f(new UbcFlowEvent("slave_dispatch_start"));
                com.baidu.swan.apps.aj.a.aLl().sG("slave_dispatch_start");
                cVar.a(bVar2);
                ab.aOa();
                cVar.aiZ().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, a2);
                cVar.kf(a2);
                com.baidu.swan.apps.core.turbo.d.ash().a(cVar.ajb(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
                com.baidu.swan.apps.statistic.e.cv(cVar.ajb(), bVar2.cZd);
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", "app path: " + aVar2.appPath);
                    Log.d("AppLaunchMessenger", "webviewId: " + cVar.ajb());
                    Log.d("AppLaunchMessenger", "pageUrl: " + a2);
                    Log.d("AppLaunchMessenger", "pagePath: " + bVar2.cZd);
                    Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar2.cZe);
                    Log.d("AppLaunchMessenger", "sConsole:" + bVar2.cYY);
                }
                a(swanAppConfigData);
                this.cXG = true;
            }
        }
    }

    private void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        com.baidu.swan.apps.core.i.a.arw().b(swanAppConfigData);
    }

    public synchronized void reset() {
        this.cXG = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final b cXH = new b();
    }
}
