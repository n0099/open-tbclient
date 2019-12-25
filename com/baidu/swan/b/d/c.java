package com.baidu.swan.b.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.ak;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c implements ak {
    private static volatile c cfl;
    private com.baidu.swan.b.b.b cfm;
    private b cfn;

    public c() {
        init();
    }

    private void init() {
        this.cfm = new com.baidu.swan.b.b.b();
        this.cfn = new b();
    }

    public static c aiy() {
        if (cfl == null) {
            synchronized (c.class) {
                if (cfl == null) {
                    cfl = new c();
                }
            }
        }
        return cfl;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ak
    public com.baidu.swan.apps.api.b.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.p.b bVar) {
        if (this.cfm.nQ(str)) {
            return this.cfm.a(str, jSONObject, bVar);
        }
        if (this.cfm.aix()) {
            return this.cfn.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.b.b(10001, "authorize fail.");
    }
}
