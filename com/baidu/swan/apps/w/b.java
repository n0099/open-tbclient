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
    private Runnable azW;

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void xh() {
        super.xh();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppForeground");
        String Mo = com.baidu.swan.apps.ae.b.Mo();
        if (!TextUtils.isEmpty(Mo)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", Mo);
            if (this.azR != null && this.azR.vL() != null) {
                hashMap.put("clkid", this.azR.vL().FL());
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, this.azR.vL().FG());
                com.baidu.swan.apps.v.b.b vL = this.azR.vL();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = com.baidu.swan.apps.statistic.e.dP(0);
                fVar.mAppId = this.azR.vL().getAppId();
                fVar.mSource = this.azR.vL().FG();
                fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
                fVar.ak(com.baidu.swan.apps.statistic.e.ht(vL.FH()));
                com.baidu.swan.apps.statistic.e.onEvent(fVar);
            }
            com.baidu.swan.apps.u.a.EM().xh();
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.xF().aT(false);
            com.baidu.swan.apps.media.b.bx(true);
            com.baidu.swan.apps.media.c.c.a.bz(false);
            com.baidu.swan.apps.y.f.Hy().bz(false);
            ab.PI();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void xi() {
        super.xi();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppBackground");
        String Mo = com.baidu.swan.apps.ae.b.Mo();
        if (!TextUtils.isEmpty(Mo)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppHide");
            hashMap.put("appId", Mo);
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppHide");
            com.baidu.swan.apps.u.a.EM().xi();
            com.baidu.swan.apps.camera.a.xF().aT(true);
            com.baidu.swan.apps.media.b.bx(false);
            com.baidu.swan.apps.media.c.c.a.bz(true);
            com.baidu.swan.apps.y.f.Hy().bz(true);
            ab.PG();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.i.b.clearAll();
        com.baidu.swan.apps.core.j.c.release();
        if (this.azO != null) {
            this.azO = null;
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.media.b.GP();
        com.baidu.swan.apps.media.c.c.a.release();
        com.baidu.swan.apps.aj.c.a.a.release();
        com.baidu.swan.apps.aj.e.a.release();
        com.baidu.swan.apps.aj.a.a.release();
        com.baidu.swan.apps.aj.g.a.release();
        com.baidu.swan.apps.core.h.a.release();
        com.baidu.swan.apps.y.f.Hy().HE();
        com.baidu.swan.apps.scheme.actions.c.a.release();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @Nullable
    public com.baidu.swan.apps.ae.b AE() {
        return com.baidu.swan.apps.ae.b.Md();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void a(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.Ci());
        }
        com.baidu.swan.apps.install.e.a(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.apps.w.b.1
            @Override // com.baidu.swan.apps.install.b
            public void a(final int i, com.baidu.swan.apps.install.a aVar) {
                final e.g gVar = (e.g) aVar;
                if (com.baidu.swan.apps.scheme.actions.i.g.c(bVar, gVar)) {
                    com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
                    if (Md == null || TextUtils.isEmpty(gVar.ayp)) {
                        if (b.DEBUG) {
                            Log.e("AppsControllerImpl", "下载分包，信息校验失败");
                        }
                        com.baidu.swan.apps.console.c.d("SwanApp", "subpackage is invalid");
                    } else {
                        String iq = aa.iq(bVar.getPage());
                        if (!TextUtils.isEmpty(iq) && iq.startsWith(File.separator)) {
                            iq = iq.substring(1);
                        }
                        String str = gVar.ayq.aQY.aRm.get(iq);
                        String str2 = gVar.ayp;
                        com.baidu.swan.apps.scheme.actions.i.g.MX().a(Md.DA(), bVar.getAppId(), bVar.getVersion(), str, gVar.ayq.aQZ.aRn.get(str), str2, b.this.Ac(), new g.a() { // from class: com.baidu.swan.apps.w.b.1.1
                            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
                            public void ff(String str3) {
                                if (b.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包成功");
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage success");
                                b.this.a(i, bVar, gVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
                            public void cJ(int i2) {
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
        com.baidu.swan.apps.core.j.c.BQ().d(bVar);
        com.baidu.swan.apps.core.j.c.BQ().e(bVar);
        com.baidu.swan.apps.core.j.c.BQ().a((c.a) null);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void b(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.Ci());
        }
        com.baidu.swan.apps.core.j.c.BQ().d(bVar);
        com.baidu.swan.apps.core.j.c.BQ().a((c.a) null);
        com.baidu.swan.apps.ae.a.c dV = com.baidu.swan.apps.core.h.a.BE().dV(bVar.getAppId());
        if (dV != null) {
            e.g gVar = new e.g();
            j.a(new Runnable() { // from class: com.baidu.swan.apps.w.b.2
                @Override // java.lang.Runnable
                public void run() {
                    e.d.af(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder");
            gVar.ayq = dV;
            gVar.ayp = e.d.ae(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.f.IL().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.y.f.Hy().fD("na_post_to_main_start");
            b(bVar, gVar);
            com.baidu.swan.apps.core.h.a.release();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion Gk() {
        return com.baidu.swan.apps.core.j.c.BQ().Ci();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.v.b.b bVar, final e.g gVar) {
        if (i == 0 && bVar != null && gVar != null) {
            com.baidu.swan.apps.performance.f.IL().f(new UbcFlowEvent("na_post_to_main_start"));
            ac.j(this.azW);
            this.azW = new Runnable() { // from class: com.baidu.swan.apps.w.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.b(bVar, gVar);
                }
            };
            ac.i(this.azW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.v.b.b bVar, e.g gVar) {
        com.baidu.swan.apps.performance.f.IL().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.y.f.Hy().fD("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
        }
        if (this.auv) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.ayp + ", baseUrl:" + e.GF().Go())));
                return;
            }
            return;
        }
        this.ayp = gVar.ayp;
        b(gVar.ayq);
        if (bVar.FR()) {
            F(this.azR).setVisibility(0);
            com.baidu.swan.apps.console.a.aU(true);
            com.baidu.swan.apps.console.c.d("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.j.c.BQ().a(bVar, gVar);
    }

    private void b(com.baidu.swan.apps.ae.a.c cVar) {
        this.ayq = cVar;
        com.baidu.swan.apps.ae.b AE = AE();
        if (AE != null) {
            AE.c(cVar);
        }
    }
}
