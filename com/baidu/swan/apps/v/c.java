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
/* loaded from: classes10.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable cLd;

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void adT() {
        super.adT();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppForeground");
        String aDc = com.baidu.swan.apps.runtime.e.aDc();
        if (!TextUtils.isEmpty(aDc)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", aDc);
            if (this.cKY != null && this.cKY.abu() != null) {
                hashMap.put("clkid", this.cKY.abu().auq());
                hashMap.put("scene", this.cKY.abu().auj());
                b.a abu = this.cKY.abu();
                com.baidu.swan.apps.statistic.e.o(abu);
                h(abu);
            }
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.afV().dX(false);
            com.baidu.swan.apps.media.b.fd(true);
            com.baidu.swan.apps.media.a.c.a.fk(false);
            com.baidu.swan.apps.y.f.ayc().fk(false);
            j.afJ().afK();
            com.baidu.swan.apps.y.e.axW();
            if (com.baidu.swan.apps.t.a.asy() != null) {
                com.baidu.swan.apps.t.a.asy().atI();
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (com.baidu.swan.apps.performance.b.c.azJ()) {
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.v.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aj.cb(currentTimeMillis);
                    }
                }, "saveSwanAppForeGroundTime");
            } else {
                aj.cb(currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void adU() {
        super.adU();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppBackground");
        String aDc = com.baidu.swan.apps.runtime.e.aDc();
        if (!TextUtils.isEmpty(aDc)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put("appId", aDc);
            contentValues.put("hiddenType", Integer.valueOf(ap.aIQ().aIP()));
            b(new com.baidu.swan.apps.event.a.c(contentValues));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppHide");
            ap.aIQ().reset();
            com.baidu.swan.apps.camera.a.afV().dX(true);
            com.baidu.swan.apps.media.b.fd(false);
            com.baidu.swan.apps.media.a.c.a.fk(true);
            com.baidu.swan.apps.y.f.ayc().fk(true);
            com.baidu.swan.apps.y.e.fs(false);
            if (com.baidu.swan.apps.t.a.asy() != null) {
                com.baidu.swan.apps.t.a.asy().atJ();
                com.baidu.swan.apps.t.a.asy().eV(false);
            }
            aj.aIy();
            com.baidu.swan.apps.x.a.axD();
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.turbo.d.release(false);
        if (this.cKV != null) {
            this.cKV = null;
        }
        com.baidu.swan.apps.ap.i.aHZ();
        com.baidu.swan.apps.media.b.avP();
        com.baidu.swan.apps.media.a.c.a.releaseAll();
        com.baidu.swan.apps.al.e.a.release();
        com.baidu.swan.apps.al.a.a.release();
        com.baidu.swan.apps.al.g.a.release();
        com.baidu.swan.apps.p.a.release();
        com.baidu.swan.apps.y.f.ayc().ayd();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.al.b.d.release();
        com.baidu.swan.apps.y.e.axX();
        if (com.baidu.swan.apps.t.a.asy() != null) {
            com.baidu.swan.apps.t.a.asy().atH();
        }
        j.afJ().release();
        com.baidu.swan.apps.camera.a.afV().onRelease();
        com.baidu.swan.apps.scheme.actions.forbidden.a.aEk().aEn();
        com.baidu.swan.apps.inlinewidget.rtcroom.e.release();
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean avk() {
        long avA = f.avu().avA();
        if (DEBUG) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + avA);
        }
        return this.cLa && avA <= 0;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e ajI() {
        return com.baidu.swan.apps.runtime.e.aDa();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.anI());
        }
        com.baidu.swan.apps.r.d.a(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.apps.v.c.2
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, com.baidu.swan.apps.r.a aVar) {
                final d.f fVar = (d.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.aDa() != null && !TextUtils.isEmpty(fVar.cIX)) {
                        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.cIY.dfe.dfG.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.cIY.dff.dfI.get(str), c.this.akr(), new g.a() { // from class: com.baidu.swan.apps.v.c.2.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void jZ(String str2) {
                                com.baidu.swan.apps.console.c.i("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void hb(int i2) {
                                com.baidu.swan.apps.console.c.w("SwanApp", "download subpackage fail: " + i2);
                                bVar.oO(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().sB(com.baidu.swan.apps.statistic.h.kd(bVar.getAppFrameType())).i(new com.baidu.swan.apps.am.a().bX(5L).bY(38L).tt("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                    com.baidu.swan.apps.console.c.w("SwanApp", "subpackage is invalid");
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.turbo.d.ann().e(bVar);
        com.baidu.swan.apps.core.turbo.d.ann().f(bVar);
        com.baidu.swan.apps.core.turbo.d.ann().a((d.b) null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void b(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.anI());
        }
        com.baidu.swan.apps.core.turbo.d.ann().e(bVar);
        com.baidu.swan.apps.core.turbo.d.ann().a((d.b) null);
        SwanAppConfigData aDj = com.baidu.swan.apps.runtime.d.aCW().aCS().aDj();
        if (aDj != null) {
            d.f fVar = new d.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.v.c.3
                @Override // java.lang.Runnable
                public void run() {
                    d.C0438d.bH(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.cIY = aDj;
            fVar.cIX = d.C0438d.bG(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.i.azm().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.ak.a.aFy().sk("na_post_to_main_start");
            b(bVar, fVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion auW() {
        return com.baidu.swan.apps.core.turbo.d.ann().anI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.i.azm().f(new UbcFlowEvent("na_post_to_main_start"));
            ak.l(this.cLd);
            this.cLd = new Runnable() { // from class: com.baidu.swan.apps.v.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ak.k(this.cLd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.azm().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.ak.a.aFy().sk("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.cBX) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.cIX + ", baseUrl:" + f.avu().avb())));
                return;
            }
            return;
        }
        this.cIX = fVar.cIX;
        d(fVar.cIY);
        if (bVar.auv()) {
            J(this.cKY).setVisibility(0);
            com.baidu.swan.apps.console.a.eb(true);
            com.baidu.swan.apps.console.c.i("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.turbo.d.ann().a(bVar, fVar);
    }

    private void d(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d aCW = com.baidu.swan.apps.runtime.d.aCW();
        if (aCW.aBj()) {
            aCW.aCS().g(swanAppConfigData);
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
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && com.baidu.swan.apps.t.a.atg().u(string, string2, string3)) {
                        bVar.bO("fromHost", null);
                        bVar.bO("spuId", null);
                        bVar.bO("contentId", null);
                    }
                }
            }, 2000L);
        }
    }
}
