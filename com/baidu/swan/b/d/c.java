package com.baidu.swan.b.d;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.adaptation.a.ap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c implements ap {
    private static volatile c cTf;
    private com.baidu.swan.b.b.b cTg;
    private b cTh;

    public c() {
        init();
    }

    private void init() {
        this.cTg = new com.baidu.swan.b.b.b();
        this.cTh = new b();
    }

    public static c axf() {
        if (cTf == null) {
            synchronized (c.class) {
                if (cTf == null) {
                    cTf = new c();
                }
            }
        }
        return cTf;
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.n.b bVar) {
        if (this.cTg.qW(str)) {
            return this.cTg.a(str, jSONObject, bVar);
        }
        if (this.cTg.axe()) {
            return this.cTh.a(str, jSONObject, bVar);
        }
        return new com.baidu.swan.apps.api.c.b(10001, "authorize fail.");
    }
}
