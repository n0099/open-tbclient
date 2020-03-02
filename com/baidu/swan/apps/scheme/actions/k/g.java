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
            } else if (com.baidu.swan.apps.console.debugger.a.e.LP() || com.baidu.swan.apps.ah.a.a.aaD()) {
                if (eVar.kM(str) || !TextUtils.isEmpty(eVar.kQ(str))) {
                    aVar.success(str2);
                } else {
                    aVar.dY(2111);
                }
            } else {
                if (eVar.kM(str)) {
                    if (com.baidu.swan.apps.t.e.aK(eVar.id, eVar.getVersion())) {
                        aVar.success(str2);
                        return;
                    } else if (eVar.acY()) {
                        b(eVar, str, str2, aVar, str3);
                        return;
                    }
                }
                final String kQ = eVar.kQ(str);
                if (TextUtils.isEmpty(kQ)) {
                    aVar.dY(2111);
                } else if (eVar.kN(kQ)) {
                    aVar.success(str2);
                } else if (eVar.kO(kQ) && eVar.kP(kQ)) {
                    aVar.success(str2);
                    eVar.y(kQ, true);
                } else {
                    String kR = eVar.kR(kQ);
                    if (TextUtils.isEmpty(kR)) {
                        aVar.dY(2112);
                        return;
                    }
                    boolean kT = eVar.kT(str);
                    if (!com.baidu.swan.apps.t.e.aK(eVar.id, eVar.getVersion()) && !kT) {
                        b(eVar, str, str2, aVar, str3);
                        return;
                    }
                    com.baidu.swan.pms.c.d.e eVar2 = new com.baidu.swan.pms.c.d.e(eVar.id, Integer.valueOf(eVar.getVersion()).intValue(), kR, 0);
                    com.baidu.swan.apps.core.pms.c.a aVar2 = new com.baidu.swan.apps.core.pms.c.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void Pj() {
                            com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
                            if (acF != null) {
                                acF.y(kQ, true);
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
                    com.baidu.swan.apps.performance.f.aY("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).bb("sub_state", "1");
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
            com.baidu.swan.apps.performance.f.aY("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).bb("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.acC().Gu());
            cVar.iJ(ai.mV(eVar.getVersion()));
            cVar.qy(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.a.a(eVar.id, new a.InterfaceC0249a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0249a
                public void PF() {
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
                public void Pj() {
                    com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
                    if (acF != null) {
                        acF.y(str3, true);
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
        return b(bVar, fVar.bxA);
    }

    public static boolean b(com.baidu.swan.apps.x.b.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.LP()) {
            return false;
        }
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.bPC == null || swanAppConfigData.bPC.le(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.bPD.bPZ.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.atv().Q(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(e.d.aL(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
