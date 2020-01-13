package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.pms.a.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.t.e;
import java.io.File;
/* loaded from: classes10.dex */
public class g {

    /* loaded from: classes10.dex */
    public interface a {
        void dI(int i);

        void success(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null || TextUtils.isEmpty(str)) {
                aVar.dI(2110);
            } else if (com.baidu.swan.apps.console.debugger.a.e.Jy() || com.baidu.swan.apps.ah.a.a.Yn()) {
                if (eVar.kx(str) || !TextUtils.isEmpty(eVar.kB(str))) {
                    aVar.success(str2);
                } else {
                    aVar.dI(2111);
                }
            } else {
                if (eVar.kx(str)) {
                    if (com.baidu.swan.apps.t.e.aA(eVar.id, eVar.getVersion())) {
                        aVar.success(str2);
                        return;
                    } else if (eVar.aaI()) {
                        b(eVar, str, str2, aVar, str3);
                        return;
                    }
                }
                final String kB = eVar.kB(str);
                if (TextUtils.isEmpty(kB)) {
                    aVar.dI(2111);
                } else if (eVar.ky(kB)) {
                    aVar.success(str2);
                } else if (eVar.kz(kB) && eVar.kA(kB)) {
                    aVar.success(str2);
                    eVar.y(kB, true);
                } else {
                    String kC = eVar.kC(kB);
                    if (TextUtils.isEmpty(kC)) {
                        aVar.dI(2112);
                        return;
                    }
                    boolean kE = eVar.kE(str);
                    if (!com.baidu.swan.apps.t.e.aA(eVar.id, eVar.getVersion()) && !kE) {
                        b(eVar, str, str2, aVar, str3);
                        return;
                    }
                    com.baidu.swan.pms.c.d.e eVar2 = new com.baidu.swan.pms.c.d.e(eVar.id, Integer.valueOf(eVar.getVersion()).intValue(), kC, 0);
                    com.baidu.swan.apps.core.pms.c.a aVar2 = new com.baidu.swan.apps.core.pms.c.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void MT() {
                            com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
                            if (aap != null) {
                                aap.y(kB, true);
                            }
                            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.success(str2);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void eq(final int i) {
                            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.dI(i);
                                }
                            });
                        }
                    });
                    com.baidu.swan.apps.performance.f.aP("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).aS("sub_state", "1");
                    com.baidu.swan.pms.c.a(eVar2, aVar2);
                }
            }
        }
    }

    private static void b(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null) {
                aVar.dI(2111);
                return;
            }
            com.baidu.swan.apps.performance.f.aP("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).aS("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.aam().Ed());
            cVar.is(ai.mG(eVar.getVersion()));
            cVar.qj(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.a.a(eVar.id, new a.InterfaceC0239a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0239a
                public void Np() {
                    a.this.dI(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0239a
                public void onSuccess() {
                    a.this.success(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0239a
                public void onError() {
                    a.this.dI(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(str, Integer.valueOf(str2).intValue(), str4, 0), new com.baidu.swan.apps.core.pms.c.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void MT() {
                    com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
                    if (aap != null) {
                        aap.y(str3, true);
                    }
                    aVar.success(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void eq(int i) {
                    aVar.dI(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.x.b.b bVar, e.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.btp);
    }

    public static boolean b(com.baidu.swan.apps.x.b.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.Jy()) {
            return false;
        }
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.bLw == null || swanAppConfigData.bLw.kP(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.bLx.bLT.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.arf().P(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(e.d.aB(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
