package com.baidu.swan.apps.w;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.dto.FaceBaseDTO;
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
    private Runnable aTI;

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void Cf() {
        super.Cf();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppForeground");
        String Rk = com.baidu.swan.apps.ae.b.Rk();
        if (!TextUtils.isEmpty(Rk)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", Rk);
            if (this.aTD != null && this.aTD.AJ() != null) {
                hashMap.put("clkid", this.aTD.AJ().KJ());
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, this.aTD.AJ().KE());
                com.baidu.swan.apps.v.b.b AJ = this.aTD.AJ();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = com.baidu.swan.apps.statistic.e.eL(0);
                fVar.mAppId = this.aTD.AJ().getAppId();
                fVar.mSource = this.aTD.AJ().KE();
                fVar.mType = "show";
                fVar.aI(com.baidu.swan.apps.statistic.e.hY(AJ.KF()));
                com.baidu.swan.apps.statistic.e.onEvent(fVar);
            }
            com.baidu.swan.apps.u.a.JK().Cf();
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.CD().bl(false);
            com.baidu.swan.apps.media.b.bP(true);
            com.baidu.swan.apps.media.c.c.a.bR(false);
            com.baidu.swan.apps.y.f.Mw().bR(false);
            ab.UC();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void Cg() {
        super.Cg();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppBackground");
        String Rk = com.baidu.swan.apps.ae.b.Rk();
        if (!TextUtils.isEmpty(Rk)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppHide");
            hashMap.put("appId", Rk);
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppHide");
            com.baidu.swan.apps.u.a.JK().Cg();
            com.baidu.swan.apps.camera.a.CD().bl(true);
            com.baidu.swan.apps.media.b.bP(false);
            com.baidu.swan.apps.media.c.c.a.bR(true);
            com.baidu.swan.apps.y.f.Mw().bR(true);
            ab.UA();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.i.b.clearAll();
        com.baidu.swan.apps.core.j.c.release();
        if (this.aTA != null) {
            this.aTA = null;
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.media.b.LN();
        com.baidu.swan.apps.media.c.c.a.release();
        com.baidu.swan.apps.aj.c.a.a.release();
        com.baidu.swan.apps.aj.e.a.release();
        com.baidu.swan.apps.aj.a.a.release();
        com.baidu.swan.apps.aj.g.a.release();
        com.baidu.swan.apps.core.h.a.release();
        com.baidu.swan.apps.y.f.Mw().MC();
        com.baidu.swan.apps.scheme.actions.c.a.release();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @Nullable
    public com.baidu.swan.apps.ae.b FD() {
        return com.baidu.swan.apps.ae.b.QZ();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void a(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.Hg());
        }
        com.baidu.swan.apps.install.e.a(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.apps.w.b.1
            @Override // com.baidu.swan.apps.install.b
            public void a(final int i, com.baidu.swan.apps.install.a aVar) {
                final e.g gVar = (e.g) aVar;
                if (com.baidu.swan.apps.scheme.actions.i.g.c(bVar, gVar)) {
                    com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
                    if (QZ == null || TextUtils.isEmpty(gVar.aSd)) {
                        if (b.DEBUG) {
                            Log.e("AppsControllerImpl", "下载分包，信息校验失败");
                        }
                        com.baidu.swan.apps.console.c.d("SwanApp", "subpackage is invalid");
                    } else {
                        String iV = aa.iV(bVar.getPage());
                        if (!TextUtils.isEmpty(iV) && iV.startsWith(File.separator)) {
                            iV = iV.substring(1);
                        }
                        String str = gVar.aSe.bkA.bkO.get(iV);
                        String str2 = gVar.aSd;
                        com.baidu.swan.apps.scheme.actions.i.g.RR().a(QZ.Iy(), bVar.getAppId(), bVar.getVersion(), str, gVar.aSe.bkB.bkP.get(str), str2, b.this.Fb(), new g.a() { // from class: com.baidu.swan.apps.w.b.1.1
                            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
                            public void fO(String str3) {
                                if (b.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包成功");
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage success");
                                b.this.a(i, bVar, gVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.i.g.a
                            public void dF(int i2) {
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
        com.baidu.swan.apps.core.j.c.GO().d(bVar);
        com.baidu.swan.apps.core.j.c.GO().e(bVar);
        com.baidu.swan.apps.core.j.c.GO().a((c.a) null);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void b(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.Hg());
        }
        com.baidu.swan.apps.core.j.c.GO().d(bVar);
        com.baidu.swan.apps.core.j.c.GO().a((c.a) null);
        com.baidu.swan.apps.ae.a.c eE = com.baidu.swan.apps.core.h.a.GC().eE(bVar.getAppId());
        if (eE != null) {
            e.g gVar = new e.g();
            j.a(new Runnable() { // from class: com.baidu.swan.apps.w.b.2
                @Override // java.lang.Runnable
                public void run() {
                    e.d.an(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder");
            gVar.aSe = eE;
            gVar.aSd = e.d.am(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.f.NJ().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.y.f.Mw().gj("na_post_to_main_start");
            b(bVar, gVar);
            com.baidu.swan.apps.core.h.a.release();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion Li() {
        return com.baidu.swan.apps.core.j.c.GO().Hg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.v.b.b bVar, final e.g gVar) {
        if (i == 0 && bVar != null && gVar != null) {
            com.baidu.swan.apps.performance.f.NJ().f(new UbcFlowEvent("na_post_to_main_start"));
            ac.h(this.aTI);
            this.aTI = new Runnable() { // from class: com.baidu.swan.apps.w.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.b(bVar, gVar);
                }
            };
            ac.g(this.aTI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.v.b.b bVar, e.g gVar) {
        com.baidu.swan.apps.performance.f.NJ().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.y.f.Mw().gj("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
        }
        if (this.aOk) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.aSd + ", baseUrl:" + e.LD().Lm())));
                return;
            }
            return;
        }
        this.aSd = gVar.aSd;
        b(gVar.aSe);
        if (bVar.KP()) {
            E(this.aTD).setVisibility(0);
            com.baidu.swan.apps.console.a.bm(true);
            com.baidu.swan.apps.console.c.d("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.j.c.GO().a(bVar, gVar);
    }

    private void b(com.baidu.swan.apps.ae.a.c cVar) {
        this.aSe = cVar;
        com.baidu.swan.apps.ae.b FD = FD();
        if (FD != null) {
            FD.c(cVar);
        }
    }
}
