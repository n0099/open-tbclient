package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class f extends com.baidu.swan.apps.api.a.d {
    private String cFF;
    private com.baidu.swan.apps.ap.e.b<Integer> cFG;

    public f(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
        this.cFG = new com.baidu.swan.apps.ap.e.b<Integer>() { // from class: com.baidu.swan.apps.api.module.k.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: d */
            public void M(Integer num) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    f.this.amA();
                }
            }
        };
    }

    public com.baidu.swan.apps.api.c.b mm(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-ExitFullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bp.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ExitFullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        this.cFF = ((JSONObject) bp.second).optString("cb");
        if (TextUtils.isEmpty(this.cFF)) {
            return new com.baidu.swan.apps.api.c.b(201);
        }
        j.amD().b(this.cFG);
        j.amD().amI();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amA() {
        j.amD().amJ();
        j.amD().amG();
        a(this.cFF, new com.baidu.swan.apps.api.c.b(0));
    }
}
