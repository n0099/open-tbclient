package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aZB;
    public String aZC;
    public String aZD;
    public String aZE;

    public a(String str, String str2, String str3, String str4) {
        this.aZB = str;
        this.aZC = str2;
        this.aZD = str3;
        this.aZE = str4;
    }

    public static a H(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
