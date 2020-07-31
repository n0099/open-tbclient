package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class au {
    public int aDO;
    public int aDP;
    public int aDQ;
    public String aDR;

    public static au z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        au auVar = new au();
        auVar.aDO = jSONObject.optInt("supernatant_time") * 1000;
        auVar.aDP = jSONObject.optInt("suoernatant_shownum");
        auVar.aDQ = jSONObject.optInt("pop_window_time") * 1000;
        auVar.aDR = jSONObject.optString("guide_follow_text");
        return auVar;
    }
}
