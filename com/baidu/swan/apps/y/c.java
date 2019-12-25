package com.baidu.swan.apps.y;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.as.ah;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.k.d;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.k.g;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.apps.x.b.b;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable but;

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void FL() {
        super.FL();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppForeground");
        String ZU = com.baidu.swan.apps.runtime.e.ZU();
        if (!TextUtils.isEmpty(ZU)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", ZU);
            if (this.buo != null && this.buo.DR() != null) {
                hashMap.put("clkid", this.buo.DR().Td());
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, this.buo.DR().SW());
                b.a DR = this.buo.DR();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = com.baidu.swan.apps.statistic.f.ga(0);
                fVar.mAppId = DR.getAppId();
                fVar.mSource = DR.SW();
                fVar.mType = "show";
                fVar.ba(com.baidu.swan.apps.statistic.f.lq(DR.SY()));
                fVar.lz(DR.Tc().getString("ubc"));
                com.baidu.swan.apps.statistic.f.onEvent(fVar);
            }
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.Ht().bO(false);
            com.baidu.swan.apps.media.b.cF(true);
            com.baidu.swan.apps.media.b.c.a.cM(false);
            com.baidu.swan.apps.ac.f.Wb().cM(false);
            com.baidu.swan.apps.ac.e.VV();
            ah.aet();
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void FM() {
        super.FM();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppBackground");
        String ZU = com.baidu.swan.apps.runtime.e.ZU();
        if (!TextUtils.isEmpty(ZU)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppHide");
            hashMap.put("appId", ZU);
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppHide");
            com.baidu.swan.apps.camera.a.Ht().bO(true);
            com.baidu.swan.apps.media.b.cF(false);
            com.baidu.swan.apps.media.b.c.a.cM(true);
            com.baidu.swan.apps.ac.f.Wb().cM(true);
            com.baidu.swan.apps.ac.e.cS(false);
            ah.aer();
            com.baidu.swan.apps.ab.a.VH();
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.k.d.release();
        if (this.bul != null) {
            this.bul = null;
        }
        com.baidu.swan.apps.as.g.adX();
        com.baidu.swan.apps.media.b.Uq();
        com.baidu.swan.apps.media.b.c.a.releaseAll();
        com.baidu.swan.apps.ao.d.a.a.release();
        com.baidu.swan.apps.ao.f.a.release();
        com.baidu.swan.apps.ao.a.a.release();
        com.baidu.swan.apps.ao.h.a.release();
        com.baidu.swan.apps.core.h.a.release();
        com.baidu.swan.apps.q.a.release();
        com.baidu.swan.apps.ac.f.Wb().Wc();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.ao.b.d.release();
        com.baidu.swan.apps.ac.e.VW();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @Nullable
    public com.baidu.swan.apps.runtime.e LO() {
        return com.baidu.swan.apps.runtime.e.ZS();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void a(final com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.Oe());
        }
        com.baidu.swan.apps.t.e.a(bVar, new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.apps.y.c.1
            @Override // com.baidu.swan.apps.t.b
            public void a(final int i, com.baidu.swan.apps.t.a aVar) {
                final e.f fVar = (e.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.ZS() == null || TextUtils.isEmpty(fVar.bsA)) {
                        if (c.DEBUG) {
                            Log.e("AppsControllerImpl", "下载分包，信息校验失败");
                        }
                        com.baidu.swan.apps.console.c.d("SwanApp", "subpackage is invalid");
                    } else {
                        String delAllParamsFromUrl = ag.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.bsB.bKN.bLj.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.bsB.bKO.bLl.get(str), c.this.Ln(), new g.a() { // from class: com.baidu.swan.apps.y.c.1.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void success(String str2) {
                                if (c.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包成功");
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void dH(int i2) {
                                if (c.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包失败：" + i2);
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage fail");
                                bVar.il(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().lv(com.baidu.swan.apps.statistic.f.ga(bVar.getAppFrameType())).e(new com.baidu.swan.apps.ap.a().aB(5L).aC(38L).mh("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.k.d.NK().e(bVar);
        com.baidu.swan.apps.core.k.d.NK().f(bVar);
        com.baidu.swan.apps.core.k.d.NK().a((d.a) null);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void b(final com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.Oe());
        }
        com.baidu.swan.apps.core.k.d.NK().e(bVar);
        com.baidu.swan.apps.core.k.d.NK().a((d.a) null);
        SwanAppConfigData ZY = com.baidu.swan.apps.runtime.d.ZP().ZM().ZY();
        if (ZY != null) {
            e.f fVar = new e.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    e.d.aB(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.bsB = ZY;
            fVar.bsA = e.d.aA(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.f.Xi().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.an.a.abU().lk("na_post_to_main_start");
            b(bVar, fVar);
            com.baidu.swan.apps.core.h.a.release();
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanCoreVersion TI() {
        return com.baidu.swan.apps.core.k.d.NK().Oe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.x.b.b bVar, final e.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.f.Xi().f(new UbcFlowEvent("na_post_to_main_start"));
            ai.k(this.but);
            this.but = new Runnable() { // from class: com.baidu.swan.apps.y.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ai.j(this.but);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.x.b.b bVar, e.f fVar) {
        com.baidu.swan.apps.performance.f.Xi().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.an.a.abU().lk("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.mIsReleased) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.bsA + ", baseUrl:" + f.Uf().TN())));
                return;
            }
            return;
        }
        this.bsA = fVar.bsA;
        a(fVar.bsB);
        if (bVar.Ti()) {
            M(this.buo).setVisibility(0);
            com.baidu.swan.apps.console.a.bS(true);
            com.baidu.swan.apps.console.c.d("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.k.d.NK().a(bVar, fVar);
    }

    private void a(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d ZP = com.baidu.swan.apps.runtime.d.ZP();
        if (ZP.Yw()) {
            ZP.ZM().c(swanAppConfigData);
        }
    }
}
