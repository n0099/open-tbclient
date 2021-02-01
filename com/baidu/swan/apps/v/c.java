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
    private Runnable dgX;

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void aiC() {
        super.aiC();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppForeground");
        String aIM = com.baidu.swan.apps.runtime.e.aIM();
        if (!TextUtils.isEmpty(aIM)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", aIM);
            if (this.dgS != null && this.dgS.afZ() != null) {
                hashMap.put("clkid", this.dgS.afZ().azh());
                hashMap.put("scene", this.dgS.afZ().aza());
                b.a afZ = this.dgS.afZ();
                com.baidu.swan.apps.statistic.e.o(afZ);
                h(afZ);
            }
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.akE().eS(false);
            com.baidu.swan.apps.media.b.fY(true);
            com.baidu.swan.apps.media.a.c.a.gf(false);
            com.baidu.swan.apps.y.f.aCU().gf(false);
            j.aks().akt();
            com.baidu.swan.apps.y.e.aCO();
            if (com.baidu.swan.apps.t.a.axo() != null) {
                com.baidu.swan.apps.t.a.axo().ayz();
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (com.baidu.swan.apps.performance.b.c.aEy()) {
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
    public void aiD() {
        super.aiD();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppBackground");
        String aIM = com.baidu.swan.apps.runtime.e.aIM();
        if (!TextUtils.isEmpty(aIM)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put("appId", aIM);
            contentValues.put("hiddenType", Integer.valueOf(ap.aOA().aOz()));
            b(new com.baidu.swan.apps.event.a.c(contentValues));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppHide");
            ap.aOA().reset();
            com.baidu.swan.apps.camera.a.akE().eS(true);
            com.baidu.swan.apps.media.b.fY(false);
            com.baidu.swan.apps.media.a.c.a.gf(true);
            com.baidu.swan.apps.y.f.aCU().gf(true);
            com.baidu.swan.apps.y.e.gn(false);
            if (com.baidu.swan.apps.t.a.axo() != null) {
                com.baidu.swan.apps.t.a.axo().ayA();
                com.baidu.swan.apps.t.a.axo().fQ(false);
            }
            aj.aOi();
            com.baidu.swan.apps.x.a.aCv();
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.turbo.d.release(false);
        if (this.dgP != null) {
            this.dgP = null;
        }
        com.baidu.swan.apps.ao.i.aNJ();
        com.baidu.swan.apps.media.b.aAG();
        com.baidu.swan.apps.media.a.c.a.releaseAll();
        com.baidu.swan.apps.ak.e.a.release();
        com.baidu.swan.apps.ak.a.a.release();
        com.baidu.swan.apps.ak.g.a.release();
        com.baidu.swan.apps.p.a.release();
        com.baidu.swan.apps.y.f.aCU().aCV();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.ak.b.d.release();
        com.baidu.swan.apps.y.e.aCP();
        if (com.baidu.swan.apps.t.a.axo() != null) {
            com.baidu.swan.apps.t.a.axo().ayy();
        }
        j.aks().release();
        com.baidu.swan.apps.camera.a.akE().onRelease();
        com.baidu.swan.apps.scheme.actions.forbidden.a.aJU().aJX();
        com.baidu.swan.apps.inlinewidget.rtcroom.e.release();
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean aAb() {
        long aAr = f.aAl().aAr();
        if (DEBUG) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + aAr);
        }
        return this.dgU && aAr <= 0;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e aos() {
        return com.baidu.swan.apps.runtime.e.aIK();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.asA());
        }
        com.baidu.swan.apps.r.d.a(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.apps.v.c.2
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, com.baidu.swan.apps.r.a aVar) {
                final d.f fVar = (d.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.aIK() != null && !TextUtils.isEmpty(fVar.deR)) {
                        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.deS.dEQ.dFs.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.deS.dER.dFu.get(str), c.this.apg(), new g.a() { // from class: com.baidu.swan.apps.v.c.2.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void ki(String str2) {
                                com.baidu.swan.apps.console.c.i("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void gg(int i2) {
                                com.baidu.swan.apps.console.c.w("SwanApp", "download subpackage fail: " + i2);
                                bVar.oW(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().sP(com.baidu.swan.apps.statistic.h.ju(bVar.getAppFrameType())).i(new com.baidu.swan.apps.al.a().db(5L).dc(38L).tH("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                    com.baidu.swan.apps.console.c.w("SwanApp", "subpackage is invalid");
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.turbo.d.ase().e(bVar);
        com.baidu.swan.apps.core.turbo.d.ase().f(bVar);
        com.baidu.swan.apps.core.turbo.d.ase().a((d.b) null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void b(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.asA());
        }
        com.baidu.swan.apps.core.turbo.d.ase().e(bVar);
        com.baidu.swan.apps.core.turbo.d.ase().a((d.b) null);
        SwanAppConfigData aIT = com.baidu.swan.apps.runtime.d.aIG().aIC().aIT();
        if (aIT != null) {
            d.f fVar = new d.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.v.c.3
                @Override // java.lang.Runnable
                public void run() {
                    d.C0446d.bM(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.deS = aIT;
            fVar.deR = d.C0446d.bL(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.i.aEb().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.aj.a.aLi().sz("na_post_to_main_start");
            b(bVar, fVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion azN() {
        return com.baidu.swan.apps.core.turbo.d.ase().asA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.i.aEb().f(new UbcFlowEvent("na_post_to_main_start"));
            ak.j(this.dgX);
            this.dgX = new Runnable() { // from class: com.baidu.swan.apps.v.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ak.i(this.dgX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aEb().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.aj.a.aLi().sz("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.mIsReleased) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.deR + ", baseUrl:" + f.aAl().azS())));
                return;
            }
            return;
        }
        this.deR = fVar.deR;
        d(fVar.deS);
        if (bVar.azm()) {
            B(this.dgS).setVisibility(0);
            com.baidu.swan.apps.console.a.eW(true);
            com.baidu.swan.apps.console.c.i("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.turbo.d.ase().a(bVar, fVar);
    }

    private void d(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d aIG = com.baidu.swan.apps.runtime.d.aIG();
        if (aIG.aFY()) {
            aIG.aIC().g(swanAppConfigData);
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
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && com.baidu.swan.apps.t.a.axW().J(string, string2, string3)) {
                        bVar.bT("fromHost", null);
                        bVar.bT("spuId", null);
                        bVar.bT("contentId", null);
                    }
                }
            }, 2000L);
        }
    }
}
