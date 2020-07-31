package com.baidu.swan.apps.core.h;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.adaptation.b.c;
import com.baidu.swan.apps.aq.aa;
import com.baidu.swan.apps.aq.aj;
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
    private boolean cfx;

    private b() {
        this.cfx = false;
    }

    public static b acH() {
        return a.cfy;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.baidu.swan.apps.adaptation.b.d] */
    public synchronized void a(@NonNull com.baidu.swan.apps.core.g.a aVar, @NonNull c cVar, @NonNull com.baidu.swan.apps.u.c.b bVar, @NonNull SwanAppConfigData swanAppConfigData, @Nullable d.f fVar) {
        boolean z = true;
        synchronized (this) {
            if (DEBUG) {
                Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                Log.d("SwanPrelink", "start dispatch launch event");
            }
            if (!this.cfx) {
                String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.akr(), bVar, swanAppConfigData);
                String op = swanAppConfigData.op(a2);
                com.baidu.swan.apps.core.turbo.a aVar2 = new com.baidu.swan.apps.core.turbo.a();
                aVar2.appConfig = swanAppConfigData.cId;
                swanAppConfigData.cId = null;
                if (fVar != null && !TextUtils.isEmpty(fVar.cnk)) {
                    aVar2.appPath = fVar.cnk;
                } else {
                    aVar2.appPath = d.C0380d.bq(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                aVar2.cgR = cVar.UR();
                aVar2.pageUrl = a2;
                aVar2.cgT = String.valueOf(com.baidu.swan.apps.console.a.XA());
                aVar2.cgU = com.baidu.swan.apps.core.turbo.a.b(e.arv(), a2);
                aVar2.pageType = op;
                if (!DEBUG && !f.akr().ajV()) {
                    z = false;
                }
                aVar2.cgV = z;
                aVar2.cgW = cVar.UM();
                if (com.baidu.swan.apps.ae.a.a.apg()) {
                    aVar2.cgX = com.baidu.swan.apps.console.debugger.b.XI();
                }
                Bundle ajl = bVar.ajl();
                if (ajl != null) {
                    String string = ajl.getString("extraData");
                    if (!TextUtils.isEmpty(string)) {
                        aVar2.cgS = string;
                    }
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", aVar2.toString());
                }
                i.anX().f(new UbcFlowEvent("master_dispatch_start"));
                com.baidu.swan.apps.al.a.atW().pf("master_dispatch_start");
                aVar.a(aVar2);
                com.baidu.swan.apps.core.turbo.d.adw().a(com.baidu.swan.apps.core.turbo.a.b(aVar2));
                com.baidu.swan.apps.core.turbo.d.adw().dY(aVar2.cgW);
                if (com.baidu.swan.apps.ae.a.a.nG(bVar.ajv())) {
                    com.baidu.swan.apps.console.debugger.a.d.XW();
                    com.baidu.swan.apps.console.debugger.a.d.XR().ji("appready");
                }
                com.baidu.swan.apps.runtime.config.c lZ = f.akr().lZ(j.oZ(aj.delAllParamsFromUrl(a2)));
                com.baidu.swan.apps.core.turbo.b bVar2 = new com.baidu.swan.apps.core.turbo.b();
                if (fVar != null && !TextUtils.isEmpty(fVar.cnk)) {
                    bVar2.appPath = fVar.cnk;
                } else {
                    bVar2.appPath = d.C0380d.bq(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
                }
                bVar2.cgY = a2;
                bVar2.cgZ = lZ.cgZ;
                bVar2.pageType = op;
                bVar2.cgU = aVar2.cgU;
                bVar2.cgT = String.valueOf(bVar.ajs());
                bVar2.cgV = z;
                bVar2.cgW = cVar.UM();
                if (com.baidu.swan.apps.ae.a.a.apg()) {
                    bVar2.cgX = com.baidu.swan.apps.console.debugger.b.XH();
                }
                if (com.baidu.swan.apps.ae.a.a.nG(bVar.ajv())) {
                    com.baidu.swan.apps.console.debugger.a.d.XR().ji("pageready");
                }
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", bVar2.toString());
                }
                i.anX().f(new UbcFlowEvent("slave_dispatch_start"));
                com.baidu.swan.apps.al.a.atW().pf("slave_dispatch_start");
                cVar.a(bVar2);
                aa.awK();
                cVar.UP().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, a2);
                cVar.ho(a2);
                com.baidu.swan.apps.core.turbo.d.adw().a(cVar.UR(), com.baidu.swan.apps.core.turbo.b.b(bVar2));
                com.baidu.swan.apps.statistic.e.bU(cVar.UR(), bVar2.cgY);
                if (DEBUG) {
                    Log.d("AppLaunchMessenger", "app path: " + aVar2.appPath);
                    Log.d("AppLaunchMessenger", "webviewId: " + cVar.UR());
                    Log.d("AppLaunchMessenger", "pageUrl: " + a2);
                    Log.d("AppLaunchMessenger", "pagePath: " + bVar2.cgY);
                    Log.d("AppLaunchMessenger", "onReachBottomDistance: " + bVar2.cgZ);
                    Log.d("AppLaunchMessenger", "sConsole:" + bVar2.cgT);
                }
                a(swanAppConfigData);
                this.cfx = true;
            }
        }
    }

    private void a(@NonNull SwanAppConfigData swanAppConfigData) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        com.baidu.swan.apps.core.i.a.acJ().b(swanAppConfigData);
    }

    public synchronized void reset() {
        this.cfx = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private static final b cfy = new b();
    }
}
