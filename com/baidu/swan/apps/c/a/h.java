package com.baidu.swan.apps.c.a;

import kotlin.jvm.internal.q;
import kotlin.text.l;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class h {
    private static String aYg;
    public static final h aYh = new h();

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
        com.baidu.swan.apps.storage.c.b adb = com.baidu.swan.apps.storage.c.h.adb();
        adb.putString("alliance_login_uk", optString);
        Long Hb = f.Hb();
        if (Hb != null) {
            adb.putLong("ma_bduss_refresh_time", Hb.longValue());
        }
    }

    private final String Hg() {
        com.baidu.swan.apps.storage.c.b adb = com.baidu.swan.apps.storage.c.h.adb();
        if (adb != null) {
            return adb.getString("alliance_login_uk", null);
        }
        return null;
    }

    public final String getUid() {
        String str = aYg;
        if (str == null || l.isBlank(str)) {
            aYg = Hg();
        }
        return aYg;
    }

    public final void Hh() {
        com.baidu.swan.apps.storage.c.h.adb().putString("alliance_login_uk", "");
        aYg = null;
    }
}
