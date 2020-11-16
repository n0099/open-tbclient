package com.baidu.live.yuyingift.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aZi;
    public String aZj;
    public String aZk;
    public String aZl;

    public a(String str, String str2, String str3, String str4) {
        this.aZi = str;
        this.aZj = str2;
        this.aZk = str3;
        this.aZl = str4;
    }

    public static a ae(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
