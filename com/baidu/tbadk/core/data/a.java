package com.baidu.tbadk.core.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    private int a;
    private String b;
    private String c;

    public final String a() {
        return this.b;
    }

    public final String b() {
        return String.valueOf(this.a);
    }

    public final String c() {
        return this.c;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("badge_id", 0);
                this.b = jSONObject.optString("badge_url", "");
                this.c = jSONObject.optString("webview");
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("BadgeData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
