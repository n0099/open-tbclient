package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cc {
    public int aQN;
    public int aQO;
    public int aQb;

    public cc(JSONObject jSONObject) {
        this.aQN = jSONObject.optInt("show_times_daily");
        this.aQO = jSONObject.optInt("continue_show_times");
        this.aQb = jSONObject.optInt("condition");
    }
}
