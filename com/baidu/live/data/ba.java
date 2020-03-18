package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ba {
    public int aeh;
    public int aei;
    public int aej;
    public String aek;
    public int isShow;
    public int showNum;

    public ba(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aeh = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aei = jSONObject.optInt("time_threshold");
        this.aej = jSONObject.optInt("gift_board_free_category_id");
        this.aek = jSONObject.optString("gift_board_free_category_name");
    }
}
