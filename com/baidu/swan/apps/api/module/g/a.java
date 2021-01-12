package com.baidu.swan.apps.api.module.g;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ak;
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

    public com.baidu.swan.apps.api.c.b kA(String str) {
        if (DEBUG) {
            Log.d("Api-NavigateBack", "handle: " + str);
        }
        String uuid = UUID.randomUUID().toString();
        j.qg(uuid);
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bn = com.baidu.swan.apps.api.d.b.bn("Api-NavigateBack", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bn.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-NavigateBack", "parse fail");
                return bVar;
            }
            return bVar;
        }
        int optInt = ((JSONObject) bn.second).optInt("delta", 1);
        final f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz == null) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "manager is null");
            return new com.baidu.swan.apps.api.c.b(1001, "manager is null");
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "back delta: " + optInt);
        }
        final int apb = afz.apb();
        if (DEBUG) {
            Log.d("Api-NavigateBack", "fragment count " + apb);
        }
        if (apb == 1) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "navigateBack api can only work when slave's count greater than 1");
            return new com.baidu.swan.apps.api.c.b(1001, "navigateBack api can only work when slave's count greater than 1");
        }
        if (optInt >= apb) {
            optInt = apb - 1;
        }
        if (DEBUG) {
            Log.d("Api-NavigateBack", "real back delta: " + optInt);
        }
        final f.b gK = afz.mk("navigateBack").ai(f.cQo, f.cQn).gK(optInt);
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.api.module.g.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (apb > 1) {
                    com.baidu.swan.apps.ao.f.a(afz, a.this.getContext(), 1);
                }
                gK.commit();
            }
        });
        i.cj("route", uuid).f(new UbcFlowEvent("na_push_page_end"));
        j.ao(1, uuid);
        j.qh(uuid);
        if (!(afz.aoY() instanceof e)) {
            com.baidu.swan.apps.console.c.e("Api-NavigateBack", "top fragment error");
            return new com.baidu.swan.apps.api.c.b(1001, "top fragment error");
        }
        e eVar = (e) afz.aoY();
        return new com.baidu.swan.apps.api.c.b(0, com.baidu.swan.apps.scheme.actions.k.a.rT(eVar != null ? eVar.aoI() : ""));
    }
}
