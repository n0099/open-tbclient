package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cn {
    public int aQt;
    public int aRp;
    public int aRq;

    public cn(JSONObject jSONObject) {
        this.aRp = jSONObject.optInt("show_times_daily");
        this.aRq = jSONObject.optInt("continue_show_times");
        this.aQt = jSONObject.optInt("condition");
    }
}
