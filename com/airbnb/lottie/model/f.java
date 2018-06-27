package com.airbnb.lottie.model;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    private final float ascent;
    private final String name;
    private final String nn;
    private final String style;

    f(String str, String str2, String str3, float f) {
        this.nn = str;
        this.name = str2;
        this.style = str3;
        this.ascent = f;
    }

    public String getFamily() {
        return this.nn;
    }

    public String getName() {
        return this.name;
    }

    public String ci() {
        return this.style;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static f e(JSONObject jSONObject) {
            return new f(jSONObject.optString("fFamily"), jSONObject.optString("fName"), jSONObject.optString("fStyle"), (float) jSONObject.optDouble("ascent"));
        }
    }
}
