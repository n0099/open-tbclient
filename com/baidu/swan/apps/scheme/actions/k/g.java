package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.pms.c.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes25.dex */
public class g {

    /* loaded from: classes25.dex */
    public interface a {
        void hQ(int i);

        void li(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, com.baidu.swan.apps.model.b bVar, final String str, final a aVar, String str2) {
        if (aVar != null) {
            if (eVar == null || bVar == null || TextUtils.isEmpty(bVar.mPage) || TextUtils.isEmpty(bVar.dlu)) {
                aVar.hQ(2110);
                return;
            }
            String str3 = bVar.dlu;
            final String lb = eVar.lb(bVar.mPage);
            boolean sw = eVar.sw(str3);
            if (com.baidu.swan.apps.console.debugger.a.e.aot() || com.baidu.swan.apps.ad.a.a.aHr()) {
                if (sw || !TextUtils.isEmpty(lb)) {
                    aVar.li(str);
                } else {
                    aVar.hQ(2111);
                }
            } else if (com.baidu.swan.apps.ac.b.a.rI(bVar.mPage)) {
                aVar.li(str);
            } else {
                if (sw) {
                    if (com.baidu.swan.apps.r.d.bS(eVar.id, eVar.getVersion())) {
                        aVar.li(str);
                        return;
                    } else if (eVar.aKp()) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(lb)) {
                    aVar.hQ(2111);
                } else if (eVar.sx(lb)) {
                    aVar.li(str);
                } else if (eVar.sy(lb) && eVar.sz(lb)) {
                    aVar.li(str);
                    eVar.ac(lb, true);
                } else {
                    String sA = eVar.sA(lb);
                    if (TextUtils.isEmpty(sA)) {
                        aVar.hQ(2112);
                        return;
                    }
                    boolean sC = eVar.sC(str3);
                    if (!com.baidu.swan.apps.r.d.bS(eVar.id, eVar.getVersion()) && !sC) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                    com.baidu.swan.pms.c.d.f fVar = new com.baidu.swan.pms.c.d.f(eVar.id, eVar.getVersion(), sA, 0);
                    com.baidu.swan.apps.core.pms.e.a aVar2 = new com.baidu.swan.apps.core.pms.e.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void asI() {
                            com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
                            if (aJU != null) {
                                aJU.ac(lb, true);
                            }
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.li(str);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void iC(final int i) {
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.hQ(i);
                                }
                            });
                        }
                    });
                    com.baidu.swan.apps.performance.i.cl("route", str2).f(new UbcFlowEvent("na_start_sub_package_download")).co("sub_state", "1");
                    com.baidu.swan.pms.c.a(fVar, aVar2);
                }
            }
        }
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null) {
                aVar.hQ(2111);
                return;
            }
            com.baidu.swan.apps.performance.i.cl("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).co("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.aJQ().aie());
            cVar.nq(ak.vb(eVar.getVersion()));
            cVar.yY(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(eVar.id, new a.InterfaceC0437a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0437a
                public void atg() {
                    a.this.hQ(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0437a
                public void onSuccess() {
                    a.this.li(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0437a
                public void onError() {
                    a.this.hQ(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.f(str, str2, str4, 0), new com.baidu.swan.apps.core.pms.e.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void asI() {
                    com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
                    if (aJU != null) {
                        aJU.ac(str3, true);
                    }
                    aVar.li(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void iC(int i) {
                    aVar.hQ(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.dcA);
    }

    public static boolean b(com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.aot()) {
            return false;
        }
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.dyS == null || swanAppConfigData.dyS.sQ(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.dyT.dzv.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.bdF().ah(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(d.C0474d.bT(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
