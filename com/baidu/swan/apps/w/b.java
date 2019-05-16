package com.baidu.swan.apps.w;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.ab;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.core.j.c;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.scheme.actions.i.g;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable azp;

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void wG() {
        super.wG();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppForeground");
        String LB = com.baidu.swan.apps.ae.b.LB();
        if (!TextUtils.isEmpty(LB)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", LB);
            if (this.azk != null && this.azk.vk() != null) {
                hashMap.put("clkid", this.azk.vk().Fb());
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, this.azk.vk().EW());
                com.baidu.swan.apps.v.b.b vk = this.azk.vk();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = com.baidu.swan.apps.statistic.e.dM(0);
                fVar.mAppId = this.azk.vk().getAppId();
                fVar.mSource = this.azk.vk().EW();
                fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
                fVar.ak(com.baidu.swan.apps.statistic.e.hn(vk.EX()));
                com.baidu.swan.apps.statistic.e.onEvent(fVar);
            }
            com.baidu.swan.apps.u.a.Ed().wG();
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.xe().aQ(false);
            com.baidu.swan.apps.media.b.bu(true);
            com.baidu.swan.apps.media.c.c.a.bw(false);
            com.baidu.swan.apps.y.f.GN().bw(false);
            ab.OS();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void wH() {
        super.wH();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppBackground");
        String LB = com.baidu.swan.apps.ae.b.LB();
        if (!TextUtils.isEmpty(LB)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppHide");
            hashMap.put("appId", LB);
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppHide");
            com.baidu.swan.apps.u.a.Ed().wH();
            com.baidu.swan.apps.camera.a.xe().aQ(true);
            com.baidu.swan.apps.media.b.bu(false);
            com.baidu.swan.apps.media.c.c.a.bw(true);
            com.baidu.swan.apps.y.f.GN().bw(true);
            ab.OQ();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.i.b.clearAll();
        com.baidu.swan.apps.core.j.c.release();
        if (this.azh != null) {
            this.azh = null;
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.media.b.Gf();
        com.baidu.swan.apps.media.c.c.a.release();
        com.baidu.swan.apps.aj.c.a.a.release();
        com.baidu.swan.apps.aj.e.a.release();
        com.baidu.swan.apps.aj.a.a.release();
        com.baidu.swan.apps.aj.g.a.release();
        com.baidu.swan.apps.core.h.a.release();
        com.baidu.swan.apps.y.f.GN().GT();
        com.baidu.swan.apps.scheme.actions.c.a.release();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @Nullable
    public com.baidu.swan.apps.ae.b zX() {
        return com.baidu.swan.apps.ae.b.Lq();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void a(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.BA());
        }
        com.baidu.swan.apps.install.e.a(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.apps.w.b.1
            @Override // com.baidu.swan.apps.install.b
            public void a(final int i, com.baidu.swan.apps.install.a aVar) {
                final e.g gVar = (e.g) aVar;
                if (com.baidu.swan.apps.scheme.actions.i.g.c(bVar, gVar)) {
                    com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
                    if (Lq == null || TextUtils.isEmpty(gVar.axI)) {
                        if (b.DEBUG) {
                            Log.e("AppsControllerImpl", "下载分包，信息校验失败");
                        }
                        com.baidu.swan.apps.console.c.d("SwanApp", "subpackage is invalid");
                    } else {
                        String ik = aa.ik(bVar.getPage());
                        if (!TextUtils.isEmpty(ik) && ik.startsWith(File.separator)) {
                            ik = ik.substring(1);
                        }
                        String str = gVar.axJ.aQo.aQC.get(ik);
                        String str2 = gVar.axI;
                        com.baidu.swan.apps.scheme.actions.i.g.Mj().a(Lq.CR(), bVar.getAppId(), bVar.getVersion(), str, gVar.axJ.aQp.aQD.get(str), str2, b.this.zv(), new g.a() { // from class: com.baidu.swan.apps.w.b.1.1
                            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
                            public void fb(String str3) {
                                if (b.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包成功");
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage success");
                                b.this.a(i, bVar, gVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
                            public void cI(int i2) {
                                if (b.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包失败：" + i2);
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage fail");
                                b.this.a(i, bVar, gVar);
                            }
                        });
                        return;
                    }
                }
                b.this.a(i, bVar, gVar);
            }
        });
        com.baidu.swan.apps.core.j.c.Bi().d(bVar);
        com.baidu.swan.apps.core.j.c.Bi().e(bVar);
        com.baidu.swan.apps.core.j.c.Bi().a((c.a) null);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void b(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.BA());
        }
        com.baidu.swan.apps.core.j.c.Bi().d(bVar);
        com.baidu.swan.apps.core.j.c.Bi().a((c.a) null);
        com.baidu.swan.apps.ae.a.c dR = com.baidu.swan.apps.core.h.a.AW().dR(bVar.getAppId());
        if (dR != null) {
            e.g gVar = new e.g();
            j.a(new Runnable() { // from class: com.baidu.swan.apps.w.b.2
                @Override // java.lang.Runnable
                public void run() {
                    e.d.af(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder");
            gVar.axJ = dR;
            gVar.axI = e.d.ae(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.f.HY().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.y.f.GN().fz("na_post_to_main_start");
            b(bVar, gVar);
            com.baidu.swan.apps.core.h.a.release();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion FA() {
        return com.baidu.swan.apps.core.j.c.Bi().BA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.v.b.b bVar, final e.g gVar) {
        if (i == 0 && bVar != null && gVar != null) {
            com.baidu.swan.apps.performance.f.HY().f(new UbcFlowEvent("na_post_to_main_start"));
            ac.j(this.azp);
            this.azp = new Runnable() { // from class: com.baidu.swan.apps.w.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.b(bVar, gVar);
                }
            };
            ac.i(this.azp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.v.b.b bVar, e.g gVar) {
        com.baidu.swan.apps.performance.f.HY().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.y.f.GN().fz("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
        }
        if (this.atS) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.axI + ", baseUrl:" + e.FV().FE())));
                return;
            }
            return;
        }
        this.axI = gVar.axI;
        b(gVar.axJ);
        if (bVar.Fh()) {
            C(this.azk).setVisibility(0);
            com.baidu.swan.apps.console.a.aR(true);
            com.baidu.swan.apps.console.c.d("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.j.c.Bi().a(bVar, gVar);
    }

    private void b(com.baidu.swan.apps.ae.a.c cVar) {
        this.axJ = cVar;
        com.baidu.swan.apps.ae.b zX = zX();
        if (zX != null) {
            zX.c(cVar);
        }
    }
}
