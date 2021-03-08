package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.pms.c.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes8.dex */
public class g {

    /* loaded from: classes8.dex */
    public interface a {
        void gh(int i);

        void kp(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, com.baidu.swan.apps.model.b bVar, final String str, final a aVar, String str2) {
        if (aVar != null) {
            if (eVar == null || bVar == null || TextUtils.isEmpty(bVar.mPage) || TextUtils.isEmpty(bVar.dps)) {
                aVar.gh(2110);
                return;
            }
            String str3 = bVar.dps;
            final String ki = eVar.ki(bVar.mPage);
            boolean rH = eVar.rH(str3);
            if (com.baidu.swan.apps.console.debugger.a.e.amn() || com.baidu.swan.apps.ad.a.a.aFp()) {
                if (rH || !TextUtils.isEmpty(ki)) {
                    aVar.kp(str);
                } else {
                    aVar.gh(2111);
                }
            } else if (com.baidu.swan.apps.ac.b.a.qP(bVar.mPage)) {
                aVar.kp(str);
            } else {
                if (rH) {
                    if (com.baidu.swan.apps.r.d.bK(eVar.id, eVar.getVersion())) {
                        aVar.kp(str);
                        return;
                    } else if (eVar.aJi()) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(ki)) {
                    aVar.gh(2111);
                } else if (eVar.rI(ki)) {
                    aVar.kp(str);
                } else if (eVar.rJ(ki) && eVar.rK(ki)) {
                    aVar.kp(str);
                    eVar.ab(ki, true);
                } else {
                    String rL = eVar.rL(ki);
                    if (TextUtils.isEmpty(rL)) {
                        aVar.gh(2112);
                        return;
                    }
                    boolean rN = eVar.rN(str3);
                    if (!com.baidu.swan.apps.r.d.bK(eVar.id, eVar.getVersion()) && !rN) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                    com.baidu.swan.pms.c.d.f fVar = new com.baidu.swan.pms.c.d.f(eVar.id, eVar.getVersion(), rL, 0);
                    com.baidu.swan.apps.core.pms.e.a aVar2 = new com.baidu.swan.apps.core.pms.e.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void aqG() {
                            com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
                            if (aIN != null) {
                                aIN.ab(ki, true);
                            }
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.kp(str);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void gV(final int i) {
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.gh(i);
                                }
                            });
                        }
                    });
                    com.baidu.swan.apps.performance.i.cd("route", str2).f(new UbcFlowEvent("na_start_sub_package_download")).cg("sub_state", "1");
                    com.baidu.swan.pms.c.a(fVar, aVar2);
                }
            }
        }
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null) {
                aVar.gh(2111);
                return;
            }
            com.baidu.swan.apps.performance.i.cd("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).cg("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.aIJ().getFrameType());
            cVar.lX(ak.up(eVar.getVersion()));
            cVar.ym(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(eVar.id, new a.InterfaceC0415a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0415a
                public void are() {
                    a.this.gh(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0415a
                public void onSuccess() {
                    a.this.kp(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0415a
                public void onError() {
                    a.this.gh(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.f(str, str2, str4, 0), new com.baidu.swan.apps.core.pms.e.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void aqG() {
                    com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
                    if (aIN != null) {
                        aIN.ab(str3, true);
                    }
                    aVar.kp(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void gV(int i) {
                    aVar.gh(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.dgt);
    }

    public static boolean b(com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.amn()) {
            return false;
        }
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.dGq == null || swanAppConfigData.dGq.sb(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.dGr.dGT.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.bcx().ak(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(d.C0452d.bL(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
