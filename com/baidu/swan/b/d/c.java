package com.baidu.swan.b.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.ak;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c implements ak {
    private static volatile c cjP;
    private com.baidu.swan.b.b.b cjQ;
    private b cjR;

    public c() {
        init();
    }

    private void init() {
        this.cjQ = new com.baidu.swan.b.b.b();
        this.cjR = new b();
    }

    public static c alk() {
        if (cjP == null) {
            synchronized (c.class) {
                if (cjP == null) {
                    cjP = new c();
                }
            }
        }
        return cjP;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ak
    public com.baidu.swan.apps.api.b.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.p.b bVar) {
        if (this.cjQ.oi(str)) {
            return this.cjQ.a(str, jSONObject, bVar);
        }
        if (this.cjQ.alj()) {
            return this.cjR.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.b.b(10001, "authorize fail.");
    }
}
