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
/* loaded from: classes25.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean cTJ;

    private b() {
        this.cTJ = false;
    }

    public static b atw() {
        return a.cTK;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.swan.apps.adaptation.b.d] */
    public synchronized void a(@NonNull com.baidu.swan.apps.core.g.a aVar, @NonNull c cVar, @NonNull com.baidu.swan.apps.u.c.b bVar, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.f fVar) {
        boolean z = true;
        synchronized (this) {
            if (DEBUG) {
                Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                Log.d("SwanPrelink", "start dispatch launch event");
            }
            if (!this.cTJ) {
                String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.aCp(), bVar, swanAppConfigData);
                String sB = swanAppConfigData.sB(a2);
                com.baidu.swan.apps.core.turbo.a aVar2 = new com.baidu.swan.apps.core.turbo.a();
                aVar2.appConfig = swanAppConfigData.dzd;
                swanAppConfigData.dzd = null;
                if (fVar != null && !TextUtils.isEmpty(fVar.dcz)) {
                    aVar2.appPath = fVar.dcz;
                } else {
                    aVar2.appPath = d.C0474d.bT(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                aVar2.cVa = cVar.alj();
                aVar2.pageUrl = a2;
                aVar2.cVc = String.valueOf(com.baidu.swan.apps.console.a.anV());
                aVar2.cVd = com.baidu.swan.apps.core.turbo.a.b(e.aJU(), a2);
                aVar2.pageType = sB;
                if (!DEBUG && !f.aCp().aBT()) {
                    z = false;
                }
                aVar2.cVe = z;
                aVar2.cVf = cVar.ale();
                if (com.baidu.swan.apps.ad.a.a.aHr()) {
                    aVar2.cVg = com.baidu.swan.apps.console.debugger.b.aod();
                }
                Bundle aBj = bVar.aBj();
                if (aBj != null) {
                    String string = aBj.getString("extraData");
                    if (!TextUtils.isEmpty(string)) {
                        aVar2.cVb = string;
                    }
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", aVar2.toString());
                }
                i.aGg().f(new UbcFlowEvent("master_dispatch_start"));
                com.baidu.swan.apps.ak.a.aMs().tu("master_dispatch_start");
                aVar.a(aVar2);
                com.baidu.swan.apps.core.turbo.d.aui().b(com.baidu.swan.apps.core.turbo.a.b(aVar2));
                com.baidu.swan.apps.core.turbo.d.aui().fs(aVar2.cVf);
                if (com.baidu.swan.apps.ad.a.a.rS(bVar.aBt())) {
                    com.baidu.swan.apps.console.debugger.a.d.aor();
                    com.baidu.swan.apps.console.debugger.a.d.aom().mX("appready");
                }
                com.baidu.swan.apps.runtime.config.c qm = f.aCp().qm(j.tm(ai.delAllParamsFromUrl(a2)));
                com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
                if (fVar != null && !TextUtils.isEmpty(fVar.dcz)) {
                    bVar2.appPath = fVar.dcz;
                } else {
                    bVar2.appPath = d.C0474d.bT(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                bVar2.cVh = a2;
                bVar2.cVi = qm.cVi;
                bVar2.pageType = sB;
                bVar2.cVd = aVar2.cVd;
                bVar2.cVc = String.valueOf(bVar.aBq());
                bVar2.cVe = z;
                bVar2.cVf = cVar.ale();
                if (com.baidu.swan.apps.ad.a.a.aHr()) {
                    bVar2.cVg = com.baidu.swan.apps.console.debugger.b.aoc();
                }
                if (com.baidu.swan.apps.ad.a.a.rS(bVar.aBt())) {
                    com.baidu.swan.apps.console.debugger.a.d.aom().mX("pageready");
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", bVar2.toString());
                }
                i.aGg().f(new UbcFlowEvent("slave_dispatch_start"));
                com.baidu.swan.apps.ak.a.aMs().tu("slave_dispatch_start");
                cVar.a(bVar2);
                ab.aPg();
                cVar.alh().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, a2);
                cVar.kY(a2);
                com.baidu.swan.apps.core.turbo.d.aui().a(cVar.alj(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
                com.baidu.swan.apps.statistic.e.cD(cVar.alj(), bVar2.cVh);
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", "app path: " + aVar2.appPath);
                    Log.d("AppLaunchMessenger", "webviewId: " + cVar.alj());
                    Log.d("AppLaunchMessenger", "pageUrl: " + a2);
                    Log.d("AppLaunchMessenger", "pagePath: " + bVar2.cVh);
                    Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar2.cVi);
                    Log.d("AppLaunchMessenger", "sConsole:" + bVar2.cVc);
                }
                a(swanAppConfigData);
                this.cTJ = true;
            }
        }
    }

    private void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        com.baidu.swan.apps.core.i.a.aty().b(swanAppConfigData);
    }

    public synchronized void reset() {
        this.cTJ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class a {
        private static final b cTK = new b();
    }
}
