package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class aw {
    public int aJa;
    public int aJb;
    public int aJc;
    public String aJd;

    public static aw B(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        aw awVar = new aw();
        awVar.aJa = jSONObject.optInt("supernatant_time") * 1000;
        awVar.aJb = jSONObject.optInt("suoernatant_shownum");
        awVar.aJc = jSONObject.optInt("pop_window_time") * 1000;
        awVar.aJd = jSONObject.optString("guide_follow_text");
        return awVar;
    }
}
