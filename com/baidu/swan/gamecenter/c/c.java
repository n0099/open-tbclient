package com.baidu.swan.gamecenter.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.aw;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c implements aw {
    private static volatile c dBR;
    private com.baidu.swan.gamecenter.a.b dBS;
    private b dBT;

    public c() {
        init();
    }

    private void init() {
        this.dBS = new com.baidu.swan.gamecenter.a.b();
        this.dBT = new b();
    }

    public static c aNZ() {
        if (dBR == null) {
            synchronized (c.class) {
                if (dBR == null) {
                    dBR = new c();
                }
            }
        }
        return dBR;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aw
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (this.dBS.vA(str)) {
            return this.dBS.a(str, jSONObject, bVar);
        }
        if (this.dBS.aNY()) {
            return this.dBT.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.c.b(10001, "authorize fail.");
    }
}
