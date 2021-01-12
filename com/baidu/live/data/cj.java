package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class cj {
    public int aOE;
    public int aOF;
    public int aOG;
    public String aOH;
    public int isShow;
    public int showNum;

    public cj(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aOE = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aOF = jSONObject.optInt("time_threshold");
        this.aOG = jSONObject.optInt("gift_board_free_category_id");
        this.aOH = jSONObject.optString("gift_board_free_category_name");
    }
}
