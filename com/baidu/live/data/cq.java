package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cq {
    public int aTg;
    public int aTh;
    public int aTi;
    public String aTj;
    public int isShow;
    public int showNum;

    public cq(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aTg = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aTh = jSONObject.optInt("time_threshold");
        this.aTi = jSONObject.optInt("gift_board_free_category_id");
        this.aTj = jSONObject.optString("gift_board_free_category_name");
    }
}
