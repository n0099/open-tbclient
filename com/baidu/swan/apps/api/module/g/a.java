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

    public com.baidu.swan.apps.api.c.b hO(String str) {
        if (DEBUG) {
            Log.d("Api-NavigateBack", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        h.mC(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("Api-NavigateBack", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aP.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigateBack", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) aP.second).optInt("delta", 1);
        final e QH = f.ahV().QH();
        if (QH == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "back delta: " + optInt);
        }
        final int YS = QH.YS();
        if (DEBUG) {
            Log.d("Api-NavigateBack", "fragment count " + YS);
        }
        if (YS == 1) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "navigateBack api can only work when slave's count greater than 1");
            return new com.baidu.swan.apps.api.c.b(1001, "navigateBack api can only work when slave's count greater than 1");
        }
        if (optInt >= YS) {
            optInt = YS - 1;
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "real back delta: " + optInt);
        }
        final e.b eM = QH.jp("navigateBack").ae(e.bVP, e.bVO).eM(optInt);
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (YS > 1) {
                    com.baidu.swan.apps.aq.e.a(QH, a.this.getContext(), 1);
                }
                eM.commit();
            }
        });
        g.bA("route", uuid).f(new UbcFlowEvent("na_push_page_end"));
        h.S(1, uuid);
        h.mD(uuid);
        if (!(QH.YP() instanceof com.baidu.swan.apps.core.d.d)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "top fragment error");
            return new com.baidu.swan.apps.api.c.b(1001, "top fragment error");
        }
        com.baidu.swan.apps.core.d.d dVar = (com.baidu.swan.apps.core.d.d) QH.YP();
        return new com.baidu.swan.apps.api.c.b(0, com.baidu.swan.apps.scheme.actions.k.a.oc(dVar != null ? dVar.YB() : ""));
    }
}
