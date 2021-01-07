package com.baidu.swan.apps.api.module.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.performance.j;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.g;
import com.baidu.swan.apps.v.f;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.apps.api.a.d {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lN(String str) {
        if (DEBUG) {
            Log.d("Api-RedirectTo", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        j.rr(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-RedirectTo", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bo.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-RedirectTo", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bo.second;
        String bX = com.baidu.swan.apps.scheme.actions.k.a.bX(jSONObject);
        if (TextUtils.isEmpty(bX)) {
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "url is null");
            return new com.baidu.swan.apps.api.c.b(202, "url is null");
        }
        final f aDH = f.aDH();
        final com.baidu.swan.apps.core.d.f ajt = aDH.ajt();
        if (ajt == null) {
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b cg = com.baidu.swan.apps.model.b.cg(bX, aDH.aDo());
        if (!ak.a(aDH.aDm(), cg, false)) {
            String str2 = "page params error : path=" + cg.mPage + " ; routePath=" + cg.dqt;
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", str2);
            return new com.baidu.swan.apps.api.c.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && cg != null && !TextUtils.isEmpty(cg.dqt) && e.aMl() != null) {
            e.aMl().cv(optString, cg.dqt);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            i.ck("route", uuid).f(new UbcFlowEvent("fe_route_start").cy(Long.valueOf(optString2).longValue()));
        }
        final String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "cb is null");
            return new com.baidu.swan.apps.api.c.b(202, "cb is null");
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aNv().f(cg)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aNv().c("redirectTo", cg);
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "access to this page is prohibited");
            return new com.baidu.swan.apps.api.c.b(1003, "access to this page is prohibited");
        } else {
            ak.l(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-RedirectTo", "PreloadSlaveManager start.");
                    }
                    SwanAppActivity aDr = aDH.aDr();
                    if (aDr == null || aDr.isFinishing()) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            c.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan activity is null"));
                            return;
                        }
                        throw new RuntimeException("swan activity is null");
                    }
                    final b.a F = com.baidu.swan.apps.core.slave.b.F(aDr);
                    final String amu = F.cZA.amu();
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-RedirectTo", "webview id: " + amu);
                    }
                    final e aMl = e.aMl();
                    if (aMl == null) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            c.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    aDH.showLoadingView();
                    g.a(aMl, cg, amu, new g.a() { // from class: com.baidu.swan.apps.api.module.g.c.1.1
                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void lb(String str3) {
                            j.rq(uuid);
                            com.baidu.swan.apps.console.c.i("Api-RedirectTo", "check pages success");
                            aDH.ajw();
                            com.baidu.swan.apps.scheme.actions.k.a.a(c.this, aMl, amu, cg.mPage, null, optString3);
                            c.this.b(F, cg, ajt, uuid);
                        }

                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void hK(int i) {
                            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "check pages failed");
                            aDH.ajw();
                            if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                Context context = c.this.getContext();
                                com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).aLT();
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
        i.ck("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).cn("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0435b() { // from class: com.baidu.swan.apps.api.module.g.c.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0435b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady start.");
                }
                j.a(aVar, str);
                com.baidu.swan.apps.scheme.actions.k.a.a(aVar.cZA, bVar, str);
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
        fVar.nv("redirectTo").ai(0, 0).a("normal", bVar).ip(z ? 0 : fVar.asX() - 2).atf();
        int i = 2;
        if (z) {
            i = 8;
        }
        i.ck("route", str).f(new UbcFlowEvent("na_push_page_end"));
        j.an(i, str);
        j.rs(str);
    }
}
