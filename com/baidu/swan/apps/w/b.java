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
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void vP() {
        super.vP();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppForeground");
        String Jg = com.baidu.swan.apps.ae.b.Jg();
        if (!TextUtils.isEmpty(Jg)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put("appId", Jg);
            if (this.aym != null && this.aym.uA() != null) {
                hashMap.put("clkid", this.aym.uA().axU);
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, this.aym.uA().axJ);
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = com.baidu.swan.apps.statistic.c.dB(0);
                fVar.mAppId = this.aym.uA().mAppId;
                fVar.mSource = this.aym.uA().axJ;
                fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
                com.baidu.swan.apps.statistic.c.onEvent(fVar);
                com.baidu.swan.apps.statistic.c.f(fVar.mAppId, fVar.mSource, 0);
            }
            com.baidu.swan.apps.u.a.CY().vP();
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppShow");
            com.baidu.swan.apps.camera.a.wm().aO(false);
            com.baidu.swan.apps.media.b.bl(true);
            com.baidu.swan.apps.media.c.c.a.bo(false);
            com.baidu.swan.apps.y.f.EP().bo(false);
            z.Mk();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void vQ() {
        super.vQ();
        com.baidu.swan.apps.console.c.d("SwanApp", "onAppBackground");
        String Jg = com.baidu.swan.apps.ae.b.Jg();
        if (!TextUtils.isEmpty(Jg)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppHide");
            hashMap.put("appId", Jg);
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onAppHide");
            com.baidu.swan.apps.u.a.CY().vQ();
            com.baidu.swan.apps.camera.a.wm().aO(true);
            com.baidu.swan.apps.media.b.bl(false);
            com.baidu.swan.apps.media.c.c.a.bo(true);
            com.baidu.swan.apps.y.f.EP().bo(true);
            z.Mi();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.apps.core.h.b.clearAll();
        com.baidu.swan.apps.core.i.c.release();
        if (this.ayj != null) {
            this.ayj = null;
        }
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.media.b.Ej();
        com.baidu.swan.apps.media.c.c.a.release();
        com.baidu.swan.apps.aj.b.a.a.release();
        com.baidu.swan.apps.aj.d.a.release();
        com.baidu.swan.apps.aj.a.a.release();
        com.baidu.swan.apps.statistic.c.Kq();
        com.baidu.swan.apps.core.g.a.release();
        com.baidu.swan.apps.y.f.EP().ES();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @Nullable
    public com.baidu.swan.apps.ae.b za() {
        return com.baidu.swan.apps.ae.b.IV();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void a(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.atu);
        }
        com.baidu.swan.apps.install.c.a(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.apps.w.b.1
            @Override // com.baidu.swan.apps.install.b
            public void a(final int i, com.baidu.swan.apps.install.a aVar) {
                final c.g gVar = (c.g) aVar;
                if (com.baidu.swan.apps.scheme.actions.h.f.c(bVar, gVar)) {
                    com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
                    if (IV == null || TextUtils.isEmpty(gVar.axb)) {
                        if (b.DEBUG) {
                            Log.e("AppsControllerImpl", "下载分包，信息校验失败");
                        }
                        com.baidu.swan.apps.console.c.d("SwanApp", "subpackage is invalid");
                    } else {
                        String hG = y.hG(bVar.axL);
                        if (!TextUtils.isEmpty(hG) && hG.startsWith(File.separator)) {
                            hG = hG.substring(1);
                        }
                        String str = gVar.axc.aOk.aOy.get(hG);
                        String str2 = gVar.axb;
                        com.baidu.swan.apps.scheme.actions.h.f.JJ().a(IV.BP(), bVar.mAppId, bVar.mVersion, str, gVar.axc.aOl.aOz.get(str), str2, b.this.yA(), new f.a() { // from class: com.baidu.swan.apps.w.b.1.1
                            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
                            public void eQ(String str3) {
                                if (b.DEBUG) {
                                    Log.e("AppsControllerImpl", "下载分包成功");
                                }
                                com.baidu.swan.apps.console.c.d("SwanApp", "download subpackage success");
                                b.this.a(i, bVar, gVar);
                            }

                            @Override // com.baidu.swan.apps.scheme.actions.h.f.a
                            public void cF(int i2) {
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
        com.baidu.swan.apps.core.i.c.Aa().d(bVar);
        com.baidu.swan.apps.core.i.c.Aa().e(bVar);
        com.baidu.swan.apps.core.i.c.Aa().a((c.a) null);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void b(final com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        super.b(bVar, bVar2);
        if (DEBUG) {
            Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.atu);
        }
        com.baidu.swan.apps.core.i.c.Aa().d(bVar);
        com.baidu.swan.apps.core.i.c.Aa().a((c.a) null);
        com.baidu.swan.apps.ae.a.c ed = com.baidu.swan.apps.core.g.a.zN().ed(bVar.mAppId);
        if (ed != null) {
            c.g gVar = new c.g();
            j.a(new Runnable() { // from class: com.baidu.swan.apps.w.b.2
                @Override // java.lang.Runnable
                public void run() {
                    c.d.ai(bVar.mAppId, bVar.mVersion);
                }
            }, "deleteLowerVersionFolder");
            gVar.axc = ed;
            gVar.axb = c.d.ah(bVar.mAppId, bVar.mVersion).getPath() + File.separator;
            com.baidu.swan.apps.performance.f.FQ().f(new UbcFlowEvent("na_post_to_main_start"));
            b(bVar, gVar);
            com.baidu.swan.apps.core.g.a.release();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion DF() {
        return com.baidu.swan.apps.core.i.c.Aa().Ar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, final com.baidu.swan.apps.v.b.b bVar, final c.g gVar) {
        if (i == 0 && bVar != null && gVar != null) {
            com.baidu.swan.apps.performance.f.FQ().f(new UbcFlowEvent("na_post_to_main_start"));
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
        com.baidu.swan.apps.performance.f.FQ().f(new UbcFlowEvent("na_post_to_main_end"));
        com.baidu.swan.apps.y.f.EP().fm("na_post_to_main_end");
        if (DEBUG) {
            Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
        }
        if (this.atC) {
            if (DEBUG) {
                Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.axb + ", baseUrl:" + e.Ea().DJ())));
                return;
            }
            return;
        }
        this.axb = gVar.axb;
        b(gVar.axc);
        if (bVar.ayb) {
            C(this.aym).setVisibility(0);
            com.baidu.swan.apps.console.a.aP(true);
            com.baidu.swan.apps.console.c.d("AppsControllerImpl", "init sConsole for devHook");
        }
        com.baidu.swan.apps.core.i.c.Aa().a(bVar, gVar);
    }

    private void b(com.baidu.swan.apps.ae.a.c cVar) {
        this.axc = cVar;
        com.baidu.swan.apps.ae.b za = za();
        if (za != null) {
            za.c(cVar);
        }
    }
}
