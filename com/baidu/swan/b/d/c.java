package com.baidu.swan.b.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.ak;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c implements ak {
    private static volatile c cjD;
    private com.baidu.swan.b.b.b cjE;
    private b cjF;

    public c() {
        init();
    }

    private void init() {
        this.cjE = new com.baidu.swan.b.b.b();
        this.cjF = new b();
    }

    public static c alh() {
        if (cjD == null) {
            synchronized (c.class) {
                if (cjD == null) {
                    cjD = new c();
                }
            }
        }
        return cjD;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ak
    public com.baidu.swan.apps.api.b.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.p.b bVar) {
        if (this.cjE.oj(str)) {
            return this.cjE.a(str, jSONObject, bVar);
        }
        if (this.cjE.alg()) {
            return this.cjF.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.b.b(10001, "authorize fail.");
    }
}
