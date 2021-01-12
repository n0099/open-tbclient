package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String aZA;
    public String aZB;
    public String aZC;
    public String aZz;

    public a(String str, String str2, String str3, String str4) {
        this.aZz = str;
        this.aZA = str2;
        this.aZB = str3;
        this.aZC = str4;
    }

    public static a L(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
