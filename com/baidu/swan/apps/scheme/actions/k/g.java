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
        void hw(int i);

        void kH(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, com.baidu.swan.apps.model.b bVar, final String str, final a aVar, String str2) {
        if (aVar != null) {
            if (eVar == null || bVar == null || TextUtils.isEmpty(bVar.mPage) || TextUtils.isEmpty(bVar.dgd)) {
                aVar.hw(2110);
                return;
            }
            String str3 = bVar.dgd;
            final String kA = eVar.kA(bVar.mPage);
            boolean rU = eVar.rU(str3);
            if (com.baidu.swan.apps.console.debugger.a.e.alT() || com.baidu.swan.apps.ad.a.a.aER()) {
                if (rU || !TextUtils.isEmpty(kA)) {
                    aVar.kH(str);
                } else {
                    aVar.hw(2111);
                }
            } else if (com.baidu.swan.apps.ac.b.a.rh(bVar.mPage)) {
                aVar.kH(str);
            } else {
                if (rU) {
                    if (com.baidu.swan.apps.r.d.bM(eVar.id, eVar.getVersion())) {
                        aVar.kH(str);
                        return;
                    } else if (eVar.aHP()) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(kA)) {
                    aVar.hw(2111);
                } else if (eVar.rV(kA)) {
                    aVar.kH(str);
                } else if (eVar.rW(kA) && eVar.rX(kA)) {
                    aVar.kH(str);
                    eVar.ab(kA, true);
                } else {
                    String rY = eVar.rY(kA);
                    if (TextUtils.isEmpty(rY)) {
                        aVar.hw(2112);
                        return;
                    }
                    boolean sa = eVar.sa(str3);
                    if (!com.baidu.swan.apps.r.d.bM(eVar.id, eVar.getVersion()) && !sa) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                    com.baidu.swan.pms.c.d.f fVar = new com.baidu.swan.pms.c.d.f(eVar.id, eVar.getVersion(), rY, 0);
                    com.baidu.swan.apps.core.pms.e.a aVar2 = new com.baidu.swan.apps.core.pms.e.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void aqi() {
                            com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
                            if (aHu != null) {
                                aHu.ab(kA, true);
                            }
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.kH(str);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void ii(final int i) {
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.hw(i);
                                }
                            });
                        }
                    });
                    com.baidu.swan.apps.performance.i.cf("route", str2).f(new UbcFlowEvent("na_start_sub_package_download")).ci("sub_state", "1");
                    com.baidu.swan.pms.c.a(fVar, aVar2);
                }
            }
        }
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null) {
                aVar.hw(2111);
                return;
            }
            com.baidu.swan.apps.performance.i.cf("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).ci("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.aHq().afE());
            cVar.mW(ak.uz(eVar.getVersion()));
            cVar.yw(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(eVar.id, new a.InterfaceC0427a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0427a
                public void aqG() {
                    a.this.hw(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0427a
                public void onSuccess() {
                    a.this.kH(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0427a
                public void onError() {
                    a.this.hw(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.f(str, str2, str4, 0), new com.baidu.swan.apps.core.pms.e.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void aqi() {
                    com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
                    if (aHu != null) {
                        aHu.ab(str3, true);
                    }
                    aVar.kH(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void ii(int i) {
                    aVar.hw(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.cXn);
    }

    public static boolean b(com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.alT()) {
            return false;
        }
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.dtA == null || swanAppConfigData.dtA.sn(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.dtB.dud.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.bbh().ae(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(d.C0464d.bN(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
