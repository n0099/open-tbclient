package com.baidu.swan.apps.api.module.g;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.performance.j;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends com.baidu.swan.apps.api.a.d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lr(String str) {
        if (DEBUG) {
            Log.d("Api-NavigateBack", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        j.qX(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bj = com.baidu.swan.apps.api.d.b.bj("Api-NavigateBack", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bj.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigateBack", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) bj.second).optInt("delta", 1);
        final f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "back delta: " + optInt);
        }
        final int ape = afM.ape();
        if (DEBUG) {
            Log.d("Api-NavigateBack", "fragment count " + ape);
        }
        if (ape == 1) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "navigateBack api can only work when slave's count greater than 1");
            return new com.baidu.swan.apps.api.c.b(1001, "navigateBack api can only work when slave's count greater than 1");
        }
        if (optInt >= ape) {
            optInt = ape - 1;
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "real back delta: " + optInt);
        }
        final f.b ib = afM.nb("navigateBack").al(f.cKU, f.cKT).ib(optInt);
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (ape > 1) {
                    com.baidu.swan.apps.ap.f.a(afM, a.this.getContext(), 1);
                }
                ib.commit();
            }
        });
        i.cf("route", uuid).f(new UbcFlowEvent("na_push_page_end"));
        j.al(1, uuid);
        j.qY(uuid);
        if (!(afM.apb() instanceof e)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "top fragment error");
            return new com.baidu.swan.apps.api.c.b(1001, "top fragment error");
        }
        e eVar = (e) afM.apb();
        return new com.baidu.swan.apps.api.c.b(0, com.baidu.swan.apps.scheme.actions.k.a.sG(eVar != null ? eVar.aoL() : ""));
    }
}
