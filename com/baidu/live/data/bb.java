package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bb {
    public int aKq;
    public int aKr;
    public int aKs;
    public String aKt;

    public static bb B(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        bb bbVar = new bb();
        bbVar.aKq = jSONObject.optInt("supernatant_time") * 1000;
        bbVar.aKr = jSONObject.optInt("suoernatant_shownum");
        bbVar.aKs = jSONObject.optInt("pop_window_time") * 1000;
        bbVar.aKt = jSONObject.optString("guide_follow_text");
        return bbVar;
    }
}
