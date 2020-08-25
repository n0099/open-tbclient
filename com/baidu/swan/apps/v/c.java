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
/* loaded from: classes8.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable cwT;

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void aay() {
        super.aay();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppForeground");
        String azK = com.baidu.swan.apps.runtime.e.azK();
        if (!TextUtils.isEmpty(azK)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", azK);
            if (this.cwO != null && this.cwO.XZ() != null) {
                hashMap.put("clkid", this.cwO.XZ().aqU());
                hashMap.put("scene", this.cwO.XZ().aqN());
                b.a XZ = this.cwO.XZ();
                com.baidu.swan.apps.statistic.e.o(XZ);
                h(XZ);
            }
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.acA().dC(false);
            com.baidu.swan.apps.media.b.eI(true);
            com.baidu.swan.apps.media.a.c.a.eP(false);
            com.baidu.swan.apps.y.f.auI().eP(false);
            j.aco().acp();
            com.baidu.swan.apps.y.e.auC();
            if (com.baidu.swan.apps.t.a.apb() != null) {
                com.baidu.swan.apps.t.a.apb().aqm();
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (com.baidu.swan.apps.performance.b.c.awp()) {
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.v.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aj.bS(currentTimeMillis);
                    }
                }, "saveSwanAppForeGroundTime");
            } else {
                aj.bS(currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void aaz() {
        super.aaz();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppBackground");
        String azK = com.baidu.swan.apps.runtime.e.azK();
        if (!TextUtils.isEmpty(azK)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put("appId", azK);
            contentValues.put("hiddenType", Integer.valueOf(ap.aFx().aFw()));
            b(new com.baidu.swan.apps.event.a.c(contentValues));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppHide");
            ap.aFx().reset();
            com.baidu.swan.apps.camera.a.acA().dC(true);
            com.baidu.swan.apps.media.b.eI(false);
            com.baidu.swan.apps.media.a.c.a.eP(true);
            com.baidu.swan.apps.y.f.auI().eP(true);
            com.baidu.swan.apps.y.e.eX(false);
            if (com.baidu.swan.apps.t.a.apb() != null) {
                com.baidu.swan.apps.t.a.apb().aqn();
                com.baidu.swan.apps.t.a.apb().eA(false);
            }
            aj.aFf();
            com.baidu.swan.apps.x.a.auj();
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.turbo.d.release(false);
        if (this.cwL != null) {
            this.cwL = null;
        }
        com.baidu.swan.apps.ap.i.aEG();
        com.baidu.swan.apps.media.b.asu();
        com.baidu.swan.apps.media.a.c.a.releaseAll();
        com.baidu.swan.apps.al.e.a.release();
        com.baidu.swan.apps.al.a.a.release();
        com.baidu.swan.apps.al.g.a.release();
        com.baidu.swan.apps.p.a.release();
        com.baidu.swan.apps.y.f.auI().auJ();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.al.b.d.release();
        com.baidu.swan.apps.y.e.auD();
        if (com.baidu.swan.apps.t.a.apb() != null) {
            com.baidu.swan.apps.t.a.apb().aql();
        }
        j.aco().release();
        com.baidu.swan.apps.camera.a.acA().onRelease();
        com.baidu.swan.apps.scheme.actions.forbidden.a.aAS().aAV();
        com.baidu.swan.apps.inlinewidget.rtcroom.e.release();
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean arO() {
        long ase = f.arY().ase();
        if (DEBUG) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + ase);
        }
        return this.cwQ && ase <= 0;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e agn() {
        return com.baidu.swan.apps.runtime.e.azI();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.akn());
        }
        com.baidu.swan.apps.r.d.a(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.apps.v.c.2
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, com.baidu.swan.apps.r.a aVar) {
                final d.f fVar = (d.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.azI() != null && !TextUtils.isEmpty(fVar.cuN)) {
                        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.cuO.cQS.cRu.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.cuO.cQT.cRw.get(str), c.this.agW(), new g.a() { // from class: com.baidu.swan.apps.v.c.2.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void iT(String str2) {
                                com.baidu.swan.apps.console.c.i("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void gv(int i2) {
                                com.baidu.swan.apps.console.c.w("SwanApp", "download subpackage fail: " + i2);
                                bVar.nG(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().ru(com.baidu.swan.apps.statistic.h.jv(bVar.getAppFrameType())).i(new com.baidu.swan.apps.am.a().bO(5L).bP(38L).sm("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                    com.baidu.swan.apps.console.c.w("SwanApp", "subpackage is invalid");
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.turbo.d.ajS().e(bVar);
        com.baidu.swan.apps.core.turbo.d.ajS().f(bVar);
        com.baidu.swan.apps.core.turbo.d.ajS().a((d.b) null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void b(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.akn());
        }
        com.baidu.swan.apps.core.turbo.d.ajS().e(bVar);
        com.baidu.swan.apps.core.turbo.d.ajS().a((d.b) null);
        SwanAppConfigData azR = com.baidu.swan.apps.runtime.d.azE().azA().azR();
        if (azR != null) {
            d.f fVar = new d.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.v.c.3
                @Override // java.lang.Runnable
                public void run() {
                    d.C0426d.bC(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.cuO = azR;
            fVar.cuN = d.C0426d.bB(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.i.avS().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.ak.a.aCf().re("na_post_to_main_start");
            b(bVar, fVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion arA() {
        return com.baidu.swan.apps.core.turbo.d.ajS().akn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.i.avS().f(new UbcFlowEvent("na_post_to_main_start"));
            ak.l(this.cwT);
            this.cwT = new Runnable() { // from class: com.baidu.swan.apps.v.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ak.k(this.cwT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.avS().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.ak.a.aCf().re("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.cnC) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.cuN + ", baseUrl:" + f.arY().arF())));
                return;
            }
            return;
        }
        this.cuN = fVar.cuN;
        d(fVar.cuO);
        if (bVar.aqZ()) {
            H(this.cwO).setVisibility(0);
            com.baidu.swan.apps.console.a.dG(true);
            com.baidu.swan.apps.console.c.i("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.turbo.d.ajS().a(bVar, fVar);
    }

    private void d(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d azE = com.baidu.swan.apps.runtime.d.azE();
        if (azE.axR()) {
            azE.azA().g(swanAppConfigData);
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
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && com.baidu.swan.apps.t.a.apK().t(string, string2, string3)) {
                        bVar.bJ("fromHost", null);
                        bVar.bJ("spuId", null);
                        bVar.bJ("contentId", null);
                    }
                }
            }, 2000L);
        }
    }
}
