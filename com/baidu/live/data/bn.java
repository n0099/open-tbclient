package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bn {
    public int aDY;
    public int aDZ;
    public int aEa;
    public String aEb;
    public int isShow;
    public int showNum;

    public bn(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aDY = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aDZ = jSONObject.optInt("time_threshold");
        this.aEa = jSONObject.optInt("gift_board_free_category_id");
        this.aEb = jSONObject.optString("gift_board_free_category_name");
    }
}
