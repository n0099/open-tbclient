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
    private Runnable aTq;

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void Cg() {
        super.Cg();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppForeground");
        String Rm = com.baidu.swan.apps.ae.b.Rm();
        if (!TextUtils.isEmpty(Rm)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", Rm);
            if (this.aTl != null && this.aTl.AK() != null) {
                hashMap.put("clkid", this.aTl.AK().KK());
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, this.aTl.AK().KF());
                com.baidu.swan.apps.v.b.b AK = this.aTl.AK();
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = com.baidu.swan.apps.statistic.e.eL(0);
                fVar.mAppId = this.aTl.AK().getAppId();
                fVar.mSource = this.aTl.AK().KF();
                fVar.mType = "show";
                fVar.aJ(com.baidu.swan.apps.statistic.e.hY(AK.KG()));
                com.baidu.swan.apps.statistic.e.onEvent(fVar);
            }
            com.baidu.swan.apps.u.a.JL().Cg();
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.CE().bl(false);
            com.baidu.swan.apps.media.b.bP(true);
            com.baidu.swan.apps.media.c.c.a.bR(false);
            com.baidu.swan.apps.y.f.Mx().bR(false);
            ab.UA();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void Ch() {
        super.Ch();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppBackground");
        String Rm = com.baidu.swan.apps.ae.b.Rm();
        if (!TextUtils.isEmpty(Rm)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppHide");
            hashMap.put("appId", Rm);
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppHide");
            com.baidu.swan.apps.u.a.JL().Ch();
            com.baidu.swan.apps.camera.a.CE().bl(true);
            com.baidu.swan.apps.media.b.bP(false);
            com.baidu.swan.apps.media.c.c.a.bR(true);
            com.baidu.swan.apps.y.f.Mx().bR(true);
            ab.Uy();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.i.b.clearAll();
        com.baidu.swan.apps.core.j.c.release();
        if (this.aTi != null) {
            this.aTi = null;
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.media.b.LO();
        com.baidu.swan.apps.media.c.c.a.release();
        com.baidu.swan.apps.aj.c.a.a.release();
        com.baidu.swan.apps.aj.e.a.release();
        com.baidu.swan.apps.aj.a.a.release();
        com.baidu.swan.apps.aj.g.a.release();
        com.baidu.swan.apps.core.h.a.release();
        com.baidu.swan.apps.y.f.Mx().MD();
        com.baidu.swan.apps.scheme.actions.c.a.release();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @Nullable
    public com.baidu.swan.apps.ae.b FE() {
        return com.baidu.swan.apps.ae.b.Ra();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void a(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.Hh());
        }
        com.baidu.swan.apps.install.e.a(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.apps.w.b.1
            @Override // com.baidu.swan.apps.install.b
            public void a(final int i, com.baidu.swan.apps.install.a aVar) {
                final e.g gVar = (e.g) aVar;
                if (com.baidu.swan.apps.scheme.actions.i.g.c(bVar, gVar)) {
                    com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
                    if (Ra == null || TextUtils.isEmpty(gVar.aRL)) {
                        if (b.DEBUG) {
                            Log.e("AppsControllerImpl", "下载分包，信息校验失败");
                        }
                        com.baidu.swan.apps.console.c.d("SwanApp", "subpackage is invalid");
                    } else {
                        String iV = aa.iV(bVar.getPage());
                        if (!TextUtils.isEmpty(iV) && iV.startsWith(File.separator)) {
                            iV = iV.substring(1);
                        }
                        String str = gVar.aRM.bki.bkw.get(iV);
                        String str2 = gVar.aRL;
                        com.baidu.swan.apps.scheme.actions.i.g.RT().a(Ra.Iz(), bVar.getAppId(), bVar.getVersion(), str, gVar.aRM.bkj.bkx.get(str), str2, b.this.Fc(), new g.a() { // from class: com.baidu.swan.apps.w.b.1.1
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
        com.baidu.swan.apps.core.j.c.GP().d(bVar);
        com.baidu.swan.apps.core.j.c.GP().e(bVar);
        com.baidu.swan.apps.core.j.c.GP().a((c.a) null);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void b(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.Hh());
        }
        com.baidu.swan.apps.core.j.c.GP().d(bVar);
        com.baidu.swan.apps.core.j.c.GP().a((c.a) null);
        com.baidu.swan.apps.ae.a.c eE = com.baidu.swan.apps.core.h.a.GD().eE(bVar.getAppId());
        if (eE != null) {
            e.g gVar = new e.g();
            j.a(new Runnable() { // from class: com.baidu.swan.apps.w.b.2
                @Override // java.lang.Runnable
                public void run() {
                    e.d.an(bVar.getAppId(), bVar.getVersion());
                }
            }, "deleteLowerVersionFolder");
            gVar.aRM = eE;
            gVar.aRL = e.d.am(bVar.getAppId(), bVar.getVersion()).getPath() + File.separator;
            com.baidu.swan.apps.performance.f.NK().f(new UbcFlowEvent("na_post_to_main_start"));
            com.baidu.swan.apps.y.f.Mx().gj("na_post_to_main_start");
            b(bVar, gVar);
            com.baidu.swan.apps.core.h.a.release();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion Lj() {
        return com.baidu.swan.apps.core.j.c.GP().Hh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.v.b.b bVar, final e.g gVar) {
        if (i == 0 && bVar != null && gVar != null) {
            com.baidu.swan.apps.performance.f.NK().f(new UbcFlowEvent("na_post_to_main_start"));
            ac.h(this.aTq);
            this.aTq = new Runnable() { // from class: com.baidu.swan.apps.w.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.b(bVar, gVar);
                }
            };
            ac.g(this.aTq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.v.b.b bVar, e.g gVar) {
        com.baidu.swan.apps.performance.f.NK().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.y.f.Mx().gj("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
        }
        if (this.aNS) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.aRL + ", baseUrl:" + e.LE().Ln())));
                return;
            }
            return;
        }
        this.aRL = gVar.aRL;
        b(gVar.aRM);
        if (bVar.KQ()) {
            E(this.aTl).setVisibility(0);
            com.baidu.swan.apps.console.a.bm(true);
            com.baidu.swan.apps.console.c.d("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.j.c.GP().a(bVar, gVar);
    }

    private void b(com.baidu.swan.apps.ae.a.c cVar) {
        this.aRM = cVar;
        com.baidu.swan.apps.ae.b FE = FE();
        if (FE != null) {
            FE.c(cVar);
        }
    }
}
