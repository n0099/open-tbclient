package com.baidu.swan.gamecenter.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.aw;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements aw {
    private static volatile c dnL;
    private com.baidu.swan.gamecenter.a.b dnM;
    private b dnN;

    public c() {
        init();
    }

    private void init() {
        this.dnM = new com.baidu.swan.gamecenter.a.b();
        this.dnN = new b();
    }

    public static c aKF() {
        if (dnL == null) {
            synchronized (c.class) {
                if (dnL == null) {
                    dnL = new c();
                }
            }
        }
        return dnL;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aw
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (this.dnM.uv(str)) {
            return this.dnM.a(str, jSONObject, bVar);
        }
        if (this.dnM.aKE()) {
            return this.dnN.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.c.b(10001, "authorize fail.");
    }
}
