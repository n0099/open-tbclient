package com.baidu.swan.apps.c.a;

import kotlin.jvm.internal.q;
import kotlin.text.l;
import org.json.JSONObject;
@kotlin.h
/* loaded from: classes11.dex */
public final class h {
    private static String bcs;
    public static final h bct = new h();

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
        com.baidu.swan.apps.storage.c.b afr = com.baidu.swan.apps.storage.c.h.afr();
        afr.putString("alliance_login_uk", optString);
        Long Js = f.Js();
        if (Js != null) {
            afr.putLong("ma_bduss_refresh_time", Js.longValue());
        }
    }

    private final String Jx() {
        com.baidu.swan.apps.storage.c.b afr = com.baidu.swan.apps.storage.c.h.afr();
        if (afr != null) {
            return afr.getString("alliance_login_uk", null);
        }
        return null;
    }

    public final String getUid() {
        String str = bcs;
        if (str == null || l.isBlank(str)) {
            bcs = Jx();
        }
        return bcs;
    }

    public final void Jy() {
        com.baidu.swan.apps.storage.c.h.afr().putString("alliance_login_uk", "");
        bcs = null;
    }
}
