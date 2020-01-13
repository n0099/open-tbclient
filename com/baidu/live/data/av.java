package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class av {
    public int abE;
    public int abF;
    public int abG;

    public av(JSONObject jSONObject) {
        this.abE = jSONObject.optInt("show_times_daily");
        this.abF = jSONObject.optInt("continue_show_times");
        this.abG = jSONObject.optInt("condition");
    }
}
