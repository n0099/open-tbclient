package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bk {
    public int aDK;
    public int aDL;
    public int aDM;

    public bk(JSONObject jSONObject) {
        this.aDK = jSONObject.optInt("show_times_daily");
        this.aDL = jSONObject.optInt("continue_show_times");
        this.aDM = jSONObject.optInt("condition");
    }
}
