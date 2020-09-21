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
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.f;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends com.baidu.swan.apps.api.a.d {
    public static final int bZi = com.baidu.swan.apps.t.a.apx().Zi();

    static {
        if (DEBUG) {
            Log.d("Api-NavigateTo", "NavigateToAction max count: " + bZi);
        }
    }

    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b jY(String str) {
        if (DEBUG) {
            Log.d("Api-NavigateTo", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        j.pE(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-NavigateTo", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aX.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigateTo", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aX.second;
        String bD = com.baidu.swan.apps.scheme.actions.k.a.bD(jSONObject);
        if (TextUtils.isEmpty(bD)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "url is null");
            return new com.baidu.swan.apps.api.c.b(202, "url is null");
        }
        final f asJ = f.asJ();
        final com.baidu.swan.apps.core.d.f YG = asJ.YG();
        if (YG == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b bP = com.baidu.swan.apps.model.b.bP(bD, asJ.asq());
        if (!ak.a(asJ.aso(), bP, false)) {
            String str2 = "page params error : path=" + bP.mPage + " ; routePath=" + bP.cFG;
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", str2);
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
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "cb is null");
            return new com.baidu.swan.apps.api.c.b(202, "cb is null");
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.aBB().f(bP)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.aBB().c("navigateTo", bP);
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "access to this page is prohibited");
            return new com.baidu.swan.apps.api.c.b(1003, "access to this page is prohibited");
        } else {
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-NavigateTo", "PreloadSlaveManager start.");
                    }
                    SwanAppActivity ast = asJ.ast();
                    if (ast == null || ast.isFinishing()) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            b.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan activity is null"));
                            return;
                        }
                        throw new RuntimeException("swan activity is null");
                    }
                    final b.a G = com.baidu.swan.apps.core.slave.b.G(ast);
                    final String abD = G.coR.abD();
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-NavigateTo", "slave webView id: " + abD);
                    }
                    final e aAr = e.aAr();
                    if (aAr == null) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            b.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    asJ.showLoadingView();
                    g.a(aAr, bP, abD, new g.a() { // from class: com.baidu.swan.apps.api.module.g.b.1.1
                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void jn(String str3) {
                            j.pD(uuid);
                            com.baidu.swan.apps.console.c.i("Api-NavigateTo", "check pages success");
                            h.j(true, aAr.YI().arx());
                            asJ.YJ();
                            com.baidu.swan.apps.scheme.actions.k.a.a(b.this, aAr, abD, bP.mPage, com.baidu.swan.apps.scheme.actions.k.a.e(YG), optString3);
                            b.this.a(G, bP, YG, uuid);
                        }

                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void gE(int i) {
                            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "check pages failed");
                            h.j(false, aAr.YI().arx());
                            asJ.YJ();
                            if (com.baidu.swan.apps.api.a.d.DEBUG) {
                                Context context = b.this.getContext();
                                com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).showToast();
                            }
                            com.baidu.swan.apps.scheme.actions.k.a.b(b.this, optString3);
                        }
                    }, uuid);
                }
            });
            return new com.baidu.swan.apps.api.c.b(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final com.baidu.swan.apps.core.d.f fVar, final String str) {
        boolean z = aVar != null && aVar.isReady;
        i.bT("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).bW("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0390b() { // from class: com.baidu.swan.apps.api.module.g.b.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0390b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady start.");
                }
                j.a(aVar, str);
                b.this.a(aVar.coR, bVar, fVar, str);
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.model.b bVar, com.baidu.swan.apps.core.d.f fVar, String str) {
        SwanAppActivity ast = f.asJ().ast();
        if (ast != null && !ast.isFinishing()) {
            com.baidu.swan.apps.scheme.actions.k.a.a(cVar, bVar, str);
            if (fVar.ahZ() < bZi) {
                fVar.lH("navigateTo").al(com.baidu.swan.apps.core.d.f.ckl, com.baidu.swan.apps.core.d.f.ckn).a("normal", bVar).aih();
                com.baidu.swan.apps.ap.f.a(fVar, getContext());
                i.bT("route", str).f(new UbcFlowEvent("na_push_page_end"));
                j.U(0, str);
                j.pF(str);
                return;
            }
            c.a(fVar, bVar, str, true);
        }
    }
}
