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
/* loaded from: classes7.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cMQ;

    private b() {
        this.cMQ = false;
    }

    public static b aqo() {
        return a.cMR;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.swan.apps.adaptation.b.d] */
    public synchronized void a(@NonNull com.baidu.swan.apps.core.g.a aVar, @NonNull c cVar, @NonNull com.baidu.swan.apps.u.c.b bVar, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.f fVar) {
        boolean z = true;
        synchronized (this) {
            if (DEBUG) {
                Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                Log.d("SwanPrelink", "start dispatch launch event");
            }
            if (!this.cMQ) {
                String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.azg(), bVar, swanAppConfigData);
                String rT = swanAppConfigData.rT(a2);
                com.baidu.swan.apps.core.turbo.a aVar2 = new com.baidu.swan.apps.core.turbo.a();
                aVar2.appConfig = swanAppConfigData.dsc;
                swanAppConfigData.dsc = null;
                if (fVar != null && !TextUtils.isEmpty(fVar.cVC)) {
                    aVar2.appPath = fVar.cVC;
                } else {
                    aVar2.appPath = d.C0462d.bM(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                aVar2.cOh = cVar.aib();
                aVar2.pageUrl = a2;
                aVar2.cOj = String.valueOf(com.baidu.swan.apps.console.a.akN());
                aVar2.cOk = com.baidu.swan.apps.core.turbo.a.b(e.aGM(), a2);
                aVar2.pageType = rT;
                if (!DEBUG && !f.azg().ayK()) {
                    z = false;
                }
                aVar2.cOl = z;
                aVar2.cOm = cVar.ahW();
                if (com.baidu.swan.apps.ad.a.a.aEj()) {
                    aVar2.cOn = com.baidu.swan.apps.console.debugger.b.akV();
                }
                Bundle aya = bVar.aya();
                if (aya != null) {
                    String string = aya.getString("extraData");
                    if (!TextUtils.isEmpty(string)) {
                        aVar2.cOi = string;
                    }
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", aVar2.toString());
                }
                i.aCY().f(new UbcFlowEvent("master_dispatch_start"));
                com.baidu.swan.apps.ak.a.aJk().sN("master_dispatch_start");
                aVar.a(aVar2);
                com.baidu.swan.apps.core.turbo.d.ara().b(com.baidu.swan.apps.core.turbo.a.b(aVar2));
                com.baidu.swan.apps.core.turbo.d.ara().fd(aVar2.cOm);
                if (com.baidu.swan.apps.ad.a.a.rl(bVar.ayk())) {
                    com.baidu.swan.apps.console.debugger.a.d.alj();
                    com.baidu.swan.apps.console.debugger.a.d.ale().mq("appready");
                }
                com.baidu.swan.apps.runtime.config.c pF = f.azg().pF(j.sF(ai.delAllParamsFromUrl(a2)));
                com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
                if (fVar != null && !TextUtils.isEmpty(fVar.cVC)) {
                    bVar2.appPath = fVar.cVC;
                } else {
                    bVar2.appPath = d.C0462d.bM(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                bVar2.cOo = a2;
                bVar2.cOp = pF.cOp;
                bVar2.pageType = rT;
                bVar2.cOk = aVar2.cOk;
                bVar2.cOj = String.valueOf(bVar.ayh());
                bVar2.cOl = z;
                bVar2.cOm = cVar.ahW();
                if (com.baidu.swan.apps.ad.a.a.aEj()) {
                    bVar2.cOn = com.baidu.swan.apps.console.debugger.b.akU();
                }
                if (com.baidu.swan.apps.ad.a.a.rl(bVar.ayk())) {
                    com.baidu.swan.apps.console.debugger.a.d.ale().mq("pageready");
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", bVar2.toString());
                }
                i.aCY().f(new UbcFlowEvent("slave_dispatch_start"));
                com.baidu.swan.apps.ak.a.aJk().sN("slave_dispatch_start");
                cVar.a(bVar2);
                ab.aLZ();
                cVar.ahZ().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, a2);
                cVar.kr(a2);
                com.baidu.swan.apps.core.turbo.d.ara().a(cVar.aib(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
                com.baidu.swan.apps.statistic.e.cw(cVar.aib(), bVar2.cOo);
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", "app path: " + aVar2.appPath);
                    Log.d("AppLaunchMessenger", "webviewId: " + cVar.aib());
                    Log.d("AppLaunchMessenger", "pageUrl: " + a2);
                    Log.d("AppLaunchMessenger", "pagePath: " + bVar2.cOo);
                    Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar2.cOp);
                    Log.d("AppLaunchMessenger", "sConsole:" + bVar2.cOj);
                }
                a(swanAppConfigData);
                this.cMQ = true;
            }
        }
    }

    private void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        com.baidu.swan.apps.core.i.a.aqq().b(swanAppConfigData);
    }

    public synchronized void reset() {
        this.cMQ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private static final b cMR = new b();
    }
}
