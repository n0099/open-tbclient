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
/* loaded from: classes8.dex */
public class d extends com.baidu.swan.apps.api.a.d {
    public d(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b kD(String str) {
        if (DEBUG) {
            Log.d("Api-ReLaunch", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        j.qg(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bn = com.baidu.swan.apps.api.d.b.bn("Api-ReLaunch", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bn.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ReLaunch", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bn.second;
        String bX = com.baidu.swan.apps.scheme.actions.k.a.bX(jSONObject);
        if (TextUtils.isEmpty(bX)) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "url is null");
            return new com.baidu.swan.apps.api.c.b(202, "url is null");
        }
        final f azN = f.azN();
        final com.baidu.swan.apps.core.d.f afz = azN.afz();
        if (afz == null) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b cf = com.baidu.swan.apps.model.b.cf(bX, azN.azu());
        if (!ak.a(azN.azs(), cf, true)) {
            String str2 = "page params error : path=" + cf.mPage + " ; routePath=" + cf.dlD;
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", str2);
            return new com.baidu.swan.apps.api.c.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && cf != null && !TextUtils.isEmpty(cf.dlD) && e.aIr() != null) {
            e.aIr().cu(optString, cf.dlD);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            i.cj("route", uuid).f(new UbcFlowEvent("fe_route_start").cy(Long.valueOf(optString2).longValue()));
        }
        final String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "cb is null");
            return new com.baidu.swan.apps.api.c.b(202, "cb is null");
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aJB().f(cf)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aJB().c("reLaunch", cf);
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "access to this page is prohibited");
            return new com.baidu.swan.apps.api.c.b(1003, "access to this page is prohibited");
        } else {
            ak.l(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.d.1
                @Override // java.lang.Runnable
                public void run() {
                    SwanAppActivity azx = azN.azx();
                    if (azx == null || azx.isFinishing()) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            d.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan activity is null"));
                            return;
                        }
                        throw new RuntimeException("swan activity is null");
                    }
                    final b.a f = com.baidu.swan.apps.core.slave.b.f(azx, a.C0417a.arm());
                    final String aiA = f.cUO.aiA();
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-ReLaunch", "webview idx: " + aiA);
                    }
                    final e aIr = e.aIr();
                    if (aIr == null) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            d.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    azN.showLoadingView();
                    g.a(aIr, cf, aiA, new g.a() { // from class: com.baidu.swan.apps.api.module.g.d.1.1
                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void jQ(String str3) {
                            j.qf(uuid);
                            com.baidu.swan.apps.console.c.i("Api-ReLaunch", "check pages success");
                            azN.afC();
                            com.baidu.swan.apps.scheme.actions.k.a.a(d.this, aIr, aiA, cf.mPage, null, optString3);
                            com.baidu.swan.apps.statistic.e.sm(aiA);
                            d.this.b(f, cf, afz, uuid);
                        }

                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void gd(int i) {
                            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "check pages failed");
                            azN.afC();
                            if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                Context context = d.this.getContext();
                                com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).aHZ();
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
        i.cj("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).cm("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("Api-ReLaunch", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0418b() { // from class: com.baidu.swan.apps.api.module.g.d.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0418b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady start.");
                }
                j.a(aVar, str);
                com.baidu.swan.apps.scheme.actions.k.a.a(aVar.cUO, bVar, str);
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
            com.baidu.swan.apps.console.c.i("Api-ReLaunch", "doReLaunch page=" + bVar.mPage + " routePage=" + bVar.dlD);
        }
        f.a aVar = new f.a() { // from class: com.baidu.swan.apps.api.module.g.d.3
            @Override // com.baidu.swan.apps.core.d.f.a
            public void a(@NonNull Fragment fragment) {
            }

            @Override // com.baidu.swan.apps.core.d.f.a
            public void b(@NonNull Fragment fragment) {
                if (fragment instanceof com.baidu.swan.apps.core.d.e) {
                    ((com.baidu.swan.apps.core.d.e) fragment).cQd = true;
                }
            }
        };
        fVar.a(aVar);
        fVar.mk("reLaunch").ai(0, 0).aph().a("normal", bVar).apk();
        fVar.b(aVar);
        i.cj("route", str).f(new UbcFlowEvent("na_push_page_end"));
        j.ao(3, str);
        j.qh(str);
    }
}
