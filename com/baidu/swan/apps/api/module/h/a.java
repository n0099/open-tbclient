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

    public com.baidu.swan.apps.api.b.b fK(String str) {
        if (DEBUG) {
            Log.d("Api-NavigateBack", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        g.ka(uuid);
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> aq = com.baidu.swan.apps.api.c.b.aq("Api-NavigateBack", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) aq.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigateBack", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) aq.second).optInt("delta", 1);
        final e GH = f.WV().GH();
        if (GH == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "manager is null");
            return new com.baidu.swan.apps.api.b.b(1001, "manager is null");
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "back delta: " + optInt);
        }
        if (optInt >= GH.Ot()) {
            optInt = GH.Ot() - 1;
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "real back delta: " + optInt);
        }
        final e.b ey = GH.ha("navigateBack").Y(e.bou, e.bot).ey(optInt);
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.api.module.h.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.as.d.a(GH, a.this.getContext(), 1);
                ey.commit();
            }
        });
        com.baidu.swan.apps.performance.f.aX("route", uuid).f(new UbcFlowEvent("na_push_page_end"));
        g.A(1, uuid);
        g.kb(uuid);
        if (!(GH.Oq() instanceof com.baidu.swan.apps.core.d.d)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "top fragment error");
            return new com.baidu.swan.apps.api.b.b(1001, "top fragment error");
        }
        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) GH.Oq();
        return new com.baidu.swan.apps.api.b.b(0, com.baidu.swan.apps.scheme.actions.k.a.ls(dVar != null ? dVar.Oc() : ""));
    }
}
