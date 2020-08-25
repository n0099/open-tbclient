package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class bq {
    public int aKC;
    public int aKD;
    public int aKE;
    public String aKF;
    public int isShow;
    public int showNum;

    public bq(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aKC = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aKD = jSONObject.optInt("time_threshold");
        this.aKE = jSONObject.optInt("gift_board_free_category_id");
        this.aKF = jSONObject.optString("gift_board_free_category_name");
    }
}
