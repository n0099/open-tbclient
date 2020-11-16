package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bf {
    public String aNc;
    public String aNd;
    public JSONObject aNe;
    public JSONObject aNf;
    public JSONObject aNg;
    public JSONObject aNh;
    public String aNi;
    public String aNj;
    public int aNk;
    public String aNl;
    public int aNm;
    public int aNn;
    public int aNo;
    public int aNp;
    public String aNq;
    public String aNr;

    public bf(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNk = jSONObject.optInt("join_amount");
            this.aNc = jSONObject.optString("guard_club_category");
            this.aNd = jSONObject.optString("guard_club_gift_type");
            this.aNe = jSONObject.optJSONObject("club_level_icon_large");
            this.aNf = jSONObject.optJSONObject("club_level_icon_small");
            this.aNg = jSONObject.optJSONObject("member_level_icon");
            this.aNh = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.aNi = optJSONObject.optString("to_join");
                this.aNj = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aNl = optJSONObject2.optString("guide_text");
                this.aNm = optJSONObject2.optInt("show_times_daily");
                this.aNn = optJSONObject2.optInt("continue_show_times");
                this.aNo = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aNp = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aNq = optJSONObject4.optString("attenuat_tip_img");
                this.aNr = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
