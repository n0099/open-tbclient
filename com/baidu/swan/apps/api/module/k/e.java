package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e extends com.baidu.swan.apps.api.a.d {
    private String bRZ;
    private com.baidu.swan.apps.aq.e.b<Integer> bSa;

    public e(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
        this.bSa = new com.baidu.swan.apps.aq.e.b<Integer>() { // from class: com.baidu.swan.apps.api.module.k.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(Integer num) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    e.this.Wf();
                }
            }
        };
    }

    public com.baidu.swan.apps.api.c.b iz(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-ExitFullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aS.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ExitFullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        this.bRZ = ((JSONObject) aS.second).optString("cb");
        if (TextUtils.isEmpty(this.bRZ)) {
            return new com.baidu.swan.apps.api.c.b(201);
        }
        h.Wh().b(this.bSa);
        h.Wh().Wm();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wf() {
        h.Wh().Wn();
        h.Wh().Wk();
        a(this.bRZ, new com.baidu.swan.apps.api.c.b(0));
    }
}
