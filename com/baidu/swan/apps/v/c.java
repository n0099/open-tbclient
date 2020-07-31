package com.baidu.swan.apps.v;

import android.content.ContentValues;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.ak;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.aq;
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
    private Runnable cpl;

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void Uw() {
        super.Uw();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppForeground");
        String arx = com.baidu.swan.apps.runtime.e.arx();
        if (!TextUtils.isEmpty(arx)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", arx);
            if (this.cpg != null && this.cpg.Se() != null) {
                hashMap.put("clkid", this.cpg.Se().ajn());
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, this.cpg.Se().ajg());
                b.a Se = this.cpg.Se();
                com.baidu.swan.apps.statistic.e.o(Se);
                h(Se);
            }
            a(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.Wu().dt(false);
            com.baidu.swan.apps.media.b.es(true);
            com.baidu.swan.apps.media.a.c.a.ez(false);
            com.baidu.swan.apps.z.f.amM().ez(false);
            com.baidu.swan.apps.api.module.k.h.Wh().Wi();
            com.baidu.swan.apps.z.e.amG();
            if (com.baidu.swan.apps.t.a.ahB() != null) {
                com.baidu.swan.apps.t.a.ahB().aiG();
            }
            ak.awY();
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void Ux() {
        super.Ux();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppBackground");
        String arx = com.baidu.swan.apps.runtime.e.arx();
        if (!TextUtils.isEmpty(arx)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put("appId", arx);
            contentValues.put("hiddenType", Integer.valueOf(aq.axo().axn()));
            a(new com.baidu.swan.apps.event.a.c(contentValues));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppHide");
            aq.axo().reset();
            com.baidu.swan.apps.camera.a.Wu().dt(true);
            com.baidu.swan.apps.media.b.es(false);
            com.baidu.swan.apps.media.a.c.a.ez(true);
            com.baidu.swan.apps.z.f.amM().ez(true);
            com.baidu.swan.apps.z.e.eG(false);
            if (com.baidu.swan.apps.t.a.ahB() != null) {
                com.baidu.swan.apps.t.a.ahB().aiH();
                com.baidu.swan.apps.t.a.ahB().eh(false);
            }
            ak.awW();
            com.baidu.swan.apps.y.a.amn();
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.turbo.d.release(false);
        if (this.cpd != null) {
            this.cpd = null;
        }
        com.baidu.swan.apps.aq.i.aww();
        com.baidu.swan.apps.media.b.akF();
        com.baidu.swan.apps.media.a.c.a.releaseAll();
        com.baidu.swan.apps.am.e.a.release();
        com.baidu.swan.apps.am.a.a.release();
        com.baidu.swan.apps.am.g.a.release();
        com.baidu.swan.apps.o.a.release();
        com.baidu.swan.apps.z.f.amM().amN();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.am.b.d.release();
        com.baidu.swan.apps.z.e.amH();
        if (com.baidu.swan.apps.t.a.ahB() != null) {
            com.baidu.swan.apps.t.a.ahB().aiF();
        }
        com.baidu.swan.apps.api.module.k.h.Wh().release();
        com.baidu.swan.apps.camera.a.Wu().onRelease();
        com.baidu.swan.apps.scheme.actions.forbidden.a.asG().asK();
        com.baidu.swan.apps.network.c.b.a.resetCache();
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean akh() {
        long akx = f.akr().akx();
        if (DEBUG) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + akx);
        }
        return this.cpi && akx <= 0;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e aad() {
        return com.baidu.swan.apps.runtime.e.arv();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.adQ());
        }
        com.baidu.swan.apps.r.d.a(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.apps.v.c.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, com.baidu.swan.apps.r.a aVar) {
                final d.f fVar = (d.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.arv() != null && !TextUtils.isEmpty(fVar.cnk)) {
                        String delAllParamsFromUrl = aj.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.cnl.cHT.cIv.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.cnl.cHU.cIx.get(str), c.this.aaL(), new g.a() { // from class: com.baidu.swan.apps.v.c.1.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void hw(String str2) {
                                com.baidu.swan.apps.console.c.i("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void ex(int i2) {
                                com.baidu.swan.apps.console.c.w("SwanApp", "download subpackage fail: " + i2);
                                bVar.lJ(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().pu(com.baidu.swan.apps.statistic.h.ho(bVar.getAppFrameType())).f(new com.baidu.swan.apps.an.a().bJ(5L).bK(38L).qm("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                    com.baidu.swan.apps.console.c.w("SwanApp", "subpackage is invalid");
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.turbo.d.adw().e(bVar);
        com.baidu.swan.apps.core.turbo.d.adw().f(bVar);
        com.baidu.swan.apps.core.turbo.d.adw().a((d.a) null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void b(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.adQ());
        }
        com.baidu.swan.apps.core.turbo.d.adw().e(bVar);
        com.baidu.swan.apps.core.turbo.d.adw().a((d.a) null);
        SwanAppConfigData arE = com.baidu.swan.apps.runtime.d.arr().arn().arE();
        if (arE != null) {
            d.f fVar = new d.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.v.c.2
                @Override // java.lang.Runnable
                public void run() {
                    d.C0380d.br(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.cnl = arE;
            fVar.cnk = d.C0380d.bq(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.i.anX().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.al.a.atW().pf("na_post_to_main_start");
            b(bVar, fVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion ajT() {
        return com.baidu.swan.apps.core.turbo.d.adw().adQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.i.anX().f(new UbcFlowEvent("na_post_to_main_start"));
            al.o(this.cpl);
            this.cpl = new Runnable() { // from class: com.baidu.swan.apps.v.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            al.n(this.cpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.anX().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.al.a.atW().pf("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.chl) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.cnk + ", baseUrl:" + f.akr().ajY())));
                return;
            }
            return;
        }
        this.cnk = fVar.cnk;
        d(fVar.cnl);
        if (bVar.ajs()) {
            H(this.cpg).setVisibility(0);
            com.baidu.swan.apps.console.a.dx(true);
            com.baidu.swan.apps.console.c.i("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.turbo.d.adw().a(bVar, fVar);
    }

    private void d(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d arr = com.baidu.swan.apps.runtime.d.arr();
        if (arr.apU()) {
            arr.arn().f(swanAppConfigData);
        }
    }

    private void h(final com.baidu.swan.apps.u.c.b bVar) {
        if (!TextUtils.isEmpty(bVar.getString("fromHost")) && !TextUtils.isEmpty(bVar.getString("spuId")) && !TextUtils.isEmpty(bVar.getString("contentId"))) {
            al.c(new Runnable() { // from class: com.baidu.swan.apps.v.c.4
                @Override // java.lang.Runnable
                public void run() {
                    String string = bVar.getString("fromHost");
                    String string2 = bVar.getString("spuId");
                    String string3 = bVar.getString("contentId");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && com.baidu.swan.apps.t.a.aii().s(string, string2, string3)) {
                        bVar.bw("fromHost", null);
                        bVar.bw("spuId", null);
                        bVar.bw("contentId", null);
                    }
                }
            }, 2000L);
        }
    }
}
