package com.baidu.swan.apps.d.a;

import kotlin.jvm.internal.q;
import org.json.JSONObject;
@kotlin.h
/* loaded from: classes10.dex */
public final class h {
    private static String cwM;
    public static final h cwN = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        q.n(jSONObject, "jsonObject");
        if (i == 0) {
            aF(jSONObject);
        }
    }

    private final void aF(JSONObject jSONObject) {
        com.baidu.swan.apps.storage.c.h.aKS().putString("alliance_login_uk", jSONObject.optString("uk"));
    }

    public final void ajs() {
        com.baidu.swan.apps.storage.c.h.aKS().putString("alliance_login_uk", "");
        cwM = null;
    }
}
