package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.pms.a.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.t.e;
import java.io.File;
/* loaded from: classes11.dex */
public class g {

    /* loaded from: classes11.dex */
    public interface a {
        void dY(int i);

        void success(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null || TextUtils.isEmpty(str)) {
                aVar.dY(2110);
            } else if (com.baidu.swan.apps.console.debugger.a.e.LS() || com.baidu.swan.apps.ah.a.a.aaG()) {
                if (eVar.kL(str) || !TextUtils.isEmpty(eVar.kP(str))) {
                    aVar.success(str2);
                } else {
                    aVar.dY(2111);
                }
            } else {
                if (eVar.kL(str)) {
                    if (com.baidu.swan.apps.t.e.aJ(eVar.id, eVar.getVersion())) {
                        aVar.success(str2);
                        return;
                    } else if (eVar.adb()) {
                        b(eVar, str, str2, aVar, str3);
                        return;
                    }
                }
                final String kP = eVar.kP(str);
                if (TextUtils.isEmpty(kP)) {
                    aVar.dY(2111);
                } else if (eVar.kM(kP)) {
                    aVar.success(str2);
                } else if (eVar.kN(kP) && eVar.kO(kP)) {
                    aVar.success(str2);
                    eVar.y(kP, true);
                } else {
                    String kQ = eVar.kQ(kP);
                    if (TextUtils.isEmpty(kQ)) {
                        aVar.dY(2112);
                        return;
                    }
                    boolean kS = eVar.kS(str);
                    if (!com.baidu.swan.apps.t.e.aJ(eVar.id, eVar.getVersion()) && !kS) {
                        b(eVar, str, str2, aVar, str3);
                        return;
                    }
                    com.baidu.swan.pms.c.d.e eVar2 = new com.baidu.swan.pms.c.d.e(eVar.id, Integer.valueOf(eVar.getVersion()).intValue(), kQ, 0);
                    com.baidu.swan.apps.core.pms.c.a aVar2 = new com.baidu.swan.apps.core.pms.c.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void Pm() {
                            com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
                            if (acI != null) {
                                acI.y(kP, true);
                            }
                            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.success(str2);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void eG(final int i) {
                            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.dY(i);
                                }
                            });
                        }
                    });
                    com.baidu.swan.apps.performance.f.aX("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).ba("sub_state", "1");
                    com.baidu.swan.pms.c.a(eVar2, aVar2);
                }
            }
        }
    }

    private static void b(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null) {
                aVar.dY(2111);
                return;
            }
            com.baidu.swan.apps.performance.f.aX("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).ba("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.acF().Gz());
            cVar.iJ(ai.mU(eVar.getVersion()));
            cVar.qx(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.a.a(eVar.id, new a.InterfaceC0249a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0249a
                public void PI() {
                    a.this.dY(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0249a
                public void onSuccess() {
                    a.this.success(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0249a
                public void onError() {
                    a.this.dY(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(str, Integer.valueOf(str2).intValue(), str4, 0), new com.baidu.swan.apps.core.pms.c.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void Pm() {
                    com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
                    if (acI != null) {
                        acI.y(str3, true);
                    }
                    aVar.success(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void eG(int i) {
                    aVar.dY(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.x.b.b bVar, e.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.bxM);
    }

    public static boolean b(com.baidu.swan.apps.x.b.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.LS()) {
            return false;
        }
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.bPO == null || swanAppConfigData.bPO.ld(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.bPP.bQl.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.aty().Q(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(e.d.aK(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
