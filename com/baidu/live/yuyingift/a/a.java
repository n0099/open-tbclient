package com.baidu.live.yuyingift.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String bcF;
    public String bcG;
    public String bcH;
    public String bcI;

    public a(String str, String str2, String str3, String str4) {
        this.bcF = str;
        this.bcG = str2;
        this.bcH = str3;
        this.bcI = str4;
    }

    public static a ag(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
