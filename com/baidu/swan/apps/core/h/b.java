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
    private boolean cTT;

    private b() {
        this.cTT = false;
    }

    public static b aqT() {
        return a.cTU;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.swan.apps.adaptation.b.d] */
    public synchronized void a(@NonNull com.baidu.swan.apps.core.g.a aVar, @NonNull c cVar, @NonNull com.baidu.swan.apps.u.c.b bVar, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.f fVar) {
        boolean z = true;
        synchronized (this) {
            if (DEBUG) {
                Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                Log.d("SwanPrelink", "start dispatch launch event");
            }
            if (!this.cTT) {
                String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.azN(), bVar, swanAppConfigData);
                String rm = swanAppConfigData.rm(a2);
                com.baidu.swan.apps.core.turbo.a aVar2 = new com.baidu.swan.apps.core.turbo.a();
                aVar2.appConfig = swanAppConfigData.dCW;
                swanAppConfigData.dCW = null;
                if (fVar != null && !TextUtils.isEmpty(fVar.dcE)) {
                    aVar2.appPath = fVar.dcE;
                } else {
                    aVar2.appPath = d.C0449d.bR(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                aVar2.cVk = cVar.aiA();
                aVar2.pageUrl = a2;
                aVar2.cVm = String.valueOf(com.baidu.swan.apps.console.a.aln());
                aVar2.cVn = com.baidu.swan.apps.core.turbo.a.b(e.aIr(), a2);
                aVar2.pageType = rm;
                if (!DEBUG && !f.azN().azr()) {
                    z = false;
                }
                aVar2.cVo = z;
                aVar2.cVp = cVar.aiv();
                if (com.baidu.swan.apps.ad.a.a.aER()) {
                    aVar2.cVq = com.baidu.swan.apps.console.debugger.b.alw();
                }
                Bundle ayH = bVar.ayH();
                if (ayH != null) {
                    String string = ayH.getString("extraData");
                    if (!TextUtils.isEmpty(string)) {
                        aVar2.cVl = string;
                    }
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", aVar2.toString());
                }
                i.aDG().f(new UbcFlowEvent("master_dispatch_start"));
                com.baidu.swan.apps.aj.a.aKP().sf("master_dispatch_start");
                aVar.a(aVar2);
                com.baidu.swan.apps.core.turbo.d.arG().b(com.baidu.swan.apps.core.turbo.a.b(aVar2));
                com.baidu.swan.apps.core.turbo.d.arG().fx(aVar2.cVp);
                if (com.baidu.swan.apps.ad.a.a.qA(bVar.ayR())) {
                    com.baidu.swan.apps.console.debugger.a.d.alK();
                    com.baidu.swan.apps.console.debugger.a.d.alF().lF("appready");
                }
                com.baidu.swan.apps.runtime.config.c oU = f.azN().oU(j.rX(ai.delAllParamsFromUrl(a2)));
                com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
                if (fVar != null && !TextUtils.isEmpty(fVar.dcE)) {
                    bVar2.appPath = fVar.dcE;
                } else {
                    bVar2.appPath = d.C0449d.bR(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                bVar2.cVr = a2;
                bVar2.cVs = oU.cVs;
                bVar2.pageType = rm;
                bVar2.cVn = aVar2.cVn;
                bVar2.cVm = String.valueOf(bVar.ayO());
                bVar2.cVo = z;
                bVar2.cVp = cVar.aiv();
                if (com.baidu.swan.apps.ad.a.a.aER()) {
                    bVar2.cVq = com.baidu.swan.apps.console.debugger.b.alv();
                }
                if (com.baidu.swan.apps.ad.a.a.qA(bVar.ayR())) {
                    com.baidu.swan.apps.console.debugger.a.d.alF().lF("pageready");
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", bVar2.toString());
                }
                i.aDG().f(new UbcFlowEvent("slave_dispatch_start"));
                com.baidu.swan.apps.aj.a.aKP().sf("slave_dispatch_start");
                cVar.a(bVar2);
                ab.aNE();
                cVar.aiy().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, a2);
                cVar.jG(a2);
                com.baidu.swan.apps.core.turbo.d.arG().a(cVar.aiA(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
                com.baidu.swan.apps.statistic.e.cB(cVar.aiA(), bVar2.cVr);
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", "app path: " + aVar2.appPath);
                    Log.d("AppLaunchMessenger", "webviewId: " + cVar.aiA());
                    Log.d("AppLaunchMessenger", "pageUrl: " + a2);
                    Log.d("AppLaunchMessenger", "pagePath: " + bVar2.cVr);
                    Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar2.cVs);
                    Log.d("AppLaunchMessenger", "sConsole:" + bVar2.cVm);
                }
                a(swanAppConfigData);
                this.cTT = true;
            }
        }
    }

    private void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        com.baidu.swan.apps.core.i.a.aqV().b(swanAppConfigData);
    }

    public synchronized void reset() {
        this.cTT = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final b cTU = new b();
    }
}
