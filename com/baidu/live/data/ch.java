package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ch {
    public int aSt;
    public int aSu;
    public int aSv;
    public String aSw;
    public int isShow;
    public int showNum;

    public ch(JSONObject jSONObject) {
        this.isShow = jSONObject.optInt("is_show");
        this.aSt = jSONObject.optInt("is_judge_taskSystemUser");
        this.showNum = jSONObject.optInt("show_num");
        this.aSu = jSONObject.optInt("time_threshold");
        this.aSv = jSONObject.optInt("gift_board_free_category_id");
        this.aSw = jSONObject.optString("gift_board_free_category_name");
    }
}
