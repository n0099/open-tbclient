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
/* loaded from: classes25.dex */
public class c extends com.baidu.swan.apps.api.a.d {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lU(String str) {
        if (DEBUG) {
            Log.d("Api-RedirectTo", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        j.ry(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-RedirectTo", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bp.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-RedirectTo", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bp.second;
        String bP = com.baidu.swan.apps.scheme.actions.k.a.bP(jSONObject);
        if (TextUtils.isEmpty(bP)) {
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "url is null");
            return new com.baidu.swan.apps.api.c.b(202, "url is null");
        }
        final f aCp = f.aCp();
        final com.baidu.swan.apps.core.d.f aim = aCp.aim();
        if (aim == null) {
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b ch = com.baidu.swan.apps.model.b.ch(bP, aCp.aBW());
        if (!ak.a(aCp.aBU(), ch, false)) {
            String str2 = "page params error : path=" + ch.mPage + " ; routePath=" + ch.dlu;
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", str2);
            return new com.baidu.swan.apps.api.c.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && ch != null && !TextUtils.isEmpty(ch.dlu) && e.aJU() != null) {
            e.aJU().cw(optString, ch.dlu);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            i.cl("route", uuid).f(new UbcFlowEvent("fe_route_start").cx(Long.valueOf(optString2).longValue()));
        }
        final String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "cb is null");
            return new com.baidu.swan.apps.api.c.b(202, "cb is null");
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aLe().f(ch)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aLe().c("redirectTo", ch);
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "access to this page is prohibited");
            return new com.baidu.swan.apps.api.c.b(1003, "access to this page is prohibited");
        } else {
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-RedirectTo", "PreloadSlaveManager start.");
                    }
                    SwanAppActivity aBZ = aCp.aBZ();
                    if (aBZ == null || aBZ.isFinishing()) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            c.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan activity is null"));
                            return;
                        }
                        throw new RuntimeException("swan activity is null");
                    }
                    final b.a G = com.baidu.swan.apps.core.slave.b.G(aBZ);
                    final String alj = G.cUE.alj();
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-RedirectTo", "webview id: " + alj);
                    }
                    final e aJU = e.aJU();
                    if (aJU == null) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            c.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    aCp.showLoadingView();
                    g.a(aJU, ch, alj, new g.a() { // from class: com.baidu.swan.apps.api.module.g.c.1.1
                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void li(String str3) {
                            j.rx(uuid);
                            com.baidu.swan.apps.console.c.i("Api-RedirectTo", "check pages success");
                            aCp.aip();
                            com.baidu.swan.apps.scheme.actions.k.a.a(c.this, aJU, alj, ch.mPage, null, optString3);
                            c.this.b(G, ch, aim, uuid);
                        }

                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void hQ(int i) {
                            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "check pages failed");
                            aCp.aip();
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
        i.cl("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).co("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0443b() { // from class: com.baidu.swan.apps.api.module.g.c.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0443b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady start.");
                }
                j.a(aVar, str);
                com.baidu.swan.apps.scheme.actions.k.a.a(aVar.cUE, bVar, str);
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
        fVar.nC("redirectTo").an(0, 0).a("normal", bVar).iu(z ? 0 : fVar.arE() - 2).arM();
        int i = 2;
        if (z) {
            i = 8;
        }
        i.cl("route", str).f(new UbcFlowEvent("na_push_page_end"));
        j.al(i, str);
        j.rz(str);
    }
}
