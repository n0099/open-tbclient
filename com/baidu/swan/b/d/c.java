package com.baidu.swan.b.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.ak;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c implements ak {
    private static volatile c cIQ;
    private com.baidu.swan.b.b.b cIR;
    private b cIS;

    public c() {
        init();
    }

    private void init() {
        this.cIR = new com.baidu.swan.b.b.b();
        this.cIS = new b();
    }

    public static c aty() {
        if (cIQ == null) {
            synchronized (c.class) {
                if (cIQ == null) {
                    cIQ = new c();
                }
            }
        }
        return cIQ;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ak
    public com.baidu.swan.apps.api.b.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.p.b bVar) {
        if (this.cIR.pw(str)) {
            return this.cIR.a(str, jSONObject, bVar);
        }
        if (this.cIR.atx()) {
            return this.cIS.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.b.b(10001, "authorize fail.");
    }
}
