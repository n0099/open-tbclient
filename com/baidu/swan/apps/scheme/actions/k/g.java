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
        void hm(int i);

        void ks(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, com.baidu.swan.apps.model.b bVar, final String str, final a aVar, String str2) {
        if (aVar != null) {
            if (eVar == null || bVar == null || TextUtils.isEmpty(bVar.mPage) || TextUtils.isEmpty(bVar.dag)) {
                aVar.hm(2110);
                return;
            }
            String str3 = bVar.dag;
            final String kl = eVar.kl(bVar.mPage);
            boolean rG = eVar.rG(str3);
            if (com.baidu.swan.apps.console.debugger.a.e.ajt() || com.baidu.swan.apps.ad.a.a.aCr()) {
                if (rG || !TextUtils.isEmpty(kl)) {
                    aVar.ks(str);
                } else {
                    aVar.hm(2111);
                }
            } else if (com.baidu.swan.apps.ac.b.a.qT(bVar.mPage)) {
                aVar.ks(str);
            } else {
                if (rG) {
                    if (com.baidu.swan.apps.r.d.bM(eVar.id, eVar.getVersion())) {
                        aVar.ks(str);
                        return;
                    } else if (eVar.aFp()) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(kl)) {
                    aVar.hm(2111);
                } else if (eVar.rH(kl)) {
                    aVar.ks(str);
                } else if (eVar.rI(kl) && eVar.rJ(kl)) {
                    aVar.ks(str);
                    eVar.ab(kl, true);
                } else {
                    String rK = eVar.rK(kl);
                    if (TextUtils.isEmpty(rK)) {
                        aVar.hm(2112);
                        return;
                    }
                    boolean rM = eVar.rM(str3);
                    if (!com.baidu.swan.apps.r.d.bM(eVar.id, eVar.getVersion()) && !rM) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                    com.baidu.swan.pms.c.d.f fVar = new com.baidu.swan.pms.c.d.f(eVar.id, eVar.getVersion(), rK, 0);
                    com.baidu.swan.apps.core.pms.e.a aVar2 = new com.baidu.swan.apps.core.pms.e.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void anH() {
                            com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
                            if (aEU != null) {
                                aEU.ab(kl, true);
                            }
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.ks(str);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void hY(final int i) {
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.hm(i);
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
                aVar.hm(2111);
                return;
            }
            com.baidu.swan.apps.performance.i.cf("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).ci("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.aEQ().ade());
            cVar.mM(ak.ul(eVar.getVersion()));
            cVar.yi(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(eVar.id, new a.InterfaceC0415a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0415a
                public void aof() {
                    a.this.hm(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0415a
                public void onSuccess() {
                    a.this.ks(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0415a
                public void onError() {
                    a.this.hm(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.f(str, str2, str4, 0), new com.baidu.swan.apps.core.pms.e.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void anH() {
                    com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
                    if (aEU != null) {
                        aEU.ab(str3, true);
                    }
                    aVar.ks(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void hY(int i) {
                    aVar.hm(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.cRu);
    }

    public static boolean b(com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.ajt()) {
            return false;
        }
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.dnD == null || swanAppConfigData.dnD.rZ(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.dnE.doh.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.aYH().ae(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(d.C0452d.bN(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
