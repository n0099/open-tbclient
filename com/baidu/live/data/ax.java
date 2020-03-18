package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ax {
    public int adT;
    public int adU;
    public int adV;

    public ax(JSONObject jSONObject) {
        this.adT = jSONObject.optInt("show_times_daily");
        this.adU = jSONObject.optInt("continue_show_times");
        this.adV = jSONObject.optInt("condition");
    }
}
