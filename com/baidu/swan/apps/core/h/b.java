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
    private boolean cAl;

    private b() {
        this.cAl = false;
    }

    public static b amB() {
        return a.cAm;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.swan.apps.adaptation.b.d] */
    public synchronized void a(@NonNull com.baidu.swan.apps.core.g.a aVar, @NonNull c cVar, @NonNull com.baidu.swan.apps.u.c.b bVar, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.f fVar) {
        boolean z = true;
        synchronized (this) {
            if (DEBUG) {
                Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                Log.d("SwanPrelink", "start dispatch launch event");
            }
            if (!this.cAl) {
                String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.avu(), bVar, swanAppConfigData);
                String rs = swanAppConfigData.rs(a2);
                com.baidu.swan.apps.core.turbo.a aVar2 = new com.baidu.swan.apps.core.turbo.a();
                aVar2.appConfig = swanAppConfigData.dfo;
                swanAppConfigData.dfo = null;
                if (fVar != null && !TextUtils.isEmpty(fVar.cIX)) {
                    aVar2.appPath = fVar.cIX;
                } else {
                    aVar2.appPath = d.C0438d.bG(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                aVar2.cBC = cVar.aep();
                aVar2.pageUrl = a2;
                aVar2.cBE = String.valueOf(com.baidu.swan.apps.console.a.ahb());
                aVar2.cBF = com.baidu.swan.apps.core.turbo.a.b(e.aDa(), a2);
                aVar2.pageType = rs;
                if (!DEBUG && !f.avu().auY()) {
                    z = false;
                }
                aVar2.cBG = z;
                aVar2.cBH = cVar.aek();
                if (com.baidu.swan.apps.ad.a.a.aAx()) {
                    aVar2.cBI = com.baidu.swan.apps.console.debugger.b.ahj();
                }
                Bundle auo = bVar.auo();
                if (auo != null) {
                    String string = auo.getString("extraData");
                    if (!TextUtils.isEmpty(string)) {
                        aVar2.cBD = string;
                    }
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", aVar2.toString());
                }
                i.azm().f(new UbcFlowEvent("master_dispatch_start"));
                com.baidu.swan.apps.ak.a.aFy().sk("master_dispatch_start");
                aVar.a(aVar2);
                com.baidu.swan.apps.core.turbo.d.ann().b(com.baidu.swan.apps.core.turbo.a.b(aVar2));
                com.baidu.swan.apps.core.turbo.d.ann().eE(aVar2.cBH);
                if (com.baidu.swan.apps.ad.a.a.qK(bVar.auy())) {
                    com.baidu.swan.apps.console.debugger.a.d.ahx();
                    com.baidu.swan.apps.console.debugger.a.d.ahs().lO("appready");
                }
                com.baidu.swan.apps.runtime.config.c pe = f.avu().pe(j.sc(ai.delAllParamsFromUrl(a2)));
                com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
                if (fVar != null && !TextUtils.isEmpty(fVar.cIX)) {
                    bVar2.appPath = fVar.cIX;
                } else {
                    bVar2.appPath = d.C0438d.bG(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                bVar2.cBJ = a2;
                bVar2.cBK = pe.cBK;
                bVar2.pageType = rs;
                bVar2.cBF = aVar2.cBF;
                bVar2.cBE = String.valueOf(bVar.auv());
                bVar2.cBG = z;
                bVar2.cBH = cVar.aek();
                if (com.baidu.swan.apps.ad.a.a.aAx()) {
                    bVar2.cBI = com.baidu.swan.apps.console.debugger.b.ahi();
                }
                if (com.baidu.swan.apps.ad.a.a.qK(bVar.auy())) {
                    com.baidu.swan.apps.console.debugger.a.d.ahs().lO("pageready");
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", bVar2.toString());
                }
                i.azm().f(new UbcFlowEvent("slave_dispatch_start"));
                com.baidu.swan.apps.ak.a.aFy().sk("slave_dispatch_start");
                cVar.a(bVar2);
                ab.aIn();
                cVar.aen().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, a2);
                cVar.jP(a2);
                com.baidu.swan.apps.core.turbo.d.ann().a(cVar.aep(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
                com.baidu.swan.apps.statistic.e.cq(cVar.aep(), bVar2.cBJ);
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", "app path: " + aVar2.appPath);
                    Log.d("AppLaunchMessenger", "webviewId: " + cVar.aep());
                    Log.d("AppLaunchMessenger", "pageUrl: " + a2);
                    Log.d("AppLaunchMessenger", "pagePath: " + bVar2.cBJ);
                    Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar2.cBK);
                    Log.d("AppLaunchMessenger", "sConsole:" + bVar2.cBE);
                }
                a(swanAppConfigData);
                this.cAl = true;
            }
        }
    }

    private void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        com.baidu.swan.apps.core.i.a.amD().b(swanAppConfigData);
    }

    public synchronized void reset() {
        this.cAl = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final b cAm = new b();
    }
}
