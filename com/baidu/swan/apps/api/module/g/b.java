package com.baidu.swan.apps.api.module.g;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.slave.b;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.performance.h;
import com.baidu.swan.apps.scheme.actions.k.g;
import com.baidu.swan.apps.w.f;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.apps.api.a.d {
    public static final int bLW = com.baidu.swan.apps.u.a.aeU().Ri();

    static {
        if (DEBUG) {
            Log.d("Api-NavigateTo", "NavigateToAction max count: " + bLW);
        }
    }

    public b(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b hP(String str) {
        if (DEBUG) {
            Log.d("Api-NavigateTo", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        h.mC(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("Api-NavigateTo", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aP.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigateTo", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aP.second;
        String bg = com.baidu.swan.apps.scheme.actions.k.a.bg(jSONObject);
        if (TextUtils.isEmpty(bg)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "url is null");
            return new com.baidu.swan.apps.api.c.b(202, "url is null");
        }
        final f ahV = f.ahV();
        final e QH = ahV.QH();
        if (QH == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b bx = com.baidu.swan.apps.model.b.bx(bg, ahV.ahC());
        if (!aj.a(ahV.ahA(), bx, false)) {
            String str2 = "page params error : path=" + bx.mPage + " ; routePath=" + bx.coT;
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", str2);
            return new com.baidu.swan.apps.api.c.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && bx != null && !TextUtils.isEmpty(bx.coT) && com.baidu.swan.apps.runtime.e.aoF() != null) {
            com.baidu.swan.apps.runtime.e.aoF().bK(optString, bx.coT);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            g.bA("route", uuid).f(new UbcFlowEvent("fe_route_start").bg(Long.valueOf(optString2).longValue()));
        }
        final String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateTo", "cb is null");
            return new com.baidu.swan.apps.api.c.b(202, "cb is null");
        }
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-NavigateTo", "PreloadSlaveManager start.");
                }
                SwanAppActivity ahF = ahV.ahF();
                if (ahF == null || ahF.isFinishing()) {
                    if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                        b.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan activity is null"));
                        return;
                    }
                    throw new RuntimeException("swan activity is null");
                }
                final b.a F = com.baidu.swan.apps.core.slave.b.F(ahF);
                final String Tj = F.bZV.Tj();
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-NavigateTo", "slave webView id: " + Tj);
                }
                final com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
                if (aoF == null) {
                    if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                        b.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                ahV.showLoadingView();
                com.baidu.swan.apps.scheme.actions.k.g.a(aoF, bx, Tj, new g.a() { // from class: com.baidu.swan.apps.api.module.g.b.1.1
                    @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                    public void hg(String str3) {
                        h.mB(uuid);
                        com.baidu.swan.apps.console.c.i("Api-NavigateTo", "check pages success");
                        com.baidu.swan.apps.statistic.h.i(true, aoF.QJ().agK());
                        ahV.QK();
                        com.baidu.swan.apps.scheme.actions.k.a.a(b.this, aoF, Tj, bx.mPage, com.baidu.swan.apps.scheme.actions.k.a.e(QH), optString3);
                        b.this.a(F, bx, QH, uuid);
                    }

                    @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                    public void ej(int i) {
                        com.baidu.swan.apps.console.c.e("Api-NavigateTo", "check pages failed");
                        com.baidu.swan.apps.statistic.h.i(false, aoF.QJ().agK());
                        ahV.QK();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final e eVar, final String str) {
        boolean z = aVar != null && aVar.isReady;
        com.baidu.swan.apps.performance.g.bA("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).bD("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("Api-NavigateTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0346b() { // from class: com.baidu.swan.apps.api.module.g.b.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0346b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-NavigateTo", "tryToExecutePageRoute onReady start.");
                }
                h.a(aVar, str);
                b.this.a(aVar.bZV, bVar, eVar, str);
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
    public void a(com.baidu.swan.apps.adaptation.b.c cVar, com.baidu.swan.apps.model.b bVar, e eVar, String str) {
        com.baidu.swan.apps.scheme.actions.k.a.a(cVar, bVar, str);
        if (eVar.YS() < bLW) {
            eVar.jp("navigateTo").ae(e.bVN, e.bVP).a("normal", bVar).Zb();
            com.baidu.swan.apps.aq.e.a(eVar, getContext());
            com.baidu.swan.apps.performance.g.bA("route", str).f(new UbcFlowEvent("na_push_page_end"));
            h.S(0, str);
            h.mD(str);
            return;
        }
        c.a(eVar, bVar, str, true);
    }
}
