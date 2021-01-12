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
        void gd(int i);

        void jQ(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, com.baidu.swan.apps.model.b bVar, final String str, final a aVar, String str2) {
        if (aVar != null) {
            if (eVar == null || bVar == null || TextUtils.isEmpty(bVar.mPage) || TextUtils.isEmpty(bVar.dlD)) {
                aVar.gd(2110);
                return;
            }
            String str3 = bVar.dlD;
            final String jJ = eVar.jJ(bVar.mPage);
            boolean rh = eVar.rh(str3);
            if (com.baidu.swan.apps.console.debugger.a.e.alM() || com.baidu.swan.apps.ad.a.a.aER()) {
                if (rh || !TextUtils.isEmpty(jJ)) {
                    aVar.jQ(str);
                } else {
                    aVar.gd(2111);
                }
            } else if (com.baidu.swan.apps.ac.b.a.qq(bVar.mPage)) {
                aVar.jQ(str);
            } else {
                if (rh) {
                    if (com.baidu.swan.apps.r.d.bQ(eVar.id, eVar.getVersion())) {
                        aVar.jQ(str);
                        return;
                    } else if (eVar.aIM()) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(jJ)) {
                    aVar.gd(2111);
                } else if (eVar.ri(jJ)) {
                    aVar.jQ(str);
                } else if (eVar.rj(jJ) && eVar.rk(jJ)) {
                    aVar.jQ(str);
                    eVar.ac(jJ, true);
                } else {
                    String rl = eVar.rl(jJ);
                    if (TextUtils.isEmpty(rl)) {
                        aVar.gd(2112);
                        return;
                    }
                    boolean rn = eVar.rn(str3);
                    if (!com.baidu.swan.apps.r.d.bQ(eVar.id, eVar.getVersion()) && !rn) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                    com.baidu.swan.pms.c.d.f fVar = new com.baidu.swan.pms.c.d.f(eVar.id, eVar.getVersion(), rl, 0);
                    com.baidu.swan.apps.core.pms.e.a aVar2 = new com.baidu.swan.apps.core.pms.e.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void aqf() {
                            com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
                            if (aIr != null) {
                                aIr.ac(jJ, true);
                            }
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.jQ(str);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void gR(final int i) {
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.gd(i);
                                }
                            });
                        }
                    });
                    com.baidu.swan.apps.performance.i.cj("route", str2).f(new UbcFlowEvent("na_start_sub_package_download")).cm("sub_state", "1");
                    com.baidu.swan.pms.c.a(fVar, aVar2);
                }
            }
        }
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null) {
                aVar.gd(2111);
                return;
            }
            com.baidu.swan.apps.performance.i.cj("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).cm("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.aIn().afr());
            cVar.lT(ak.tP(eVar.getVersion()));
            cVar.xM(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(eVar.id, new a.InterfaceC0412a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0412a
                public void aqD() {
                    a.this.gd(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0412a
                public void onSuccess() {
                    a.this.jQ(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0412a
                public void onError() {
                    a.this.gd(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.f(str, str2, str4, 0), new com.baidu.swan.apps.core.pms.e.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void aqf() {
                    com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
                    if (aIr != null) {
                        aIr.ac(str3, true);
                    }
                    aVar.jQ(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void gR(int i) {
                    aVar.gd(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.dcF);
    }

    public static boolean b(com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.alM()) {
            return false;
        }
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.dCL == null || swanAppConfigData.dCL.rB(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.dCM.dDo.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.bci().aj(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(d.C0449d.bR(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
