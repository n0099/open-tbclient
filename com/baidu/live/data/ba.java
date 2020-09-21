package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ba {
    public String aKa;
    public String aKb;
    public JSONObject aKc;
    public JSONObject aKd;
    public JSONObject aKe;
    public JSONObject aKf;
    public String aKg;
    public String aKh;
    public int aKi;
    public String aKj;
    public int aKk;
    public int aKl;
    public int aKm;
    public int aKn;
    public String aKo;
    public String aKp;

    public ba(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aKi = jSONObject.optInt("join_amount");
            this.aKa = jSONObject.optString("guard_club_category");
            this.aKb = jSONObject.optString("guard_club_gift_type");
            this.aKc = jSONObject.optJSONObject("club_level_icon_large");
            this.aKd = jSONObject.optJSONObject("club_level_icon_small");
            this.aKe = jSONObject.optJSONObject("member_level_icon");
            this.aKf = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.aKg = optJSONObject.optString("to_join");
                this.aKh = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aKj = optJSONObject2.optString("guide_text");
                this.aKk = optJSONObject2.optInt("show_times_daily");
                this.aKl = optJSONObject2.optInt("continue_show_times");
                this.aKm = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aKn = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aKo = optJSONObject4.optString("attenuat_tip_img");
                this.aKp = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
