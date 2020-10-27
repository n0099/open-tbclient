package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ca {
    public int aPL;
    public int aPM;
    public int aPe;

    public ca(JSONObject jSONObject) {
        this.aPL = jSONObject.optInt("show_times_daily");
        this.aPM = jSONObject.optInt("continue_show_times");
        this.aPe = jSONObject.optInt("condition");
    }
}
