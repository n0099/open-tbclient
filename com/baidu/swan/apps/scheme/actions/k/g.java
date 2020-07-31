package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.core.pms.c.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import java.io.File;
/* loaded from: classes7.dex */
public class g {

    /* loaded from: classes7.dex */
    public interface a {
        void ex(int i);

        void hw(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, com.baidu.swan.apps.model.b bVar, final String str, final a aVar, String str2) {
        if (aVar != null) {
            if (eVar == null || bVar == null || TextUtils.isEmpty(bVar.mPage) || TextUtils.isEmpty(bVar.cvJ)) {
                aVar.ex(2110);
                return;
            }
            String str3 = bVar.cvJ;
            final String hq = eVar.hq(bVar.mPage);
            boolean oj = eVar.oj(str3);
            if (com.baidu.swan.apps.console.debugger.a.e.XY() || com.baidu.swan.apps.ae.a.a.apg()) {
                if (oj || !TextUtils.isEmpty(hq)) {
                    aVar.hw(str);
                } else {
                    aVar.ex(2111);
                }
            } else if (com.baidu.swan.apps.ad.b.a.nw(bVar.mPage)) {
                aVar.hw(str);
            } else {
                if (oj) {
                    if (com.baidu.swan.apps.r.d.bp(eVar.id, eVar.getVersion())) {
                        aVar.hw(str);
                        return;
                    } else if (eVar.arQ()) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                }
                if (TextUtils.isEmpty(hq)) {
                    aVar.ex(2111);
                } else if (eVar.ok(hq)) {
                    aVar.hw(str);
                } else if (eVar.ol(hq) && eVar.om(hq)) {
                    aVar.hw(str);
                    eVar.Q(hq, true);
                } else {
                    String oo = eVar.oo(hq);
                    if (TextUtils.isEmpty(oo)) {
                        aVar.ex(2112);
                        return;
                    }
                    boolean oq = eVar.oq(str3);
                    if (!com.baidu.swan.apps.r.d.bp(eVar.id, eVar.getVersion()) && !oq) {
                        a(eVar, str3, str, aVar, str2);
                        return;
                    }
                    com.baidu.swan.pms.c.d.f fVar = new com.baidu.swan.pms.c.d.f(eVar.id, eVar.getVersion(), oo, 0);
                    com.baidu.swan.apps.core.pms.e.a aVar2 = new com.baidu.swan.apps.core.pms.e.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void abT() {
                            com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
                            if (arv != null) {
                                arv.Q(hq, true);
                            }
                            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.hw(str);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void fl(final int i) {
                            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.ex(i);
                                }
                            });
                        }
                    });
                    com.baidu.swan.apps.performance.i.bE("route", str2).f(new UbcFlowEvent("na_start_sub_package_download")).bH("sub_state", "1");
                    com.baidu.swan.pms.c.a(fVar, aVar2);
                }
            }
        }
    }

    private static void a(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null) {
                aVar.ex(2111);
                return;
            }
            com.baidu.swan.apps.performance.i.bE("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).bH("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.arr().RU());
            cVar.jM(al.qK(eVar.getVersion()));
            cVar.uA(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(eVar.id, new a.InterfaceC0348a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0348a
                public void acr() {
                    a.this.ex(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0348a
                public void onSuccess() {
                    a.this.hw(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0348a
                public void onError() {
                    a.this.ex(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.f(str, str2, str4, 0), new com.baidu.swan.apps.core.pms.e.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void abT() {
                    com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
                    if (arv != null) {
                        arv.Q(str3, true);
                    }
                    aVar.hw(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void fl(int i) {
                    aVar.ex(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.cnl);
    }

    public static boolean b(com.baidu.swan.apps.u.c.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.XY()) {
            return false;
        }
        String delAllParamsFromUrl = aj.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.cHS == null || swanAppConfigData.cHS.oD(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.cHT.cIv.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.aKS().W(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(d.C0380d.bq(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
