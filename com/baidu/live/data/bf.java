package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bf {
    public int aBA;
    public int aBB;
    public int aBz;

    public bf(JSONObject jSONObject) {
        this.aBz = jSONObject.optInt("show_times_daily");
        this.aBA = jSONObject.optInt("continue_show_times");
        this.aBB = jSONObject.optInt("condition");
    }
}
