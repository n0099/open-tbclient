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
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.apps.api.a.c {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b gY(String str) {
        if (DEBUG) {
            Log.d("Api-NavigateBack", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        g.ln(uuid);
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> az = com.baidu.swan.apps.api.c.b.az("Api-NavigateBack", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) az.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigateBack", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) az.second).optInt("delta", 1);
        final e Ou = f.aeK().Ou();
        if (Ou == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "manager is null");
            return new com.baidu.swan.apps.api.b.b(1001, "manager is null");
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "back delta: " + optInt);
        }
        if (optInt >= Ou.Wh()) {
            optInt = Ou.Wh() - 1;
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "real back delta: " + optInt);
        }
        final e.b eD = Ou.io("navigateBack").ab(e.bMB, e.bMA).eD(optInt);
        ai.o(new Runnable() { // from class: com.baidu.swan.apps.api.module.h.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.as.d.a(Ou, a.this.getContext(), 1);
                eD.commit();
            }
        });
        com.baidu.swan.apps.performance.f.bh("route", uuid).f(new UbcFlowEvent("na_push_page_end"));
        g.R(1, uuid);
        g.lo(uuid);
        if (!(Ou.We() instanceof com.baidu.swan.apps.core.d.d)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "top fragment error");
            return new com.baidu.swan.apps.api.b.b(1001, "top fragment error");
        }
        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) Ou.We();
        return new com.baidu.swan.apps.api.b.b(0, com.baidu.swan.apps.scheme.actions.k.a.mF(dVar != null ? dVar.VQ() : ""));
    }
}
