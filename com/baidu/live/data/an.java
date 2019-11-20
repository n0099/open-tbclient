package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class an {
    public String UB;
    public int Ux;
    public int Uy;
    public int Uz;
    public int isShow;
    public int showNum;

    public an(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.Ux = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.Uy = jSONObject.optInt("time_threshold");
        this.Uz = jSONObject.optInt("gift_board_free_category_id");
        this.UB = jSONObject.optString("gift_board_free_category_name");
    }
}
