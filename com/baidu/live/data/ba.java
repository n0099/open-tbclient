package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ba {
    public int awq;
    public int awr;
    public int aws;

    public ba(JSONObject jSONObject) {
        this.awq = jSONObject.optInt("show_times_daily");
        this.awr = jSONObject.optInt("continue_show_times");
        this.aws = jSONObject.optInt("condition");
    }
}
