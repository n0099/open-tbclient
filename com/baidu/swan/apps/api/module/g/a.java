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
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.apps.api.a.d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b jD(String str) {
        if (DEBUG) {
            Log.d("Api-NavigateBack", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        j.pk(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-NavigateBack", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aX.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigateBack", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) aX.second).optInt("delta", 1);
        final f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "back delta: " + optInt);
        }
        final int ahp = XX.ahp();
        if (DEBUG) {
            Log.d("Api-NavigateBack", "fragment count " + ahp);
        }
        if (ahp == 1) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "navigateBack api can only work when slave's count greater than 1");
            return new com.baidu.swan.apps.api.c.b(1001, "navigateBack api can only work when slave's count greater than 1");
        }
        if (optInt >= ahp) {
            optInt = ahp - 1;
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "real back delta: " + optInt);
        }
        final f.b ha = XX.ln("navigateBack").al(f.cii, f.cih).ha(optInt);
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (ahp > 1) {
                    com.baidu.swan.apps.ap.f.a(XX, a.this.getContext(), 1);
                }
                ha.commit();
            }
        });
        i.bT("route", uuid).f(new UbcFlowEvent("na_push_page_end"));
        j.T(1, uuid);
        j.pl(uuid);
        if (!(XX.ahm() instanceof e)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "top fragment error");
            return new com.baidu.swan.apps.api.c.b(1001, "top fragment error");
        }
        e eVar = (e) XX.ahm();
        return new com.baidu.swan.apps.api.c.b(0, com.baidu.swan.apps.scheme.actions.k.a.qS(eVar != null ? eVar.agW() : ""));
    }
}
