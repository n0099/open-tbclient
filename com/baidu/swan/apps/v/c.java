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
/* loaded from: classes8.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable diB;

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void aiF() {
        super.aiF();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppForeground");
        String aIP = com.baidu.swan.apps.runtime.e.aIP();
        if (!TextUtils.isEmpty(aIP)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", aIP);
            if (this.diw != null && this.diw.agc() != null) {
                hashMap.put("clkid", this.diw.agc().azk());
                hashMap.put("scene", this.diw.agc().azd());
                b.a agc = this.diw.agc();
                com.baidu.swan.apps.statistic.e.o(agc);
                h(agc);
            }
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.akH().eS(false);
            com.baidu.swan.apps.media.b.fY(true);
            com.baidu.swan.apps.media.a.c.a.gf(false);
            com.baidu.swan.apps.y.f.aCX().gf(false);
            j.akv().akw();
            com.baidu.swan.apps.y.e.aCR();
            if (com.baidu.swan.apps.t.a.axr() != null) {
                com.baidu.swan.apps.t.a.axr().ayC();
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (com.baidu.swan.apps.performance.b.c.aEB()) {
                p.a(new Runnable() { // from class: com.baidu.swan.apps.v.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aj.df(currentTimeMillis);
                    }
                }, "saveSwanAppForeGroundTime");
            } else {
                aj.df(currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void aiG() {
        super.aiG();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppBackground");
        String aIP = com.baidu.swan.apps.runtime.e.aIP();
        if (!TextUtils.isEmpty(aIP)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put("appId", aIP);
            contentValues.put("hiddenType", Integer.valueOf(ap.aOD().aOC()));
            b(new com.baidu.swan.apps.event.a.c(contentValues));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppHide");
            ap.aOD().reset();
            com.baidu.swan.apps.camera.a.akH().eS(true);
            com.baidu.swan.apps.media.b.fY(false);
            com.baidu.swan.apps.media.a.c.a.gf(true);
            com.baidu.swan.apps.y.f.aCX().gf(true);
            com.baidu.swan.apps.y.e.gn(false);
            if (com.baidu.swan.apps.t.a.axr() != null) {
                com.baidu.swan.apps.t.a.axr().ayD();
                com.baidu.swan.apps.t.a.axr().fQ(false);
            }
            aj.aOl();
            com.baidu.swan.apps.x.a.aCy();
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.turbo.d.release(false);
        if (this.dit != null) {
            this.dit = null;
        }
        com.baidu.swan.apps.ao.i.aNM();
        com.baidu.swan.apps.media.b.aAJ();
        com.baidu.swan.apps.media.a.c.a.releaseAll();
        com.baidu.swan.apps.ak.e.a.release();
        com.baidu.swan.apps.ak.a.a.release();
        com.baidu.swan.apps.ak.g.a.release();
        com.baidu.swan.apps.p.a.release();
        com.baidu.swan.apps.y.f.aCX().aCY();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.ak.b.d.release();
        com.baidu.swan.apps.y.e.aCS();
        if (com.baidu.swan.apps.t.a.axr() != null) {
            com.baidu.swan.apps.t.a.axr().ayB();
        }
        j.akv().release();
        com.baidu.swan.apps.camera.a.akH().onRelease();
        com.baidu.swan.apps.scheme.actions.forbidden.a.aJX().aKa();
        com.baidu.swan.apps.inlinewidget.rtcroom.e.release();
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean aAe() {
        long aAu = f.aAo().aAu();
        if (DEBUG) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + aAu);
        }
        return this.diy && aAu <= 0;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e aov() {
        return com.baidu.swan.apps.runtime.e.aIN();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.asD());
        }
        com.baidu.swan.apps.r.d.a(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.apps.v.c.2
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, com.baidu.swan.apps.r.a aVar) {
                final d.f fVar = (d.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.aIN() != null && !TextUtils.isEmpty(fVar.dgs)) {
                        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.dgt.dGr.dGT.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.dgt.dGs.dGV.get(str), c.this.apk(), new g.a() { // from class: com.baidu.swan.apps.v.c.2.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void kp(String str2) {
                                com.baidu.swan.apps.console.c.i("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void gh(int i2) {
                                com.baidu.swan.apps.console.c.w("SwanApp", "download subpackage fail: " + i2);
                                bVar.pd(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().sW(com.baidu.swan.apps.statistic.h.jv(bVar.getAppFrameType())).i(new com.baidu.swan.apps.al.a().db(5L).dc(38L).tO("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                    com.baidu.swan.apps.console.c.w("SwanApp", "subpackage is invalid");
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.turbo.d.ash().e(bVar);
        com.baidu.swan.apps.core.turbo.d.ash().f(bVar);
        com.baidu.swan.apps.core.turbo.d.ash().a((d.b) null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void b(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.asD());
        }
        com.baidu.swan.apps.core.turbo.d.ash().e(bVar);
        com.baidu.swan.apps.core.turbo.d.ash().a((d.b) null);
        SwanAppConfigData aIW = com.baidu.swan.apps.runtime.d.aIJ().aIF().aIW();
        if (aIW != null) {
            d.f fVar = new d.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.v.c.3
                @Override // java.lang.Runnable
                public void run() {
                    d.C0452d.bM(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.dgt = aIW;
            fVar.dgs = d.C0452d.bL(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.i.aEe().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.aj.a.aLl().sG("na_post_to_main_start");
            b(bVar, fVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion azQ() {
        return com.baidu.swan.apps.core.turbo.d.ash().asD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.i.aEe().f(new UbcFlowEvent("na_post_to_main_start"));
            ak.i(this.diB);
            this.diB = new Runnable() { // from class: com.baidu.swan.apps.v.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ak.h(this.diB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aEe().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.aj.a.aLl().sG("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.mIsReleased) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.dgs + ", baseUrl:" + f.aAo().azV())));
                return;
            }
            return;
        }
        this.dgs = fVar.dgs;
        d(fVar.dgt);
        if (bVar.azp()) {
            B(this.diw).setVisibility(0);
            com.baidu.swan.apps.console.a.eW(true);
            com.baidu.swan.apps.console.c.i("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.turbo.d.ash().a(bVar, fVar);
    }

    private void d(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d aIJ = com.baidu.swan.apps.runtime.d.aIJ();
        if (aIJ.aGb()) {
            aIJ.aIF().g(swanAppConfigData);
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
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && com.baidu.swan.apps.t.a.axZ().J(string, string2, string3)) {
                        bVar.bT("fromHost", null);
                        bVar.bT("spuId", null);
                        bVar.bT("contentId", null);
                    }
                }
            }, 2000L);
        }
    }
}
