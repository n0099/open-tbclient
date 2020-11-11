package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class cf {
    public int aRc;
    public int aRd;
    public int aRe;
    public String aRf;
    public int isShow;
    public int showNum;

    public cf(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aRc = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aRd = jSONObject.optInt("time_threshold");
        this.aRe = jSONObject.optInt("gift_board_free_category_id");
        this.aRf = jSONObject.optString("gift_board_free_category_name");
    }
}
