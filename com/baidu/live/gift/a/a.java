package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aYg;
    public String aYh;
    public String aYi;
    public String aYj;

    public a(String str, String str2, String str3, String str4) {
        this.aYg = str;
        this.aYh = str2;
        this.aYi = str3;
        this.aYj = str4;
    }

    public static a F(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
