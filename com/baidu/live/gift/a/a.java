package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String aDP;
    public String aDQ;
    public String aDR;
    public String aDS;

    public a(String str, String str2, String str3, String str4) {
        this.aDP = str;
        this.aDQ = str2;
        this.aDR = str3;
        this.aDS = str4;
    }

    public static a w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
