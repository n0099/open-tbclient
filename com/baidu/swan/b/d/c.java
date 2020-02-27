package com.baidu.swan.b.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.ak;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c implements ak {
    private static volatile c cjC;
    private com.baidu.swan.b.b.b cjD;
    private b cjE;

    public c() {
        init();
    }

    private void init() {
        this.cjD = new com.baidu.swan.b.b.b();
        this.cjE = new b();
    }

    public static c alf() {
        if (cjC == null) {
            synchronized (c.class) {
                if (cjC == null) {
                    cjC = new c();
                }
            }
        }
        return cjC;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ak
    public com.baidu.swan.apps.api.b.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.p.b bVar) {
        if (this.cjD.oj(str)) {
            return this.cjD.a(str, jSONObject, bVar);
        }
        if (this.cjD.ale()) {
            return this.cjE.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.b.b(10001, "authorize fail.");
    }
}
