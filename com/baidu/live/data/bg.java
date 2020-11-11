package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bg {
    public int aPd;
    public int aPe;
    public int aPf;
    public String aPg;

    public static bg E(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        bg bgVar = new bg();
        bgVar.aPd = jSONObject.optInt("supernatant_time") * 1000;
        bgVar.aPe = jSONObject.optInt("suoernatant_shownum");
        bgVar.aPf = jSONObject.optInt("pop_window_time") * 1000;
        bgVar.aPg = jSONObject.optString("guide_follow_text");
        return bgVar;
    }
}
