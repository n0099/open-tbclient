package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bg {
    public String aQb;
    public String aQc;
    public JSONObject aQd;
    public JSONObject aQe;
    public JSONObject aQf;
    public JSONObject aQg;
    public String aQh;
    public String aQi;
    public int aQj;
    public String aQk;
    public int aQl;
    public int aQm;
    public int aQn;
    public int aQo;
    public String aQp;
    public String aQq;

    public bg(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQj = jSONObject.optInt("join_amount");
            this.aQb = jSONObject.optString("guard_club_category");
            this.aQc = jSONObject.optString("guard_club_gift_type");
            this.aQd = jSONObject.optJSONObject("club_level_icon_large");
            this.aQe = jSONObject.optJSONObject("club_level_icon_small");
            this.aQf = jSONObject.optJSONObject("member_level_icon");
            this.aQg = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.aQh = optJSONObject.optString("to_join");
                this.aQi = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aQk = optJSONObject2.optString("guide_text");
                this.aQl = optJSONObject2.optInt("show_times_daily");
                this.aQm = optJSONObject2.optInt("continue_show_times");
                this.aQn = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aQo = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aQp = optJSONObject4.optString("attenuat_tip_img");
                this.aQq = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
