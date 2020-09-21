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
/* loaded from: classes3.dex */
public class a extends com.baidu.swan.apps.api.a.d {
    public a(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b jX(String str) {
        if (DEBUG) {
            Log.d("Api-NavigateBack", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        j.pE(uuid);
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
        final f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "back delta: " + optInt);
        }
        final int ahZ = YG.ahZ();
        if (DEBUG) {
            Log.d("Api-NavigateBack", "fragment count " + ahZ);
        }
        if (ahZ == 1) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "navigateBack api can only work when slave's count greater than 1");
            return new com.baidu.swan.apps.api.c.b(1001, "navigateBack api can only work when slave's count greater than 1");
        }
        if (optInt >= ahZ) {
            optInt = ahZ - 1;
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "real back delta: " + optInt);
        }
        final f.b hj = YG.lH("navigateBack").al(f.ckn, f.ckm).hj(optInt);
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (ahZ > 1) {
                    com.baidu.swan.apps.ap.f.a(YG, a.this.getContext(), 1);
                }
                hj.commit();
            }
        });
        i.bT("route", uuid).f(new UbcFlowEvent("na_push_page_end"));
        j.U(1, uuid);
        j.pF(uuid);
        if (!(YG.ahW() instanceof e)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "top fragment error");
            return new com.baidu.swan.apps.api.c.b(1001, "top fragment error");
        }
        e eVar = (e) YG.ahW();
        return new com.baidu.swan.apps.api.c.b(0, com.baidu.swan.apps.scheme.actions.k.a.rm(eVar != null ? eVar.ahG() : ""));
    }
}
