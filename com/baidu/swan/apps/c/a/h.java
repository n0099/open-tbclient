package com.baidu.swan.apps.c.a;

import kotlin.jvm.internal.q;
import kotlin.text.l;
import org.json.JSONObject;
@kotlin.h
/* loaded from: classes11.dex */
public final class h {
    private static String bAT;
    public static final h bAU = new h();

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
        com.baidu.swan.apps.storage.c.b anz = com.baidu.swan.apps.storage.c.h.anz();
        anz.putString("alliance_login_uk", optString);
        Long Rh = f.Rh();
        if (Rh != null) {
            anz.putLong("ma_bduss_refresh_time", Rh.longValue());
        }
    }

    private final String Rm() {
        com.baidu.swan.apps.storage.c.b anz = com.baidu.swan.apps.storage.c.h.anz();
        if (anz != null) {
            return anz.getString("alliance_login_uk", null);
        }
        return null;
    }

    public final String getUid() {
        String str = bAT;
        if (str == null || l.isBlank(str)) {
            bAT = Rm();
        }
        return bAT;
    }

    public final void Rn() {
        com.baidu.swan.apps.storage.c.h.anz().putString("alliance_login_uk", "");
        bAT = null;
    }
}
