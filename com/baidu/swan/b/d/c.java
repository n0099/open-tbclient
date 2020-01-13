package com.baidu.swan.b.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.ak;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c implements ak {
    private static volatile c cfy;
    private b cfA;
    private com.baidu.swan.b.b.b cfz;

    public c() {
        init();
    }

    private void init() {
        this.cfz = new com.baidu.swan.b.b.b();
        this.cfA = new b();
    }

    public static c aiR() {
        if (cfy == null) {
            synchronized (c.class) {
                if (cfy == null) {
                    cfy = new c();
                }
            }
        }
        return cfy;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ak
    public com.baidu.swan.apps.api.b.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.p.b bVar) {
        if (this.cfz.nT(str)) {
            return this.cfz.a(str, jSONObject, bVar);
        }
        if (this.cfz.aiQ()) {
            return this.cfA.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.b.b(10001, "authorize fail.");
    }
}
