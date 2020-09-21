package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class by {
    public int aMl;
    public int aMm;
    public int aMn;
    public String aMo;
    public int isShow;
    public int showNum;

    public by(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aMl = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aMm = jSONObject.optInt("time_threshold");
        this.aMn = jSONObject.optInt("gift_board_free_category_id");
        this.aMo = jSONObject.optString("gift_board_free_category_name");
    }
}
