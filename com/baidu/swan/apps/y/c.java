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
    private Runnable bXP;

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Qm() {
        super.Qm();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppForeground");
        String akO = com.baidu.swan.apps.runtime.e.akO();
        if (!TextUtils.isEmpty(akO)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", akO);
            if (this.bXK != null && this.bXK.Ov() != null) {
                hashMap.put("clkid", this.bXK.Ov().adH());
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, this.bXK.Ov().adA());
                b.a Ov = this.bXK.Ov();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(0);
                fVar.mAppId = Ov.getAppId();
                fVar.mSource = Ov.adA();
                fVar.mType = "show";
                fVar.bl(com.baidu.swan.apps.statistic.f.mU(Ov.adC()));
                fVar.nd(Ov.adG().getString("ubc"));
                com.baidu.swan.apps.statistic.f.onEvent(fVar);
            }
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.RV().cY(false);
            com.baidu.swan.apps.media.b.dO(true);
            com.baidu.swan.apps.media.b.c.a.dV(false);
            com.baidu.swan.apps.ac.f.agW().dV(false);
            com.baidu.swan.apps.ac.e.agQ();
            ah.apm();
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Qn() {
        super.Qn();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppBackground");
        String akO = com.baidu.swan.apps.runtime.e.akO();
        if (!TextUtils.isEmpty(akO)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppHide");
            hashMap.put("appId", akO);
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppHide");
            com.baidu.swan.apps.camera.a.RV().cY(true);
            com.baidu.swan.apps.media.b.dO(false);
            com.baidu.swan.apps.media.b.c.a.dV(true);
            com.baidu.swan.apps.ac.f.agW().dV(true);
            com.baidu.swan.apps.ac.e.eb(false);
            ah.apk();
            com.baidu.swan.apps.ab.a.agC();
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.k.d.release();
        if (this.bXH != null) {
            this.bXH = null;
        }
        com.baidu.swan.apps.as.g.aoN();
        com.baidu.swan.apps.media.b.aeV();
        com.baidu.swan.apps.media.b.c.a.releaseAll();
        com.baidu.swan.apps.ao.e.a.release();
        com.baidu.swan.apps.ao.a.a.release();
        com.baidu.swan.apps.ao.g.a.release();
        com.baidu.swan.apps.core.h.a.release();
        com.baidu.swan.apps.q.a.release();
        com.baidu.swan.apps.ac.f.agW().agX();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.ao.b.d.release();
        com.baidu.swan.apps.ac.e.agR();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @Nullable
    public com.baidu.swan.apps.runtime.e Wq() {
        return com.baidu.swan.apps.runtime.e.akM();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void a(final com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.YH());
        }
        com.baidu.swan.apps.t.e.a(bVar, new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.apps.y.c.1
            @Override // com.baidu.swan.apps.t.b
            public void a(final int i, com.baidu.swan.apps.t.a aVar) {
                final e.f fVar = (e.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.akM() == null || TextUtils.isEmpty(fVar.bVX)) {
                        if (c.DEBUG) {
                            Log.e("AppsControllerImpl", "下载分包，信息校验失败");
                        }
                        com.baidu.swan.apps.console.c.d("SwanApp", "subpackage is invalid");
                    } else {
                        String delAllParamsFromUrl = ag.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.bVY.coH.cpd.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.bVY.coI.cpf.get(str), c.this.VP(), new g.a() { // from class: com.baidu.swan.apps.y.c.1.1
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
        com.baidu.swan.apps.core.k.d.Yn().e(bVar);
        com.baidu.swan.apps.core.k.d.Yn().f(bVar);
        com.baidu.swan.apps.core.k.d.Yn().a((d.a) null);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void b(final com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.YH());
        }
        com.baidu.swan.apps.core.k.d.Yn().e(bVar);
        com.baidu.swan.apps.core.k.d.Yn().a((d.a) null);
        SwanAppConfigData akS = com.baidu.swan.apps.runtime.d.akJ().akG().akS();
        if (akS != null) {
            e.f fVar = new e.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    e.d.aU(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.bVY = akS;
            fVar.bVX = e.d.aT(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.f.aic().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.an.a.amO().mO("na_post_to_main_start");
            b(bVar, fVar);
            com.baidu.swan.apps.core.h.a.release();
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanCoreVersion aem() {
        return com.baidu.swan.apps.core.k.d.Yn().YH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.x.b.b bVar, final e.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.f.aic().f(new UbcFlowEvent("na_post_to_main_start"));
            ai.n(this.bXP);
            this.bXP = new Runnable() { // from class: com.baidu.swan.apps.y.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            ai.m(this.bXP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.x.b.b bVar, e.f fVar) {
        com.baidu.swan.apps.performance.f.aic().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.an.a.amO().mO("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.bRa) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.bVX + ", baseUrl:" + f.aeJ().aer())));
                return;
            }
            return;
        }
        this.bVX = fVar.bVX;
        a(fVar.bVY);
        if (bVar.adM()) {
            K(this.bXK).setVisibility(0);
            com.baidu.swan.apps.console.a.dc(true);
            com.baidu.swan.apps.console.c.d("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.k.d.Yn().a(bVar, fVar);
    }

    private void a(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d akJ = com.baidu.swan.apps.runtime.d.akJ();
        if (akJ.ajq()) {
            akJ.akG().c(swanAppConfigData);
        }
    }
}
