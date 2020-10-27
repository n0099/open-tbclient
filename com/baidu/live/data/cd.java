package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cd {
    public int aQa;
    public int aQb;
    public int aQc;
    public String aQd;
    public int isShow;
    public int showNum;

    public cd(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aQa = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aQb = jSONObject.optInt("time_threshold");
        this.aQc = jSONObject.optInt("gift_board_free_category_id");
        this.aQd = jSONObject.optString("gift_board_free_category_name");
    }
}
