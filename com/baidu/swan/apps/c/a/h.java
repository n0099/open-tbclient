package com.baidu.swan.apps.c.a;

import kotlin.jvm.internal.q;
import org.json.JSONObject;
@kotlin.h
/* loaded from: classes7.dex */
public final class h {
    private static String bOw;
    public static final h bOx = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        q.m(jSONObject, "jsonObject");
        if (i == 0) {
            ak(jSONObject);
        }
    }

    private final void ak(JSONObject jSONObject) {
        com.baidu.swan.apps.storage.c.h.auW().putString("alliance_login_uk", jSONObject.optString("uk"));
    }

    public final void Vx() {
        com.baidu.swan.apps.storage.c.h.auW().putString("alliance_login_uk", "");
        bOw = null;
    }
}
