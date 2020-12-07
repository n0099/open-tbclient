package com.baidu.swan.gamecenter.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.aw;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class c implements aw {
    private static volatile c dVw;
    private com.baidu.swan.gamecenter.a.b dVx;
    private b dVy;

    public c() {
        init();
    }

    private void init() {
        this.dVx = new com.baidu.swan.gamecenter.a.b();
        this.dVy = new b();
    }

    public static c aUQ() {
        if (dVw == null) {
            synchronized (c.class) {
                if (dVw == null) {
                    dVw = new c();
                }
            }
        }
        return dVw;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aw
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (this.dVx.wJ(str)) {
            return this.dVx.a(str, jSONObject, bVar);
        }
        if (this.dVx.aUP()) {
            return this.dVy.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.c.b(10001, "authorize fail.");
    }
}
