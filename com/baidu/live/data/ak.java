package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ak {
    public int UF;
    public int UG;
    public int UH;

    public ak(JSONObject jSONObject) {
        this.UF = jSONObject.optInt("show_times_daily");
        this.UG = jSONObject.optInt("continue_show_times");
        this.UH = jSONObject.optInt("condition");
    }
}
