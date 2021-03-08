package com.baidu.swan.apps.d.a;

import kotlin.jvm.internal.p;
import org.json.JSONObject;
@kotlin.e
/* loaded from: classes8.dex */
public final class h {
    private static String cFU;
    public static final h cFV = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        p.p(jSONObject, "jsonObject");
        if (i == 0) {
            aI(jSONObject);
        }
    }

    private final void aI(JSONObject jSONObject) {
        com.baidu.swan.apps.storage.c.h.aMk().putString("alliance_login_uk", jSONObject.optString("uk"));
    }

    public final void ajK() {
        com.baidu.swan.apps.storage.c.h.aMk().putString("alliance_login_uk", "");
        cFU = null;
    }
}
