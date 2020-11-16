package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cc {
    public int aOq;
    public int aPc;
    public int aPd;

    public cc(JSONObject jSONObject) {
        this.aPc = jSONObject.optInt("show_times_daily");
        this.aPd = jSONObject.optInt("continue_show_times");
        this.aOq = jSONObject.optInt("condition");
    }
}
