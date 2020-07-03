package com.baidu.swan.b.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.ap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c implements ap {
    private static volatile c cXP;
    private com.baidu.swan.b.b.b cXQ;
    private b cXR;

    public c() {
        init();
    }

    private void init() {
        this.cXQ = new com.baidu.swan.b.b.b();
        this.cXR = new b();
    }

    public static c ayl() {
        if (cXP == null) {
            synchronized (c.class) {
                if (cXP == null) {
                    cXP = new c();
                }
            }
        }
        return cXP;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.n.b bVar) {
        if (this.cXQ.re(str)) {
            return this.cXQ.a(str, jSONObject, bVar);
        }
        if (this.cXQ.ayk()) {
            return this.cXR.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.c.b(10001, "authorize fail.");
    }
}
