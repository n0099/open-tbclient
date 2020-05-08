package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String aDV;
    public String aDW;
    public String aDX;
    public String aDY;

    public a(String str, String str2, String str3, String str4) {
        this.aDV = str;
        this.aDW = str2;
        this.aDX = str3;
        this.aDY = str4;
    }

    public static a w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
