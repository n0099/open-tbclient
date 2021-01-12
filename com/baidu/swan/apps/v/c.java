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
    private Runnable deM;

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void aie() {
        super.aie();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppForeground");
        String aIt = com.baidu.swan.apps.runtime.e.aIt();
        if (!TextUtils.isEmpty(aIt)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", aIt);
            if (this.deH != null && this.deH.afB() != null) {
                hashMap.put("clkid", this.deH.afB().ayJ());
                hashMap.put("scene", this.deH.afB().ayC());
                b.a afB = this.deH.afB();
                com.baidu.swan.apps.statistic.e.o(afB);
                h(afB);
            }
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.akg().eQ(false);
            com.baidu.swan.apps.media.b.fW(true);
            com.baidu.swan.apps.media.a.c.a.gd(false);
            com.baidu.swan.apps.y.f.aCy().gd(false);
            j.ajU().ajV();
            com.baidu.swan.apps.y.e.aCs();
            if (com.baidu.swan.apps.t.a.awQ() != null) {
                com.baidu.swan.apps.t.a.awQ().ayb();
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (com.baidu.swan.apps.performance.b.c.aEd()) {
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
    public void aif() {
        super.aif();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppBackground");
        String aIt = com.baidu.swan.apps.runtime.e.aIt();
        if (!TextUtils.isEmpty(aIt)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put("appId", aIt);
            contentValues.put("hiddenType", Integer.valueOf(ap.aOh().aOg()));
            b(new com.baidu.swan.apps.event.a.c(contentValues));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppHide");
            ap.aOh().reset();
            com.baidu.swan.apps.camera.a.akg().eQ(true);
            com.baidu.swan.apps.media.b.fW(false);
            com.baidu.swan.apps.media.a.c.a.gd(true);
            com.baidu.swan.apps.y.f.aCy().gd(true);
            com.baidu.swan.apps.y.e.gl(false);
            if (com.baidu.swan.apps.t.a.awQ() != null) {
                com.baidu.swan.apps.t.a.awQ().ayc();
                com.baidu.swan.apps.t.a.awQ().fO(false);
            }
            aj.aNP();
            com.baidu.swan.apps.x.a.aBY();
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.turbo.d.release(false);
        if (this.deE != null) {
            this.deE = null;
        }
        com.baidu.swan.apps.ao.i.aNq();
        com.baidu.swan.apps.media.b.aAi();
        com.baidu.swan.apps.media.a.c.a.releaseAll();
        com.baidu.swan.apps.ak.e.a.release();
        com.baidu.swan.apps.ak.a.a.release();
        com.baidu.swan.apps.ak.g.a.release();
        com.baidu.swan.apps.p.a.release();
        com.baidu.swan.apps.y.f.aCy().aCz();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.ak.b.d.release();
        com.baidu.swan.apps.y.e.aCt();
        if (com.baidu.swan.apps.t.a.awQ() != null) {
            com.baidu.swan.apps.t.a.awQ().aya();
        }
        j.ajU().release();
        com.baidu.swan.apps.camera.a.akg().onRelease();
        com.baidu.swan.apps.scheme.actions.forbidden.a.aJB().aJE();
        com.baidu.swan.apps.inlinewidget.rtcroom.e.release();
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean azD() {
        long azT = f.azN().azT();
        if (DEBUG) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + azT);
        }
        return this.deJ && azT <= 0;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e anU() {
        return com.baidu.swan.apps.runtime.e.aIr();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.asb());
        }
        com.baidu.swan.apps.r.d.a(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.apps.v.c.2
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, com.baidu.swan.apps.r.a aVar) {
                final d.f fVar = (d.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.aIr() != null && !TextUtils.isEmpty(fVar.dcE)) {
                        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.dcF.dCM.dDo.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.dcF.dCN.dDq.get(str), c.this.aoI(), new g.a() { // from class: com.baidu.swan.apps.v.c.2.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void jQ(String str2) {
                                com.baidu.swan.apps.console.c.i("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void gd(int i2) {
                                com.baidu.swan.apps.console.c.w("SwanApp", "download subpackage fail: " + i2);
                                bVar.oE(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().sw(com.baidu.swan.apps.statistic.h.jr(bVar.getAppFrameType())).i(new com.baidu.swan.apps.al.a().cV(5L).cW(38L).to("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                    com.baidu.swan.apps.console.c.w("SwanApp", "subpackage is invalid");
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.turbo.d.arG().e(bVar);
        com.baidu.swan.apps.core.turbo.d.arG().f(bVar);
        com.baidu.swan.apps.core.turbo.d.arG().a((d.b) null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void b(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.asb());
        }
        com.baidu.swan.apps.core.turbo.d.arG().e(bVar);
        com.baidu.swan.apps.core.turbo.d.arG().a((d.b) null);
        SwanAppConfigData aIA = com.baidu.swan.apps.runtime.d.aIn().aIj().aIA();
        if (aIA != null) {
            d.f fVar = new d.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.v.c.3
                @Override // java.lang.Runnable
                public void run() {
                    d.C0449d.bS(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.dcF = aIA;
            fVar.dcE = d.C0449d.bR(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.i.aDG().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.aj.a.aKP().sf("na_post_to_main_start");
            b(bVar, fVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion azp() {
        return com.baidu.swan.apps.core.turbo.d.arG().asb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.i.aDG().f(new UbcFlowEvent("na_post_to_main_start"));
            ak.k(this.deM);
            this.deM = new Runnable() { // from class: com.baidu.swan.apps.v.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ak.j(this.deM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aDG().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.aj.a.aKP().sf("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.mIsReleased) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.dcE + ", baseUrl:" + f.azN().azu())));
                return;
            }
            return;
        }
        this.dcE = fVar.dcE;
        d(fVar.dcF);
        if (bVar.ayO()) {
            H(this.deH).setVisibility(0);
            com.baidu.swan.apps.console.a.eU(true);
            com.baidu.swan.apps.console.c.i("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.turbo.d.arG().a(bVar, fVar);
    }

    private void d(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d aIn = com.baidu.swan.apps.runtime.d.aIn();
        if (aIn.aFD()) {
            aIn.aIj().g(swanAppConfigData);
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
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && com.baidu.swan.apps.t.a.axy().I(string, string2, string3)) {
                        bVar.bZ("fromHost", null);
                        bVar.bZ("spuId", null);
                        bVar.bZ("contentId", null);
                    }
                }
            }, 2000L);
        }
    }
}
