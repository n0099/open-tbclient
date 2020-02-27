package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ax {
    public int adJ;
    public int adK;
    public int adL;

    public ax(JSONObject jSONObject) {
        this.adJ = jSONObject.optInt("show_times_daily");
        this.adK = jSONObject.optInt("continue_show_times");
        this.adL = jSONObject.optInt("condition");
    }
}
