package com.baidu.swan.apps.d.a;

import kotlin.jvm.internal.q;
import org.json.JSONObject;
@kotlin.h
/* loaded from: classes8.dex */
public final class h {
    private static String bTY;
    public static final h bTZ = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        q.m(jSONObject, "jsonObject");
        if (i == 0) {
            am(jSONObject);
        }
    }

    private final void am(JSONObject jSONObject) {
        com.baidu.swan.apps.storage.c.h.aDf().putString("alliance_login_uk", jSONObject.optString("uk"));
    }

    public final void abD() {
        com.baidu.swan.apps.storage.c.h.aDf().putString("alliance_login_uk", "");
        bTY = null;
    }
}
