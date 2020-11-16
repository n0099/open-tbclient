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
/* loaded from: classes7.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable cXI;

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void ahF() {
        super.ahF();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppForeground");
        String aGO = com.baidu.swan.apps.runtime.e.aGO();
        if (!TextUtils.isEmpty(aGO)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", aGO);
            if (this.cXD != null && this.cXD.afg() != null) {
                hashMap.put("clkid", this.cXD.afg().ayc());
                hashMap.put("scene", this.cXD.afg().axV());
                b.a afg = this.cXD.afg();
                com.baidu.swan.apps.statistic.e.o(afg);
                h(afg);
            }
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.ajH().ew(false);
            com.baidu.swan.apps.media.b.fC(true);
            com.baidu.swan.apps.media.a.c.a.fJ(false);
            com.baidu.swan.apps.y.f.aBO().fJ(false);
            j.ajv().ajw();
            com.baidu.swan.apps.y.e.aBI();
            if (com.baidu.swan.apps.t.a.awk() != null) {
                com.baidu.swan.apps.t.a.awk().axu();
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (com.baidu.swan.apps.performance.b.c.aDv()) {
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
    public void ahG() {
        super.ahG();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppBackground");
        String aGO = com.baidu.swan.apps.runtime.e.aGO();
        if (!TextUtils.isEmpty(aGO)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put("appId", aGO);
            contentValues.put("hiddenType", Integer.valueOf(ap.aMC().aMB()));
            b(new com.baidu.swan.apps.event.a.c(contentValues));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppHide");
            ap.aMC().reset();
            com.baidu.swan.apps.camera.a.ajH().ew(true);
            com.baidu.swan.apps.media.b.fC(false);
            com.baidu.swan.apps.media.a.c.a.fJ(true);
            com.baidu.swan.apps.y.f.aBO().fJ(true);
            com.baidu.swan.apps.y.e.fR(false);
            if (com.baidu.swan.apps.t.a.awk() != null) {
                com.baidu.swan.apps.t.a.awk().axv();
                com.baidu.swan.apps.t.a.awk().fu(false);
            }
            aj.aMk();
            com.baidu.swan.apps.x.a.aBp();
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.turbo.d.release(false);
        if (this.cXA != null) {
            this.cXA = null;
        }
        com.baidu.swan.apps.ap.i.aLL();
        com.baidu.swan.apps.media.b.azB();
        com.baidu.swan.apps.media.a.c.a.releaseAll();
        com.baidu.swan.apps.al.e.a.release();
        com.baidu.swan.apps.al.a.a.release();
        com.baidu.swan.apps.al.g.a.release();
        com.baidu.swan.apps.p.a.release();
        com.baidu.swan.apps.y.f.aBO().aBP();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.al.b.d.release();
        com.baidu.swan.apps.y.e.aBJ();
        if (com.baidu.swan.apps.t.a.awk() != null) {
            com.baidu.swan.apps.t.a.awk().axt();
        }
        j.ajv().release();
        com.baidu.swan.apps.camera.a.ajH().onRelease();
        com.baidu.swan.apps.scheme.actions.forbidden.a.aHW().aHZ();
        com.baidu.swan.apps.inlinewidget.rtcroom.e.release();
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean ayW() {
        long azm = f.azg().azm();
        if (DEBUG) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + azm);
        }
        return this.cXF && azm <= 0;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e anu() {
        return com.baidu.swan.apps.runtime.e.aGM();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.arv());
        }
        com.baidu.swan.apps.r.d.a(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.apps.v.c.2
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, com.baidu.swan.apps.r.a aVar) {
                final d.f fVar = (d.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.aGM() != null && !TextUtils.isEmpty(fVar.cVC)) {
                        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.cVD.drS.dsv.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.cVD.drT.dsx.get(str), c.this.aod(), new g.a() { // from class: com.baidu.swan.apps.v.c.2.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void kB(String str2) {
                                com.baidu.swan.apps.console.c.i("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void hs(int i2) {
                                com.baidu.swan.apps.console.c.w("SwanApp", "download subpackage fail: " + i2);
                                bVar.pp(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().td(com.baidu.swan.apps.statistic.h.ku(bVar.getAppFrameType())).i(new com.baidu.swan.apps.am.a().cv(5L).cw(38L).tV("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                    com.baidu.swan.apps.console.c.w("SwanApp", "subpackage is invalid");
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.turbo.d.ara().e(bVar);
        com.baidu.swan.apps.core.turbo.d.ara().f(bVar);
        com.baidu.swan.apps.core.turbo.d.ara().a((d.b) null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void b(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.arv());
        }
        com.baidu.swan.apps.core.turbo.d.ara().e(bVar);
        com.baidu.swan.apps.core.turbo.d.ara().a((d.b) null);
        SwanAppConfigData aGV = com.baidu.swan.apps.runtime.d.aGI().aGE().aGV();
        if (aGV != null) {
            d.f fVar = new d.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.v.c.3
                @Override // java.lang.Runnable
                public void run() {
                    d.C0462d.bN(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.cVD = aGV;
            fVar.cVC = d.C0462d.bM(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.i.aCY().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.ak.a.aJk().sN("na_post_to_main_start");
            b(bVar, fVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion ayI() {
        return com.baidu.swan.apps.core.turbo.d.ara().arv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.i.aCY().f(new UbcFlowEvent("na_post_to_main_start"));
            ak.l(this.cXI);
            this.cXI = new Runnable() { // from class: com.baidu.swan.apps.v.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ak.k(this.cXI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aCY().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.ak.a.aJk().sN("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.cOC) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.cVC + ", baseUrl:" + f.azg().ayN())));
                return;
            }
            return;
        }
        this.cVC = fVar.cVC;
        d(fVar.cVD);
        if (bVar.ayh()) {
            I(this.cXD).setVisibility(0);
            com.baidu.swan.apps.console.a.eA(true);
            com.baidu.swan.apps.console.c.i("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.turbo.d.ara().a(bVar, fVar);
    }

    private void d(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d aGI = com.baidu.swan.apps.runtime.d.aGI();
        if (aGI.aEV()) {
            aGI.aGE().g(swanAppConfigData);
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
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && com.baidu.swan.apps.t.a.awS().D(string, string2, string3)) {
                        bVar.bU("fromHost", null);
                        bVar.bU("spuId", null);
                        bVar.bU("contentId", null);
                    }
                }
            }, 2000L);
        }
    }
}
