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
/* loaded from: classes3.dex */
public class c extends com.baidu.swan.apps.api.a.d {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b jZ(String str) {
        if (DEBUG) {
            Log.d("Api-RedirectTo", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        j.pE(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-RedirectTo", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aX.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-RedirectTo", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aX.second;
        String bD = com.baidu.swan.apps.scheme.actions.k.a.bD(jSONObject);
        if (TextUtils.isEmpty(bD)) {
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "url is null");
            return new com.baidu.swan.apps.api.c.b(202, "url is null");
        }
        final f asJ = f.asJ();
        final com.baidu.swan.apps.core.d.f YG = asJ.YG();
        if (YG == null) {
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b bP = com.baidu.swan.apps.model.b.bP(bD, asJ.asq());
        if (!ak.a(asJ.aso(), bP, false)) {
            String str2 = "page params error : path=" + bP.mPage + " ; routePath=" + bP.cFG;
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", str2);
            return new com.baidu.swan.apps.api.c.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && bP != null && !TextUtils.isEmpty(bP.cFG) && e.aAr() != null) {
            e.aAr().ce(optString, bP.cFG);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            i.bT("route", uuid).f(new UbcFlowEvent("fe_route_start").bs(Long.valueOf(optString2).longValue()));
        }
        final String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "cb is null");
            return new com.baidu.swan.apps.api.c.b(202, "cb is null");
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aBB().f(bP)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aBB().c("redirectTo", bP);
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "access to this page is prohibited");
            return new com.baidu.swan.apps.api.c.b(1003, "access to this page is prohibited");
        } else {
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-RedirectTo", "PreloadSlaveManager start.");
                    }
                    SwanAppActivity ast = asJ.ast();
                    if (ast == null || ast.isFinishing()) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            c.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan activity is null"));
                            return;
                        }
                        throw new RuntimeException("swan activity is null");
                    }
                    final b.a G = com.baidu.swan.apps.core.slave.b.G(ast);
                    final String abD = G.coR.abD();
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-RedirectTo", "webview id: " + abD);
                    }
                    final e aAr = e.aAr();
                    if (aAr == null) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            c.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    asJ.showLoadingView();
                    g.a(aAr, bP, abD, new g.a() { // from class: com.baidu.swan.apps.api.module.g.c.1.1
                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void jn(String str3) {
                            j.pD(uuid);
                            com.baidu.swan.apps.console.c.i("Api-RedirectTo", "check pages success");
                            asJ.YJ();
                            com.baidu.swan.apps.scheme.actions.k.a.a(c.this, aAr, abD, bP.mPage, null, optString3);
                            c.this.b(G, bP, YG, uuid);
                        }

                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void gE(int i) {
                            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "check pages failed");
                            asJ.YJ();
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
        i.bT("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).bW("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0390b() { // from class: com.baidu.swan.apps.api.module.g.c.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0390b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady start.");
                }
                j.a(aVar, str);
                com.baidu.swan.apps.scheme.actions.k.a.a(aVar.coR, bVar, str);
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
        fVar.lH("redirectTo").al(0, 0).a("normal", bVar).hi(z ? 0 : fVar.ahZ() - 2).aih();
        int i = 2;
        if (z) {
            i = 8;
        }
        i.bT("route", str).f(new UbcFlowEvent("na_push_page_end"));
        j.U(i, str);
        j.pF(str);
    }
}
