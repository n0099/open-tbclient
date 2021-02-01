package com.baidu.live.gift.a;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String bcG;
    public String bcH;
    public String bcI;
    public String bcJ;

    public a(String str, String str2, String str3, String str4) {
        this.bcG = str;
        this.bcH = str2;
        this.bcI = str3;
        this.bcJ = str4;
    }

    public static a L(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new a(jSONObject.optString("title"), jSONObject.optString("showText"), jSONObject.optString("leftButtonText"), jSONObject.optString("rightButtonText"));
    }
}
