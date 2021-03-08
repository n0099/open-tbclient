package com.baidu.swan.gamecenter.c;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.aw;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class c implements aw {
    private static volatile c edp;
    private com.baidu.swan.gamecenter.a.b edq;
    private b edr;

    public c() {
        init();
    }

    private void init() {
        this.edq = new com.baidu.swan.gamecenter.a.b();
        this.edr = new b();
    }

    public static c aTG() {
        if (edp == null) {
            synchronized (c.class) {
                if (edp == null) {
                    edp = new c();
                }
            }
        }
        return edp;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aw
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (this.edq.vX(str)) {
            return this.edq.a(str, jSONObject, bVar);
        }
        if (this.edq.aTF()) {
            return this.edr.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.c.b(10001, "authorize fail.");
    }
}
