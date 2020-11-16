package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends com.baidu.swan.apps.api.a.d {
    private String cyN;
    private com.baidu.swan.apps.ap.e.b<Integer> cyO;

    public f(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
        this.cyO = new com.baidu.swan.apps.ap.e.b<Integer>() { // from class: com.baidu.swan.apps.api.module.k.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: d */
            public void M(Integer num) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    f.this.ajs();
                }
            }
        };
    }

    public com.baidu.swan.apps.api.c.b lF(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bi = com.baidu.swan.apps.api.d.b.bi("Api-ExitFullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bi.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ExitFullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        this.cyN = ((JSONObject) bi.second).optString("cb");
        if (TextUtils.isEmpty(this.cyN)) {
            return new com.baidu.swan.apps.api.c.b(201);
        }
        j.ajv().b(this.cyO);
        j.ajv().ajA();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajs() {
        j.ajv().ajB();
        j.ajv().ajy();
        a(this.cyN, new com.baidu.swan.apps.api.c.b(0));
    }
}
