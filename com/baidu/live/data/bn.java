package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bn {
    public int aKo;
    public int aKp;
    public int aKq;

    public bn(JSONObject jSONObject) {
        this.aKo = jSONObject.optInt("show_times_daily");
        this.aKp = jSONObject.optInt("continue_show_times");
        this.aKq = jSONObject.optInt("condition");
    }
}
