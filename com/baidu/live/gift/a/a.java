package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String beo;
    public String bep;
    public String beq;
    public String ber;

    public a(String str, String str2, String str3, String str4) {
        this.beo = str;
        this.bep = str2;
        this.beq = str3;
        this.ber = str4;
    }

    public static a L(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
