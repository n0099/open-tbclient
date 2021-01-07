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
        void hK(int i);

        void lb(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, com.baidu.swan.apps.model.b bVar, final String str, final a aVar, String str2) {
        if (aVar != null) {
            if (eVar == null || bVar == null || TextUtils.isEmpty(bVar.mPage) || TextUtils.isEmpty(bVar.dqt)) {
                aVar.hK(2110);
                return;
            }
            String str3 = bVar.dqt;
            final String kU = eVar.kU(bVar.mPage);
            boolean st = eVar.st(str3);
            if (com.baidu.swan.apps.console.debugger.a.e.apH() || com.baidu.swan.apps.ad.a.a.aIL()) {
                if (st || !TextUtils.isEmpty(kU)) {
                    aVar.lb(str);
                } else {
                    aVar.hK(2111);
                }
            } else if (com.baidu.swan.apps.ac.b.a.rB(bVar.mPage)) {
                aVar.lb(str);
            } else {
                if (st) {
                    if (com.baidu.swan.apps.r.d.bR(eVar.id, eVar.getVersion())) {
                        aVar.lb(str);
                        return;
                    } else if (eVar.aMG()) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(kU)) {
                    aVar.hK(2111);
                } else if (eVar.su(kU)) {
                    aVar.lb(str);
                } else if (eVar.sv(kU) && eVar.sw(kU)) {
                    aVar.lb(str);
                    eVar.ac(kU, true);
                } else {
                    String sx = eVar.sx(kU);
                    if (TextUtils.isEmpty(sx)) {
                        aVar.hK(2112);
                        return;
                    }
                    boolean sz = eVar.sz(str3);
                    if (!com.baidu.swan.apps.r.d.bR(eVar.id, eVar.getVersion()) && !sz) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                    com.baidu.swan.pms.c.d.f fVar = new com.baidu.swan.pms.c.d.f(eVar.id, eVar.getVersion(), sx, 0);
                    com.baidu.swan.apps.core.pms.e.a aVar2 = new com.baidu.swan.apps.core.pms.e.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void aua() {
                            com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
                            if (aMl != null) {
                                aMl.ac(kU, true);
                            }
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.lb(str);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void ix(final int i) {
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.hK(i);
                                }
                            });
                        }
                    });
                    com.baidu.swan.apps.performance.i.ck("route", str2).f(new UbcFlowEvent("na_start_sub_package_download")).cn("sub_state", "1");
                    com.baidu.swan.pms.c.a(fVar, aVar2);
                }
            }
        }
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null) {
                aVar.hK(2111);
                return;
            }
            com.baidu.swan.apps.performance.i.ck("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).cn("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.aMh().ajl());
            cVar.nz(ak.va(eVar.getVersion()));
            cVar.yX(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(eVar.id, new a.InterfaceC0429a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0429a
                public void auy() {
                    a.this.hK(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0429a
                public void onSuccess() {
                    a.this.lb(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0429a
                public void onError() {
                    a.this.hK(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.f(str, str2, str4, 0), new com.baidu.swan.apps.core.pms.e.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void aua() {
                    com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
                    if (aMl != null) {
                        aMl.ac(str3, true);
                    }
                    aVar.lb(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void ix(int i) {
                    aVar.hK(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.dht);
    }

    public static boolean b(com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.apH()) {
            return false;
        }
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.dHx == null || swanAppConfigData.dHx.sN(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.dHy.dIa.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.bgc().ak(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(d.C0466d.bS(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
