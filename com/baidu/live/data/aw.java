package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class aw {
    public int aIY;
    public int aIZ;
    public int aJa;
    public String aJb;

    public static aw B(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        aw awVar = new aw();
        awVar.aIY = jSONObject.optInt("supernatant_time") * 1000;
        awVar.aIZ = jSONObject.optInt("suoernatant_shownum");
        awVar.aJa = jSONObject.optInt("pop_window_time") * 1000;
        awVar.aJb = jSONObject.optString("guide_follow_text");
        return awVar;
    }
}
