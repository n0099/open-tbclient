package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bn {
    public int aKq;
    public int aKr;
    public int aKs;

    public bn(JSONObject jSONObject) {
        this.aKq = jSONObject.optInt("show_times_daily");
        this.aKr = jSONObject.optInt("continue_show_times");
        this.aKs = jSONObject.optInt("condition");
    }
}
