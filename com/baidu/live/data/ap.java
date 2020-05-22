package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ap {
    public int aAi;
    public int aAj;
    public int aAk;
    public String aAl;

    public static ap x(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ap apVar = new ap();
        apVar.aAi = jSONObject.optInt("supernatant_time") * 1000;
        apVar.aAj = jSONObject.optInt("suoernatant_shownum");
        apVar.aAk = jSONObject.optInt("pop_window_time") * 1000;
        apVar.aAl = jSONObject.optString("guide_follow_text");
        return apVar;
    }
}
