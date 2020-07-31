package com.baidu.swan.gamecenter.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.ar;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class c implements ar {
    private static volatile c ddz;
    private com.baidu.swan.gamecenter.a.b ddA;
    private b ddB;

    public c() {
        init();
    }

    private void init() {
        this.ddA = new com.baidu.swan.gamecenter.a.b();
        this.ddB = new b();
    }

    public static c aBQ() {
        if (ddz == null) {
            synchronized (c.class) {
                if (ddz == null) {
                    ddz = new c();
                }
            }
        }
        return ddz;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ar
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.n.b bVar) {
        if (this.ddA.sc(str)) {
            return this.ddA.a(str, jSONObject, bVar);
        }
        if (this.ddA.aBP()) {
            return this.ddB.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.c.b(10001, "authorize fail.");
    }
}
