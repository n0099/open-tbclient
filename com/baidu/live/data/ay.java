package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ay {
    public int abS;
    public int abT;
    public int abU;
    public String abV;
    public int isShow;
    public int showNum;

    public ay(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.abS = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.abT = jSONObject.optInt("time_threshold");
        this.abU = jSONObject.optInt("gift_board_free_category_id");
        this.abV = jSONObject.optString("gift_board_free_category_name");
    }
}
