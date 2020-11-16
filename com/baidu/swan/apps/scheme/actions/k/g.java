package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.pms.c.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes7.dex */
public class g {

    /* loaded from: classes7.dex */
    public interface a {
        void hs(int i);

        void kB(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, com.baidu.swan.apps.model.b bVar, final String str, final a aVar, String str2) {
        if (aVar != null) {
            if (eVar == null || bVar == null || TextUtils.isEmpty(bVar.mPage) || TextUtils.isEmpty(bVar.dew)) {
                aVar.hs(2110);
                return;
            }
            String str3 = bVar.dew;
            final String ku = eVar.ku(bVar.mPage);
            boolean rO = eVar.rO(str3);
            if (com.baidu.swan.apps.console.debugger.a.e.all() || com.baidu.swan.apps.ad.a.a.aEj()) {
                if (rO || !TextUtils.isEmpty(ku)) {
                    aVar.kB(str);
                } else {
                    aVar.hs(2111);
                }
            } else if (com.baidu.swan.apps.ac.b.a.rb(bVar.mPage)) {
                aVar.kB(str);
            } else {
                if (rO) {
                    if (com.baidu.swan.apps.r.d.bL(eVar.id, eVar.getVersion())) {
                        aVar.kB(str);
                        return;
                    } else if (eVar.aHh()) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(ku)) {
                    aVar.hs(2111);
                } else if (eVar.rP(ku)) {
                    aVar.kB(str);
                } else if (eVar.rQ(ku) && eVar.rR(ku)) {
                    aVar.kB(str);
                    eVar.ab(ku, true);
                } else {
                    String rS = eVar.rS(ku);
                    if (TextUtils.isEmpty(rS)) {
                        aVar.hs(2112);
                        return;
                    }
                    boolean rU = eVar.rU(str3);
                    if (!com.baidu.swan.apps.r.d.bL(eVar.id, eVar.getVersion()) && !rU) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                    com.baidu.swan.pms.c.d.f fVar = new com.baidu.swan.pms.c.d.f(eVar.id, eVar.getVersion(), rS, 0);
                    com.baidu.swan.apps.core.pms.e.a aVar2 = new com.baidu.swan.apps.core.pms.e.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void apA() {
                            com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
                            if (aGM != null) {
                                aGM.ab(ku, true);
                            }
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.kB(str);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void ie(final int i) {
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.hs(i);
                                }
                            });
                        }
                    });
                    com.baidu.swan.apps.performance.i.ce("route", str2).f(new UbcFlowEvent("na_start_sub_package_download")).ch("sub_state", "1");
                    com.baidu.swan.pms.c.a(fVar, aVar2);
                }
            }
        }
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null) {
                aVar.hs(2111);
                return;
            }
            com.baidu.swan.apps.performance.i.ce("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).ch("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.aGI().aeW());
            cVar.mS(ak.uu(eVar.getVersion()));
            cVar.yr(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(eVar.id, new a.InterfaceC0425a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0425a
                public void apY() {
                    a.this.hs(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0425a
                public void onSuccess() {
                    a.this.kB(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0425a
                public void onError() {
                    a.this.hs(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.f(str, str2, str4, 0), new com.baidu.swan.apps.core.pms.e.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void apA() {
                    com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
                    if (aGM != null) {
                        aGM.ab(str3, true);
                    }
                    aVar.kB(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void ie(int i) {
                    aVar.hs(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.cVD);
    }

    public static boolean b(com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.all()) {
            return false;
        }
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.drR == null || swanAppConfigData.drR.si(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.drS.dsv.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.baA().ae(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(d.C0462d.bM(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
