package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ce {
    public int aRq;
    public int aSe;
    public int aSf;

    public ce(JSONObject jSONObject) {
        this.aSe = jSONObject.optInt("show_times_daily");
        this.aSf = jSONObject.optInt("continue_show_times");
        this.aRq = jSONObject.optInt("condition");
    }
}
