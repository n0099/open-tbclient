package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bb {
    public int aNv;
    public int aNw;
    public int aNx;
    public String aNy;

    public static bb B(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        bb bbVar = new bb();
        bbVar.aNv = jSONObject.optInt("supernatant_time") * 1000;
        bbVar.aNw = jSONObject.optInt("suoernatant_shownum");
        bbVar.aNx = jSONObject.optInt("pop_window_time") * 1000;
        bbVar.aNy = jSONObject.optString("guide_follow_text");
        return bbVar;
    }
}
