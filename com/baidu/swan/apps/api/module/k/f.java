package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f extends com.baidu.swan.apps.api.a.d {
    private String clZ;
    private com.baidu.swan.apps.ap.e.b<Integer> cma;

    public f(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
        this.cma = new com.baidu.swan.apps.ap.e.b<Integer>() { // from class: com.baidu.swan.apps.api.module.k.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: d */
            public void M(Integer num) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    f.this.afG();
                }
            }
        };
    }

    public com.baidu.swan.apps.api.c.b ld(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bc = com.baidu.swan.apps.api.d.b.bc("Api-ExitFullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bc.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ExitFullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        this.clZ = ((JSONObject) bc.second).optString("cb");
        if (TextUtils.isEmpty(this.clZ)) {
            return new com.baidu.swan.apps.api.c.b(201);
        }
        j.afJ().b(this.cma);
        j.afJ().afO();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afG() {
        j.afJ().afP();
        j.afJ().afM();
        a(this.clZ, new com.baidu.swan.apps.api.c.b(0));
    }
}
