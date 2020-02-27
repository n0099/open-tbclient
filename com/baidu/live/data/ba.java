package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ba {
    public int adX;
    public int adY;
    public int adZ;
    public String aea;
    public int isShow;
    public int showNum;

    public ba(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.adX = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.adY = jSONObject.optInt("time_threshold");
        this.adZ = jSONObject.optInt("gift_board_free_category_id");
        this.aea = jSONObject.optString("gift_board_free_category_name");
    }
}
