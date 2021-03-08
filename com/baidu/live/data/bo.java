package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bo {
    public int aQR;
    public int aQS;
    public int aQT;
    public String aQU;

    public static bo G(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        bo boVar = new bo();
        boVar.aQR = jSONObject.optInt("supernatant_time") * 1000;
        boVar.aQS = jSONObject.optInt("suoernatant_shownum");
        boVar.aQT = jSONObject.optInt("pop_window_time") * 1000;
        boVar.aQU = jSONObject.optString("guide_follow_text");
        return boVar;
    }
}
