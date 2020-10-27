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
    private boolean cIH;

    private b() {
        this.cIH = false;
    }

    public static b aov() {
        return a.cII;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.swan.apps.adaptation.b.d] */
    public synchronized void a(@NonNull com.baidu.swan.apps.core.g.a aVar, @NonNull c cVar, @NonNull com.baidu.swan.apps.u.c.b bVar, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.f fVar) {
        boolean z = true;
        synchronized (this) {
            if (DEBUG) {
                Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                Log.d("SwanPrelink", "start dispatch launch event");
            }
            if (!this.cIH) {
                String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.axo(), bVar, swanAppConfigData);
                String rL = swanAppConfigData.rL(a2);
                com.baidu.swan.apps.core.turbo.a aVar2 = new com.baidu.swan.apps.core.turbo.a();
                aVar2.appConfig = swanAppConfigData.dnO;
                swanAppConfigData.dnO = null;
                if (fVar != null && !TextUtils.isEmpty(fVar.cRt)) {
                    aVar2.appPath = fVar.cRt;
                } else {
                    aVar2.appPath = d.C0452d.bN(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                aVar2.cJY = cVar.agj();
                aVar2.pageUrl = a2;
                aVar2.cKa = String.valueOf(com.baidu.swan.apps.console.a.aiV());
                aVar2.cKb = com.baidu.swan.apps.core.turbo.a.b(e.aEU(), a2);
                aVar2.pageType = rL;
                if (!DEBUG && !f.axo().awS()) {
                    z = false;
                }
                aVar2.cKc = z;
                aVar2.cKd = cVar.age();
                if (com.baidu.swan.apps.ad.a.a.aCr()) {
                    aVar2.cKe = com.baidu.swan.apps.console.debugger.b.ajd();
                }
                Bundle awi = bVar.awi();
                if (awi != null) {
                    String string = awi.getString("extraData");
                    if (!TextUtils.isEmpty(string)) {
                        aVar2.cJZ = string;
                    }
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", aVar2.toString());
                }
                i.aBg().f(new UbcFlowEvent("master_dispatch_start"));
                com.baidu.swan.apps.ak.a.aHs().sE("master_dispatch_start");
                aVar.a(aVar2);
                com.baidu.swan.apps.core.turbo.d.aph().b(com.baidu.swan.apps.core.turbo.a.b(aVar2));
                com.baidu.swan.apps.core.turbo.d.aph().eR(aVar2.cKd);
                if (com.baidu.swan.apps.ad.a.a.rd(bVar.aws())) {
                    com.baidu.swan.apps.console.debugger.a.d.ajr();
                    com.baidu.swan.apps.console.debugger.a.d.ajm().mh("appready");
                }
                com.baidu.swan.apps.runtime.config.c px = f.axo().px(j.sw(ai.delAllParamsFromUrl(a2)));
                com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
                if (fVar != null && !TextUtils.isEmpty(fVar.cRt)) {
                    bVar2.appPath = fVar.cRt;
                } else {
                    bVar2.appPath = d.C0452d.bN(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                bVar2.cKf = a2;
                bVar2.cKg = px.cKg;
                bVar2.pageType = rL;
                bVar2.cKb = aVar2.cKb;
                bVar2.cKa = String.valueOf(bVar.awp());
                bVar2.cKc = z;
                bVar2.cKd = cVar.age();
                if (com.baidu.swan.apps.ad.a.a.aCr()) {
                    bVar2.cKe = com.baidu.swan.apps.console.debugger.b.ajc();
                }
                if (com.baidu.swan.apps.ad.a.a.rd(bVar.aws())) {
                    com.baidu.swan.apps.console.debugger.a.d.ajm().mh("pageready");
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", bVar2.toString());
                }
                i.aBg().f(new UbcFlowEvent("slave_dispatch_start"));
                com.baidu.swan.apps.ak.a.aHs().sE("slave_dispatch_start");
                cVar.a(bVar2);
                ab.aKh();
                cVar.agh().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, a2);
                cVar.ki(a2);
                com.baidu.swan.apps.core.turbo.d.aph().a(cVar.agj(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
                com.baidu.swan.apps.statistic.e.cx(cVar.agj(), bVar2.cKf);
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", "app path: " + aVar2.appPath);
                    Log.d("AppLaunchMessenger", "webviewId: " + cVar.agj());
                    Log.d("AppLaunchMessenger", "pageUrl: " + a2);
                    Log.d("AppLaunchMessenger", "pagePath: " + bVar2.cKf);
                    Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar2.cKg);
                    Log.d("AppLaunchMessenger", "sConsole:" + bVar2.cKa);
                }
                a(swanAppConfigData);
                this.cIH = true;
            }
        }
    }

    private void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        com.baidu.swan.apps.core.i.a.aox().b(swanAppConfigData);
    }

    public synchronized void reset() {
        this.cIH = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final b cII = new b();
    }
}
