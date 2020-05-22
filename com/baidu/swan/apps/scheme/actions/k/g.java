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
        void ej(int i);

        void hg(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, com.baidu.swan.apps.model.b bVar, final String str, final a aVar, String str2) {
        if (aVar != null) {
            if (eVar == null || bVar == null || TextUtils.isEmpty(bVar.mPage) || TextUtils.isEmpty(bVar.coT)) {
                aVar.ej(2110);
                return;
            }
            String str3 = bVar.coT;
            final String nx = eVar.nx(bVar.mPage);
            boolean nt = eVar.nt(str3);
            if (com.baidu.swan.apps.console.debugger.a.e.Wm() || com.baidu.swan.apps.af.a.a.amr()) {
                if (nt || !TextUtils.isEmpty(nx)) {
                    aVar.hg(str);
                } else {
                    aVar.ej(2111);
                }
            } else if (com.baidu.swan.apps.ae.b.a.mH(bVar.mPage)) {
                aVar.hg(str);
            } else {
                if (nt) {
                    if (com.baidu.swan.apps.r.e.bj(eVar.id, eVar.getVersion())) {
                        aVar.hg(str);
                        return;
                    } else if (eVar.apa()) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(nx)) {
                    aVar.ej(2111);
                } else if (eVar.nu(nx)) {
                    aVar.hg(str);
                } else if (eVar.nv(nx) && eVar.nw(nx)) {
                    aVar.hg(str);
                    eVar.P(nx, true);
                } else {
                    String ny = eVar.ny(nx);
                    if (TextUtils.isEmpty(ny)) {
                        aVar.ej(2112);
                        return;
                    }
                    boolean nA = eVar.nA(str3);
                    if (!com.baidu.swan.apps.r.e.bj(eVar.id, eVar.getVersion()) && !nA) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                    com.baidu.swan.pms.c.d.e eVar2 = new com.baidu.swan.pms.c.d.e(eVar.id, Integer.valueOf(eVar.getVersion()).intValue(), ny, 0);
                    com.baidu.swan.apps.core.pms.e.a aVar2 = new com.baidu.swan.apps.core.pms.e.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void ZM() {
                            com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
                            if (aoF != null) {
                                aoF.P(nx, true);
                            }
                            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.hg(str);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void eU(final int i) {
                            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.ej(i);
                                }
                            });
                        }
                    });
                    com.baidu.swan.apps.performance.g.bA("route", str2).f(new UbcFlowEvent("na_start_sub_package_download")).bD("sub_state", "1");
                    com.baidu.swan.pms.c.a(eVar2, aVar2);
                }
            }
        }
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null) {
                aVar.ej(2111);
                return;
            }
            com.baidu.swan.apps.performance.g.bA("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).bD("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.aoB().Qz());
            cVar.jg(aj.pQ(eVar.getVersion()));
            cVar.tp(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(eVar.id, new a.InterfaceC0340a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0340a
                public void aaj() {
                    a.this.ej(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0340a
                public void onSuccess() {
                    a.this.hg(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0340a
                public void onError() {
                    a.this.ej(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(str, Integer.valueOf(str2).intValue(), str4, 0), new com.baidu.swan.apps.core.pms.e.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void ZM() {
                    com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
                    if (aoF != null) {
                        aoF.P(str3, true);
                    }
                    aVar.hg(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void eU(int i) {
                    aVar.ej(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.v.b.b bVar, e.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.cgt);
    }

    public static boolean b(com.baidu.swan.apps.v.b.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.Wm()) {
            return false;
        }
        String delAllParamsFromUrl = ah.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.cAs == null || swanAppConfigData.cAs.nN(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.cAt.cAT.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.aFV().V(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(e.d.bk(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
