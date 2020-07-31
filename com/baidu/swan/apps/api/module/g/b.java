package com.baidu.swan.apps.api.module.g;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.al;
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
/* loaded from: classes7.dex */
public class b extends com.baidu.swan.apps.api.a.d {
    public static final int bRB = com.baidu.swan.apps.t.a.ahm().SF();

    static {
        if (DEBUG) {
            Log.d("Api-NavigateTo", "NavigateToAction max count: " + bRB);
        }
    }

    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ih(String str) {
        if (DEBUG) {
            Log.d("Api-NavigateTo", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        j.nm(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-NavigateTo", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aS.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigateTo", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aS.second;
        String bs = com.baidu.swan.apps.scheme.actions.k.a.bs(jSONObject);
        if (TextUtils.isEmpty(bs)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "url is null");
            return new com.baidu.swan.apps.api.c.b(202, "url is null");
        }
        final f akr = f.akr();
        final com.baidu.swan.apps.core.d.f Sc = akr.Sc();
        if (Sc == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b bB = com.baidu.swan.apps.model.b.bB(bs, akr.ajY());
        if (!al.a(akr.ajW(), bB, false)) {
            String str2 = "page params error : path=" + bB.mPage + " ; routePath=" + bB.cvJ;
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", str2);
            return new com.baidu.swan.apps.api.c.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && bB != null && !TextUtils.isEmpty(bB.cvJ) && e.arv() != null) {
            e.arv().bO(optString, bB.cvJ);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            i.bE("route", uuid).f(new UbcFlowEvent("fe_route_start").bm(Long.valueOf(optString2).longValue()));
        }
        final String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "cb is null");
            return new com.baidu.swan.apps.api.c.b(202, "cb is null");
        } else if (com.baidu.swan.apps.scheme.actions.forbidden.a.asG().f(bB)) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.asG().c("navigateTo", bB);
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "access to this page is prohibited");
            return new com.baidu.swan.apps.api.c.b(1003, "access to this page is prohibited");
        } else {
            al.p(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-NavigateTo", "PreloadSlaveManager start.");
                    }
                    SwanAppActivity akb = akr.akb();
                    if (akb == null || akb.isFinishing()) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            b.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan activity is null"));
                            return;
                        }
                        throw new RuntimeException("swan activity is null");
                    }
                    final b.a E = com.baidu.swan.apps.core.slave.b.E(akb);
                    final String UR = E.cgw.UR();
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-NavigateTo", "slave webView id: " + UR);
                    }
                    final e arv = e.arv();
                    if (arv == null) {
                        if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                            b.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan app is null"));
                            return;
                        }
                        throw new RuntimeException("swan app is null");
                    }
                    akr.showLoadingView();
                    g.a(arv, bB, UR, new g.a() { // from class: com.baidu.swan.apps.api.module.g.b.1.1
                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void hw(String str3) {
                            j.nl(uuid);
                            com.baidu.swan.apps.console.c.i("Api-NavigateTo", "check pages success");
                            h.j(true, arv.Se().ajg());
                            akr.Sf();
                            com.baidu.swan.apps.scheme.actions.k.a.a(b.this, arv, UR, bB.mPage, com.baidu.swan.apps.scheme.actions.k.a.e(Sc), optString3);
                            b.this.a(E, bB, Sc, uuid);
                        }

                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void ex(int i) {
                            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "check pages failed");
                            h.j(false, arv.Se().ajg());
                            akr.Sf();
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
        i.bE("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).bH("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0353b() { // from class: com.baidu.swan.apps.api.module.g.b.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0353b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady start.");
                }
                j.a(aVar, str);
                b.this.a(aVar.cgw, bVar, fVar, str);
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
        SwanAppActivity akb = f.akr().akb();
        if (akb != null && !akb.isFinishing()) {
            com.baidu.swan.apps.scheme.actions.k.a.a(cVar, bVar, str);
            if (fVar.abc() < bRB) {
                fVar.jO("navigateTo").ag(com.baidu.swan.apps.core.d.f.cci, com.baidu.swan.apps.core.d.f.cck).a("normal", bVar).abl();
                com.baidu.swan.apps.aq.f.a(fVar, getContext());
                i.bE("route", str).f(new UbcFlowEvent("na_push_page_end"));
                j.U(0, str);
                j.nn(str);
                return;
            }
            c.a(fVar, bVar, str, true);
        }
    }
}
