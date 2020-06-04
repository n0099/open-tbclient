package com.baidu.swan.apps.w;

import android.content.ContentValues;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.an;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.k.g;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.b.b;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable ciq;

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void SQ() {
        super.SQ();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppForeground");
        String aoH = com.baidu.swan.apps.runtime.e.aoH();
        if (!TextUtils.isEmpty(aoH)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", aoH);
            if (this.cil != null && this.cil.QJ() != null) {
                hashMap.put("clkid", this.cil.QJ().agR());
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, this.cil.QJ().agK());
                b.a QJ = this.cil.QJ();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = com.baidu.swan.apps.statistic.h.gU(0);
                fVar.mAppId = QJ.getAppId();
                fVar.mSource = QJ.agK();
                fVar.mType = "show";
                fVar.bu(com.baidu.swan.apps.statistic.h.ox(QJ.agM()));
                fVar.oG(QJ.agQ().getString("ubc"));
                com.baidu.swan.apps.statistic.h.onEvent(fVar);
                h(QJ);
            }
            a(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.UH().dl(false);
            com.baidu.swan.apps.media.b.ef(true);
            com.baidu.swan.apps.media.a.c.a.em(false);
            com.baidu.swan.apps.aa.f.akp().em(false);
            com.baidu.swan.apps.api.module.k.h.Uv().Uw();
            com.baidu.swan.apps.aa.e.akj();
            ai.atM();
        }
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void SR() {
        super.SR();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppBackground");
        String aoH = com.baidu.swan.apps.runtime.e.aoH();
        if (!TextUtils.isEmpty(aoH)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put("appId", aoH);
            contentValues.put("hiddenType", Integer.valueOf(an.atY().atX() ? 1 : 0));
            a(new com.baidu.swan.apps.event.a.c(contentValues));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppHide");
            an.atY().reset();
            com.baidu.swan.apps.camera.a.UH().dl(true);
            com.baidu.swan.apps.media.b.ef(false);
            com.baidu.swan.apps.media.a.c.a.em(true);
            com.baidu.swan.apps.aa.f.akp().em(true);
            com.baidu.swan.apps.aa.e.es(false);
            ai.atK();
            com.baidu.swan.apps.z.a.ajQ();
        }
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.turbo.d.release(false);
        if (this.cii != null) {
            this.cii = null;
        }
        com.baidu.swan.apps.aq.h.ato();
        com.baidu.swan.apps.media.b.aij();
        com.baidu.swan.apps.media.a.c.a.releaseAll();
        com.baidu.swan.apps.am.e.a.release();
        com.baidu.swan.apps.am.a.a.release();
        com.baidu.swan.apps.am.g.a.release();
        com.baidu.swan.apps.o.a.release();
        com.baidu.swan.apps.aa.f.akp().akq();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.am.b.d.release();
        com.baidu.swan.apps.aa.e.akk();
        com.baidu.swan.apps.camera.a.UH().release();
        com.baidu.swan.apps.api.module.k.h.Uv().release();
    }

    @Override // com.baidu.swan.apps.w.d
    public boolean ahL() {
        long aib = f.ahV().aib();
        if (DEBUG) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + aib);
        }
        return this.cin && aib <= 0;
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    @Nullable
    public com.baidu.swan.apps.runtime.e Zc() {
        return com.baidu.swan.apps.runtime.e.aoF();
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void a(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.abG());
        }
        com.baidu.swan.apps.r.e.a(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.apps.w.c.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, com.baidu.swan.apps.r.a aVar) {
                final e.f fVar = (e.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.aoF() == null || TextUtils.isEmpty(fVar.cgs)) {
                        if (c.DEBUG) {
                            Log.e("AppsControllerImpl", "下载分包，信息校验失败");
                        }
                        com.baidu.swan.apps.console.c.d("SwanApp", "subpackage is invalid");
                    } else {
                        String delAllParamsFromUrl = ah.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.cgt.cAt.cAT.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.cgt.cAu.cAV.get(str), c.this.YB(), new g.a() { // from class: com.baidu.swan.apps.w.c.1.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void hg(String str2) {
                                if (c.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包成功");
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void el(int i2) {
                                if (c.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包失败：" + i2);
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage fail");
                                bVar.lb(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().oC(com.baidu.swan.apps.statistic.h.gU(bVar.getAppFrameType())).f(new com.baidu.swan.apps.an.a().bw(5L).bx(38L).pt("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.turbo.d.abl().e(bVar);
        com.baidu.swan.apps.core.turbo.d.abl().f(bVar);
        com.baidu.swan.apps.core.turbo.d.abl().a((d.a) null);
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void b(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.abG());
        }
        com.baidu.swan.apps.core.turbo.d.abl().e(bVar);
        com.baidu.swan.apps.core.turbo.d.abl().a((d.a) null);
        SwanAppConfigData aoO = com.baidu.swan.apps.runtime.d.aoB().aox().aoO();
        if (aoO != null) {
            e.f fVar = new e.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.w.c.2
                @Override // java.lang.Runnable
                public void run() {
                    e.d.bl(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.cgt = aoO;
            fVar.cgs = e.d.bk(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.g.alx().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.al.a.aqT().oo("na_post_to_main_start");
            b(bVar, fVar);
        }
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public SwanCoreVersion ahx() {
        return com.baidu.swan.apps.core.turbo.d.abl().abG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.v.b.b bVar, final e.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.g.alx().f(new UbcFlowEvent("na_post_to_main_start"));
            aj.o(this.ciq);
            this.ciq = new Runnable() { // from class: com.baidu.swan.apps.w.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            aj.n(this.ciq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.v.b.b bVar, e.f fVar) {
        com.baidu.swan.apps.performance.g.alx().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.al.a.aqT().oo("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.caM) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.cgs + ", baseUrl:" + f.ahV().ahC())));
                return;
            }
            return;
        }
        this.cgs = fVar.cgs;
        d(fVar.cgt);
        if (bVar.agW()) {
            I(this.cil).setVisibility(0);
            com.baidu.swan.apps.console.a.dp(true);
            com.baidu.swan.apps.console.c.d("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.turbo.d.abl().a(bVar, fVar);
    }

    private void d(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d aoB = com.baidu.swan.apps.runtime.d.aoB();
        if (aoB.ane()) {
            aoB.aox().f(swanAppConfigData);
        }
    }

    private void h(final com.baidu.swan.apps.v.b.b bVar) {
        if (!TextUtils.isEmpty(bVar.getString("fromHost")) && !TextUtils.isEmpty(bVar.getString("spuId")) && !TextUtils.isEmpty(bVar.getString("contentId"))) {
            aj.c(new Runnable() { // from class: com.baidu.swan.apps.w.c.4
                @Override // java.lang.Runnable
                public void run() {
                    String string = bVar.getString("fromHost");
                    String string2 = bVar.getString("spuId");
                    String string3 = bVar.getString("contentId");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && com.baidu.swan.apps.u.a.afP().r(string, string2, string3)) {
                        bVar.bs("fromHost", null);
                        bVar.bs("spuId", null);
                        bVar.bs("contentId", null);
                    }
                }
            }, 2000L);
        }
    }
}
