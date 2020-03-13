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
/* loaded from: classes11.dex */
public class c extends b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable bzs;

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Iy() {
        super.Iy();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppForeground");
        String acH = com.baidu.swan.apps.runtime.e.acH();
        if (!TextUtils.isEmpty(acH)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", acH);
            if (this.bzn != null && this.bzn.GE() != null) {
                hashMap.put("clkid", this.bzn.GE().VQ());
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, this.bzn.GE().VJ());
                b.a GE = this.bzn.GE();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(0);
                fVar.mAppId = GE.getAppId();
                fVar.mSource = GE.VJ();
                fVar.mType = "show";
                fVar.ba(com.baidu.swan.apps.statistic.f.lI(GE.VL()));
                fVar.lR(GE.VP().getString("ubc"));
                com.baidu.swan.apps.statistic.f.onEvent(fVar);
            }
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.Kg().cb(false);
            com.baidu.swan.apps.media.b.cR(true);
            com.baidu.swan.apps.media.b.c.a.cY(false);
            com.baidu.swan.apps.ac.f.YO().cY(false);
            com.baidu.swan.apps.ac.e.YI();
            ah.ahc();
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Iz() {
        super.Iz();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppBackground");
        String acH = com.baidu.swan.apps.runtime.e.acH();
        if (!TextUtils.isEmpty(acH)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppHide");
            hashMap.put("appId", acH);
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppHide");
            com.baidu.swan.apps.camera.a.Kg().cb(true);
            com.baidu.swan.apps.media.b.cR(false);
            com.baidu.swan.apps.media.b.c.a.cY(true);
            com.baidu.swan.apps.ac.f.YO().cY(true);
            com.baidu.swan.apps.ac.e.de(false);
            ah.aha();
            com.baidu.swan.apps.ab.a.Yu();
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.k.d.release();
        if (this.bzk != null) {
            this.bzk = null;
        }
        com.baidu.swan.apps.as.g.agG();
        com.baidu.swan.apps.media.b.Xd();
        com.baidu.swan.apps.media.b.c.a.releaseAll();
        com.baidu.swan.apps.ao.e.a.release();
        com.baidu.swan.apps.ao.a.a.release();
        com.baidu.swan.apps.ao.g.a.release();
        com.baidu.swan.apps.core.h.a.release();
        com.baidu.swan.apps.q.a.release();
        com.baidu.swan.apps.ac.f.YO().YP();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.ao.b.d.release();
        com.baidu.swan.apps.ac.e.YJ();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @Nullable
    public com.baidu.swan.apps.runtime.e OA() {
        return com.baidu.swan.apps.runtime.e.acF();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void a(final com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.QQ());
        }
        com.baidu.swan.apps.t.e.a(bVar, new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.apps.y.c.1
            @Override // com.baidu.swan.apps.t.b
            public void a(final int i, com.baidu.swan.apps.t.a aVar) {
                final e.f fVar = (e.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.acF() == null || TextUtils.isEmpty(fVar.bxA)) {
                        if (c.DEBUG) {
                            Log.e("AppsControllerImpl", "下载分包，信息校验失败");
                        }
                        com.baidu.swan.apps.console.c.d("SwanApp", "subpackage is invalid");
                    } else {
                        String delAllParamsFromUrl = ag.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.bxB.bPE.bQa.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.bxB.bPF.bQc.get(str), c.this.NZ(), new g.a() { // from class: com.baidu.swan.apps.y.c.1.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void success(String str2) {
                                if (c.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包成功");
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void dY(int i2) {
                                if (c.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包失败：" + i2);
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage fail");
                                bVar.iD(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().lN(com.baidu.swan.apps.statistic.f.gs(bVar.getAppFrameType())).e(new com.baidu.swan.apps.ap.a().aI(5L).aJ(38L).mz("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.k.d.Qw().e(bVar);
        com.baidu.swan.apps.core.k.d.Qw().f(bVar);
        com.baidu.swan.apps.core.k.d.Qw().a((d.a) null);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void b(final com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.QQ());
        }
        com.baidu.swan.apps.core.k.d.Qw().e(bVar);
        com.baidu.swan.apps.core.k.d.Qw().a((d.a) null);
        SwanAppConfigData acL = com.baidu.swan.apps.runtime.d.acC().acz().acL();
        if (acL != null) {
            e.f fVar = new e.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    e.d.aM(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.bxB = acL;
            fVar.bxA = e.d.aL(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.f.ZV().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.an.a.aeH().lC("na_post_to_main_start");
            b(bVar, fVar);
            com.baidu.swan.apps.core.h.a.release();
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanCoreVersion Wv() {
        return com.baidu.swan.apps.core.k.d.Qw().QQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.x.b.b bVar, final e.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.f.ZV().f(new UbcFlowEvent("na_post_to_main_start"));
            ai.k(this.bzs);
            this.bzs = new Runnable() { // from class: com.baidu.swan.apps.y.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ai.j(this.bzs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.x.b.b bVar, e.f fVar) {
        com.baidu.swan.apps.performance.f.ZV().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.an.a.aeH().lC("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.mIsReleased) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.bxA + ", baseUrl:" + f.WS().WA())));
                return;
            }
            return;
        }
        this.bxA = fVar.bxA;
        a(fVar.bxB);
        if (bVar.VV()) {
            O(this.bzn).setVisibility(0);
            com.baidu.swan.apps.console.a.cf(true);
            com.baidu.swan.apps.console.c.d("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.k.d.Qw().a(bVar, fVar);
    }

    private void a(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d acC = com.baidu.swan.apps.runtime.d.acC();
        if (acC.abj()) {
            acC.acz().c(swanAppConfigData);
        }
    }
}
