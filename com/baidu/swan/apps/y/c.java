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
/* loaded from: classes10.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable bvh;

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Gh() {
        super.Gh();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppForeground");
        String aar = com.baidu.swan.apps.runtime.e.aar();
        if (!TextUtils.isEmpty(aar)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", aar);
            if (this.bvc != null && this.bvc.En() != null) {
                hashMap.put("clkid", this.bvc.En().TA());
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, this.bvc.En().Tt());
                b.a En = this.bvc.En();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = com.baidu.swan.apps.statistic.f.gb(0);
                fVar.mAppId = En.getAppId();
                fVar.mSource = En.Tt();
                fVar.mType = "show";
                fVar.ba(com.baidu.swan.apps.statistic.f.lt(En.Tv()));
                fVar.lC(En.Tz().getString("ubc"));
                com.baidu.swan.apps.statistic.f.onEvent(fVar);
            }
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.HP().bT(false);
            com.baidu.swan.apps.media.b.cK(true);
            com.baidu.swan.apps.media.b.c.a.cR(false);
            com.baidu.swan.apps.ac.f.Wy().cR(false);
            com.baidu.swan.apps.ac.e.Ws();
            ah.aeM();
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Gi() {
        super.Gi();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppBackground");
        String aar = com.baidu.swan.apps.runtime.e.aar();
        if (!TextUtils.isEmpty(aar)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppHide");
            hashMap.put("appId", aar);
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppHide");
            com.baidu.swan.apps.camera.a.HP().bT(true);
            com.baidu.swan.apps.media.b.cK(false);
            com.baidu.swan.apps.media.b.c.a.cR(true);
            com.baidu.swan.apps.ac.f.Wy().cR(true);
            com.baidu.swan.apps.ac.e.cX(false);
            ah.aeK();
            com.baidu.swan.apps.ab.a.We();
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.k.d.release();
        if (this.buZ != null) {
            this.buZ = null;
        }
        com.baidu.swan.apps.as.g.aeq();
        com.baidu.swan.apps.media.b.UN();
        com.baidu.swan.apps.media.b.c.a.releaseAll();
        com.baidu.swan.apps.ao.e.a.release();
        com.baidu.swan.apps.ao.a.a.release();
        com.baidu.swan.apps.ao.g.a.release();
        com.baidu.swan.apps.core.h.a.release();
        com.baidu.swan.apps.q.a.release();
        com.baidu.swan.apps.ac.f.Wy().Wz();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.ao.b.d.release();
        com.baidu.swan.apps.ac.e.Wt();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @Nullable
    public com.baidu.swan.apps.runtime.e Mk() {
        return com.baidu.swan.apps.runtime.e.aap();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void a(final com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.OA());
        }
        com.baidu.swan.apps.t.e.a(bVar, new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.apps.y.c.1
            @Override // com.baidu.swan.apps.t.b
            public void a(final int i, com.baidu.swan.apps.t.a aVar) {
                final e.f fVar = (e.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.aap() == null || TextUtils.isEmpty(fVar.bto)) {
                        if (c.DEBUG) {
                            Log.e("AppsControllerImpl", "下载分包，信息校验失败");
                        }
                        com.baidu.swan.apps.console.c.d("SwanApp", "subpackage is invalid");
                    } else {
                        String delAllParamsFromUrl = ag.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.btp.bLx.bLT.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.btp.bLy.bLV.get(str), c.this.LJ(), new g.a() { // from class: com.baidu.swan.apps.y.c.1.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void success(String str2) {
                                if (c.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包成功");
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void dI(int i2) {
                                if (c.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包失败：" + i2);
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage fail");
                                bVar.io(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().ly(com.baidu.swan.apps.statistic.f.gb(bVar.getAppFrameType())).e(new com.baidu.swan.apps.ap.a().aE(5L).aF(38L).mk("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.k.d.Og().e(bVar);
        com.baidu.swan.apps.core.k.d.Og().f(bVar);
        com.baidu.swan.apps.core.k.d.Og().a((d.a) null);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void b(final com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.OA());
        }
        com.baidu.swan.apps.core.k.d.Og().e(bVar);
        com.baidu.swan.apps.core.k.d.Og().a((d.a) null);
        SwanAppConfigData aav = com.baidu.swan.apps.runtime.d.aam().aaj().aav();
        if (aav != null) {
            e.f fVar = new e.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    e.d.aC(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.btp = aav;
            fVar.bto = e.d.aB(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.f.XF().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.an.a.acr().ln("na_post_to_main_start");
            b(bVar, fVar);
            com.baidu.swan.apps.core.h.a.release();
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanCoreVersion Uf() {
        return com.baidu.swan.apps.core.k.d.Og().OA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.x.b.b bVar, final e.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.f.XF().f(new UbcFlowEvent("na_post_to_main_start"));
            ai.k(this.bvh);
            this.bvh = new Runnable() { // from class: com.baidu.swan.apps.y.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ai.j(this.bvh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.x.b.b bVar, e.f fVar) {
        com.baidu.swan.apps.performance.f.XF().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.an.a.acr().ln("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.mIsReleased) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.bto + ", baseUrl:" + f.UC().Uk())));
                return;
            }
            return;
        }
        this.bto = fVar.bto;
        a(fVar.btp);
        if (bVar.TF()) {
            N(this.bvc).setVisibility(0);
            com.baidu.swan.apps.console.a.bX(true);
            com.baidu.swan.apps.console.c.d("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.k.d.Og().a(bVar, fVar);
    }

    private void a(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d aam = com.baidu.swan.apps.runtime.d.aam();
        if (aam.YT()) {
            aam.aaj().c(swanAppConfigData);
        }
    }
}
