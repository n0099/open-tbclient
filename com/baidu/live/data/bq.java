package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bq {
    public int aKE;
    public int aKF;
    public int aKG;
    public String aKH;
    public int isShow;
    public int showNum;

    public bq(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aKE = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aKF = jSONObject.optInt("time_threshold");
        this.aKG = jSONObject.optInt("gift_board_free_category_id");
        this.aKH = jSONObject.optString("gift_board_free_category_name");
    }
}
