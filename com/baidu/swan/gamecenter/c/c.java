package com.baidu.swan.gamecenter.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.aw;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class c implements aw {
    private static volatile c dpN;
    private com.baidu.swan.gamecenter.a.b dpO;
    private b dpP;

    public c() {
        init();
    }

    private void init() {
        this.dpO = new com.baidu.swan.gamecenter.a.b();
        this.dpP = new b();
    }

    public static c aLq() {
        if (dpN == null) {
            synchronized (c.class) {
                if (dpN == null) {
                    dpN = new c();
                }
            }
        }
        return dpN;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aw
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (this.dpO.uO(str)) {
            return this.dpO.a(str, jSONObject, bVar);
        }
        if (this.dpO.aLp()) {
            return this.dpP.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.c.b(10001, "authorize fail.");
    }
}
