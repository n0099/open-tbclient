package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String alA;
    public String alB;
    public String alC;
    public String alD;

    public a(String str, String str2, String str3, String str4) {
        this.alA = str;
        this.alB = str2;
        this.alC = str3;
        this.alD = str4;
    }

    public static a q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
