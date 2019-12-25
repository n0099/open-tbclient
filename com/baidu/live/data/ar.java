package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ar {
    public int abt;
    public int abu;
    public int abv;

    public ar(JSONObject jSONObject) {
        this.abt = jSONObject.optInt("show_times_daily");
        this.abu = jSONObject.optInt("continue_show_times");
        this.abv = jSONObject.optInt("condition");
    }
}
