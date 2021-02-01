package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.pms.c.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes9.dex */
public class g {

    /* loaded from: classes9.dex */
    public interface a {
        void gg(int i);

        void ki(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, com.baidu.swan.apps.model.b bVar, final String str, final a aVar, String str2) {
        if (aVar != null) {
            if (eVar == null || bVar == null || TextUtils.isEmpty(bVar.mPage) || TextUtils.isEmpty(bVar.dnO)) {
                aVar.gg(2110);
                return;
            }
            String str3 = bVar.dnO;
            final String kb = eVar.kb(bVar.mPage);
            boolean rA = eVar.rA(str3);
            if (com.baidu.swan.apps.console.debugger.a.e.amk() || com.baidu.swan.apps.ad.a.a.aFm()) {
                if (rA || !TextUtils.isEmpty(kb)) {
                    aVar.ki(str);
                } else {
                    aVar.gg(2111);
                }
            } else if (com.baidu.swan.apps.ac.b.a.qI(bVar.mPage)) {
                aVar.ki(str);
            } else {
                if (rA) {
                    if (com.baidu.swan.apps.r.d.bK(eVar.id, eVar.getVersion())) {
                        aVar.ki(str);
                        return;
                    } else if (eVar.aJf()) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(kb)) {
                    aVar.gg(2111);
                } else if (eVar.rB(kb)) {
                    aVar.ki(str);
                } else if (eVar.rC(kb) && eVar.rD(kb)) {
                    aVar.ki(str);
                    eVar.ab(kb, true);
                } else {
                    String rE = eVar.rE(kb);
                    if (TextUtils.isEmpty(rE)) {
                        aVar.gg(2112);
                        return;
                    }
                    boolean rG = eVar.rG(str3);
                    if (!com.baidu.swan.apps.r.d.bK(eVar.id, eVar.getVersion()) && !rG) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                    com.baidu.swan.pms.c.d.f fVar = new com.baidu.swan.pms.c.d.f(eVar.id, eVar.getVersion(), rE, 0);
                    com.baidu.swan.apps.core.pms.e.a aVar2 = new com.baidu.swan.apps.core.pms.e.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void aqD() {
                            com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
                            if (aIK != null) {
                                aIK.ab(kb, true);
                            }
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.ki(str);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void gU(final int i) {
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.gg(i);
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
                aVar.gg(2111);
                return;
            }
            com.baidu.swan.apps.performance.i.cd("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).cg("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.aIG().getFrameType());
            cVar.lW(ak.ui(eVar.getVersion()));
            cVar.yf(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(eVar.id, new a.InterfaceC0409a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0409a
                public void arb() {
                    a.this.gg(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0409a
                public void onSuccess() {
                    a.this.ki(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0409a
                public void onError() {
                    a.this.gg(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.f(str, str2, str4, 0), new com.baidu.swan.apps.core.pms.e.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void aqD() {
                    com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
                    if (aIK != null) {
                        aIK.ab(str3, true);
                    }
                    aVar.ki(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void gU(int i) {
                    aVar.gg(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.deS);
    }

    public static boolean b(com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.amk()) {
            return false;
        }
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.dEP == null || swanAppConfigData.dEP.rU(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.dEQ.dFs.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.bcv().ak(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(d.C0446d.bL(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
