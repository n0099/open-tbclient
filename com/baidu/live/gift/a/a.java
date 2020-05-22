package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String aJu;
    public String aJv;
    public String aJw;
    public String aJx;

    public a(String str, String str2, String str3, String str4) {
        this.aJu = str;
        this.aJv = str2;
        this.aJw = str3;
        this.aJx = str4;
    }

    public static a A(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
