package com.baidu.tbadk.core.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public final class q {
    private int a = 0;
    private int b = 0;
    private String c = "";

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optInt("is_lpost", 0);
                this.b = jSONObject.optInt("topic_type", 0);
                this.c = jSONObject.optString("link", "");
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
