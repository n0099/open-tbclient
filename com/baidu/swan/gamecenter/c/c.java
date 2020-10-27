package com.baidu.swan.gamecenter.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.aw;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c implements aw {
    private static volatile c dKo;
    private com.baidu.swan.gamecenter.a.b dKp;
    private b dKq;

    public c() {
        init();
    }

    private void init() {
        this.dKp = new com.baidu.swan.gamecenter.a.b();
        this.dKq = new b();
    }

    public static c aPT() {
        if (dKo == null) {
            synchronized (c.class) {
                if (dKo == null) {
                    dKo = new c();
                }
            }
        }
        return dKo;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aw
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (this.dKp.vT(str)) {
            return this.dKp.a(str, jSONObject, bVar);
        }
        if (this.dKp.aPS()) {
            return this.dKq.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.c.b(10001, "authorize fail.");
    }
}
