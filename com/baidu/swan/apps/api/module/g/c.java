package com.baidu.swan.apps.api.module.g;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.performance.j;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.g;
import com.baidu.swan.apps.v.f;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.baidu.swan.apps.api.a.d {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lt(String str) {
        if (DEBUG) {
            Log.d("Api-RedirectTo", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        j.qX(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bj = com.baidu.swan.apps.api.d.b.bj("Api-RedirectTo", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bj.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-RedirectTo", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bj.second;
        String bT = com.baidu.swan.apps.scheme.actions.k.a.bT(jSONObject);
        if (TextUtils.isEmpty(bT)) {
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "url is null");
            return new com.baidu.swan.apps.api.c.b(202, "url is null");
        }
        final f azO = f.azO();
        final com.baidu.swan.apps.core.d.f afM = azO.afM();
        if (afM == null) {
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b cb = com.baidu.swan.apps.model.b.cb(bT, azO.azv());
        if (!ak.a(azO.azt(), cb, false)) {
            String str2 = "page params error : path=" + cb.mPage + " ; routePath=" + cb.dgd;
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", str2);
            return new com.baidu.swan.apps.api.c.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && cb != null && !TextUtils.isEmpty(cb.dgd) && e.aHu() != null) {
            e.aHu().cq(optString, cb.dgd);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            i.cf("route", uuid).f(new UbcFlowEvent("fe_route_start").bY(Long.valueOf(optString2).longValue()));
        }
        final String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "cb is null");
            return new com.baidu.swan.apps.api.c.b(202, "cb is null");
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aIE().f(cb)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aIE().c("redirectTo", cb);
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "access to this page is prohibited");
            return new com.baidu.swan.apps.api.c.b(1003, "access to this page is prohibited");
        } else {
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-RedirectTo", "PreloadSlaveManager start.");
                    }
                    SwanAppActivity azy = azO.azy();
                    if (azy == null || azy.isFinishing()) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            c.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan activity is null"));
                            return;
                        }
                        throw new RuntimeException("swan activity is null");
                    }
                    final b.a H = com.baidu.swan.apps.core.slave.b.H(azy);
                    final String aiJ = H.cPv.aiJ();
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-RedirectTo", "webview id: " + aiJ);
                    }
                    final e aHu = e.aHu();
                    if (aHu == null) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            c.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    azO.showLoadingView();
                    g.a(aHu, cb, aiJ, new g.a() { // from class: com.baidu.swan.apps.api.module.g.c.1.1
                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void kH(String str3) {
                            j.qW(uuid);
                            com.baidu.swan.apps.console.c.i("Api-RedirectTo", "check pages success");
                            azO.afP();
                            com.baidu.swan.apps.scheme.actions.k.a.a(c.this, aHu, aiJ, cb.mPage, null, optString3);
                            c.this.b(H, cb, afM, uuid);
                        }

                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void hw(int i) {
                            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "check pages failed");
                            azO.afP();
                            if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                Context context = c.this.getContext();
                                com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).showToast();
                            }
                            com.baidu.swan.apps.scheme.actions.k.a.b(c.this, optString3);
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
            Log.d("Api-RedirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0433b() { // from class: com.baidu.swan.apps.api.module.g.c.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0433b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady start.");
                }
                j.a(aVar, str);
                com.baidu.swan.apps.scheme.actions.k.a.a(aVar.cPv, bVar, str);
                c.a(fVar, bVar, str, false);
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute end.");
        }
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, com.baidu.swan.apps.model.b bVar, String str, boolean z) {
        fVar.nb("redirectTo").al(0, 0).a("normal", bVar).ia(z ? 0 : fVar.ape() - 2).apn();
        int i = 2;
        if (z) {
            i = 8;
        }
        i.cf("route", str).f(new UbcFlowEvent("na_push_page_end"));
        j.al(i, str);
        j.qY(str);
    }
}
