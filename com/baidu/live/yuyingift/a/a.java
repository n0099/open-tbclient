package com.baidu.live.yuyingift.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String baU;
    public String baV;
    public String baW;
    public String baX;

    public a(String str, String str2, String str3, String str4) {
        this.baU = str;
        this.baV = str2;
        this.baW = str3;
        this.baX = str4;
    }

    public static a ak(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
