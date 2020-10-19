package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bv {
    public int aOz;
    public int aPb;
    public int aPc;

    public bv(JSONObject jSONObject) {
        this.aPb = jSONObject.optInt("show_times_daily");
        this.aPc = jSONObject.optInt("continue_show_times");
        this.aOz = jSONObject.optInt("condition");
    }
}
