package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.pms.a.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.t.e;
import java.io.File;
/* loaded from: classes9.dex */
public class g {

    /* loaded from: classes9.dex */
    public interface a {
        void dH(int i);

        void success(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null || TextUtils.isEmpty(str)) {
                aVar.dH(2110);
            } else if (com.baidu.swan.apps.console.debugger.a.e.Jc() || com.baidu.swan.apps.ah.a.a.XQ()) {
                if (eVar.ku(str) || !TextUtils.isEmpty(eVar.ky(str))) {
                    aVar.success(str2);
                } else {
                    aVar.dH(2111);
                }
            } else {
                if (eVar.ku(str)) {
                    if (com.baidu.swan.apps.t.e.az(eVar.id, eVar.getVersion())) {
                        aVar.success(str2);
                        return;
                    } else if (eVar.aal()) {
                        b(eVar, str, str2, aVar, str3);
                        return;
                    }
                }
                final String ky = eVar.ky(str);
                if (TextUtils.isEmpty(ky)) {
                    aVar.dH(2111);
                } else if (eVar.kv(ky)) {
                    aVar.success(str2);
                } else if (eVar.kw(ky) && eVar.kx(ky)) {
                    aVar.success(str2);
                    eVar.y(ky, true);
                } else {
                    String kz = eVar.kz(ky);
                    if (TextUtils.isEmpty(kz)) {
                        aVar.dH(2112);
                        return;
                    }
                    boolean kB = eVar.kB(str);
                    if (!com.baidu.swan.apps.t.e.az(eVar.id, eVar.getVersion()) && !kB) {
                        b(eVar, str, str2, aVar, str3);
                        return;
                    }
                    com.baidu.swan.pms.c.d.e eVar2 = new com.baidu.swan.pms.c.d.e(eVar.id, Integer.valueOf(eVar.getVersion()).intValue(), kz, 0);
                    com.baidu.swan.apps.core.pms.c.a aVar2 = new com.baidu.swan.apps.core.pms.c.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void Mx() {
                            com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
                            if (ZS != null) {
                                ZS.y(ky, true);
                            }
                            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.success(str2);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void ep(final int i) {
                            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.dH(i);
                                }
                            });
                        }
                    });
                    com.baidu.swan.apps.performance.f.aO("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).aR("sub_state", "1");
                    com.baidu.swan.pms.c.a(eVar2, aVar2);
                }
            }
        }
    }

    private static void b(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null) {
                aVar.dH(2111);
                return;
            }
            com.baidu.swan.apps.performance.f.aO("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).aR("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.ZP().DH());
            cVar.is(ai.mD(eVar.getVersion()));
            cVar.qg(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.a.a(eVar.id, new a.InterfaceC0237a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0237a
                public void MT() {
                    a.this.dH(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0237a
                public void onSuccess() {
                    a.this.success(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0237a
                public void onError() {
                    a.this.dH(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(str, Integer.valueOf(str2).intValue(), str4, 0), new com.baidu.swan.apps.core.pms.c.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void Mx() {
                    com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
                    if (ZS != null) {
                        ZS.y(str3, true);
                    }
                    aVar.success(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void ep(int i) {
                    aVar.dH(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.x.b.b bVar, e.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.bsB);
    }

    public static boolean b(com.baidu.swan.apps.x.b.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.Jc()) {
            return false;
        }
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.bKM == null || swanAppConfigData.bKM.kM(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.bKN.bLj.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.aqM().P(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(e.d.aA(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
