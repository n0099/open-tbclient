package com.baidu.swan.gamecenter.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.aw;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c implements aw {
    private static volatile c dQg;
    private com.baidu.swan.gamecenter.a.b dQh;
    private b dQi;

    public c() {
        init();
    }

    private void init() {
        this.dQh = new com.baidu.swan.gamecenter.a.b();
        this.dQi = new b();
    }

    public static c aSt() {
        if (dQg == null) {
            synchronized (c.class) {
                if (dQg == null) {
                    dQg = new c();
                }
            }
        }
        return dQg;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aw
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (this.dQh.wh(str)) {
            return this.dQh.a(str, jSONObject, bVar);
        }
        if (this.dQh.aSs()) {
            return this.dQi.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.c.b(10001, "authorize fail.");
    }
}
