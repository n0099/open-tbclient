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
    private Runnable cTz;

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void afN() {
        super.afN();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppForeground");
        String aEW = com.baidu.swan.apps.runtime.e.aEW();
        if (!TextUtils.isEmpty(aEW)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", aEW);
            if (this.cTu != null && this.cTu.ado() != null) {
                hashMap.put("clkid", this.cTu.ado().awk());
                hashMap.put("scene", this.cTu.ado().awd());
                b.a ado = this.cTu.ado();
                com.baidu.swan.apps.statistic.e.o(ado);
                h(ado);
            }
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.ahP().ek(false);
            com.baidu.swan.apps.media.b.fq(true);
            com.baidu.swan.apps.media.a.c.a.fx(false);
            com.baidu.swan.apps.y.f.azW().fx(false);
            j.ahD().ahE();
            com.baidu.swan.apps.y.e.azQ();
            if (com.baidu.swan.apps.t.a.aus() != null) {
                com.baidu.swan.apps.t.a.aus().avC();
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (com.baidu.swan.apps.performance.b.c.aBD()) {
                p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.v.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aj.cd(currentTimeMillis);
                    }
                }, "saveSwanAppForeGroundTime");
            } else {
                aj.cd(currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void afO() {
        super.afO();
        com.baidu.swan.apps.console.c.i("SwanApp", "onAppBackground");
        String aEW = com.baidu.swan.apps.runtime.e.aEW();
        if (!TextUtils.isEmpty(aEW)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put("appId", aEW);
            contentValues.put("hiddenType", Integer.valueOf(ap.aKK().aKJ()));
            b(new com.baidu.swan.apps.event.a.c(contentValues));
            com.baidu.swan.apps.console.c.i("SwanApp", "onAppHide");
            ap.aKK().reset();
            com.baidu.swan.apps.camera.a.ahP().ek(true);
            com.baidu.swan.apps.media.b.fq(false);
            com.baidu.swan.apps.media.a.c.a.fx(true);
            com.baidu.swan.apps.y.f.azW().fx(true);
            com.baidu.swan.apps.y.e.fF(false);
            if (com.baidu.swan.apps.t.a.aus() != null) {
                com.baidu.swan.apps.t.a.aus().avD();
                com.baidu.swan.apps.t.a.aus().fi(false);
            }
            aj.aKs();
            com.baidu.swan.apps.x.a.azx();
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.turbo.d.release(false);
        if (this.cTr != null) {
            this.cTr = null;
        }
        com.baidu.swan.apps.ap.i.aJT();
        com.baidu.swan.apps.media.b.axJ();
        com.baidu.swan.apps.media.a.c.a.releaseAll();
        com.baidu.swan.apps.al.e.a.release();
        com.baidu.swan.apps.al.a.a.release();
        com.baidu.swan.apps.al.g.a.release();
        com.baidu.swan.apps.p.a.release();
        com.baidu.swan.apps.y.f.azW().azX();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.al.b.d.release();
        com.baidu.swan.apps.y.e.azR();
        if (com.baidu.swan.apps.t.a.aus() != null) {
            com.baidu.swan.apps.t.a.aus().avB();
        }
        j.ahD().release();
        com.baidu.swan.apps.camera.a.ahP().onRelease();
        com.baidu.swan.apps.scheme.actions.forbidden.a.aGe().aGh();
        com.baidu.swan.apps.inlinewidget.rtcroom.e.release();
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean axe() {
        long axu = f.axo().axu();
        if (DEBUG) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + axu);
        }
        return this.cTw && axu <= 0;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e alC() {
        return com.baidu.swan.apps.runtime.e.aEU();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.apD());
        }
        com.baidu.swan.apps.r.d.a(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.apps.v.c.2
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, com.baidu.swan.apps.r.a aVar) {
                final d.f fVar = (d.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.aEU() != null && !TextUtils.isEmpty(fVar.cRt)) {
                        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.cRu.dnE.doh.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.cRu.dnF.doj.get(str), c.this.aml(), new g.a() { // from class: com.baidu.swan.apps.v.c.2.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void ks(String str2) {
                                com.baidu.swan.apps.console.c.i("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void hm(int i2) {
                                com.baidu.swan.apps.console.c.w("SwanApp", "download subpackage fail: " + i2);
                                bVar.ph(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().sU(com.baidu.swan.apps.statistic.h.ko(bVar.getAppFrameType())).i(new com.baidu.swan.apps.am.a().bZ(5L).ca(38L).tM("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                    com.baidu.swan.apps.console.c.w("SwanApp", "subpackage is invalid");
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.turbo.d.aph().e(bVar);
        com.baidu.swan.apps.core.turbo.d.aph().f(bVar);
        com.baidu.swan.apps.core.turbo.d.aph().a((d.b) null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void b(final com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.apD());
        }
        com.baidu.swan.apps.core.turbo.d.aph().e(bVar);
        com.baidu.swan.apps.core.turbo.d.aph().a((d.b) null);
        SwanAppConfigData aFd = com.baidu.swan.apps.runtime.d.aEQ().aEM().aFd();
        if (aFd != null) {
            d.f fVar = new d.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.v.c.3
                @Override // java.lang.Runnable
                public void run() {
                    d.C0452d.bO(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.cRu = aFd;
            fVar.cRt = d.C0452d.bN(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.i.aBg().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.ak.a.aHs().sE("na_post_to_main_start");
            b(bVar, fVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion awQ() {
        return com.baidu.swan.apps.core.turbo.d.aph().apD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.i.aBg().f(new UbcFlowEvent("na_post_to_main_start"));
            ak.l(this.cTz);
            this.cTz = new Runnable() { // from class: com.baidu.swan.apps.v.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ak.k(this.cTz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.performance.i.aBg().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.ak.a.aHs().sE("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.cKt) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.cRt + ", baseUrl:" + f.axo().awV())));
                return;
            }
            return;
        }
        this.cRt = fVar.cRt;
        d(fVar.cRu);
        if (bVar.awp()) {
            J(this.cTu).setVisibility(0);
            com.baidu.swan.apps.console.a.eo(true);
            com.baidu.swan.apps.console.c.i("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.turbo.d.aph().a(bVar, fVar);
    }

    private void d(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d aEQ = com.baidu.swan.apps.runtime.d.aEQ();
        if (aEQ.aDd()) {
            aEQ.aEM().g(swanAppConfigData);
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
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && com.baidu.swan.apps.t.a.ava().D(string, string2, string3)) {
                        bVar.bV("fromHost", null);
                        bVar.bV("spuId", null);
                        bVar.bV("contentId", null);
                    }
                }
            }, 2000L);
        }
    }
}
