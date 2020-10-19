package com.baidu.swan.apps.api.module.g;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.core.slave.a;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.performance.j;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.g;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.support.v4.app.Fragment;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends com.baidu.swan.apps.api.a.d {
    public d(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b kM(String str) {
        if (DEBUG) {
            Log.d("Api-ReLaunch", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        j.qq(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bc = com.baidu.swan.apps.api.d.b.bc("Api-ReLaunch", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bc.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ReLaunch", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bc.second;
        String bK = com.baidu.swan.apps.scheme.actions.k.a.bK(jSONObject);
        if (TextUtils.isEmpty(bK)) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "url is null");
            return new com.baidu.swan.apps.api.c.b(202, "url is null");
        }
        final f avu = f.avu();
        final com.baidu.swan.apps.core.d.f abs = avu.abs();
        if (abs == null) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b bU = com.baidu.swan.apps.model.b.bU(bK, avu.avb());
        if (!ak.a(avu.auZ(), bU, true)) {
            String str2 = "page params error : path=" + bU.mPage + " ; routePath=" + bU.cRK;
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", str2);
            return new com.baidu.swan.apps.api.c.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && bU != null && !TextUtils.isEmpty(bU.cRK) && e.aDa() != null) {
            e.aDa().cj(optString, bU.cRK);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            i.bY("route", uuid).f(new UbcFlowEvent("fe_route_start").bA(Long.valueOf(optString2).longValue()));
        }
        final String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "cb is null");
            return new com.baidu.swan.apps.api.c.b(202, "cb is null");
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aEk().f(bU)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aEk().c("reLaunch", bU);
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "access to this page is prohibited");
            return new com.baidu.swan.apps.api.c.b(1003, "access to this page is prohibited");
        } else {
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.d.1
                @Override // java.lang.Runnable
                public void run() {
                    SwanAppActivity ave = avu.ave();
                    if (ave == null || ave.isFinishing()) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            d.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan activity is null"));
                            return;
                        }
                        throw new RuntimeException("swan activity is null");
                    }
                    final b.a f = com.baidu.swan.apps.core.slave.b.f(ave, a.C0406a.amU());
                    final String aep = f.cBg.aep();
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-ReLaunch", "webview idx: " + aep);
                    }
                    final e aDa = e.aDa();
                    if (aDa == null) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            d.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    avu.showLoadingView();
                    g.a(aDa, bU, aep, new g.a() { // from class: com.baidu.swan.apps.api.module.g.d.1.1
                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void jZ(String str3) {
                            j.qp(uuid);
                            com.baidu.swan.apps.console.c.i("Api-ReLaunch", "check pages success");
                            avu.abv();
                            com.baidu.swan.apps.scheme.actions.k.a.a(d.this, aDa, aep, bU.mPage, null, optString3);
                            com.baidu.swan.apps.statistic.e.ss(aep);
                            d.this.b(f, bU, abs, uuid);
                        }

                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void hb(int i) {
                            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "check pages failed");
                            avu.abv();
                            if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                Context context = d.this.getContext();
                                com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).showToast();
                            }
                            com.baidu.swan.apps.scheme.actions.k.a.b(d.this, optString3);
                        }
                    }, uuid);
                }
            });
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.d.f fVar, final String str) {
        boolean z = aVar != null && aVar.isReady;
        i.bY("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).cb("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("Api-ReLaunch", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0407b() { // from class: com.baidu.swan.apps.api.module.g.d.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0407b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady start.");
                }
                j.a(aVar, str);
                com.baidu.swan.apps.scheme.actions.k.a.a(aVar.cBg, bVar, str);
                d.a(fVar, bVar, str);
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("Api-ReLaunch", "tryToExecutePageRoute end.");
        }
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, com.baidu.swan.apps.model.b bVar, String str) {
        if (bVar != null) {
            com.baidu.swan.apps.console.c.i("Api-ReLaunch", "doReLaunch page=" + bVar.mPage + " routePage=" + bVar.cRK);
        }
        f.a aVar = new f.a() { // from class: com.baidu.swan.apps.api.module.g.d.3
            @Override // com.baidu.swan.apps.core.d.f.a
            public void a(@NonNull Fragment fragment) {
            }

            @Override // com.baidu.swan.apps.core.d.f.a
            public void b(@NonNull Fragment fragment) {
                if (fragment instanceof com.baidu.swan.apps.core.d.e) {
                    ((com.baidu.swan.apps.core.d.e) fragment).cwu = true;
                }
            }
        };
        fVar.a(aVar);
        fVar.mt("reLaunch").ak(0, 0).akQ().a("normal", bVar).akS();
        fVar.b(aVar);
        i.bY("route", str).f(new UbcFlowEvent("na_push_page_end"));
        j.af(3, str);
        j.qr(str);
    }
}
