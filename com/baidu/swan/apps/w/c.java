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
    private Runnable cne;

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void TW() {
        super.TW();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppForeground");
        String apO = com.baidu.swan.apps.runtime.e.apO();
        if (!TextUtils.isEmpty(apO)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", apO);
            if (this.cmZ != null && this.cmZ.RP() != null) {
                hashMap.put("clkid", this.cmZ.RP().ahX());
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, this.cmZ.RP().ahQ());
                b.a RP = this.cmZ.RP();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = com.baidu.swan.apps.statistic.h.hf(0);
                fVar.mAppId = RP.getAppId();
                fVar.mSource = RP.ahQ();
                fVar.mType = "show";
                fVar.bB(com.baidu.swan.apps.statistic.h.oF(RP.ahS()));
                fVar.oO(RP.ahW().getString("ubc"));
                com.baidu.swan.apps.statistic.h.onEvent(fVar);
                h(RP);
            }
            a(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.VN().dq(false);
            com.baidu.swan.apps.media.b.ek(true);
            com.baidu.swan.apps.media.a.c.a.er(false);
            com.baidu.swan.apps.aa.f.alv().er(false);
            com.baidu.swan.apps.api.module.k.h.VB().VC();
            com.baidu.swan.apps.aa.e.alp();
            ai.auS();
        }
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void TX() {
        super.TX();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppBackground");
        String apO = com.baidu.swan.apps.runtime.e.apO();
        if (!TextUtils.isEmpty(apO)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put("appId", apO);
            contentValues.put("hiddenType", Integer.valueOf(an.ave().avd() ? 1 : 0));
            a(new com.baidu.swan.apps.event.a.c(contentValues));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppHide");
            an.ave().reset();
            com.baidu.swan.apps.camera.a.VN().dq(true);
            com.baidu.swan.apps.media.b.ek(false);
            com.baidu.swan.apps.media.a.c.a.er(true);
            com.baidu.swan.apps.aa.f.alv().er(true);
            com.baidu.swan.apps.aa.e.ex(false);
            ai.auQ();
            com.baidu.swan.apps.z.a.akW();
        }
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.slave.b.clearAll();
        com.baidu.swan.apps.core.turbo.d.release(false);
        if (this.cmW != null) {
            this.cmW = null;
        }
        com.baidu.swan.apps.aq.h.auu();
        com.baidu.swan.apps.media.b.ajp();
        com.baidu.swan.apps.media.a.c.a.releaseAll();
        com.baidu.swan.apps.am.e.a.release();
        com.baidu.swan.apps.am.a.a.release();
        com.baidu.swan.apps.am.g.a.release();
        com.baidu.swan.apps.o.a.release();
        com.baidu.swan.apps.aa.f.alv().alw();
        com.baidu.swan.apps.scheme.actions.d.a.release();
        com.baidu.swan.apps.am.b.d.release();
        com.baidu.swan.apps.aa.e.alq();
        com.baidu.swan.apps.camera.a.VN().release();
        com.baidu.swan.apps.api.module.k.h.VB().release();
    }

    @Override // com.baidu.swan.apps.w.d
    public boolean aiR() {
        long ajh = f.ajb().ajh();
        if (DEBUG) {
            Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + ajh);
        }
        return this.cnb && ajh <= 0;
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    @Nullable
    public com.baidu.swan.apps.runtime.e aai() {
        return com.baidu.swan.apps.runtime.e.apM();
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void a(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.acM());
        }
        com.baidu.swan.apps.r.e.a(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.apps.w.c.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, com.baidu.swan.apps.r.a aVar) {
                final e.f fVar = (e.f) aVar;
                if (com.baidu.swan.apps.scheme.actions.k.g.c(bVar, fVar)) {
                    if (com.baidu.swan.apps.runtime.e.apM() == null || TextUtils.isEmpty(fVar.clg)) {
                        if (c.DEBUG) {
                            Log.e("AppsControllerImpl", "下载分包，信息校验失败");
                        }
                        com.baidu.swan.apps.console.c.d("SwanApp", "subpackage is invalid");
                    } else {
                        String delAllParamsFromUrl = ah.delAllParamsFromUrl(bVar.getPage());
                        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
                            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
                        }
                        String str = fVar.clh.cFd.cFD.get(delAllParamsFromUrl);
                        com.baidu.swan.apps.scheme.actions.k.g.a(bVar.getAppId(), bVar.getVersion(), str, fVar.clh.cFe.cFF.get(str), c.this.ZH(), new g.a() { // from class: com.baidu.swan.apps.w.c.1.1
                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void ho(String str2) {
                                if (c.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包成功");
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage success");
                                c.this.a(i, bVar, fVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                            public void ew(int i2) {
                                if (c.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包失败：" + i2);
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage fail");
                                bVar.lj(null);
                                c.this.a(i, bVar, fVar);
                                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().oK(com.baidu.swan.apps.statistic.h.hf(bVar.getAppFrameType())).f(new com.baidu.swan.apps.an.a().bw(5L).bx(38L).pB("download subpackage fail, errcode=" + i2)).a(bVar));
                            }
                        });
                        return;
                    }
                }
                c.this.a(i, bVar, fVar);
            }
        });
        com.baidu.swan.apps.core.turbo.d.acr().e(bVar);
        com.baidu.swan.apps.core.turbo.d.acr().f(bVar);
        com.baidu.swan.apps.core.turbo.d.acr().a((d.a) null);
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void b(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + bVar.acM());
        }
        com.baidu.swan.apps.core.turbo.d.acr().e(bVar);
        com.baidu.swan.apps.core.turbo.d.acr().a((d.a) null);
        SwanAppConfigData apV = com.baidu.swan.apps.runtime.d.apI().apE().apV();
        if (apV != null) {
            e.f fVar = new e.f();
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.w.c.2
                @Override // java.lang.Runnable
                public void run() {
                    e.d.bn(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder", 3);
            fVar.clh = apV;
            fVar.clg = e.d.bm(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.g.amD().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.al.a.arZ().ow("na_post_to_main_start");
            b(bVar, fVar);
        }
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public SwanCoreVersion aiD() {
        return com.baidu.swan.apps.core.turbo.d.acr().acM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.v.b.b bVar, final e.f fVar) {
        if (i == 0 && bVar != null && fVar != null) {
            com.baidu.swan.apps.performance.g.amD().f(new UbcFlowEvent("na_post_to_main_start"));
            aj.o(this.cne);
            this.cne = new Runnable() { // from class: com.baidu.swan.apps.w.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(bVar, fVar);
                }
            };
            aj.n(this.cne);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.v.b.b bVar, e.f fVar) {
        com.baidu.swan.apps.performance.g.amD().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.al.a.arZ().ow("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + fVar);
        }
        if (this.cfB) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + fVar.clg + ", baseUrl:" + f.ajb().aiI())));
                return;
            }
            return;
        }
        this.clg = fVar.clg;
        d(fVar.clh);
        if (bVar.aic()) {
            I(this.cmZ).setVisibility(0);
            com.baidu.swan.apps.console.a.du(true);
            com.baidu.swan.apps.console.c.d("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.turbo.d.acr().a(bVar, fVar);
    }

    private void d(SwanAppConfigData swanAppConfigData) {
        com.baidu.swan.apps.runtime.d apI = com.baidu.swan.apps.runtime.d.apI();
        if (apI.aok()) {
            apI.apE().f(swanAppConfigData);
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
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && com.baidu.swan.apps.u.a.agV().s(string, string2, string3)) {
                        bVar.bu("fromHost", null);
                        bVar.bu("spuId", null);
                        bVar.bu("contentId", null);
                    }
                }
            }, 2000L);
        }
    }
}
