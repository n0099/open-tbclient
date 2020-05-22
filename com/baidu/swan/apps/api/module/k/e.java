package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e extends com.baidu.swan.apps.api.a.d {
    private String bMu;
    private com.baidu.swan.apps.aq.e.b<Integer> bMv;

    public e(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
        this.bMv = new com.baidu.swan.apps.aq.e.b<Integer>() { // from class: com.baidu.swan.apps.api.module.k.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(Integer num) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    e.this.Ut();
                }
            }
        };
    }

    public com.baidu.swan.apps.api.c.b ih(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("Api-ExitFullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aP.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ExitFullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        this.bMu = ((JSONObject) aP.second).optString("cb");
        if (TextUtils.isEmpty(this.bMu)) {
            return new com.baidu.swan.apps.api.c.b(201);
        }
        h.Uv().a(this.bMv);
        h.Uv().UA();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ut() {
        h.Uv().UB();
        h.Uv().Uy();
        a(this.bMu, new com.baidu.swan.apps.api.c.b(0));
    }
}
