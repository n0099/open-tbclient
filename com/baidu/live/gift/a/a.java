package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String alp;
    public String alq;
    public String alr;
    public String als;

    public a(String str, String str2, String str3, String str4) {
        this.alp = str;
        this.alq = str2;
        this.alr = str3;
        this.als = str4;
    }

    public static a q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
