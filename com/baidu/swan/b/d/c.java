package com.baidu.swan.b.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.ak;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c implements ak {
    private static volatile c cjE;
    private com.baidu.swan.b.b.b cjF;
    private b cjG;

    public c() {
        init();
    }

    private void init() {
        this.cjF = new com.baidu.swan.b.b.b();
        this.cjG = new b();
    }

    public static c alh() {
        if (cjE == null) {
            synchronized (c.class) {
                if (cjE == null) {
                    cjE = new c();
                }
            }
        }
        return cjE;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ak
    public com.baidu.swan.apps.api.b.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.p.b bVar) {
        if (this.cjF.oj(str)) {
            return this.cjF.a(str, jSONObject, bVar);
        }
        if (this.cjF.alg()) {
            return this.cjG.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.b.b(10001, "authorize fail.");
    }
}
