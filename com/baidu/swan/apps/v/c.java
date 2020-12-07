package com.baidu.swan.apps.v;

import android.content.ContentValues;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.aj;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.ap;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.api.module.k.j;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.k.g;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes25.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable deH;

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void akN() {
        super.akN();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppForeground");
        String aJW = com.baidu.swan.apps.runtime.e.aJW();
        if (!TextUtils.isEmpty(aJW)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", aJW);
            if (this.deC != null && this.deC.aio() != null) {
                hashMap.put("clkid", this.deC.aio().aBl());
                hashMap.put("scene", this.deC.aio().aBe());
                b.a aio = this.deC.aio();
                com.baidu.swan.apps.statistic.e.o(aio);
                h(aio);
            }
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.amP().eL(false);
            com.baidu.swan.apps.media.b.fR(true);
            com.baidu.swan.apps.media.a.c.a.fY(false);
            com.baidu.swan.apps.y.f.aEX().fY(false);
            j.amD().amE();
            com.baidu.swan.apps.y.e.aER();
            if (com.baidu.swan.apps.t.a.azs() != null) {
                com.baidu.swan.apps.t.a.azs().aAD();
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (com.baidu.swan.apps.performance.b.c.aGD()) {
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.v.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aj.cY(currentTimeMillis);
                    }
                }, "saveSwanAppForeGroundTime");
            } else {
                aj.cY(currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void akO() {
        super.akO();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppBackground");
        String aJW = com.baidu.swan.apps.runtime.e.aJW();
        if (!TextUtils.isEmpty(aJW)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put("appId", aJW);
            contentValues.put("hiddenType", Integer.valueOf(ap.aPI().aPH()));
            b(new com.baidu.swan.apps.event.a.c(contentValues));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppHide");
            ap.aPI().reset();
            com.baidu.swan.apps.camera.a.amP().eL(true);
            com.baidu.swan.apps.media.b.fR(false);
            com.baidu.swan.apps.media.a.c.a.fY(true);
            com.baidu.swan.apps.y.f.aEX().fY(true);
            com.baidu.swan.apps.y.e.gg(false);
            if (com.baidu.swan.apps.t.a.azs() != null) {
                com.baidu.swan.apps.t.a.azs().aAE();
                com.baidu.swan.apps.t.a.azs().fJ(false);
            }
            aj.aPr();
            com.baidu.swan.apps.x.a.aEy();
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.turbo.d.release(false);
        if (this.dez != null) {
            this.dez = null;
        }
        com.baidu.swan.apps.ap.i.aOS();
        com.baidu.swan.apps.media.b.aCK();
        com.baidu.swan.apps.media.a.c.a.releaseAll();
        com.baidu.swan.apps.al.e.a.release();
        com.baidu.swan.apps.al.a.a.release();
        com.baidu.swan.apps.al.g.a.release();
        com.baidu.swan.apps.p.a.release();
        com.baidu.swan.apps.y.f.aEX().aEY();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.al.b.d.release();
        com.baidu.swan.apps.y.e.aES();
        if (com.baidu.swan.apps.t.a.azs() != null) {
            com.baidu.swan.apps.t.a.azs().aAC();
        }
        j.amD().release();
        com.baidu.swan.apps.camera.a.amP().onRelease();
        com.baidu.swan.apps.scheme.actions.forbidden.a.aLe().aLh();
        com.baidu.swan.apps.inlinewidget.rtcroom.e.release();
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean aCf() {
        long aCv = f.aCp().aCv();
        if (DEBUG) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + aCv);
        }
        return this.deE && aCv <= 0;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e aqC() {
        return com.baidu.swan.apps.runtime.e.aJU();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.auD());
        }
        com.baidu.swan.apps.r.d.a(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.apps.v.c.2
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, com.baidu.swan.apps.r.a aVar) {
                final d.f fVar = (d.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.aJU() != null && !TextUtils.isEmpty(fVar.dcz)) {
                        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.dcA.dyT.dzv.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.dcA.dyU.dzx.get(str), c.this.arl(), new g.a() { // from class: com.baidu.swan.apps.v.c.2.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void li(String str2) {
                                com.baidu.swan.apps.console.c.i("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void hQ(int i2) {
                                com.baidu.swan.apps.console.c.w("SwanApp", "download subpackage fail: " + i2);
                                bVar.pW(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().tK(com.baidu.swan.apps.statistic.h.kS(bVar.getAppFrameType())).i(new com.baidu.swan.apps.am.a().cU(5L).cV(38L).uC("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                    com.baidu.swan.apps.console.c.w("SwanApp", "subpackage is invalid");
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.turbo.d.aui().e(bVar);
        com.baidu.swan.apps.core.turbo.d.aui().f(bVar);
        com.baidu.swan.apps.core.turbo.d.aui().a((d.b) null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void b(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.auD());
        }
        com.baidu.swan.apps.core.turbo.d.aui().e(bVar);
        com.baidu.swan.apps.core.turbo.d.aui().a((d.b) null);
        SwanAppConfigData aKd = com.baidu.swan.apps.runtime.d.aJQ().aJM().aKd();
        if (aKd != null) {
            d.f fVar = new d.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.v.c.3
                @Override // java.lang.Runnable
                public void run() {
                    d.C0474d.bU(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.dcA = aKd;
            fVar.dcz = d.C0474d.bT(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.i.aGg().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.ak.a.aMs().tu("na_post_to_main_start");
            b(bVar, fVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion aBR() {
        return com.baidu.swan.apps.core.turbo.d.aui().auD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.i.aGg().f(new UbcFlowEvent("na_post_to_main_start"));
            ak.l(this.deH);
            this.deH = new Runnable() { // from class: com.baidu.swan.apps.v.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ak.k(this.deH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aGg().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.ak.a.aMs().tu("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.cVv) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.dcz + ", baseUrl:" + f.aCp().aBW())));
                return;
            }
            return;
        }
        this.dcz = fVar.dcz;
        d(fVar.dcA);
        if (bVar.aBq()) {
            I(this.deC).setVisibility(0);
            com.baidu.swan.apps.console.a.eP(true);
            com.baidu.swan.apps.console.c.i("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.turbo.d.aui().a(bVar, fVar);
    }

    private void d(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d aJQ = com.baidu.swan.apps.runtime.d.aJQ();
        if (aJQ.aId()) {
            aJQ.aJM().g(swanAppConfigData);
        }
    }

    private void h(final com.baidu.swan.apps.u.c.b bVar) {
        if (!TextUtils.isEmpty(bVar.getString("fromHost")) && !TextUtils.isEmpty(bVar.getString("spuId")) && !TextUtils.isEmpty(bVar.getString("contentId"))) {
            ak.c(new Runnable() { // from class: com.baidu.swan.apps.v.c.5
                @Override // java.lang.Runnable
                public void run() {
                    String string = bVar.getString("fromHost");
                    String string2 = bVar.getString("spuId");
                    String string3 = bVar.getString("contentId");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && com.baidu.swan.apps.t.a.aAa().G(string, string2, string3)) {
                        bVar.cb("fromHost", null);
                        bVar.cb("spuId", null);
                        bVar.cb("contentId", null);
                    }
                }
            }, 2000L);
        }
    }
}
