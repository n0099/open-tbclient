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
    private Runnable aAu;

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void xl() {
        super.xl();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppForeground");
        String Ms = com.baidu.swan.apps.ae.b.Ms();
        if (!TextUtils.isEmpty(Ms)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", Ms);
            if (this.aAp != null && this.aAp.vP() != null) {
                hashMap.put("clkid", this.aAp.vP().FP());
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, this.aAp.vP().FK());
                com.baidu.swan.apps.v.b.b vP = this.aAp.vP();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = com.baidu.swan.apps.statistic.e.dQ(0);
                fVar.mAppId = this.aAp.vP().getAppId();
                fVar.mSource = this.aAp.vP().FK();
                fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
                fVar.ak(com.baidu.swan.apps.statistic.e.hv(vP.FL()));
                com.baidu.swan.apps.statistic.e.onEvent(fVar);
            }
            com.baidu.swan.apps.u.a.EQ().xl();
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.xJ().aT(false);
            com.baidu.swan.apps.media.b.bx(true);
            com.baidu.swan.apps.media.c.c.a.bz(false);
            com.baidu.swan.apps.y.f.HC().bz(false);
            ab.PM();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void xm() {
        super.xm();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppBackground");
        String Ms = com.baidu.swan.apps.ae.b.Ms();
        if (!TextUtils.isEmpty(Ms)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppHide");
            hashMap.put("appId", Ms);
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppHide");
            com.baidu.swan.apps.u.a.EQ().xm();
            com.baidu.swan.apps.camera.a.xJ().aT(true);
            com.baidu.swan.apps.media.b.bx(false);
            com.baidu.swan.apps.media.c.c.a.bz(true);
            com.baidu.swan.apps.y.f.HC().bz(true);
            ab.PK();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.i.b.clearAll();
        com.baidu.swan.apps.core.j.c.release();
        if (this.aAm != null) {
            this.aAm = null;
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.media.b.GT();
        com.baidu.swan.apps.media.c.c.a.release();
        com.baidu.swan.apps.aj.c.a.a.release();
        com.baidu.swan.apps.aj.e.a.release();
        com.baidu.swan.apps.aj.a.a.release();
        com.baidu.swan.apps.aj.g.a.release();
        com.baidu.swan.apps.core.h.a.release();
        com.baidu.swan.apps.y.f.HC().HI();
        com.baidu.swan.apps.scheme.actions.c.a.release();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @Nullable
    public com.baidu.swan.apps.ae.b AI() {
        return com.baidu.swan.apps.ae.b.Mh();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void a(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.Cm());
        }
        com.baidu.swan.apps.install.e.a(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.apps.w.b.1
            @Override // com.baidu.swan.apps.install.b
            public void a(final int i, com.baidu.swan.apps.install.a aVar) {
                final e.g gVar = (e.g) aVar;
                if (com.baidu.swan.apps.scheme.actions.i.g.c(bVar, gVar)) {
                    com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
                    if (Mh == null || TextUtils.isEmpty(gVar.ayN)) {
                        if (b.DEBUG) {
                            Log.e("AppsControllerImpl", "下载分包，信息校验失败");
                        }
                        com.baidu.swan.apps.console.c.d("SwanApp", "subpackage is invalid");
                    } else {
                        String is = aa.is(bVar.getPage());
                        if (!TextUtils.isEmpty(is) && is.startsWith(File.separator)) {
                            is = is.substring(1);
                        }
                        String str = gVar.ayO.aRw.aRK.get(is);
                        String str2 = gVar.ayN;
                        com.baidu.swan.apps.scheme.actions.i.g.Nb().a(Mh.DE(), bVar.getAppId(), bVar.getVersion(), str, gVar.ayO.aRx.aRL.get(str), str2, b.this.Ag(), new g.a() { // from class: com.baidu.swan.apps.w.b.1.1
                            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
                            public void fh(String str3) {
                                if (b.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包成功");
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage success");
                                b.this.a(i, bVar, gVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
                            public void cK(int i2) {
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
        com.baidu.swan.apps.core.j.c.BU().d(bVar);
        com.baidu.swan.apps.core.j.c.BU().e(bVar);
        com.baidu.swan.apps.core.j.c.BU().a((c.a) null);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void b(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.Cm());
        }
        com.baidu.swan.apps.core.j.c.BU().d(bVar);
        com.baidu.swan.apps.core.j.c.BU().a((c.a) null);
        com.baidu.swan.apps.ae.a.c dX = com.baidu.swan.apps.core.h.a.BI().dX(bVar.getAppId());
        if (dX != null) {
            e.g gVar = new e.g();
            j.a(new Runnable() { // from class: com.baidu.swan.apps.w.b.2
                @Override // java.lang.Runnable
                public void run() {
                    e.d.af(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder");
            gVar.ayO = dX;
            gVar.ayN = e.d.ae(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.f.IP().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.y.f.HC().fF("na_post_to_main_start");
            b(bVar, gVar);
            com.baidu.swan.apps.core.h.a.release();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion Go() {
        return com.baidu.swan.apps.core.j.c.BU().Cm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.v.b.b bVar, final e.g gVar) {
        if (i == 0 && bVar != null && gVar != null) {
            com.baidu.swan.apps.performance.f.IP().f(new UbcFlowEvent("na_post_to_main_start"));
            ac.j(this.aAu);
            this.aAu = new Runnable() { // from class: com.baidu.swan.apps.w.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.b(bVar, gVar);
                }
            };
            ac.i(this.aAu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.v.b.b bVar, e.g gVar) {
        com.baidu.swan.apps.performance.f.IP().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.y.f.HC().fF("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
        }
        if (this.auT) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.ayN + ", baseUrl:" + e.GJ().Gs())));
                return;
            }
            return;
        }
        this.ayN = gVar.ayN;
        b(gVar.ayO);
        if (bVar.FV()) {
            F(this.aAp).setVisibility(0);
            com.baidu.swan.apps.console.a.aU(true);
            com.baidu.swan.apps.console.c.d("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.j.c.BU().a(bVar, gVar);
    }

    private void b(com.baidu.swan.apps.ae.a.c cVar) {
        this.ayO = cVar;
        com.baidu.swan.apps.ae.b AI = AI();
        if (AI != null) {
            AI.c(cVar);
        }
    }
}
