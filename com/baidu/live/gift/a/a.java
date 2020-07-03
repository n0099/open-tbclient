package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String aMa;
    public String aMb;
    public String aMc;
    public String aMd;

    public a(String str, String str2, String str3, String str4) {
        this.aMa = str;
        this.aMb = str2;
        this.aMc = str3;
        this.aMd = str4;
    }

    public static a C(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
