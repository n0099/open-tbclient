package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ba {
    public int awk;
    public int awl;
    public int awm;

    public ba(JSONObject jSONObject) {
        this.awk = jSONObject.optInt("show_times_daily");
        this.awl = jSONObject.optInt("continue_show_times");
        this.awm = jSONObject.optInt("condition");
    }
}
