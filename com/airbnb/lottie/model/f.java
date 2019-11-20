package com.airbnb.lottie.model;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    private final String fM;
    private final float fN;
    private final String name;
    private final String style;

    f(String str, String str2, String str3, float f) {
        this.fM = str;
        this.name = str2;
        this.style = str3;
        this.fN = f;
    }

    public String bV() {
        return this.fM;
    }

    public String getName() {
        return this.name;
    }

    public String bW() {
        return this.style;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static f f(JSONObject jSONObject) {
            return new f(jSONObject.optString("fFamily"), jSONObject.optString("fName"), jSONObject.optString("fStyle"), (float) jSONObject.optDouble("ascent"));
        }
    }
}
