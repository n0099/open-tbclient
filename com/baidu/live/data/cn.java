package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cn {
    public int aRT;
    public int aSP;
    public int aSQ;

    public cn(JSONObject jSONObject) {
        this.aSP = jSONObject.optInt("show_times_daily");
        this.aSQ = jSONObject.optInt("continue_show_times");
        this.aRT = jSONObject.optInt("condition");
    }
}
