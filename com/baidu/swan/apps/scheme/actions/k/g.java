package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.pms.c.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes8.dex */
public class g {

    /* loaded from: classes8.dex */
    public interface a {
        void gv(int i);

        void iT(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, com.baidu.swan.apps.model.b bVar, final String str, final a aVar, String str2) {
        if (aVar != null) {
            if (eVar == null || bVar == null || TextUtils.isEmpty(bVar.mPage) || TextUtils.isEmpty(bVar.cDC)) {
                aVar.gv(2110);
                return;
            }
            String str3 = bVar.cDC;
            final String iM = eVar.iM(bVar.mPage);
            boolean qh = eVar.qh(str3);
            if (com.baidu.swan.apps.console.debugger.a.e.aee() || com.baidu.swan.apps.ad.a.a.axd()) {
                if (qh || !TextUtils.isEmpty(iM)) {
                    aVar.iT(str);
                } else {
                    aVar.gv(2111);
                }
            } else if (com.baidu.swan.apps.ac.b.a.pu(bVar.mPage)) {
                aVar.iT(str);
            } else {
                if (qh) {
                    if (com.baidu.swan.apps.r.d.bA(eVar.id, eVar.getVersion())) {
                        aVar.iT(str);
                        return;
                    } else if (eVar.aAd()) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(iM)) {
                    aVar.gv(2111);
                } else if (eVar.qi(iM)) {
                    aVar.iT(str);
                } else if (eVar.qj(iM) && eVar.qk(iM)) {
                    aVar.iT(str);
                    eVar.V(iM, true);
                } else {
                    String ql = eVar.ql(iM);
                    if (TextUtils.isEmpty(ql)) {
                        aVar.gv(2112);
                        return;
                    }
                    boolean qn = eVar.qn(str3);
                    if (!com.baidu.swan.apps.r.d.bA(eVar.id, eVar.getVersion()) && !qn) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                    com.baidu.swan.pms.c.d.f fVar = new com.baidu.swan.pms.c.d.f(eVar.id, eVar.getVersion(), ql, 0);
                    com.baidu.swan.apps.core.pms.e.a aVar2 = new com.baidu.swan.apps.core.pms.e.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void ais() {
                            com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
                            if (azI != null) {
                                azI.V(iM, true);
                            }
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.iT(str);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void hh(final int i) {
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.gv(i);
                                }
                            });
                        }
                    });
                    com.baidu.swan.apps.performance.i.bT("route", str2).f(new UbcFlowEvent("na_start_sub_package_download")).bW("sub_state", "1");
                    com.baidu.swan.pms.c.a(fVar, aVar2);
                }
            }
        }
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null) {
                aVar.gv(2111);
                return;
            }
            com.baidu.swan.apps.performance.i.bT("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).bW("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.azE().XP());
            cVar.lT(ak.sM(eVar.getVersion()));
            cVar.wJ(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(eVar.id, new a.InterfaceC0389a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0389a
                public void aiQ() {
                    a.this.gv(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0389a
                public void onSuccess() {
                    a.this.iT(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0389a
                public void onError() {
                    a.this.gv(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.f(str, str2, str4, 0), new com.baidu.swan.apps.core.pms.e.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void ais() {
                    com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
                    if (azI != null) {
                        azI.V(str3, true);
                    }
                    aVar.iT(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void hh(int i) {
                    aVar.gv(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.cuO);
    }

    public static boolean b(com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.aee()) {
            return false;
        }
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.cQR == null || swanAppConfigData.cQR.qA(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.cQS.cRu.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.aTt().W(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(d.C0426d.bB(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
