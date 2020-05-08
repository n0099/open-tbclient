package com.baidu.swan.apps.c.a;

import kotlin.jvm.internal.q;
import kotlin.text.l;
import org.json.JSONObject;
@kotlin.h
/* loaded from: classes11.dex */
public final class h {
    private static String bAY;
    public static final h bAZ = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        q.j(jSONObject, "jsonObject");
        if (i == 0) {
            X(jSONObject);
        }
    }

    private final void X(JSONObject jSONObject) {
        String optString = jSONObject.optString("uk");
        f.c(Long.valueOf(jSONObject.optLong("refresh_time")));
        com.baidu.swan.apps.storage.c.b any = com.baidu.swan.apps.storage.c.h.any();
        any.putString("alliance_login_uk", optString);
        Long Rg = f.Rg();
        if (Rg != null) {
            any.putLong("ma_bduss_refresh_time", Rg.longValue());
        }
    }

    private final String Rl() {
        com.baidu.swan.apps.storage.c.b any = com.baidu.swan.apps.storage.c.h.any();
        if (any != null) {
            return any.getString("alliance_login_uk", null);
        }
        return null;
    }

    public final String getUid() {
        String str = bAY;
        if (str == null || l.isBlank(str)) {
            bAY = Rl();
        }
        return bAY;
    }

    public final void Rm() {
        com.baidu.swan.apps.storage.c.h.any().putString("alliance_login_uk", "");
        bAY = null;
    }
}
