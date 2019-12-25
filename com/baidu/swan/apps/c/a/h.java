package com.baidu.swan.apps.c.a;

import kotlin.jvm.internal.p;
import kotlin.text.l;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class h {
    private static String aXo;
    public static final h aXp = new h();

    private h() {
    }

    public final void d(int i, JSONObject jSONObject) {
        p.j(jSONObject, "jsonObject");
        if (i == 0) {
            M(jSONObject);
        }
    }

    private final void M(JSONObject jSONObject) {
        String optString = jSONObject.optString("uk");
        f.c(Long.valueOf(jSONObject.optLong("refresh_time")));
        com.baidu.swan.apps.storage.c.b acE = com.baidu.swan.apps.storage.c.h.acE();
        acE.putString("alliance_login_uk", optString);
        Long GF = f.GF();
        if (GF != null) {
            acE.putLong("ma_bduss_refresh_time", GF.longValue());
        }
    }

    private final String GK() {
        com.baidu.swan.apps.storage.c.b acE = com.baidu.swan.apps.storage.c.h.acE();
        if (acE != null) {
            return acE.getString("alliance_login_uk", null);
        }
        return null;
    }

    public final String getUid() {
        String str = aXo;
        if (str == null || l.isBlank(str)) {
            aXo = GK();
        }
        return aXo;
    }

    public final void GL() {
        com.baidu.swan.apps.storage.c.h.acE().putString("alliance_login_uk", "");
        aXo = null;
    }
}
