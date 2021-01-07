package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f extends com.baidu.swan.apps.api.a.d {
    private String cKv;
    private com.baidu.swan.apps.ao.e.b<Integer> cKw;

    public f(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
        this.cKw = new com.baidu.swan.apps.ao.e.b<Integer>() { // from class: com.baidu.swan.apps.api.module.k.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: f */
            public void L(Integer num) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    f.this.anL();
                }
            }
        };
    }

    public com.baidu.swan.apps.api.c.b mf(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-ExitFullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bo.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ExitFullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        this.cKv = ((JSONObject) bo.second).optString("cb");
        if (TextUtils.isEmpty(this.cKv)) {
            return new com.baidu.swan.apps.api.c.b(201);
        }
        j.anO().b(this.cKw);
        j.anO().anT();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anL() {
        j.anO().anU();
        j.anO().anR();
        a(this.cKv, new com.baidu.swan.apps.api.c.b(0));
    }
}
