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
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean clO;

    private b() {
        this.clO = false;
    }

    public static b ajg() {
        return a.clP;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.swan.apps.adaptation.b.d] */
    public synchronized void a(@NonNull com.baidu.swan.apps.core.g.a aVar, @NonNull c cVar, @NonNull com.baidu.swan.apps.u.c.b bVar, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.f fVar) {
        boolean z = true;
        synchronized (this) {
            if (DEBUG) {
                Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                Log.d("SwanPrelink", "start dispatch launch event");
            }
            if (!this.clO) {
                String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.arY(), bVar, swanAppConfigData);
                String qm = swanAppConfigData.qm(a2);
                com.baidu.swan.apps.core.turbo.a aVar2 = new com.baidu.swan.apps.core.turbo.a();
                aVar2.appConfig = swanAppConfigData.cRc;
                swanAppConfigData.cRc = null;
                if (fVar != null && !TextUtils.isEmpty(fVar.cuN)) {
                    aVar2.appPath = fVar.cuN;
                } else {
                    aVar2.appPath = d.C0426d.bB(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                aVar2.cng = cVar.aaU();
                aVar2.pageUrl = a2;
                aVar2.cni = String.valueOf(com.baidu.swan.apps.console.a.adG());
                aVar2.cnj = com.baidu.swan.apps.core.turbo.a.b(e.azI(), a2);
                aVar2.pageType = qm;
                if (!DEBUG && !f.arY().arC()) {
                    z = false;
                }
                aVar2.cnk = z;
                aVar2.cnl = cVar.aaP();
                if (com.baidu.swan.apps.ad.a.a.axd()) {
                    aVar2.cnm = com.baidu.swan.apps.console.debugger.b.adO();
                }
                Bundle aqS = bVar.aqS();
                if (aqS != null) {
                    String string = aqS.getString("extraData");
                    if (!TextUtils.isEmpty(string)) {
                        aVar2.cnh = string;
                    }
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", aVar2.toString());
                }
                i.avS().f(new UbcFlowEvent("master_dispatch_start"));
                com.baidu.swan.apps.ak.a.aCf().re("master_dispatch_start");
                aVar.a(aVar2);
                com.baidu.swan.apps.core.turbo.d.ajS().b(com.baidu.swan.apps.core.turbo.a.b(aVar2));
                com.baidu.swan.apps.core.turbo.d.ajS().ej(aVar2.cnl);
                if (com.baidu.swan.apps.ad.a.a.pE(bVar.arc())) {
                    com.baidu.swan.apps.console.debugger.a.d.aec();
                    com.baidu.swan.apps.console.debugger.a.d.adX().kI("appready");
                }
                com.baidu.swan.apps.runtime.config.c nW = f.arY().nW(j.qW(ai.delAllParamsFromUrl(a2)));
                com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
                if (fVar != null && !TextUtils.isEmpty(fVar.cuN)) {
                    bVar2.appPath = fVar.cuN;
                } else {
                    bVar2.appPath = d.C0426d.bB(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                bVar2.cnn = a2;
                bVar2.cno = nW.cno;
                bVar2.pageType = qm;
                bVar2.cnj = aVar2.cnj;
                bVar2.cni = String.valueOf(bVar.aqZ());
                bVar2.cnk = z;
                bVar2.cnl = cVar.aaP();
                if (com.baidu.swan.apps.ad.a.a.axd()) {
                    bVar2.cnm = com.baidu.swan.apps.console.debugger.b.adN();
                }
                if (com.baidu.swan.apps.ad.a.a.pE(bVar.arc())) {
                    com.baidu.swan.apps.console.debugger.a.d.adX().kI("pageready");
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", bVar2.toString());
                }
                i.avS().f(new UbcFlowEvent("slave_dispatch_start"));
                com.baidu.swan.apps.ak.a.aCf().re("slave_dispatch_start");
                cVar.a(bVar2);
                ab.aEU();
                cVar.aaS().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, a2);
                cVar.iJ(a2);
                com.baidu.swan.apps.core.turbo.d.ajS().a(cVar.aaU(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
                com.baidu.swan.apps.statistic.e.cl(cVar.aaU(), bVar2.cnn);
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", "app path: " + aVar2.appPath);
                    Log.d("AppLaunchMessenger", "webviewId: " + cVar.aaU());
                    Log.d("AppLaunchMessenger", "pageUrl: " + a2);
                    Log.d("AppLaunchMessenger", "pagePath: " + bVar2.cnn);
                    Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar2.cno);
                    Log.d("AppLaunchMessenger", "sConsole:" + bVar2.cni);
                }
                a(swanAppConfigData);
                this.clO = true;
            }
        }
    }

    private void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        com.baidu.swan.apps.core.i.a.aji().b(swanAppConfigData);
    }

    public synchronized void reset() {
        this.clO = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final b clP = new b();
    }
}
