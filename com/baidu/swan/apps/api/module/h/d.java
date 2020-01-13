package com.baidu.swan.apps.api.module.h;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.scheme.actions.k.g;
import com.baidu.swan.apps.y.f;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends com.baidu.swan.apps.api.a.c {
    public d(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b fz(String str) {
        if (DEBUG) {
            Log.d("Api-ReLaunch", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        g.jM(uuid);
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ah = com.baidu.swan.apps.api.c.b.ah("Api-ReLaunch", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) ah.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ReLaunch", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) ah.second;
        String aM = com.baidu.swan.apps.scheme.actions.k.a.aM(jSONObject);
        if (TextUtils.isEmpty(aM)) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "url is null");
            return new com.baidu.swan.apps.api.b.b(202, "url is null");
        }
        final f UC = f.UC();
        final e El = UC.El();
        if (El == null) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "manager is null");
            return new com.baidu.swan.apps.api.b.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b aO = com.baidu.swan.apps.model.b.aO(aM, UC.Uk());
        if (!ai.a(UC.Ui(), aO, true)) {
            String str2 = "page params error : pageParam=" + aO.mPage;
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", str2);
            return new com.baidu.swan.apps.api.b.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && aO != null && !TextUtils.isEmpty(aO.mPage) && com.baidu.swan.apps.runtime.e.aap() != null) {
            com.baidu.swan.apps.runtime.e.aap().aX(optString, aO.mPage);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.performance.f.aP("route", uuid).f(new UbcFlowEvent("fe_route_start").aq(Long.valueOf(optString2).longValue()));
        }
        final String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "cb is null");
            return new com.baidu.swan.apps.api.b.b(202, "cb is null");
        }
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.api.module.h.d.1
            @Override // java.lang.Runnable
            public void run() {
                final b.a J = com.baidu.swan.apps.core.slave.b.J(UC.Un());
                final String GA = J.bnA.GA();
                if (com.baidu.swan.apps.api.a.c.DEBUG) {
                    Log.d("Api-ReLaunch", "webview idx: " + GA);
                }
                final com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
                if (aap == null) {
                    if (!com.baidu.swan.apps.api.a.c.DEBUG) {
                        d.this.a(optString3, new com.baidu.swan.apps.api.b.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                UC.showLoadingView();
                com.baidu.swan.apps.scheme.actions.k.g.a(aap, aO.mPage, GA, new g.a() { // from class: com.baidu.swan.apps.api.module.h.d.1.1
                    @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                    public void success(String str3) {
                        com.baidu.swan.apps.performance.g.jL(uuid);
                        com.baidu.swan.apps.console.c.i("Api-ReLaunch", "check pages success");
                        UC.Eo();
                        com.baidu.swan.apps.scheme.actions.k.a.a(d.this, aap, GA, aO.mPage, optString3);
                        com.baidu.swan.apps.statistic.c.lr(GA);
                        d.this.b(J, aO, El, uuid);
                    }

                    @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                    public void dI(int i) {
                        com.baidu.swan.apps.console.c.e("Api-ReLaunch", "check pages failed");
                        UC.Eo();
                        if (com.baidu.swan.apps.api.a.c.DEBUG) {
                            Context context = d.this.getContext();
                            com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).showToast();
                        }
                        com.baidu.swan.apps.scheme.actions.k.a.b(d.this, optString3);
                    }
                }, uuid);
            }
        });
        return new com.baidu.swan.apps.api.b.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final e eVar, final String str) {
        boolean z = aVar != null && aVar.bnB;
        com.baidu.swan.apps.performance.f.aP("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).aS("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("Api-ReLaunch", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0245b() { // from class: com.baidu.swan.apps.api.module.h.d.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0245b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.c.DEBUG) {
                    Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.g.a(aVar, str);
                com.baidu.swan.apps.scheme.actions.k.a.a(aVar.bnA, bVar, str);
                d.a(eVar, bVar, str);
                if (com.baidu.swan.apps.api.a.c.DEBUG) {
                    Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("Api-ReLaunch", "tryToExecutePageRoute end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(e eVar, com.baidu.swan.apps.model.b bVar, String str) {
        eVar.gM("reLaunch").Y(0, 0).Mh().a("normal", bVar).Mj();
        com.baidu.swan.apps.performance.f.aP("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.g.y(3, str);
        com.baidu.swan.apps.performance.g.jN(str);
    }
}
