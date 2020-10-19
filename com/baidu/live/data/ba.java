package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ba {
    public String aNf;
    public String aNg;
    public JSONObject aNh;
    public JSONObject aNi;
    public JSONObject aNj;
    public JSONObject aNk;
    public String aNl;
    public String aNm;
    public int aNn;
    public String aNo;
    public int aNp;
    public int aNq;
    public int aNr;
    public int aNs;
    public String aNt;
    public String aNu;

    public ba(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNn = jSONObject.optInt("join_amount");
            this.aNf = jSONObject.optString("guard_club_category");
            this.aNg = jSONObject.optString("guard_club_gift_type");
            this.aNh = jSONObject.optJSONObject("club_level_icon_large");
            this.aNi = jSONObject.optJSONObject("club_level_icon_small");
            this.aNj = jSONObject.optJSONObject("member_level_icon");
            this.aNk = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.aNl = optJSONObject.optString("to_join");
                this.aNm = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aNo = optJSONObject2.optString("guide_text");
                this.aNp = optJSONObject2.optInt("show_times_daily");
                this.aNq = optJSONObject2.optInt("continue_show_times");
                this.aNr = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aNs = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aNt = optJSONObject4.optString("attenuat_tip_img");
                this.aNu = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
