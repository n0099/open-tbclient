package com.baidu.swan.apps.api.module.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
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
/* loaded from: classes9.dex */
public class d extends com.baidu.swan.apps.api.a.d {
    public d(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lO(String str) {
        if (DEBUG) {
            Log.d("Api-ReLaunch", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        j.rr(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-ReLaunch", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bo.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ReLaunch", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bo.second;
        String bX = com.baidu.swan.apps.scheme.actions.k.a.bX(jSONObject);
        if (TextUtils.isEmpty(bX)) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "url is null");
            return new com.baidu.swan.apps.api.c.b(202, "url is null");
        }
        final f aDG = f.aDG();
        final com.baidu.swan.apps.core.d.f ajs = aDG.ajs();
        if (ajs == null) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b cg = com.baidu.swan.apps.model.b.cg(bX, aDG.aDn());
        if (!ak.a(aDG.aDl(), cg, true)) {
            String str2 = "page params error : path=" + cg.mPage + " ; routePath=" + cg.dqt;
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", str2);
            return new com.baidu.swan.apps.api.c.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && cg != null && !TextUtils.isEmpty(cg.dqt) && e.aMk() != null) {
            e.aMk().cv(optString, cg.dqt);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            i.ck("route", uuid).f(new UbcFlowEvent("fe_route_start").cy(Long.valueOf(optString2).longValue()));
        }
        final String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "cb is null");
            return new com.baidu.swan.apps.api.c.b(202, "cb is null");
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aNu().f(cg)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aNu().c("reLaunch", cg);
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "access to this page is prohibited");
            return new com.baidu.swan.apps.api.c.b(1003, "access to this page is prohibited");
        } else {
            ak.l(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.d.1
                @Override // java.lang.Runnable
                public void run() {
                    SwanAppActivity aDq = aDG.aDq();
                    if (aDq == null || aDq.isFinishing()) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            d.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan activity is null"));
                            return;
                        }
                        throw new RuntimeException("swan activity is null");
                    }
                    final b.a f = com.baidu.swan.apps.core.slave.b.f(aDq, a.C0434a.avg());
                    final String amt = f.cZA.amt();
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-ReLaunch", "webview idx: " + amt);
                    }
                    final e aMk = e.aMk();
                    if (aMk == null) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            d.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    aDG.showLoadingView();
                    g.a(aMk, cg, amt, new g.a() { // from class: com.baidu.swan.apps.api.module.g.d.1.1
                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void lb(String str3) {
                            j.rq(uuid);
                            com.baidu.swan.apps.console.c.i("Api-ReLaunch", "check pages success");
                            aDG.ajv();
                            com.baidu.swan.apps.scheme.actions.k.a.a(d.this, aMk, amt, cg.mPage, null, optString3);
                            com.baidu.swan.apps.statistic.e.ty(amt);
                            d.this.b(f, cg, ajs, uuid);
                        }

                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void hK(int i) {
                            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "check pages failed");
                            aDG.ajv();
                            if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                Context context = d.this.getContext();
                                com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).aLS();
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
        i.ck("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).cn("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("Api-ReLaunch", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0435b() { // from class: com.baidu.swan.apps.api.module.g.d.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0435b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady start.");
                }
                j.a(aVar, str);
                com.baidu.swan.apps.scheme.actions.k.a.a(aVar.cZA, bVar, str);
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
            com.baidu.swan.apps.console.c.i("Api-ReLaunch", "doReLaunch page=" + bVar.mPage + " routePage=" + bVar.dqt);
        }
        f.a aVar = new f.a() { // from class: com.baidu.swan.apps.api.module.g.d.3
            @Override // com.baidu.swan.apps.core.d.f.a
            public void a(@NonNull Fragment fragment) {
            }

            @Override // com.baidu.swan.apps.core.d.f.a
            public void b(@NonNull Fragment fragment) {
                if (fragment instanceof com.baidu.swan.apps.core.d.e) {
                    ((com.baidu.swan.apps.core.d.e) fragment).cUP = true;
                }
            }
        };
        fVar.a(aVar);
        fVar.nv("reLaunch").ai(0, 0).atc().a("normal", bVar).ate();
        fVar.b(aVar);
        i.ck("route", str).f(new UbcFlowEvent("na_push_page_end"));
        j.an(3, str);
        j.rs(str);
    }
}
