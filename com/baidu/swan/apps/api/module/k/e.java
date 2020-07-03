package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e extends com.baidu.swan.apps.api.a.d {
    private String bRi;
    private com.baidu.swan.apps.aq.e.b<Integer> bRj;

    public e(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
        this.bRj = new com.baidu.swan.apps.aq.e.b<Integer>() { // from class: com.baidu.swan.apps.api.module.k.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: b */
            public void H(Integer num) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    e.this.Vz();
                }
            }
        };
    }

    public com.baidu.swan.apps.api.c.b ip(String str) {
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aR = com.baidu.swan.apps.api.d.b.aR("Api-ExitFullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aR.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ExitFullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        this.bRi = ((JSONObject) aR.second).optString("cb");
        if (TextUtils.isEmpty(this.bRi)) {
            return new com.baidu.swan.apps.api.c.b(201);
        }
        h.VB().a(this.bRj);
        h.VB().VG();
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vz() {
        h.VB().VH();
        h.VB().VE();
        a(this.bRi, new com.baidu.swan.apps.api.c.b(0));
    }
}
