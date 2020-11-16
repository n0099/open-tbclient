package com.baidu.swan.gamecenter.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.aw;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class c implements aw {
    private static volatile c dOy;
    private b dOA;
    private com.baidu.swan.gamecenter.a.b dOz;

    public c() {
        init();
    }

    private void init() {
        this.dOz = new com.baidu.swan.gamecenter.a.b();
        this.dOA = new b();
    }

    public static c aRL() {
        if (dOy == null) {
            synchronized (c.class) {
                if (dOy == null) {
                    dOy = new c();
                }
            }
        }
        return dOy;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aw
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (this.dOz.wc(str)) {
            return this.dOz.a(str, jSONObject, bVar);
        }
        if (this.dOz.aRK()) {
            return this.dOA.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.c.b(10001, "authorize fail.");
    }
}
