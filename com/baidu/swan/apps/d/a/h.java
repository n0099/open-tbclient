package com.baidu.swan.apps.d.a;

import kotlin.jvm.internal.p;
import org.json.JSONObject;
@kotlin.e
/* loaded from: classes25.dex */
public final class h {
    private static String cBU;
    public static final h cBV = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        p.o(jSONObject, "jsonObject");
        if (i == 0) {
            aB(jSONObject);
        }
    }

    private final void aB(JSONObject jSONObject) {
        com.baidu.swan.apps.storage.c.h.aNr().putString("alliance_login_uk", jSONObject.optString("uk"));
    }

    public final void alS() {
        com.baidu.swan.apps.storage.c.h.aNr().putString("alliance_login_uk", "");
        cBU = null;
    }
}
