package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class by {
    public int aPq;
    public int aPr;
    public int aPs;
    public String aPt;
    public int isShow;
    public int showNum;

    public by(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aPq = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aPr = jSONObject.optInt("time_threshold");
        this.aPs = jSONObject.optInt("gift_board_free_category_id");
        this.aPt = jSONObject.optString("gift_board_free_category_name");
    }
}
