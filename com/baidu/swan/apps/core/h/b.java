package com.baidu.swan.apps.core.h;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.aq.z;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.swan.apps.w.f;
import java.io.File;
/* loaded from: classes11.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private boolean bZa;

    private b() {
        this.bZa = false;
    }

    public static b aaz() {
        return a.bZb;
    }

    public synchronized void a(@NonNull com.baidu.swan.apps.core.g.a aVar, @NonNull c cVar, @NonNull com.baidu.swan.apps.v.b.b bVar, @NonNull SwanAppConfigData swanAppConfigData, @Nullable e.f fVar) {
        boolean z = true;
        synchronized (this) {
            if (DEBUG) {
                Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                Log.d("SwanPrelink", "start dispatch launch event");
            }
            if (!this.bZa) {
                String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.ahV(), bVar, swanAppConfigData);
                String nz = swanAppConfigData.nz(a2);
                com.baidu.swan.apps.core.turbo.a aVar2 = new com.baidu.swan.apps.core.turbo.a();
                aVar2.appConfig = swanAppConfigData.cAD;
                swanAppConfigData.cAD = null;
                if (fVar != null && !TextUtils.isEmpty(fVar.cgs)) {
                    aVar2.appPath = fVar.cgs;
                } else {
                    aVar2.appPath = e.d.bk(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                aVar2.caq = cVar.Tj();
                aVar2.car = a2;
                aVar2.cat = String.valueOf(com.baidu.swan.apps.console.a.VO());
                aVar2.cau = com.baidu.swan.apps.core.turbo.a.b(com.baidu.swan.apps.runtime.e.aoF(), a2);
                aVar2.caw = nz;
                if (!DEBUG && !f.ahV().ahz()) {
                    z = false;
                }
                aVar2.cav = z;
                aVar2.cax = cVar.Tf();
                if (com.baidu.swan.apps.af.a.a.amr()) {
                    aVar2.cay = com.baidu.swan.apps.console.debugger.b.VW();
                }
                Bundle agP = bVar.agP();
                if (agP != null) {
                    String string = agP.getString("extraData");
                    if (!TextUtils.isEmpty(string)) {
                        aVar2.cas = string;
                    }
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", aVar2.toString());
                }
                g.alx().f(new UbcFlowEvent("master_dispatch_start"));
                com.baidu.swan.apps.al.a.aqT().oo("master_dispatch_start");
                aVar.a(aVar2);
                d.abl().a(com.baidu.swan.apps.core.turbo.a.b(aVar2));
                d.abl().dN(aVar2.cax);
                if (com.baidu.swan.apps.af.a.a.mR(bVar.agZ())) {
                    com.baidu.swan.apps.console.debugger.a.d.Wk();
                    com.baidu.swan.apps.console.debugger.a.d.Wf().iQ("appready");
                }
                com.baidu.swan.apps.runtime.config.c lq = f.ahV().lq(j.oh(ah.delAllParamsFromUrl(a2)));
                com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
                if (fVar != null && !TextUtils.isEmpty(fVar.cgs)) {
                    bVar2.appPath = fVar.cgs;
                } else {
                    bVar2.appPath = e.d.bk(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                bVar2.caz = a2;
                bVar2.caA = lq.caA;
                bVar2.caw = nz;
                bVar2.cau = aVar2.cau;
                bVar2.cat = String.valueOf(bVar.agW());
                bVar2.cav = z;
                bVar2.cax = cVar.Tf();
                if (com.baidu.swan.apps.af.a.a.amr()) {
                    bVar2.cay = com.baidu.swan.apps.console.debugger.b.VV();
                }
                if (com.baidu.swan.apps.af.a.a.mR(bVar.agZ())) {
                    com.baidu.swan.apps.console.debugger.a.d.Wf().iQ("pageready");
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", bVar2.toString());
                }
                g.alx().f(new UbcFlowEvent("slave_dispatch_start"));
                com.baidu.swan.apps.al.a.aqT().oo("slave_dispatch_start");
                cVar.a(bVar2);
                z.atC();
                d.abl().a(cVar.Tj(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
                com.baidu.swan.apps.statistic.e.bR(cVar.Tj(), bVar2.caz);
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", "app path: " + aVar2.appPath);
                    Log.d("AppLaunchMessenger", "webviewId: " + cVar.Tj());
                    Log.d("AppLaunchMessenger", "pageUrl: " + a2);
                    Log.d("AppLaunchMessenger", "pagePath: " + bVar2.caz);
                    Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar2.caA);
                    Log.d("AppLaunchMessenger", "sConsole:" + bVar2.cat);
                }
                a(swanAppConfigData);
                this.bZa = true;
            }
        }
    }

    private void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        com.baidu.swan.apps.core.i.a.aaB().b(swanAppConfigData);
    }

    public synchronized void reset() {
        this.bZa = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        private static final b bZb = new b();
    }
}
