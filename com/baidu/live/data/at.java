package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class at {
    public int aCt;
    public int aCu;
    public int aCv;
    public String aCw;

    public static at z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        at atVar = new at();
        atVar.aCt = jSONObject.optInt("supernatant_time") * 1000;
        atVar.aCu = jSONObject.optInt("suoernatant_shownum");
        atVar.aCv = jSONObject.optInt("pop_window_time") * 1000;
        atVar.aCw = jSONObject.optString("guide_follow_text");
        return atVar;
    }
}
