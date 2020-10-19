package com.baidu.swan.apps.d.a;

import kotlin.jvm.internal.q;
import org.json.JSONObject;
@kotlin.h
/* loaded from: classes10.dex */
public final class h {
    private static String cio;
    public static final h cip = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        q.n(jSONObject, "jsonObject");
        if (i == 0) {
            aw(jSONObject);
        }
    }

    private final void aw(JSONObject jSONObject) {
        com.baidu.swan.apps.storage.c.h.aGy().putString("alliance_login_uk", jSONObject.optString("uk"));
    }

    public final void aeY() {
        com.baidu.swan.apps.storage.c.h.aGy().putString("alliance_login_uk", "");
        cio = null;
    }
}
