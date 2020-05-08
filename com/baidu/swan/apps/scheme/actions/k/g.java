package com.baidu.swan.apps.scheme.actions.k;

import android.text.TextUtils;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.pms.a.a;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.t.e;
import java.io.File;
/* loaded from: classes11.dex */
public class g {

    /* loaded from: classes11.dex */
    public interface a {
        void ed(int i);

        void gt(String str);
    }

    public static void a(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null || TextUtils.isEmpty(str)) {
                aVar.ed(2110);
            } else if (com.baidu.swan.apps.console.debugger.a.e.TF() || com.baidu.swan.apps.ah.a.a.aiK()) {
                if (eVar.lY(str) || !TextUtils.isEmpty(eVar.mc(str))) {
                    aVar.gt(str2);
                } else {
                    aVar.ed(2111);
                }
            } else {
                if (eVar.lY(str)) {
                    if (com.baidu.swan.apps.t.e.aS(eVar.id, eVar.getVersion())) {
                        aVar.gt(str2);
                        return;
                    } else if (eVar.alf()) {
                        b(eVar, str, str2, aVar, str3);
                        return;
                    }
                }
                final String mc = eVar.mc(str);
                if (TextUtils.isEmpty(mc)) {
                    aVar.ed(2111);
                } else if (eVar.lZ(mc)) {
                    aVar.gt(str2);
                } else if (eVar.ma(mc) && eVar.mb(mc)) {
                    aVar.gt(str2);
                    eVar.D(mc, true);
                } else {
                    String md = eVar.md(mc);
                    if (TextUtils.isEmpty(md)) {
                        aVar.ed(2112);
                        return;
                    }
                    boolean mf = eVar.mf(str);
                    if (!com.baidu.swan.apps.t.e.aS(eVar.id, eVar.getVersion()) && !mf) {
                        b(eVar, str, str2, aVar, str3);
                        return;
                    }
                    com.baidu.swan.pms.c.d.e eVar2 = new com.baidu.swan.pms.c.d.e(eVar.id, Integer.valueOf(eVar.getVersion()).intValue(), md, 0);
                    com.baidu.swan.apps.core.pms.c.a aVar2 = new com.baidu.swan.apps.core.pms.c.a(eVar.id, eVar.getVersion(), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1
                        @Override // com.baidu.swan.apps.core.pms.b
                        public void Xa() {
                            com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
                            if (akM != null) {
                                akM.D(mc, true);
                            }
                            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.gt(str2);
                                }
                            });
                        }

                        @Override // com.baidu.swan.apps.core.pms.b
                        public void eL(final int i) {
                            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.k.g.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    aVar.ed(i);
                                }
                            });
                        }
                    });
                    com.baidu.swan.apps.performance.f.bh("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).bk("sub_state", "1");
                    com.baidu.swan.pms.c.a(eVar2, aVar2);
                }
            }
        }
    }

    private static void b(com.baidu.swan.apps.runtime.e eVar, String str, final String str2, final a aVar, String str3) {
        if (aVar != null) {
            if (eVar == null) {
                aVar.ed(2111);
                return;
            }
            com.baidu.swan.apps.performance.f.bh("route", str3).f(new UbcFlowEvent("na_start_sub_package_download")).bk("sub_state", "1");
            com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(eVar.id, com.baidu.swan.apps.runtime.d.akJ().Ol());
            cVar.iQ(ai.oi(eVar.getVersion()));
            cVar.rK(str);
            com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.a.a(eVar.id, new a.InterfaceC0300a() { // from class: com.baidu.swan.apps.scheme.actions.k.g.2
                @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0300a
                public void Xw() {
                    a.this.ed(2113);
                }

                @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0300a
                public void onSuccess() {
                    a.this.gt(str2);
                }

                @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0300a
                public void onError() {
                    a.this.ed(2113);
                }
            }));
        }
    }

    public static void a(String str, String str2, final String str3, String str4, final String str5, final a aVar) {
        if (aVar != null) {
            com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(str, Integer.valueOf(str2).intValue(), str4, 0), new com.baidu.swan.apps.core.pms.c.a(str, str2, new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.scheme.actions.k.g.3
                @Override // com.baidu.swan.apps.core.pms.b
                public void Xa() {
                    com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
                    if (akM != null) {
                        akM.D(str3, true);
                    }
                    aVar.gt(str5);
                }

                @Override // com.baidu.swan.apps.core.pms.b
                public void eL(int i) {
                    aVar.ed(i);
                }
            }));
        }
    }

    public static boolean c(com.baidu.swan.apps.x.b.b bVar, e.f fVar) {
        if (fVar == null) {
            return false;
        }
        return b(bVar, fVar.bVY);
    }

    public static boolean b(com.baidu.swan.apps.x.b.b bVar, SwanAppConfigData swanAppConfigData) {
        if (bVar == null || TextUtils.isEmpty(bVar.getPage()) || com.baidu.swan.apps.console.debugger.a.e.TF()) {
            return false;
        }
        String delAllParamsFromUrl = ag.delAllParamsFromUrl(bVar.getPage());
        if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith(File.separator)) {
            delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
        }
        if (swanAppConfigData == null || swanAppConfigData.coG == null || swanAppConfigData.coG.mq(delAllParamsFromUrl)) {
            return false;
        }
        String str = swanAppConfigData.coH.cpd.get(delAllParamsFromUrl);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.pms.database.a.aBI().Q(bVar.getAppId(), bVar.getVersion(), str)) {
            return !new File(e.d.aT(bVar.getAppId(), bVar.getVersion()), str).exists();
        }
        return true;
    }
}
