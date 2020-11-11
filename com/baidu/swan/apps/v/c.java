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
    private Runnable cZs;

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void ain() {
        super.ain();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppForeground");
        String aHw = com.baidu.swan.apps.runtime.e.aHw();
        if (!TextUtils.isEmpty(aHw)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", aHw);
            if (this.cZn != null && this.cZn.afO() != null) {
                hashMap.put("clkid", this.cZn.afO().ayK());
                hashMap.put("scene", this.cZn.afO().ayD());
                b.a afO = this.cZn.afO();
                com.baidu.swan.apps.statistic.e.o(afO);
                h(afO);
            }
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.akp().et(false);
            com.baidu.swan.apps.media.b.fz(true);
            com.baidu.swan.apps.media.a.c.a.fG(false);
            com.baidu.swan.apps.y.f.aCw().fG(false);
            j.akd().ake();
            com.baidu.swan.apps.y.e.aCq();
            if (com.baidu.swan.apps.t.a.awS() != null) {
                com.baidu.swan.apps.t.a.awS().ayc();
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (com.baidu.swan.apps.performance.b.c.aEd()) {
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.v.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aj.cz(currentTimeMillis);
                    }
                }, "saveSwanAppForeGroundTime");
            } else {
                aj.cz(currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void aio() {
        super.aio();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppBackground");
        String aHw = com.baidu.swan.apps.runtime.e.aHw();
        if (!TextUtils.isEmpty(aHw)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put("appId", aHw);
            contentValues.put("hiddenType", Integer.valueOf(ap.aNk().aNj()));
            b(new com.baidu.swan.apps.event.a.c(contentValues));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppHide");
            ap.aNk().reset();
            com.baidu.swan.apps.camera.a.akp().et(true);
            com.baidu.swan.apps.media.b.fz(false);
            com.baidu.swan.apps.media.a.c.a.fG(true);
            com.baidu.swan.apps.y.f.aCw().fG(true);
            com.baidu.swan.apps.y.e.fO(false);
            if (com.baidu.swan.apps.t.a.awS() != null) {
                com.baidu.swan.apps.t.a.awS().ayd();
                com.baidu.swan.apps.t.a.awS().fr(false);
            }
            aj.aMS();
            com.baidu.swan.apps.x.a.aBX();
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.turbo.d.release(false);
        if (this.cZk != null) {
            this.cZk = null;
        }
        com.baidu.swan.apps.ap.i.aMt();
        com.baidu.swan.apps.media.b.aAj();
        com.baidu.swan.apps.media.a.c.a.releaseAll();
        com.baidu.swan.apps.al.e.a.release();
        com.baidu.swan.apps.al.a.a.release();
        com.baidu.swan.apps.al.g.a.release();
        com.baidu.swan.apps.p.a.release();
        com.baidu.swan.apps.y.f.aCw().aCx();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.al.b.d.release();
        com.baidu.swan.apps.y.e.aCr();
        if (com.baidu.swan.apps.t.a.awS() != null) {
            com.baidu.swan.apps.t.a.awS().ayb();
        }
        j.akd().release();
        com.baidu.swan.apps.camera.a.akp().onRelease();
        com.baidu.swan.apps.scheme.actions.forbidden.a.aIE().aIH();
        com.baidu.swan.apps.inlinewidget.rtcroom.e.release();
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean azE() {
        long azU = f.azO().azU();
        if (DEBUG) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + azU);
        }
        return this.cZp && azU <= 0;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e aoc() {
        return com.baidu.swan.apps.runtime.e.aHu();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.asd());
        }
        com.baidu.swan.apps.r.d.a(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.apps.v.c.2
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, com.baidu.swan.apps.r.a aVar) {
                final d.f fVar = (d.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.aHu() != null && !TextUtils.isEmpty(fVar.cXm)) {
                        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.cXn.dtB.dud.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.cXn.dtC.duf.get(str), c.this.aoL(), new g.a() { // from class: com.baidu.swan.apps.v.c.2.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void kH(String str2) {
                                com.baidu.swan.apps.console.c.i("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void hw(int i2) {
                                com.baidu.swan.apps.console.c.w("SwanApp", "download subpackage fail: " + i2);
                                bVar.pv(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().ti(com.baidu.swan.apps.statistic.h.ky(bVar.getAppFrameType())).i(new com.baidu.swan.apps.am.a().cv(5L).cw(38L).ua("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                    com.baidu.swan.apps.console.c.w("SwanApp", "subpackage is invalid");
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.turbo.d.arI().e(bVar);
        com.baidu.swan.apps.core.turbo.d.arI().f(bVar);
        com.baidu.swan.apps.core.turbo.d.arI().a((d.b) null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void b(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.asd());
        }
        com.baidu.swan.apps.core.turbo.d.arI().e(bVar);
        com.baidu.swan.apps.core.turbo.d.arI().a((d.b) null);
        SwanAppConfigData aHD = com.baidu.swan.apps.runtime.d.aHq().aHm().aHD();
        if (aHD != null) {
            d.f fVar = new d.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.v.c.3
                @Override // java.lang.Runnable
                public void run() {
                    d.C0464d.bO(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.cXn = aHD;
            fVar.cXm = d.C0464d.bN(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.i.aDG().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.ak.a.aJS().sS("na_post_to_main_start");
            b(bVar, fVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion azq() {
        return com.baidu.swan.apps.core.turbo.d.arI().asd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.i.aDG().f(new UbcFlowEvent("na_post_to_main_start"));
            ak.l(this.cZs);
            this.cZs = new Runnable() { // from class: com.baidu.swan.apps.v.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ak.k(this.cZs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aDG().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.ak.a.aJS().sS("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.cQm) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.cXm + ", baseUrl:" + f.azO().azv())));
                return;
            }
            return;
        }
        this.cXm = fVar.cXm;
        d(fVar.cXn);
        if (bVar.ayP()) {
            J(this.cZn).setVisibility(0);
            com.baidu.swan.apps.console.a.ex(true);
            com.baidu.swan.apps.console.c.i("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.turbo.d.arI().a(bVar, fVar);
    }

    private void d(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d aHq = com.baidu.swan.apps.runtime.d.aHq();
        if (aHq.aFD()) {
            aHq.aHm().g(swanAppConfigData);
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
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && com.baidu.swan.apps.t.a.axA().D(string, string2, string3)) {
                        bVar.bV("fromHost", null);
                        bVar.bV("spuId", null);
                        bVar.bV("contentId", null);
                    }
                }
            }, 2000L);
        }
    }
}
