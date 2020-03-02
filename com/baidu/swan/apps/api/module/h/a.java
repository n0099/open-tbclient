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

    public com.baidu.swan.apps.api.b.b fL(String str) {
        if (DEBUG) {
            Log.d("Api-NavigateBack", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        g.kb(uuid);
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ar = com.baidu.swan.apps.api.c.b.ar("Api-NavigateBack", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) ar.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigateBack", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) ar.second).optInt("delta", 1);
        final e GC = f.WS().GC();
        if (GC == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "manager is null");
            return new com.baidu.swan.apps.api.b.b(1001, "manager is null");
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "back delta: " + optInt);
        }
        if (optInt >= GC.Oq()) {
            optInt = GC.Oq() - 1;
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "real back delta: " + optInt);
        }
        final e.b ey = GC.hb("navigateBack").Y(e.boh, e.bog).ey(optInt);
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.api.module.h.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.as.d.a(GC, a.this.getContext(), 1);
                ey.commit();
            }
        });
        com.baidu.swan.apps.performance.f.aY("route", uuid).f(new UbcFlowEvent("na_push_page_end"));
        g.A(1, uuid);
        g.kc(uuid);
        if (!(GC.On() instanceof com.baidu.swan.apps.core.d.d)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "top fragment error");
            return new com.baidu.swan.apps.api.b.b(1001, "top fragment error");
        }
        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) GC.On();
        return new com.baidu.swan.apps.api.b.b(0, com.baidu.swan.apps.scheme.actions.k.a.lt(dVar != null ? dVar.NZ() : ""));
    }
}
