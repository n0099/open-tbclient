package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bg {
    public int aNs;
    public int aNt;
    public int aNu;
    public String aNv;

    public static bg y(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        bg bgVar = new bg();
        bgVar.aNs = jSONObject.optInt("supernatant_time") * 1000;
        bgVar.aNt = jSONObject.optInt("suoernatant_shownum");
        bgVar.aNu = jSONObject.optInt("pop_window_time") * 1000;
        bgVar.aNv = jSONObject.optString("guide_follow_text");
        return bgVar;
    }
}
