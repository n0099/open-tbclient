package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class au {
    public int abH;
    public int abI;
    public int abJ;
    public String abK;
    public int isShow;
    public int showNum;

    public au(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.abH = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.abI = jSONObject.optInt("time_threshold");
        this.abJ = jSONObject.optInt("gift_board_free_category_id");
        this.abK = jSONObject.optString("gift_board_free_category_name");
    }
}
