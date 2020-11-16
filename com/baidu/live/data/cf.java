package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cf {
    public int aPr;
    public int aPs;
    public int aPt;
    public String aPu;
    public int isShow;
    public int showNum;

    public cf(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aPr = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aPs = jSONObject.optInt("time_threshold");
        this.aPt = jSONObject.optInt("gift_board_free_category_id");
        this.aPu = jSONObject.optString("gift_board_free_category_name");
    }
}
