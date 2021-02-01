package com.baidu.swan.apps.d.a;

import kotlin.jvm.internal.p;
import org.json.JSONObject;
@kotlin.e
/* loaded from: classes9.dex */
public final class h {
    private static String cEu;
    public static final h cEv = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        p.o(jSONObject, "jsonObject");
        if (i == 0) {
            aG(jSONObject);
        }
    }

    private final void aG(JSONObject jSONObject) {
        com.baidu.swan.apps.storage.c.h.aMh().putString("alliance_login_uk", jSONObject.optString("uk"));
    }

    public final void ajH() {
        com.baidu.swan.apps.storage.c.h.aMh().putString("alliance_login_uk", "");
        cEu = null;
    }
}
