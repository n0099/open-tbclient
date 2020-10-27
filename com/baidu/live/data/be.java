package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class be {
    public int aOa;
    public int aOb;
    public int aOc;
    public String aOd;

    public static be B(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        be beVar = new be();
        beVar.aOa = jSONObject.optInt("supernatant_time") * 1000;
        beVar.aOb = jSONObject.optInt("suoernatant_shownum");
        beVar.aOc = jSONObject.optInt("pop_window_time") * 1000;
        beVar.aOd = jSONObject.optString("guide_follow_text");
        return beVar;
    }
}
