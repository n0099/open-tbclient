package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bj {
    public int aMt;
    public int aMu;
    public int aMv;
    public String aMw;

    public static bj E(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        bj bjVar = new bj();
        bjVar.aMt = jSONObject.optInt("supernatant_time") * 1000;
        bjVar.aMu = jSONObject.optInt("suoernatant_shownum");
        bjVar.aMv = jSONObject.optInt("pop_window_time") * 1000;
        bjVar.aMw = jSONObject.optString("guide_follow_text");
        return bjVar;
    }
}
