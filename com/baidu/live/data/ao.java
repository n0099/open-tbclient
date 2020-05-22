package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ao {
    public int aAa;
    public String aAb;
    public int aAc;
    public int aAd;
    public int aAe;
    public int aAf;
    public String aAg;
    public String aAh;
    public String azS;
    public String azT;
    public JSONObject azU;
    public JSONObject azV;
    public JSONObject azW;
    public JSONObject azX;
    public String azY;
    public String azZ;

    public ao(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aAa = jSONObject.optInt("join_amount");
            this.azS = jSONObject.optString("guard_club_category");
            this.azT = jSONObject.optString("guard_club_gift_type");
            this.azU = jSONObject.optJSONObject("club_level_icon_large");
            this.azV = jSONObject.optJSONObject("club_level_icon_small");
            this.azW = jSONObject.optJSONObject("member_level_icon");
            this.azX = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.azY = optJSONObject.optString("to_join");
                this.azZ = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aAb = optJSONObject2.optString("guide_text");
                this.aAc = optJSONObject2.optInt("show_times_daily");
                this.aAd = optJSONObject2.optInt("continue_show_times");
                this.aAe = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aAf = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aAg = optJSONObject4.optString("attenuat_tip_img");
                this.aAh = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
