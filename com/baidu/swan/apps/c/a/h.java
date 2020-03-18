package com.baidu.swan.apps.c.a;

import kotlin.jvm.internal.q;
import kotlin.text.l;
import org.json.JSONObject;
@kotlin.h
/* loaded from: classes11.dex */
public final class h {
    private static String bcF;
    public static final h bcG = new h();

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
        com.baidu.swan.apps.storage.c.b afu = com.baidu.swan.apps.storage.c.h.afu();
        afu.putString("alliance_login_uk", optString);
        Long Jv = f.Jv();
        if (Jv != null) {
            afu.putLong("ma_bduss_refresh_time", Jv.longValue());
        }
    }

    private final String JA() {
        com.baidu.swan.apps.storage.c.b afu = com.baidu.swan.apps.storage.c.h.afu();
        if (afu != null) {
            return afu.getString("alliance_login_uk", null);
        }
        return null;
    }

    public final String getUid() {
        String str = bcF;
        if (str == null || l.isBlank(str)) {
            bcF = JA();
        }
        return bcF;
    }

    public final void JB() {
        com.baidu.swan.apps.storage.c.h.afu().putString("alliance_login_uk", "");
        bcF = null;
    }
}
