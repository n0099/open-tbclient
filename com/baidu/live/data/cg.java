package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cg {
    public int aNs;
    public int aOm;
    public int aOn;

    public cg(JSONObject jSONObject) {
        this.aOm = jSONObject.optInt("show_times_daily");
        this.aOn = jSONObject.optInt("continue_show_times");
        this.aNs = jSONObject.optInt("condition");
    }
}
