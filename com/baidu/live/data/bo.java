package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bo {
    public int aFs;
    public int aFt;
    public int aFu;
    public String aFv;
    public int isShow;
    public int showNum;

    public bo(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aFs = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aFt = jSONObject.optInt("time_threshold");
        this.aFu = jSONObject.optInt("gift_board_free_category_id");
        this.aFv = jSONObject.optString("gift_board_free_category_name");
    }
}
