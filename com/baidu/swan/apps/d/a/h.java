package com.baidu.swan.apps.d.a;

import kotlin.jvm.internal.q;
import org.json.JSONObject;
@kotlin.h
/* loaded from: classes3.dex */
public final class h {
    private static String bVZ;
    public static final h bWa = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        q.m(jSONObject, "jsonObject");
        if (i == 0) {
            ap(jSONObject);
        }
    }

    private final void ap(JSONObject jSONObject) {
        com.baidu.swan.apps.storage.c.h.aDP().putString("alliance_login_uk", jSONObject.optString("uk"));
    }

    public final void acm() {
        com.baidu.swan.apps.storage.c.h.aDP().putString("alliance_login_uk", "");
        bVZ = null;
    }
}
