package com.baidu.swan.apps.d.a;

import kotlin.jvm.internal.p;
import org.json.JSONObject;
@kotlin.e
/* loaded from: classes9.dex */
public final class h {
    private static String cGK;
    public static final h cGL = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        p.o(jSONObject, "jsonObject");
        if (i == 0) {
            aJ(jSONObject);
        }
    }

    private final void aJ(JSONObject jSONObject) {
        com.baidu.swan.apps.storage.c.h.aPH().putString("alliance_login_uk", jSONObject.optString("uk"));
    }

    public final void anc() {
        com.baidu.swan.apps.storage.c.h.aPH().putString("alliance_login_uk", "");
        cGK = null;
    }
}
