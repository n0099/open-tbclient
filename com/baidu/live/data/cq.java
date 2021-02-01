package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cq {
    public int aRG;
    public int aRH;
    public int aRI;
    public String aRJ;
    public int isShow;
    public int showNum;

    public cq(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aRG = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aRH = jSONObject.optInt("time_threshold");
        this.aRI = jSONObject.optInt("gift_board_free_category_id");
        this.aRJ = jSONObject.optString("gift_board_free_category_name");
    }
}
