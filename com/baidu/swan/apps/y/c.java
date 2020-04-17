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
    private Runnable bXJ;

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Qn() {
        super.Qn();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppForeground");
        String akP = com.baidu.swan.apps.runtime.e.akP();
        if (!TextUtils.isEmpty(akP)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", akP);
            if (this.bXE != null && this.bXE.Ow() != null) {
                hashMap.put("clkid", this.bXE.Ow().adI());
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, this.bXE.Ow().adB());
                b.a Ow = this.bXE.Ow();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(0);
                fVar.mAppId = Ow.getAppId();
                fVar.mSource = Ow.adB();
                fVar.mType = "show";
                fVar.bl(com.baidu.swan.apps.statistic.f.mU(Ow.adD()));
                fVar.nd(Ow.adH().getString("ubc"));
                com.baidu.swan.apps.statistic.f.onEvent(fVar);
            }
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.RW().cY(false);
            com.baidu.swan.apps.media.b.dO(true);
            com.baidu.swan.apps.media.b.c.a.dV(false);
            com.baidu.swan.apps.ac.f.agX().dV(false);
            com.baidu.swan.apps.ac.e.agR();
            ah.apn();
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Qo() {
        super.Qo();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppBackground");
        String akP = com.baidu.swan.apps.runtime.e.akP();
        if (!TextUtils.isEmpty(akP)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppHide");
            hashMap.put("appId", akP);
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppHide");
            com.baidu.swan.apps.camera.a.RW().cY(true);
            com.baidu.swan.apps.media.b.dO(false);
            com.baidu.swan.apps.media.b.c.a.dV(true);
            com.baidu.swan.apps.ac.f.agX().dV(true);
            com.baidu.swan.apps.ac.e.eb(false);
            ah.apl();
            com.baidu.swan.apps.ab.a.agD();
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.k.d.release();
        if (this.bXB != null) {
            this.bXB = null;
        }
        com.baidu.swan.apps.as.g.aoO();
        com.baidu.swan.apps.media.b.aeW();
        com.baidu.swan.apps.media.b.c.a.releaseAll();
        com.baidu.swan.apps.ao.e.a.release();
        com.baidu.swan.apps.ao.a.a.release();
        com.baidu.swan.apps.ao.g.a.release();
        com.baidu.swan.apps.core.h.a.release();
        com.baidu.swan.apps.q.a.release();
        com.baidu.swan.apps.ac.f.agX().agY();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.ao.b.d.release();
        com.baidu.swan.apps.ac.e.agS();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @Nullable
    public com.baidu.swan.apps.runtime.e Wr() {
        return com.baidu.swan.apps.runtime.e.akN();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void a(final com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.YI());
        }
        com.baidu.swan.apps.t.e.a(bVar, new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.apps.y.c.1
            @Override // com.baidu.swan.apps.t.b
            public void a(final int i, com.baidu.swan.apps.t.a aVar) {
                final e.f fVar = (e.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.akN() == null || TextUtils.isEmpty(fVar.bVR)) {
                        if (c.DEBUG) {
                            Log.e("AppsControllerImpl", "下载分包，信息校验失败");
                        }
                        com.baidu.swan.apps.console.c.d("SwanApp", "subpackage is invalid");
                    } else {
                        String delAllParamsFromUrl = ag.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.bVS.coB.coX.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.bVS.coC.coZ.get(str), c.this.VQ(), new g.a() { // from class: com.baidu.swan.apps.y.c.1.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void gt(String str2) {
                                if (c.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包成功");
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void ed(int i2) {
                                if (c.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包失败：" + i2);
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage fail");
                                bVar.jP(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().mZ(com.baidu.swan.apps.statistic.f.gz(bVar.getAppFrameType())).e(new com.baidu.swan.apps.ap.a().bn(5L).bo(38L).nL("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.k.d.Yo().e(bVar);
        com.baidu.swan.apps.core.k.d.Yo().f(bVar);
        com.baidu.swan.apps.core.k.d.Yo().a((d.a) null);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void b(final com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.YI());
        }
        com.baidu.swan.apps.core.k.d.Yo().e(bVar);
        com.baidu.swan.apps.core.k.d.Yo().a((d.a) null);
        SwanAppConfigData akT = com.baidu.swan.apps.runtime.d.akK().akH().akT();
        if (akT != null) {
            e.f fVar = new e.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    e.d.aU(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.bVS = akT;
            fVar.bVR = e.d.aT(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.f.aid().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.an.a.amP().mO("na_post_to_main_start");
            b(bVar, fVar);
            com.baidu.swan.apps.core.h.a.release();
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanCoreVersion aen() {
        return com.baidu.swan.apps.core.k.d.Yo().YI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.x.b.b bVar, final e.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.f.aid().f(new UbcFlowEvent("na_post_to_main_start"));
            ai.n(this.bXJ);
            this.bXJ = new Runnable() { // from class: com.baidu.swan.apps.y.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ai.m(this.bXJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.x.b.b bVar, e.f fVar) {
        com.baidu.swan.apps.performance.f.aid().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.an.a.amP().mO("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.bQV) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.bVR + ", baseUrl:" + f.aeK().aes())));
                return;
            }
            return;
        }
        this.bVR = fVar.bVR;
        a(fVar.bVS);
        if (bVar.adN()) {
            K(this.bXE).setVisibility(0);
            com.baidu.swan.apps.console.a.dc(true);
            com.baidu.swan.apps.console.c.d("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.k.d.Yo().a(bVar, fVar);
    }

    private void a(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d akK = com.baidu.swan.apps.runtime.d.akK();
        if (akK.ajr()) {
            akK.akH().c(swanAppConfigData);
        }
    }
}
