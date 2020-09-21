package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.pms.c.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes3.dex */
public class g {

    /* loaded from: classes3.dex */
    public interface a {
        void gE(int i);

        void jn(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, com.baidu.swan.apps.model.b bVar, final String str, final a aVar, String str2) {
        if (aVar != null) {
            if (eVar == null || bVar == null || TextUtils.isEmpty(bVar.mPage) || TextUtils.isEmpty(bVar.cFG)) {
                aVar.gE(2110);
                return;
            }
            String str3 = bVar.cFG;
            final String jg = eVar.jg(bVar.mPage);
            boolean qB = eVar.qB(str3);
            if (com.baidu.swan.apps.console.debugger.a.e.aeO() || com.baidu.swan.apps.ad.a.a.axM()) {
                if (qB || !TextUtils.isEmpty(jg)) {
                    aVar.jn(str);
                } else {
                    aVar.gE(2111);
                }
            } else if (com.baidu.swan.apps.ac.b.a.pO(bVar.mPage)) {
                aVar.jn(str);
            } else {
                if (qB) {
                    if (com.baidu.swan.apps.r.d.bA(eVar.id, eVar.getVersion())) {
                        aVar.jn(str);
                        return;
                    } else if (eVar.aAM()) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(jg)) {
                    aVar.gE(2111);
                } else if (eVar.qC(jg)) {
                    aVar.jn(str);
                } else if (eVar.qD(jg) && eVar.qE(jg)) {
                    aVar.jn(str);
                    eVar.V(jg, true);
                } else {
                    String qF = eVar.qF(jg);
                    if (TextUtils.isEmpty(qF)) {
                        aVar.gE(2112);
                        return;
                    }
                    boolean qH = eVar.qH(str3);
                    if (!com.baidu.swan.apps.r.d.bA(eVar.id, eVar.getVersion()) && !qH) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                    com.baidu.swan.pms.c.d.f fVar = new com.baidu.swan.pms.c.d.f(eVar.id, eVar.getVersion(), qF, 0);
                    com.baidu.swan.apps.core.pms.e.a aVar2 = new com.baidu.swan.apps.core.pms.e.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void ajc() {
                            com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
                            if (aAr != null) {
                                aAr.V(jg, true);
                            }
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.jn(str);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void hq(final int i) {
                            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.gE(i);
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
                aVar.gE(2111);
                return;
            }
            com.baidu.swan.apps.performance.i.bT("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).bW("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.aAn().Yy());
            cVar.me(ak.tg(eVar.getVersion()));
            cVar.xd(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(eVar.id, new a.InterfaceC0384a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0384a
                public void ajA() {
                    a.this.gE(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0384a
                public void onSuccess() {
                    a.this.jn(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0384a
                public void onError() {
                    a.this.gE(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.f(str, str2, str4, 0), new com.baidu.swan.apps.core.pms.e.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void ajc() {
                    com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
                    if (aAr != null) {
                        aAr.V(str3, true);
                    }
                    aVar.jn(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void hq(int i) {
                    aVar.gE(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.cwT);
    }

    public static boolean b(com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.aeO()) {
            return false;
        }
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.cSV == null || swanAppConfigData.cSV.qU(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.cSW.cTy.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.aUf().W(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(d.C0421d.bB(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
