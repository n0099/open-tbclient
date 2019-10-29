package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class an {
    public int UT;
    public int UU;
    public int UV;
    public String UW;
    public int isShow;
    public int showNum;

    public an(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.UT = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.UU = jSONObject.optInt("time_threshold");
        this.UV = jSONObject.optInt("gift_board_free_category_id");
        this.UW = jSONObject.optString("gift_board_free_category_name");
    }
}
