package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public String ajh;
    public String aji;
    public String ajj;
    public String ajk;

    public a(String str, String str2, String str3, String str4) {
        this.ajh = str;
        this.aji = str2;
        this.ajj = str3;
        this.ajk = str4;
    }

    public static a q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
