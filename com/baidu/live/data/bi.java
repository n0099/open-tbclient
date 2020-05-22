package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bi {
    public int aBN;
    public int aBO;
    public int aBP;
    public String aBQ;
    public int isShow;
    public int showNum;

    public bi(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aBN = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aBO = jSONObject.optInt("time_threshold");
        this.aBP = jSONObject.optInt("gift_board_free_category_id");
        this.aBQ = jSONObject.optString("gift_board_free_category_name");
    }
}
