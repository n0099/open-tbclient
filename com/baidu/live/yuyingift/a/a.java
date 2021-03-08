package com.baidu.live.yuyingift.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String beh;
    public String bei;
    public String bej;
    public String bek;

    public a(String str, String str2, String str3, String str4) {
        this.beh = str;
        this.bei = str2;
        this.bej = str3;
        this.bek = str4;
    }

    public static a as(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
