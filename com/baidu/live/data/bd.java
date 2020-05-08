package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bd {
    public int awD;
    public int awE;
    public int awF;
    public String awG;
    public int isShow;
    public int showNum;

    public bd(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.awD = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.awE = jSONObject.optInt("time_threshold");
        this.awF = jSONObject.optInt("gift_board_free_category_id");
        this.awG = jSONObject.optString("gift_board_free_category_name");
    }
}
