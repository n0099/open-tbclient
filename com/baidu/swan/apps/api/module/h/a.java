package com.baidu.swan.apps.api.module.h;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.y.f;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.apps.api.a.c {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b ft(String str) {
        if (DEBUG) {
            Log.d("Api-NavigateBack", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        g.jJ(uuid);
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ag = com.baidu.swan.apps.api.c.b.ag("Api-NavigateBack", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) ag.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigateBack", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) ag.second).optInt("delta", 1);
        final e DP = f.Uf().DP();
        if (DP == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "manager is null");
            return new com.baidu.swan.apps.api.b.b(1001, "manager is null");
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "back delta: " + optInt);
        }
        if (optInt >= DP.LE()) {
            optInt = DP.LE() - 1;
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "real back delta: " + optInt);
        }
        final e.b eh = DP.gJ("navigateBack").U(e.bjh, e.bjg).eh(optInt);
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.api.module.h.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.as.d.a(DP, a.this.getContext(), 1);
                eh.commit();
            }
        });
        com.baidu.swan.apps.performance.f.aO("route", uuid).f(new UbcFlowEvent("na_push_page_end"));
        g.v(1, uuid);
        g.jK(uuid);
        if (!(DP.LB() instanceof com.baidu.swan.apps.core.d.d)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "top fragment error");
            return new com.baidu.swan.apps.api.b.b(1001, "top fragment error");
        }
        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) DP.LB();
        return new com.baidu.swan.apps.api.b.b(0, com.baidu.swan.apps.scheme.actions.k.a.lb(dVar != null ? dVar.Ln() : ""));
    }
}
