package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bj {
    public int aRg;
    public int aRh;
    public int aRi;
    public String aRj;

    public static bj E(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        bj bjVar = new bj();
        bjVar.aRg = jSONObject.optInt("supernatant_time") * 1000;
        bjVar.aRh = jSONObject.optInt("suoernatant_shownum");
        bjVar.aRi = jSONObject.optInt("pop_window_time") * 1000;
        bjVar.aRj = jSONObject.optString("guide_follow_text");
        return bjVar;
    }
}
