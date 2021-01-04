package com.baidu.swan.apps.v;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.ao.aj;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.ap;
import com.baidu.swan.apps.ao.p;
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
/* loaded from: classes9.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable djB;

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void alX() {
        super.alX();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppForeground");
        String aMm = com.baidu.swan.apps.runtime.e.aMm();
        if (!TextUtils.isEmpty(aMm)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", aMm);
            if (this.djw != null && this.djw.aju() != null) {
                hashMap.put("clkid", this.djw.aju().aCC());
                hashMap.put("scene", this.djw.aju().aCv());
                b.a aju = this.djw.aju();
                com.baidu.swan.apps.statistic.e.o(aju);
                h(aju);
            }
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.anZ().eU(false);
            com.baidu.swan.apps.media.b.ga(true);
            com.baidu.swan.apps.media.a.c.a.gh(false);
            com.baidu.swan.apps.y.f.aGr().gh(false);
            j.anN().anO();
            com.baidu.swan.apps.y.e.aGl();
            if (com.baidu.swan.apps.t.a.aAJ() != null) {
                com.baidu.swan.apps.t.a.aAJ().aBU();
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (com.baidu.swan.apps.performance.b.c.aHW()) {
                p.a(new Runnable() { // from class: com.baidu.swan.apps.v.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aj.cZ(currentTimeMillis);
                    }
                }, "saveSwanAppForeGroundTime");
            } else {
                aj.cZ(currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void alY() {
        super.alY();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppBackground");
        String aMm = com.baidu.swan.apps.runtime.e.aMm();
        if (!TextUtils.isEmpty(aMm)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put("appId", aMm);
            contentValues.put("hiddenType", Integer.valueOf(ap.aSa().aRZ()));
            b(new com.baidu.swan.apps.event.a.c(contentValues));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppHide");
            ap.aSa().reset();
            com.baidu.swan.apps.camera.a.anZ().eU(true);
            com.baidu.swan.apps.media.b.ga(false);
            com.baidu.swan.apps.media.a.c.a.gh(true);
            com.baidu.swan.apps.y.f.aGr().gh(true);
            com.baidu.swan.apps.y.e.gp(false);
            if (com.baidu.swan.apps.t.a.aAJ() != null) {
                com.baidu.swan.apps.t.a.aAJ().aBV();
                com.baidu.swan.apps.t.a.aAJ().fS(false);
            }
            aj.aRI();
            com.baidu.swan.apps.x.a.aFR();
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.turbo.d.release(false);
        if (this.djt != null) {
            this.djt = null;
        }
        com.baidu.swan.apps.ao.i.aRj();
        com.baidu.swan.apps.media.b.aEb();
        com.baidu.swan.apps.media.a.c.a.releaseAll();
        com.baidu.swan.apps.ak.e.a.release();
        com.baidu.swan.apps.ak.a.a.release();
        com.baidu.swan.apps.ak.g.a.release();
        com.baidu.swan.apps.p.a.release();
        com.baidu.swan.apps.y.f.aGr().aGs();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.ak.b.d.release();
        com.baidu.swan.apps.y.e.aGm();
        if (com.baidu.swan.apps.t.a.aAJ() != null) {
            com.baidu.swan.apps.t.a.aAJ().aBT();
        }
        j.anN().release();
        com.baidu.swan.apps.camera.a.anZ().onRelease();
        com.baidu.swan.apps.scheme.actions.forbidden.a.aNu().aNx();
        com.baidu.swan.apps.inlinewidget.rtcroom.e.release();
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean aDw() {
        long aDM = f.aDG().aDM();
        if (DEBUG) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + aDM);
        }
        return this.djy && aDM <= 0;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e arO() {
        return com.baidu.swan.apps.runtime.e.aMk();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.avV());
        }
        com.baidu.swan.apps.r.d.a(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.apps.v.c.2
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, com.baidu.swan.apps.r.a aVar) {
                final d.f fVar = (d.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.aMk() != null && !TextUtils.isEmpty(fVar.dhs)) {
                        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.dht.dHy.dIa.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.dht.dHz.dIc.get(str), c.this.asD(), new g.a() { // from class: com.baidu.swan.apps.v.c.2.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void lb(String str2) {
                                com.baidu.swan.apps.console.c.i("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void hK(int i2) {
                                com.baidu.swan.apps.console.c.w("SwanApp", "download subpackage fail: " + i2);
                                bVar.pP(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().tH(com.baidu.swan.apps.statistic.h.kX(bVar.getAppFrameType())).i(new com.baidu.swan.apps.al.a().cV(5L).cW(38L).uz("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                    com.baidu.swan.apps.console.c.w("SwanApp", "subpackage is invalid");
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.turbo.d.avA().e(bVar);
        com.baidu.swan.apps.core.turbo.d.avA().f(bVar);
        com.baidu.swan.apps.core.turbo.d.avA().a((d.b) null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void b(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.avV());
        }
        com.baidu.swan.apps.core.turbo.d.avA().e(bVar);
        com.baidu.swan.apps.core.turbo.d.avA().a((d.b) null);
        SwanAppConfigData aMt = com.baidu.swan.apps.runtime.d.aMg().aMc().aMt();
        if (aMt != null) {
            d.f fVar = new d.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.v.c.3
                @Override // java.lang.Runnable
                public void run() {
                    d.C0466d.bT(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.dht = aMt;
            fVar.dhs = d.C0466d.bS(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.i.aHz().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.aj.a.aOI().tr("na_post_to_main_start");
            b(bVar, fVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion aDi() {
        return com.baidu.swan.apps.core.turbo.d.avA().avV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.i.aHz().f(new UbcFlowEvent("na_post_to_main_start"));
            ak.k(this.djB);
            this.djB = new Runnable() { // from class: com.baidu.swan.apps.v.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ak.j(this.djB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aHz().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.aj.a.aOI().tr("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.mIsReleased) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.dhs + ", baseUrl:" + f.aDG().aDn())));
                return;
            }
            return;
        }
        this.dhs = fVar.dhs;
        d(fVar.dht);
        if (bVar.aCH()) {
            H(this.djw).setVisibility(0);
            com.baidu.swan.apps.console.a.eY(true);
            com.baidu.swan.apps.console.c.i("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.turbo.d.avA().a(bVar, fVar);
    }

    private void d(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d aMg = com.baidu.swan.apps.runtime.d.aMg();
        if (aMg.aJw()) {
            aMg.aMc().g(swanAppConfigData);
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
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && com.baidu.swan.apps.t.a.aBr().J(string, string2, string3)) {
                        bVar.ca("fromHost", null);
                        bVar.ca("spuId", null);
                        bVar.ca("contentId", null);
                    }
                }
            }, 2000L);
        }
    }
}
