package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.pms.c.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes10.dex */
public class g {

    /* loaded from: classes10.dex */
    public interface a {
        void hb(int i);

        void jZ(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, com.baidu.swan.apps.model.b bVar, final String str, final a aVar, String str2) {
        if (aVar != null) {
            if (eVar == null || bVar == null || TextUtils.isEmpty(bVar.mPage) || TextUtils.isEmpty(bVar.cRK)) {
                aVar.hb(2110);
                return;
            }
            String str3 = bVar.cRK;
            final String jS = eVar.jS(bVar.mPage);
            boolean rn = eVar.rn(str3);
            if (com.baidu.swan.apps.console.debugger.a.e.ahz() || com.baidu.swan.apps.ad.a.a.aAx()) {
                if (rn || !TextUtils.isEmpty(jS)) {
                    aVar.jZ(str);
                } else {
                    aVar.hb(2111);
                }
            } else if (com.baidu.swan.apps.ac.b.a.qA(bVar.mPage)) {
                aVar.jZ(str);
            } else {
                if (rn) {
                    if (com.baidu.swan.apps.r.d.bF(eVar.id, eVar.getVersion())) {
                        aVar.jZ(str);
                        return;
                    } else if (eVar.aDv()) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(jS)) {
                    aVar.hb(2111);
                } else if (eVar.ro(jS)) {
                    aVar.jZ(str);
                } else if (eVar.rp(jS) && eVar.rq(jS)) {
                    aVar.jZ(str);
                    eVar.Z(jS, true);
                } else {
                    String rr = eVar.rr(jS);
                    if (TextUtils.isEmpty(rr)) {
                        aVar.hb(2112);
                        return;
                    }
                    boolean rt = eVar.rt(str3);
                    if (!com.baidu.swan.apps.r.d.bF(eVar.id, eVar.getVersion()) && !rt) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                    com.baidu.swan.pms.c.d.f fVar = new com.baidu.swan.pms.c.d.f(eVar.id, eVar.getVersion(), rr, 0);
                    com.baidu.swan.apps.core.pms.e.a aVar2 = new com.baidu.swan.apps.core.pms.e.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void alN() {
                            com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
                            if (aDa != null) {
                                aDa.Z(jS, true);
                            }
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.jZ(str);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void hN(final int i) {
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.hb(i);
                                }
                            });
                        }
                    });
                    com.baidu.swan.apps.performance.i.bY("route", str2).f(new UbcFlowEvent("na_start_sub_package_download")).cb("sub_state", "1");
                    com.baidu.swan.pms.c.a(fVar, aVar2);
                }
            }
        }
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null) {
                aVar.hb(2111);
                return;
            }
            com.baidu.swan.apps.performance.i.bY("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).cb("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.aCW().abk());
            cVar.mB(ak.tS(eVar.getVersion()));
            cVar.xP(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(eVar.id, new a.InterfaceC0401a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0401a
                public void aml() {
                    a.this.hb(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0401a
                public void onSuccess() {
                    a.this.jZ(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0401a
                public void onError() {
                    a.this.hb(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.f(str, str2, str4, 0), new com.baidu.swan.apps.core.pms.e.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void alN() {
                    com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
                    if (aDa != null) {
                        aDa.Z(str3, true);
                    }
                    aVar.jZ(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void hN(int i) {
                    aVar.hb(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.cIY);
    }

    public static boolean b(com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.ahz()) {
            return false;
        }
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.dfd == null || swanAppConfigData.dfd.rG(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.dfe.dfG.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.aWO().X(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(d.C0438d.bG(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
