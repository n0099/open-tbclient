package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bh {
    public int aQr;
    public int aQs;
    public int aQt;
    public String aQu;

    public static bh y(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        bh bhVar = new bh();
        bhVar.aQr = jSONObject.optInt("supernatant_time") * 1000;
        bhVar.aQs = jSONObject.optInt("suoernatant_shownum");
        bhVar.aQt = jSONObject.optInt("pop_window_time") * 1000;
        bhVar.aQu = jSONObject.optString("guide_follow_text");
        return bhVar;
    }
}
