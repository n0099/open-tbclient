package com.baidu.swan.gamecenter.c;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.aw;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements aw {
    private static volatile c dZH;
    private com.baidu.swan.gamecenter.a.b dZI;
    private b dZJ;

    public c() {
        init();
    }

    private void init() {
        this.dZI = new com.baidu.swan.gamecenter.a.b();
        this.dZJ = new b();
    }

    public static c aTr() {
        if (dZH == null) {
            synchronized (c.class) {
                if (dZH == null) {
                    dZH = new c();
                }
            }
        }
        return dZH;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aw
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (this.dZI.vx(str)) {
            return this.dZI.a(str, jSONObject, bVar);
        }
        if (this.dZI.aTq()) {
            return this.dZJ.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.c.b(10001, "authorize fail.");
    }
}
