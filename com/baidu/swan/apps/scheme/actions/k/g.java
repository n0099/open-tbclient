package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.core.pms.c.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes11.dex */
public class g {

    /* loaded from: classes11.dex */
    public interface a {
        void ew(int i);

        void ho(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, com.baidu.swan.apps.model.b bVar, final String str, final a aVar, String str2) {
        if (aVar != null) {
            if (eVar == null || bVar == null || TextUtils.isEmpty(bVar.mPage) || TextUtils.isEmpty(bVar.ctH)) {
                aVar.ew(2110);
                return;
            }
            String str3 = bVar.ctH;
            final String nF = eVar.nF(bVar.mPage);
            boolean nB = eVar.nB(str3);
            if (com.baidu.swan.apps.console.debugger.a.e.Xs() || com.baidu.swan.apps.af.a.a.anx()) {
                if (nB || !TextUtils.isEmpty(nF)) {
                    aVar.ho(str);
                } else {
                    aVar.ew(2111);
                }
            } else if (com.baidu.swan.apps.ae.b.a.mP(bVar.mPage)) {
                aVar.ho(str);
            } else {
                if (nB) {
                    if (com.baidu.swan.apps.r.e.bl(eVar.id, eVar.getVersion())) {
                        aVar.ho(str);
                        return;
                    } else if (eVar.aqh()) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(nF)) {
                    aVar.ew(2111);
                } else if (eVar.nC(nF)) {
                    aVar.ho(str);
                } else if (eVar.nD(nF) && eVar.nE(nF)) {
                    aVar.ho(str);
                    eVar.R(nF, true);
                } else {
                    String nG = eVar.nG(nF);
                    if (TextUtils.isEmpty(nG)) {
                        aVar.ew(2112);
                        return;
                    }
                    boolean nI = eVar.nI(str3);
                    if (!com.baidu.swan.apps.r.e.bl(eVar.id, eVar.getVersion()) && !nI) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                    com.baidu.swan.pms.c.d.e eVar2 = new com.baidu.swan.pms.c.d.e(eVar.id, Integer.valueOf(eVar.getVersion()).intValue(), nG, 0);
                    com.baidu.swan.apps.core.pms.e.a aVar2 = new com.baidu.swan.apps.core.pms.e.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void aaS() {
                            com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
                            if (apM != null) {
                                apM.R(nF, true);
                            }
                            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.ho(str);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void fh(final int i) {
                            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.ew(i);
                                }
                            });
                        }
                    });
                    com.baidu.swan.apps.performance.g.bC("route", str2).f(new UbcFlowEvent("na_start_sub_package_download")).bF("sub_state", "1");
                    com.baidu.swan.pms.c.a(eVar2, aVar2);
                }
            }
        }
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null) {
                aVar.ew(2111);
                return;
            }
            com.baidu.swan.apps.performance.g.bC("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).bF("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.apI().RF());
            cVar.jt(aj.pY(eVar.getVersion()));
            cVar.tx(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(eVar.id, new a.InterfaceC0346a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0346a
                public void abp() {
                    a.this.ew(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0346a
                public void onSuccess() {
                    a.this.ho(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0346a
                public void onError() {
                    a.this.ew(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(str, Integer.valueOf(str2).intValue(), str4, 0), new com.baidu.swan.apps.core.pms.e.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void aaS() {
                    com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
                    if (apM != null) {
                        apM.R(str3, true);
                    }
                    aVar.ho(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void fh(int i) {
                    aVar.ew(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.v.b.b bVar, e.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.clh);
    }

    public static boolean b(com.baidu.swan.apps.v.b.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.Xs()) {
            return false;
        }
        String delAllParamsFromUrl = ah.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.cFc == null || swanAppConfigData.cFc.nV(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.cFd.cFD.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.aHb().W(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(e.d.bm(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
