package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bd {
    public String awA;
    public int awx;
    public int awy;
    public int awz;
    public int isShow;
    public int showNum;

    public bd(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.awx = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.awy = jSONObject.optInt("time_threshold");
        this.awz = jSONObject.optInt("gift_board_free_category_id");
        this.awA = jSONObject.optString("gift_board_free_category_name");
    }
}
