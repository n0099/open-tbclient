package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aNv;
    public String aNw;
    public String aNx;
    public String aNy;

    public a(String str, String str2, String str3, String str4) {
        this.aNv = str;
        this.aNw = str2;
        this.aNx = str3;
        this.aNy = str4;
    }

    public static a C(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
