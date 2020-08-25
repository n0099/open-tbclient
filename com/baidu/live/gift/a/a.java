package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public String aSI;
    public String aSJ;
    public String aSK;
    public String aSL;

    public a(String str, String str2, String str3, String str4) {
        this.aSI = str;
        this.aSJ = str2;
        this.aSK = str3;
        this.aSL = str4;
    }

    public static a E(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
