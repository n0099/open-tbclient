package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aUV;
    public String aUW;
    public String aUX;
    public String aUY;

    public a(String str, String str2, String str3, String str4) {
        this.aUV = str;
        this.aUW = str2;
        this.aUX = str3;
        this.aUY = str4;
    }

    public static a F(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
