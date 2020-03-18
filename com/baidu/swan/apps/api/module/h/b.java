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
    private static final int bfl = com.baidu.swan.apps.w.a.Uc().Hl();

    static {
        if (DEBUG) {
            Log.d("Api-NavigateTo", "NavigateToAction max count: " + bfl);
        }
    }

    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b fL(String str) {
        if (DEBUG) {
            Log.d("Api-NavigateTo", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        g.ka(uuid);
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> aq = com.baidu.swan.apps.api.c.b.aq("Api-NavigateTo", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) aq.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigateTo", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aq.second;
        String aM = com.baidu.swan.apps.scheme.actions.k.a.aM(jSONObject);
        if (TextUtils.isEmpty(aM)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "url is null");
            return new com.baidu.swan.apps.api.b.b(202, "url is null");
        }
        final f WV = f.WV();
        final e GH = WV.GH();
        if (GH == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "manager is null");
            return new com.baidu.swan.apps.api.b.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b aW = com.baidu.swan.apps.model.b.aW(aM, WV.WD());
        if (!ai.a(WV.WB(), aW, false)) {
            String str2 = "page params error : pageParam=" + aW.mPage;
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", str2);
            return new com.baidu.swan.apps.api.b.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && aW != null && !TextUtils.isEmpty(aW.mPage) && com.baidu.swan.apps.runtime.e.acI() != null) {
            com.baidu.swan.apps.runtime.e.acI().bf(optString, aW.mPage);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.performance.f.aX("route", uuid).f(new UbcFlowEvent("fe_route_start").au(Long.valueOf(optString2).longValue()));
        }
        final String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "cb is null");
            return new com.baidu.swan.apps.api.b.b(202, "cb is null");
        }
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.api.module.h.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.api.a.c.DEBUG) {
                    Log.d("Api-NavigateTo", "PreloadSlaveManager start.");
                }
                final b.a K = com.baidu.swan.apps.core.slave.b.K(WV.WG());
                final String IU = K.brX.IU();
                if (com.baidu.swan.apps.api.a.c.DEBUG) {
                    Log.d("Api-NavigateTo", "slave webView id: " + IU);
                }
                final com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
                if (acI == null) {
                    if (!com.baidu.swan.apps.api.a.c.DEBUG) {
                        b.this.a(optString3, new com.baidu.swan.apps.api.b.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                WV.showLoadingView();
                com.baidu.swan.apps.scheme.actions.k.g.a(acI, aW.mPage, IU, new g.a() { // from class: com.baidu.swan.apps.api.module.h.b.1.1
                    @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                    public void success(String str3) {
                        com.baidu.swan.apps.performance.g.jZ(uuid);
                        com.baidu.swan.apps.console.c.i("Api-NavigateTo", "check pages success");
                        com.baidu.swan.apps.statistic.f.h(true, acI.GJ().VM());
                        WV.GK();
                        com.baidu.swan.apps.scheme.actions.k.a.a(b.this, acI, IU, aW.mPage, optString3);
                        b.this.a(K, aW, GH, uuid);
                    }

                    @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                    public void dY(int i) {
                        com.baidu.swan.apps.console.c.e("Api-NavigateTo", "check pages failed");
                        com.baidu.swan.apps.statistic.f.h(false, acI.GJ().VM());
                        WV.GK();
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
        boolean z = aVar != null && aVar.brY;
        com.baidu.swan.apps.performance.f.aX("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).ba("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0255b() { // from class: com.baidu.swan.apps.api.module.h.b.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0255b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.c.DEBUG) {
                    Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady start.");
                }
                com.baidu.swan.apps.performance.g.a(aVar, str);
                b.this.a(aVar.brX, bVar, eVar, str);
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
        if (eVar.Ot() < bfl) {
            eVar.ha("navigateTo").Y(e.bos, e.bou).a("normal", bVar).OC();
            com.baidu.swan.apps.as.d.a(eVar, getContext());
            com.baidu.swan.apps.performance.f.aX("route", str).f(new UbcFlowEvent("na_push_page_end"));
            com.baidu.swan.apps.performance.g.A(0, str);
            com.baidu.swan.apps.performance.g.kb(str);
            return;
        }
        c.a(eVar, bVar, str, true);
    }
}
