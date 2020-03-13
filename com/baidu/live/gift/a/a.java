package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String alq;
    public String alr;
    public String als;
    public String alt;

    public a(String str, String str2, String str3, String str4) {
        this.alq = str;
        this.alr = str2;
        this.als = str3;
        this.alt = str4;
    }

    public static a q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
