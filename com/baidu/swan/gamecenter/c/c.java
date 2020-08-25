package com.baidu.swan.gamecenter.c;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.aw;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements aw {
    private static volatile c dnH;
    private com.baidu.swan.gamecenter.a.b dnI;
    private b dnJ;

    public c() {
        init();
    }

    private void init() {
        this.dnI = new com.baidu.swan.gamecenter.a.b();
        this.dnJ = new b();
    }

    public static c aKF() {
        if (dnH == null) {
            synchronized (c.class) {
                if (dnH == null) {
                    dnH = new c();
                }
            }
        }
        return dnH;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aw
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (this.dnI.uu(str)) {
            return this.dnI.a(str, jSONObject, bVar);
        }
        if (this.dnI.aKE()) {
            return this.dnJ.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.c.b(10001, "authorize fail.");
    }
}
