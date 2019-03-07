package com.baidu.swan.apps.w;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.an.y;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.core.i.c;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.scheme.actions.h.f;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void vQ() {
        super.vQ();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppForeground");
        String Ji = com.baidu.swan.apps.ae.b.Ji();
        if (!TextUtils.isEmpty(Ji)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", Ji);
            if (this.ayi != null && this.ayi.uB() != null) {
                hashMap.put("clkid", this.ayi.uB().axQ);
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, this.ayi.uB().axF);
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = com.baidu.swan.apps.statistic.c.dC(0);
                fVar.mAppId = this.ayi.uB().mAppId;
                fVar.mSource = this.ayi.uB().axF;
                fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
                com.baidu.swan.apps.statistic.c.onEvent(fVar);
                com.baidu.swan.apps.statistic.c.f(fVar.mAppId, fVar.mSource, 0);
            }
            com.baidu.swan.apps.u.a.Da().vQ();
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.wn().aO(false);
            com.baidu.swan.apps.media.b.bl(true);
            com.baidu.swan.apps.media.c.c.a.bo(false);
            com.baidu.swan.apps.y.f.ER().bo(false);
            z.Mm();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void vR() {
        super.vR();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppBackground");
        String Ji = com.baidu.swan.apps.ae.b.Ji();
        if (!TextUtils.isEmpty(Ji)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppHide");
            hashMap.put("appId", Ji);
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppHide");
            com.baidu.swan.apps.u.a.Da().vR();
            com.baidu.swan.apps.camera.a.wn().aO(true);
            com.baidu.swan.apps.media.b.bl(false);
            com.baidu.swan.apps.media.c.c.a.bo(true);
            com.baidu.swan.apps.y.f.ER().bo(true);
            z.Mk();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.h.b.clearAll();
        com.baidu.swan.apps.core.i.c.release();
        if (this.ayf != null) {
            this.ayf = null;
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.media.b.El();
        com.baidu.swan.apps.media.c.c.a.release();
        com.baidu.swan.apps.aj.b.a.a.release();
        com.baidu.swan.apps.aj.d.a.release();
        com.baidu.swan.apps.aj.a.a.release();
        com.baidu.swan.apps.statistic.c.Ks();
        com.baidu.swan.apps.core.g.a.release();
        com.baidu.swan.apps.y.f.ER().EU();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @Nullable
    public com.baidu.swan.apps.ae.b zb() {
        return com.baidu.swan.apps.ae.b.IX();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void a(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.atp);
        }
        com.baidu.swan.apps.install.c.a(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.apps.w.b.1
            @Override // com.baidu.swan.apps.install.b
            public void a(final int i, com.baidu.swan.apps.install.a aVar) {
                final c.g gVar = (c.g) aVar;
                if (com.baidu.swan.apps.scheme.actions.h.f.c(bVar, gVar)) {
                    com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
                    if (IX == null || TextUtils.isEmpty(gVar.awX)) {
                        if (b.DEBUG) {
                            Log.e("AppsControllerImpl", "下载分包，信息校验失败");
                        }
                        com.baidu.swan.apps.console.c.d("SwanApp", "subpackage is invalid");
                    } else {
                        String hF = y.hF(bVar.axH);
                        if (!TextUtils.isEmpty(hF) && hF.startsWith(File.separator)) {
                            hF = hF.substring(1);
                        }
                        String str = gVar.awY.aOg.aOu.get(hF);
                        String str2 = gVar.awX;
                        com.baidu.swan.apps.scheme.actions.h.f.JL().a(IX.BR(), bVar.mAppId, bVar.mVersion, str, gVar.awY.aOh.aOv.get(str), str2, b.this.yB(), new f.a() { // from class: com.baidu.swan.apps.w.b.1.1
                            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
                            public void eP(String str3) {
                                if (b.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包成功");
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage success");
                                b.this.a(i, bVar, gVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
                            public void cG(int i2) {
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
        com.baidu.swan.apps.core.i.c.Ab().d(bVar);
        com.baidu.swan.apps.core.i.c.Ab().e(bVar);
        com.baidu.swan.apps.core.i.c.Ab().a((c.a) null);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void b(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.atp);
        }
        com.baidu.swan.apps.core.i.c.Ab().d(bVar);
        com.baidu.swan.apps.core.i.c.Ab().a((c.a) null);
        com.baidu.swan.apps.ae.a.c eb = com.baidu.swan.apps.core.g.a.zO().eb(bVar.mAppId);
        if (eb != null) {
            c.g gVar = new c.g();
            j.a(new Runnable() { // from class: com.baidu.swan.apps.w.b.2
                @Override // java.lang.Runnable
                public void run() {
                    c.d.ai(bVar.mAppId, bVar.mVersion);
                }
            }, "deleteLowerVersionFolder");
            gVar.awY = eb;
            gVar.awX = c.d.ah(bVar.mAppId, bVar.mVersion).getPath() + File.separator;
            com.baidu.swan.apps.performance.f.FS().f(new UbcFlowEvent("na_post_to_main_start"));
            b(bVar, gVar);
            com.baidu.swan.apps.core.g.a.release();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion DH() {
        return com.baidu.swan.apps.core.i.c.Ab().As();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.v.b.b bVar, final c.g gVar) {
        if (i == 0 && bVar != null && gVar != null) {
            com.baidu.swan.apps.performance.f.FS().f(new UbcFlowEvent("na_post_to_main_start"));
            aa.i(new Runnable() { // from class: com.baidu.swan.apps.w.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.b(bVar, gVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.apps.v.b.b bVar, c.g gVar) {
        com.baidu.swan.apps.performance.f.FS().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.y.f.ER().fl("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
        }
        if (this.atx) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.awX + ", baseUrl:" + e.Ec().DL())));
                return;
            }
            return;
        }
        this.awX = gVar.awX;
        b(gVar.awY);
        if (bVar.axX) {
            C(this.ayi).setVisibility(0);
            com.baidu.swan.apps.console.a.aP(true);
            com.baidu.swan.apps.console.c.d("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.i.c.Ab().a(bVar, gVar);
    }

    private void b(com.baidu.swan.apps.ae.a.c cVar) {
        this.awY = cVar;
        com.baidu.swan.apps.ae.b zb = zb();
        if (zb != null) {
            zb.c(cVar);
        }
    }
}
