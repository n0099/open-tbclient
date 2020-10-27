package com.baidu.swan.apps.d.a;

import kotlin.jvm.internal.q;
import org.json.JSONObject;
@kotlin.h
/* loaded from: classes10.dex */
public final class h {
    private static String cqO;
    public static final h cqP = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        q.n(jSONObject, "jsonObject");
        if (i == 0) {
            az(jSONObject);
        }
    }

    private final void az(JSONObject jSONObject) {
        com.baidu.swan.apps.storage.c.h.aIs().putString("alliance_login_uk", jSONObject.optString("uk"));
    }

    public final void agS() {
        com.baidu.swan.apps.storage.c.h.aIs().putString("alliance_login_uk", "");
        cqO = null;
    }
}
