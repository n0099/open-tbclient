package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends com.baidu.swan.apps.api.a.d {
    private String cJE;
    private com.baidu.swan.apps.ao.e.b<Integer> cJF;

    public f(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
        this.cJF = new com.baidu.swan.apps.ao.e.b<Integer>() { // from class: com.baidu.swan.apps.api.module.k.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: f */
            public void N(Integer num) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    f.this.aks();
                }
            }
        };
    }

    public com.baidu.swan.apps.api.c.b lt(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-ExitFullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bh.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ExitFullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        this.cJE = ((JSONObject) bh.second).optString("cb");
        if (TextUtils.isEmpty(this.cJE)) {
            return new com.baidu.swan.apps.api.c.b(201);
        }
        j.akv().b(this.cJF);
        j.akv().akA();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aks() {
        j.akv().akB();
        j.akv().aky();
        a(this.cJE, new com.baidu.swan.apps.api.c.b(0));
    }
}
