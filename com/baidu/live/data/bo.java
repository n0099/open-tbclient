package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bo {
    public int aPr;
    public int aPs;
    public int aPt;
    public String aPu;

    public static bo E(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        bo boVar = new bo();
        boVar.aPr = jSONObject.optInt("supernatant_time") * 1000;
        boVar.aPs = jSONObject.optInt("suoernatant_shownum");
        boVar.aPt = jSONObject.optInt("pop_window_time") * 1000;
        boVar.aPu = jSONObject.optString("guide_follow_text");
        return boVar;
    }
}
