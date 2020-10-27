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

    public com.baidu.swan.apps.api.c.b lf(String str) {
        if (DEBUG) {
            Log.d("Api-ReLaunch", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        j.qJ(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bj = com.baidu.swan.apps.api.d.b.bj("Api-ReLaunch", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bj.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ReLaunch", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bj.second;
        String bN = com.baidu.swan.apps.scheme.actions.k.a.bN(jSONObject);
        if (TextUtils.isEmpty(bN)) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "url is null");
            return new com.baidu.swan.apps.api.c.b(202, "url is null");
        }
        final f axo = f.axo();
        final com.baidu.swan.apps.core.d.f adm = axo.adm();
        if (adm == null) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b cb = com.baidu.swan.apps.model.b.cb(bN, axo.awV());
        if (!ak.a(axo.awT(), cb, true)) {
            String str2 = "page params error : path=" + cb.mPage + " ; routePath=" + cb.dag;
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", str2);
            return new com.baidu.swan.apps.api.c.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && cb != null && !TextUtils.isEmpty(cb.dag) && e.aEU() != null) {
            e.aEU().cq(optString, cb.dag);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            i.cf("route", uuid).f(new UbcFlowEvent("fe_route_start").bC(Long.valueOf(optString2).longValue()));
        }
        final String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "cb is null");
            return new com.baidu.swan.apps.api.c.b(202, "cb is null");
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aGe().f(cb)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aGe().c("reLaunch", cb);
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "access to this page is prohibited");
            return new com.baidu.swan.apps.api.c.b(1003, "access to this page is prohibited");
        } else {
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.d.1
                @Override // java.lang.Runnable
                public void run() {
                    SwanAppActivity awY = axo.awY();
                    if (awY == null || awY.isFinishing()) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            d.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan activity is null"));
                            return;
                        }
                        throw new RuntimeException("swan activity is null");
                    }
                    final b.a f = com.baidu.swan.apps.core.slave.b.f(awY, a.C0420a.aoO());
                    final String agj = f.cJC.agj();
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-ReLaunch", "webview idx: " + agj);
                    }
                    final e aEU = e.aEU();
                    if (aEU == null) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            d.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    axo.showLoadingView();
                    g.a(aEU, cb, agj, new g.a() { // from class: com.baidu.swan.apps.api.module.g.d.1.1
                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void ks(String str3) {
                            j.qI(uuid);
                            com.baidu.swan.apps.console.c.i("Api-ReLaunch", "check pages success");
                            axo.adp();
                            com.baidu.swan.apps.scheme.actions.k.a.a(d.this, aEU, agj, cb.mPage, null, optString3);
                            com.baidu.swan.apps.statistic.e.sL(agj);
                            d.this.b(f, cb, adm, uuid);
                        }

                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void hm(int i) {
                            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "check pages failed");
                            axo.adp();
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
        i.cf("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).ci("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("Api-ReLaunch", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0421b() { // from class: com.baidu.swan.apps.api.module.g.d.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0421b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady start.");
                }
                j.a(aVar, str);
                com.baidu.swan.apps.scheme.actions.k.a.a(aVar.cJC, bVar, str);
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
            com.baidu.swan.apps.console.c.i("Api-ReLaunch", "doReLaunch page=" + bVar.mPage + " routePage=" + bVar.dag);
        }
        f.a aVar = new f.a() { // from class: com.baidu.swan.apps.api.module.g.d.3
            @Override // com.baidu.swan.apps.core.d.f.a
            public void a(@NonNull Fragment fragment) {
            }

            @Override // com.baidu.swan.apps.core.d.f.a
            public void b(@NonNull Fragment fragment) {
                if (fragment instanceof com.baidu.swan.apps.core.d.e) {
                    ((com.baidu.swan.apps.core.d.e) fragment).cEQ = true;
                }
            }
        };
        fVar.a(aVar);
        fVar.mM("reLaunch").al(0, 0).amK().a("normal", bVar).amM();
        fVar.b(aVar);
        i.cf("route", str).f(new UbcFlowEvent("na_push_page_end"));
        j.ah(3, str);
        j.qK(str);
    }
}
