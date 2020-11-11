package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f extends com.baidu.swan.apps.api.a.d {
    private String cAx;
    private com.baidu.swan.apps.ap.e.b<Integer> cAy;

    public f(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
        this.cAy = new com.baidu.swan.apps.ap.e.b<Integer>() { // from class: com.baidu.swan.apps.api.module.k.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: d */
            public void M(Integer num) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    f.this.aka();
                }
            }
        };
    }

    public com.baidu.swan.apps.api.c.b lL(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bj = com.baidu.swan.apps.api.d.b.bj("Api-ExitFullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bj.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ExitFullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        this.cAx = ((JSONObject) bj.second).optString("cb");
        if (TextUtils.isEmpty(this.cAx)) {
            return new com.baidu.swan.apps.api.c.b(201);
        }
        j.akd().b(this.cAy);
        j.akd().aki();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aka() {
        j.akd().akj();
        j.akd().akg();
        a(this.cAx, new com.baidu.swan.apps.api.c.b(0));
    }
}
