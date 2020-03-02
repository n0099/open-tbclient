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
/* loaded from: classes11.dex */
public class d extends com.baidu.swan.apps.api.a.c {
    public d(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b fO(String str) {
        if (DEBUG) {
            Log.d("Api-ReLaunch", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        g.kb(uuid);
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ar = com.baidu.swan.apps.api.c.b.ar("Api-ReLaunch", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) ar.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ReLaunch", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) ar.second;
        String aM = com.baidu.swan.apps.scheme.actions.k.a.aM(jSONObject);
        if (TextUtils.isEmpty(aM)) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "url is null");
            return new com.baidu.swan.apps.api.b.b(202, "url is null");
        }
        final f WS = f.WS();
        final e GC = WS.GC();
        if (GC == null) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "manager is null");
            return new com.baidu.swan.apps.api.b.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b aX = com.baidu.swan.apps.model.b.aX(aM, WS.WA());
        if (!ai.a(WS.Wy(), aX, true)) {
            String str2 = "page params error : pageParam=" + aX.mPage;
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", str2);
            return new com.baidu.swan.apps.api.b.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && aX != null && !TextUtils.isEmpty(aX.mPage) && com.baidu.swan.apps.runtime.e.acF() != null) {
            com.baidu.swan.apps.runtime.e.acF().bg(optString, aX.mPage);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.performance.f.aY("route", uuid).f(new UbcFlowEvent("fe_route_start").au(Long.valueOf(optString2).longValue()));
        }
        final String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            com.baidu.swan.apps.console.c.e("Api-ReLaunch", "cb is null");
            return new com.baidu.swan.apps.api.b.b(202, "cb is null");
        }
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.api.module.h.d.1
            @Override // java.lang.Runnable
            public void run() {
                final b.a K = com.baidu.swan.apps.core.slave.b.K(WS.WD());
                final String IR = K.brK.IR();
                if (com.baidu.swan.apps.api.a.c.DEBUG) {
                    Log.d("Api-ReLaunch", "webview idx: " + IR);
                }
                final com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
                if (acF == null) {
                    if (!com.baidu.swan.apps.api.a.c.DEBUG) {
                        d.this.a(optString3, new com.baidu.swan.apps.api.b.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                WS.showLoadingView();
                com.baidu.swan.apps.scheme.actions.k.g.a(acF, aX.mPage, IR, new g.a() { // from class: com.baidu.swan.apps.api.module.h.d.1.1
                    @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                    public void success(String str3) {
                        com.baidu.swan.apps.performance.g.ka(uuid);
                        com.baidu.swan.apps.console.c.i("Api-ReLaunch", "check pages success");
                        WS.GF();
                        com.baidu.swan.apps.scheme.actions.k.a.a(d.this, acF, IR, aX.mPage, optString3);
                        com.baidu.swan.apps.statistic.c.lG(IR);
                        d.this.b(K, aX, GC, uuid);
                    }

                    @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                    public void dY(int i) {
                        com.baidu.swan.apps.console.c.e("Api-ReLaunch", "check pages failed");
                        WS.GF();
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
        boolean z = aVar != null && aVar.brL;
        com.baidu.swan.apps.performance.f.aY("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).bb("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("Api-ReLaunch", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0255b() { // from class: com.baidu.swan.apps.api.module.h.d.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0255b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.c.DEBUG) {
                    Log.d("Api-ReLaunch", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.g.a(aVar, str);
                com.baidu.swan.apps.scheme.actions.k.a.a(aVar.brK, bVar, str);
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
        eVar.hb("reLaunch").Y(0, 0).Ox().a("normal", bVar).Oz();
        com.baidu.swan.apps.performance.f.aY("route", str).f(new UbcFlowEvent("na_push_page_end"));
        com.baidu.swan.apps.performance.g.A(3, str);
        com.baidu.swan.apps.performance.g.kc(str);
    }
}
