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
/* loaded from: classes3.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable cyY;

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void abh() {
        super.abh();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppForeground");
        String aAt = com.baidu.swan.apps.runtime.e.aAt();
        if (!TextUtils.isEmpty(aAt)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", aAt);
            if (this.cyT != null && this.cyT.YI() != null) {
                hashMap.put("clkid", this.cyT.YI().arE());
                hashMap.put("scene", this.cyT.YI().arx());
                b.a YI = this.cyT.YI();
                com.baidu.swan.apps.statistic.e.o(YI);
                h(YI);
            }
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.adj().dB(false);
            com.baidu.swan.apps.media.b.eH(true);
            com.baidu.swan.apps.media.a.c.a.eO(false);
            com.baidu.swan.apps.y.f.avr().eO(false);
            j.acX().acY();
            com.baidu.swan.apps.y.e.avl();
            if (com.baidu.swan.apps.t.a.apM() != null) {
                com.baidu.swan.apps.t.a.apM().aqW();
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (com.baidu.swan.apps.performance.b.c.awY()) {
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.v.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aj.bT(currentTimeMillis);
                    }
                }, "saveSwanAppForeGroundTime");
            } else {
                aj.bT(currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void abi() {
        super.abi();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppBackground");
        String aAt = com.baidu.swan.apps.runtime.e.aAt();
        if (!TextUtils.isEmpty(aAt)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put("appId", aAt);
            contentValues.put("hiddenType", Integer.valueOf(ap.aGh().aGg()));
            b(new com.baidu.swan.apps.event.a.c(contentValues));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppHide");
            ap.aGh().reset();
            com.baidu.swan.apps.camera.a.adj().dB(true);
            com.baidu.swan.apps.media.b.eH(false);
            com.baidu.swan.apps.media.a.c.a.eO(true);
            com.baidu.swan.apps.y.f.avr().eO(true);
            com.baidu.swan.apps.y.e.eW(false);
            if (com.baidu.swan.apps.t.a.apM() != null) {
                com.baidu.swan.apps.t.a.apM().aqX();
                com.baidu.swan.apps.t.a.apM().ez(false);
            }
            aj.aFP();
            com.baidu.swan.apps.x.a.auS();
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.turbo.d.release(false);
        if (this.cyQ != null) {
            this.cyQ = null;
        }
        com.baidu.swan.apps.ap.i.aFq();
        com.baidu.swan.apps.media.b.ate();
        com.baidu.swan.apps.media.a.c.a.releaseAll();
        com.baidu.swan.apps.al.e.a.release();
        com.baidu.swan.apps.al.a.a.release();
        com.baidu.swan.apps.al.g.a.release();
        com.baidu.swan.apps.p.a.release();
        com.baidu.swan.apps.y.f.avr().avs();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.al.b.d.release();
        com.baidu.swan.apps.y.e.avm();
        if (com.baidu.swan.apps.t.a.apM() != null) {
            com.baidu.swan.apps.t.a.apM().aqV();
        }
        j.acX().release();
        com.baidu.swan.apps.camera.a.adj().onRelease();
        com.baidu.swan.apps.scheme.actions.forbidden.a.aBB().aBE();
        com.baidu.swan.apps.inlinewidget.rtcroom.e.release();
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean asz() {
        long asP = f.asJ().asP();
        if (DEBUG) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + asP);
        }
        return this.cyV && asP <= 0;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e agX() {
        return com.baidu.swan.apps.runtime.e.aAr();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.akX());
        }
        com.baidu.swan.apps.r.d.a(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.apps.v.c.2
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, com.baidu.swan.apps.r.a aVar) {
                final d.f fVar = (d.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.aAr() != null && !TextUtils.isEmpty(fVar.cwS)) {
                        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.cwT.cSW.cTy.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.cwT.cSX.cTA.get(str), c.this.ahG(), new g.a() { // from class: com.baidu.swan.apps.v.c.2.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void jn(String str2) {
                                com.baidu.swan.apps.console.c.i("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void gE(int i2) {
                                com.baidu.swan.apps.console.c.w("SwanApp", "download subpackage fail: " + i2);
                                bVar.oa(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().rO(com.baidu.swan.apps.statistic.h.jG(bVar.getAppFrameType())).i(new com.baidu.swan.apps.am.a().bP(5L).bQ(38L).sH("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                    com.baidu.swan.apps.console.c.w("SwanApp", "subpackage is invalid");
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.turbo.d.akC().e(bVar);
        com.baidu.swan.apps.core.turbo.d.akC().f(bVar);
        com.baidu.swan.apps.core.turbo.d.akC().a((d.b) null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void b(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.akX());
        }
        com.baidu.swan.apps.core.turbo.d.akC().e(bVar);
        com.baidu.swan.apps.core.turbo.d.akC().a((d.b) null);
        SwanAppConfigData aAA = com.baidu.swan.apps.runtime.d.aAn().aAj().aAA();
        if (aAA != null) {
            d.f fVar = new d.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.v.c.3
                @Override // java.lang.Runnable
                public void run() {
                    d.C0421d.bC(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.cwT = aAA;
            fVar.cwS = d.C0421d.bB(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.i.awB().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.ak.a.aCP().ry("na_post_to_main_start");
            b(bVar, fVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion ask() {
        return com.baidu.swan.apps.core.turbo.d.akC().akX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.i.awB().f(new UbcFlowEvent("na_post_to_main_start"));
            ak.l(this.cyY);
            this.cyY = new Runnable() { // from class: com.baidu.swan.apps.v.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ak.k(this.cyY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.awB().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.ak.a.aCP().ry("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.cpJ) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.cwS + ", baseUrl:" + f.asJ().asq())));
                return;
            }
            return;
        }
        this.cwS = fVar.cwS;
        d(fVar.cwT);
        if (bVar.arJ()) {
            I(this.cyT).setVisibility(0);
            com.baidu.swan.apps.console.a.dF(true);
            com.baidu.swan.apps.console.c.i("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.turbo.d.akC().a(bVar, fVar);
    }

    private void d(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d aAn = com.baidu.swan.apps.runtime.d.aAn();
        if (aAn.ayA()) {
            aAn.aAj().g(swanAppConfigData);
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
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && com.baidu.swan.apps.t.a.aqu().t(string, string2, string3)) {
                        bVar.bJ("fromHost", null);
                        bVar.bJ("spuId", null);
                        bVar.bJ("contentId", null);
                    }
                }
            }, 2000L);
        }
    }
}
