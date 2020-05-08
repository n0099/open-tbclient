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
public class b extends com.baidu.swan.apps.api.a.c {
    private static final int bDC = com.baidu.swan.apps.w.a.abQ().OX();

    static {
        if (DEBUG) {
            Log.d("Api-NavigateTo", "NavigateToAction max count: " + bDC);
        }
    }

    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b gZ(String str) {
        if (DEBUG) {
            Log.d("Api-NavigateTo", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        g.ln(uuid);
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> az = com.baidu.swan.apps.api.c.b.az("Api-NavigateTo", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) az.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigateTo", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) az.second;
        String aX = com.baidu.swan.apps.scheme.actions.k.a.aX(jSONObject);
        if (TextUtils.isEmpty(aX)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "url is null");
            return new com.baidu.swan.apps.api.b.b(202, "url is null");
        }
        final f aeJ = f.aeJ();
        final e Ot = aeJ.Ot();
        if (Ot == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "manager is null");
            return new com.baidu.swan.apps.api.b.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b bg = com.baidu.swan.apps.model.b.bg(aX, aeJ.aer());
        if (!ai.a(aeJ.aep(), bg, false)) {
            String str2 = "page params error : pageParam=" + bg.mPage;
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", str2);
            return new com.baidu.swan.apps.api.b.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && bg != null && !TextUtils.isEmpty(bg.mPage) && com.baidu.swan.apps.runtime.e.akM() != null) {
            com.baidu.swan.apps.runtime.e.akM().bp(optString, bg.mPage);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.performance.f.bh("route", uuid).f(new UbcFlowEvent("fe_route_start").aZ(Long.valueOf(optString2).longValue()));
        }
        final String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "cb is null");
            return new com.baidu.swan.apps.api.b.b(202, "cb is null");
        }
        ai.o(new Runnable() { // from class: com.baidu.swan.apps.api.module.h.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.api.a.c.DEBUG) {
                    Log.d("Api-NavigateTo", "PreloadSlaveManager start.");
                }
                final b.a G = com.baidu.swan.apps.core.slave.b.G(aeJ.aeu());
                final String QF = G.bQj.QF();
                if (com.baidu.swan.apps.api.a.c.DEBUG) {
                    Log.d("Api-NavigateTo", "slave webView id: " + QF);
                }
                final com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
                if (akM == null) {
                    if (!com.baidu.swan.apps.api.a.c.DEBUG) {
                        b.this.a(optString3, new com.baidu.swan.apps.api.b.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                aeJ.showLoadingView();
                com.baidu.swan.apps.scheme.actions.k.g.a(akM, bg.mPage, QF, new g.a() { // from class: com.baidu.swan.apps.api.module.h.b.1.1
                    @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                    public void gt(String str3) {
                        com.baidu.swan.apps.performance.g.lm(uuid);
                        com.baidu.swan.apps.console.c.i("Api-NavigateTo", "check pages success");
                        com.baidu.swan.apps.statistic.f.i(true, akM.Ov().adA());
                        aeJ.Ow();
                        com.baidu.swan.apps.scheme.actions.k.a.a(b.this, akM, QF, bg.mPage, optString3);
                        b.this.a(G, bg, Ot, uuid);
                    }

                    @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                    public void ed(int i) {
                        com.baidu.swan.apps.console.c.e("Api-NavigateTo", "check pages failed");
                        com.baidu.swan.apps.statistic.f.i(false, akM.Ov().adA());
                        aeJ.Ow();
                        if (com.baidu.swan.apps.api.a.c.DEBUG) {
                            Context context = b.this.getContext();
                            com.baidu.swan.apps.res.widget.b.d.a(context, context.getString(a.h.aiapps_open_pages_failed) + i).showToast();
                        }
                        com.baidu.swan.apps.scheme.actions.k.a.b(b.this, optString3);
                    }
                }, uuid);
            }
        });
        return new com.baidu.swan.apps.api.b.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final e eVar, final String str) {
        boolean z = aVar != null && aVar.isReady;
        com.baidu.swan.apps.performance.f.bh("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).bk("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0306b() { // from class: com.baidu.swan.apps.api.module.h.b.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0306b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.c.DEBUG) {
                    Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.g.a(aVar, str);
                b.this.a(aVar.bQj, bVar, eVar, str);
                if (com.baidu.swan.apps.api.a.c.DEBUG) {
                    Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute end.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.model.b bVar, e eVar, String str) {
        com.baidu.swan.apps.scheme.actions.k.a.a(cVar, bVar, str);
        if (eVar.Wg() < bDC) {
            eVar.io("navigateTo").ab(e.bME, e.bMG).a("normal", bVar).Wp();
            com.baidu.swan.apps.as.d.a(eVar, getContext());
            com.baidu.swan.apps.performance.f.bh("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.g.R(0, str);
            com.baidu.swan.apps.performance.g.lo(str);
            return;
        }
        c.a(eVar, bVar, str, true);
    }
}
