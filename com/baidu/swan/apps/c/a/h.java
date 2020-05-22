package com.baidu.swan.apps.c.a;

import kotlin.jvm.internal.q;
import org.json.JSONObject;
@kotlin.h
/* loaded from: classes11.dex */
public final class h {
    private static String bIS;
    public static final h bIT = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        q.m(jSONObject, "jsonObject");
        if (i == 0) {
            ac(jSONObject);
        }
    }

    private final void ac(JSONObject jSONObject) {
        com.baidu.swan.apps.storage.c.h.arO().putString("alliance_login_uk", jSONObject.optString("uk"));
    }

    public final void TM() {
        com.baidu.swan.apps.storage.c.h.arO().putString("alliance_login_uk", "");
        bIS = null;
    }
}
