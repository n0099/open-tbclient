package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bv {
    public int aLW;
    public int aLX;
    public int aLu;

    public bv(JSONObject jSONObject) {
        this.aLW = jSONObject.optInt("show_times_daily");
        this.aLX = jSONObject.optInt("continue_show_times");
        this.aLu = jSONObject.optInt("condition");
    }
}
