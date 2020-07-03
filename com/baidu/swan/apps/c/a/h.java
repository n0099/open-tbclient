package com.baidu.swan.apps.c.a;

import kotlin.jvm.internal.q;
import org.json.JSONObject;
@kotlin.h
/* loaded from: classes11.dex */
public final class h {
    private static String bNG;
    public static final h bNH = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        q.m(jSONObject, "jsonObject");
        if (i == 0) {
            aj(jSONObject);
        }
    }

    private final void aj(JSONObject jSONObject) {
        com.baidu.swan.apps.storage.c.h.asV().putString("alliance_login_uk", jSONObject.optString("uk"));
    }

    public final void US() {
        com.baidu.swan.apps.storage.c.h.asV().putString("alliance_login_uk", "");
        bNG = null;
    }
}
