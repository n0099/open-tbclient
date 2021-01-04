package com.baidu.swan.gamecenter.c;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.aw;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements aw {
    private static volatile c eet;
    private com.baidu.swan.gamecenter.a.b eeu;
    private b eev;

    public c() {
        init();
    }

    private void init() {
        this.eeu = new com.baidu.swan.gamecenter.a.b();
        this.eev = new b();
    }

    public static c aXk() {
        if (eet == null) {
            synchronized (c.class) {
                if (eet == null) {
                    eet = new c();
                }
            }
        }
        return eet;
    }

    @Override // com.baidu.swan.apps.adaptation.a.aw
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.o.b bVar) {
        if (this.eeu.wI(str)) {
            return this.eeu.a(str, jSONObject, bVar);
        }
        if (this.eeu.aXj()) {
            return this.eev.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.c.b(10001, "authorize fail.");
    }
}
