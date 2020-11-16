package com.baidu.swan.apps.d.a;

import kotlin.jvm.internal.q;
import org.json.JSONObject;
@kotlin.h
/* loaded from: classes7.dex */
public final class h {
    private static String cvc;
    public static final h cvd = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        q.n(jSONObject, "jsonObject");
        if (i == 0) {
            az(jSONObject);
        }
    }

    private final void az(JSONObject jSONObject) {
        com.baidu.swan.apps.storage.c.h.aKk().putString("alliance_login_uk", jSONObject.optString("uk"));
    }

    public final void aiK() {
        com.baidu.swan.apps.storage.c.h.aKk().putString("alliance_login_uk", "");
        cvc = null;
    }
}
