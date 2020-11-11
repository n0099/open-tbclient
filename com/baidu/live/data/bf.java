package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bf {
    public String aON;
    public String aOO;
    public JSONObject aOP;
    public JSONObject aOQ;
    public JSONObject aOR;
    public JSONObject aOS;
    public String aOT;
    public String aOU;
    public int aOV;
    public String aOW;
    public int aOX;
    public int aOY;
    public int aOZ;
    public int aPa;
    public String aPb;
    public String aPc;

    public bf(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aOV = jSONObject.optInt("join_amount");
            this.aON = jSONObject.optString("guard_club_category");
            this.aOO = jSONObject.optString("guard_club_gift_type");
            this.aOP = jSONObject.optJSONObject("club_level_icon_large");
            this.aOQ = jSONObject.optJSONObject("club_level_icon_small");
            this.aOR = jSONObject.optJSONObject("member_level_icon");
            this.aOS = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.aOT = optJSONObject.optString("to_join");
                this.aOU = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aOW = optJSONObject2.optString("guide_text");
                this.aOX = optJSONObject2.optInt("show_times_daily");
                this.aOY = optJSONObject2.optInt("continue_show_times");
                this.aOZ = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aPa = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aPb = optJSONObject4.optString("attenuat_tip_img");
                this.aPc = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
