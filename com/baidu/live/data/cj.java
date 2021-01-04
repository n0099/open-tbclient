package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class cj {
    public int aTr;
    public int aTs;
    public int aTt;
    public String aTu;
    public int isShow;
    public int showNum;

    public cj(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aTr = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aTs = jSONObject.optInt("time_threshold");
        this.aTt = jSONObject.optInt("gift_board_free_category_id");
        this.aTu = jSONObject.optString("gift_board_free_category_name");
    }
}
