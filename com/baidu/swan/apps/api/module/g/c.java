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
public class c extends com.baidu.swan.apps.api.a.d {
    public c(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b hY(String str) {
        if (DEBUG) {
            Log.d("Api-RedirectTo", "handle: " + str);
        }
        final String uuid = UUID.randomUUID().toString();
        h.mK(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aR = com.baidu.swan.apps.api.d.b.aR("Api-RedirectTo", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aR.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-RedirectTo", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aR.second;
        String bn = com.baidu.swan.apps.scheme.actions.k.a.bn(jSONObject);
        if (TextUtils.isEmpty(bn)) {
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "url is null");
            return new com.baidu.swan.apps.api.c.b(202, "url is null");
        }
        final f ajb = f.ajb();
        final e RN = ajb.RN();
        if (RN == null) {
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        final com.baidu.swan.apps.model.b bz = com.baidu.swan.apps.model.b.bz(bn, ajb.aiI());
        if (!aj.a(ajb.aiG(), bz, false)) {
            String str2 = "page params error : path=" + bz.mPage + " ; routePath=" + bz.ctH;
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", str2);
            return new com.baidu.swan.apps.api.c.b(202, str2);
        }
        String optString = jSONObject.optString("initData");
        if (!TextUtils.isEmpty(optString) && bz != null && !TextUtils.isEmpty(bz.ctH) && com.baidu.swan.apps.runtime.e.apM() != null) {
            com.baidu.swan.apps.runtime.e.apM().bM(optString, bz.ctH);
        }
        String optString2 = jSONObject.optString("startTime");
        if (!TextUtils.isEmpty(optString2)) {
            g.bC("route", uuid).f(new UbcFlowEvent("fe_route_start").bg(Long.valueOf(optString2).longValue()));
        }
        final String optString3 = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            com.baidu.swan.apps.console.c.e("Api-RedirectTo", "cb is null");
            return new com.baidu.swan.apps.api.c.b(202, "cb is null");
        }
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-RedirectTo", "PreloadSlaveManager start.");
                }
                SwanAppActivity aiL = ajb.aiL();
                if (aiL == null || aiL.isFinishing()) {
                    if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                        c.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan activity is null"));
                        return;
                    }
                    throw new RuntimeException("swan activity is null");
                }
                final b.a F = com.baidu.swan.apps.core.slave.b.F(aiL);
                final String Up = F.ceL.Up();
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-RedirectTo", "webview id: " + Up);
                }
                final com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
                if (apM == null) {
                    if (!com.baidu.swan.apps.api.a.d.DEBUG) {
                        c.this.a(optString3, new com.baidu.swan.apps.api.c.b(1001, "swan app is null"));
                        return;
                    }
                    throw new RuntimeException("swan app is null");
                }
                ajb.showLoadingView();
                com.baidu.swan.apps.scheme.actions.k.g.a(apM, bz, Up, new g.a() { // from class: com.baidu.swan.apps.api.module.g.c.1.1
                    @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                    public void ho(String str3) {
                        h.mJ(uuid);
                        com.baidu.swan.apps.console.c.i("Api-RedirectTo", "check pages success");
                        ajb.RQ();
                        com.baidu.swan.apps.scheme.actions.k.a.a(c.this, apM, Up, bz.mPage, null, optString3);
                        c.this.b(F, bz, RN, uuid);
                    }

                    @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                    public void ew(int i) {
                        com.baidu.swan.apps.console.c.e("Api-RedirectTo", "check pages failed");
                        ajb.RQ();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final b.a aVar, final com.baidu.swan.apps.model.b bVar, final e eVar, final String str) {
        boolean z = aVar != null && aVar.isReady;
        com.baidu.swan.apps.performance.g.bC("route", str).f(new UbcFlowEvent("na_pre_load_slave_check")).bF("preload", z ? "1" : "0");
        if (DEBUG) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute start. isReady : " + z);
        }
        com.baidu.swan.apps.core.slave.b.a(aVar, new b.InterfaceC0352b() { // from class: com.baidu.swan.apps.api.module.g.c.2
            @Override // com.baidu.swan.apps.core.slave.b.InterfaceC0352b
            public void onReady() {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady start.");
                }
                h.a(aVar, str);
                com.baidu.swan.apps.scheme.actions.k.a.a(aVar.ceL, bVar, str);
                c.a(eVar, bVar, str, false);
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-RedirectTo", "tryToExecutePageRoute onReady end.");
                }
            }
        });
        if (DEBUG) {
            Log.d("Api-RedirectTo", "tryToExecutePageRoute end.");
        }
    }

    public static void a(e eVar, com.baidu.swan.apps.model.b bVar, String str, boolean z) {
        eVar.jx("redirectTo").ag(0, 0).a("normal", bVar).eY(z ? 0 : eVar.ZY() - 2).aah();
        int i = 2;
        if (z) {
            i = 8;
        }
        com.baidu.swan.apps.performance.g.bC("route", str).f(new UbcFlowEvent("na_push_page_end"));
        h.U(i, str);
        h.mL(str);
    }
}
