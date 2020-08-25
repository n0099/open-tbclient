package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends com.baidu.swan.apps.api.a.d {
    private String bXF;
    private com.baidu.swan.apps.ap.e.b<Integer> bXG;

    public f(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
        this.bXG = new com.baidu.swan.apps.ap.e.b<Integer>() { // from class: com.baidu.swan.apps.api.module.k.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: b */
            public void I(Integer num) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    f.this.acl();
                }
            }
        };
    }

    public com.baidu.swan.apps.api.c.b jX(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-ExitFullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aX.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ExitFullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        this.bXF = ((JSONObject) aX.second).optString("cb");
        if (TextUtils.isEmpty(this.bXF)) {
            return new com.baidu.swan.apps.api.c.b(201);
        }
        j.aco().b(this.bXG);
        j.aco().act();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acl() {
        j.aco().acu();
        j.aco().acr();
        a(this.bXF, new com.baidu.swan.apps.api.c.b(0));
    }
}
