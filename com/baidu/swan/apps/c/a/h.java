package com.baidu.swan.apps.c.a;

import kotlin.jvm.internal.q;
import kotlin.text.l;
import org.json.JSONObject;
@kotlin.h
/* loaded from: classes11.dex */
public final class h {
    private static String bcq;
    public static final h bcr = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        q.j(jSONObject, "jsonObject");
        if (i == 0) {
            M(jSONObject);
        }
    }

    private final void M(JSONObject jSONObject) {
        String optString = jSONObject.optString("uk");
        f.c(Long.valueOf(jSONObject.optLong("refresh_time")));
        com.baidu.swan.apps.storage.c.b afp = com.baidu.swan.apps.storage.c.h.afp();
        afp.putString("alliance_login_uk", optString);
        Long Jq = f.Jq();
        if (Jq != null) {
            afp.putLong("ma_bduss_refresh_time", Jq.longValue());
        }
    }

    private final String Jv() {
        com.baidu.swan.apps.storage.c.b afp = com.baidu.swan.apps.storage.c.h.afp();
        if (afp != null) {
            return afp.getString("alliance_login_uk", null);
        }
        return null;
    }

    public final String getUid() {
        String str = bcq;
        if (str == null || l.isBlank(str)) {
            bcq = Jv();
        }
        return bcq;
    }

    public final void Jw() {
        com.baidu.swan.apps.storage.c.h.afp().putString("alliance_login_uk", "");
        bcq = null;
    }
}
