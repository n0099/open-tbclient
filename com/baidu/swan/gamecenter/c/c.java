package com.baidu.swan.gamecenter.c;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.aw;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class c implements aw {
    private static volatile c ebO;
    private com.baidu.swan.gamecenter.a.b ebP;
    private b ebQ;

    public c() {
        init();
    }

    private void init() {
        this.ebP = new com.baidu.swan.gamecenter.a.b();
        this.ebQ = new b();
    }

    public static c aTD() {
        if (ebO == null) {
            synchronized (c.class) {
                if (ebO == null) {
                    ebO = new c();
                }
            }
        }
        return ebO;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aw
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (this.ebP.vQ(str)) {
            return this.ebP.a(str, jSONObject, bVar);
        }
        if (this.ebP.aTC()) {
            return this.ebQ.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.c.b(10001, "authorize fail.");
    }
}
