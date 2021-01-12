package com.baidu.swan.apps.api.module.k;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends com.baidu.swan.apps.api.a.d {
    private String cFJ;
    private com.baidu.swan.apps.ao.e.b<Integer> cFK;

    public f(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
        this.cFK = new com.baidu.swan.apps.ao.e.b<Integer>() { // from class: com.baidu.swan.apps.api.module.k.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: f */
            public void L(Integer num) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    f.this.ajR();
                }
            }
        };
    }

    public com.baidu.swan.apps.api.c.b kU(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bn = com.baidu.swan.apps.api.d.b.bn("Api-ExitFullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bn.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ExitFullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        this.cFJ = ((JSONObject) bn.second).optString("cb");
        if (TextUtils.isEmpty(this.cFJ)) {
            return new com.baidu.swan.apps.api.c.b(201);
        }
        j.ajU().b(this.cFK);
        j.ajU().ajZ();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajR() {
        j.ajU().aka();
        j.ajU().ajX();
        a(this.cFJ, new com.baidu.swan.apps.api.c.b(0));
    }
}
