package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ak {
    public int Ul;
    public int Um;
    public int Un;

    public ak(JSONObject jSONObject) {
        this.Ul = jSONObject.optInt("show_times_daily");
        this.Um = jSONObject.optInt("continue_show_times");
        this.Un = jSONObject.optInt("condition");
    }
}
