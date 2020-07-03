package com.baidu.swan.apps.api.module.g;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.performance.h;
import com.baidu.swan.apps.w.f;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.apps.api.a.d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b hW(String str) {
        if (DEBUG) {
            Log.d("Api-NavigateBack", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        h.mK(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aR = com.baidu.swan.apps.api.d.b.aR("Api-NavigateBack", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aR.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigateBack", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) aR.second).optInt("delta", 1);
        final e RN = f.ajb().RN();
        if (RN == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "back delta: " + optInt);
        }
        final int ZY = RN.ZY();
        if (DEBUG) {
            Log.d("Api-NavigateBack", "fragment count " + ZY);
        }
        if (ZY == 1) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "navigateBack api can only work when slave's count greater than 1");
            return new com.baidu.swan.apps.api.c.b(1001, "navigateBack api can only work when slave's count greater than 1");
        }
        if (optInt >= ZY) {
            optInt = ZY - 1;
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "real back delta: " + optInt);
        }
        final e.b eZ = RN.jx("navigateBack").ag(e.caD, e.caC).eZ(optInt);
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (ZY > 1) {
                    com.baidu.swan.apps.aq.e.a(RN, a.this.getContext(), 1);
                }
                eZ.commit();
            }
        });
        g.bC("route", uuid).f(new UbcFlowEvent("na_push_page_end"));
        h.U(1, uuid);
        h.mL(uuid);
        if (!(RN.ZV() instanceof com.baidu.swan.apps.core.d.d)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "top fragment error");
            return new com.baidu.swan.apps.api.c.b(1001, "top fragment error");
        }
        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) RN.ZV();
        return new com.baidu.swan.apps.api.c.b(0, com.baidu.swan.apps.scheme.actions.k.a.ol(dVar != null ? dVar.ZH() : ""));
    }
}
