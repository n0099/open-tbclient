package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bn {
    public String aQB;
    public String aQC;
    public JSONObject aQD;
    public JSONObject aQE;
    public JSONObject aQF;
    public JSONObject aQG;
    public String aQH;
    public String aQI;
    public int aQJ;
    public String aQK;
    public int aQL;
    public int aQM;
    public int aQN;
    public int aQO;
    public String aQP;
    public String aQQ;

    public bn(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQJ = jSONObject.optInt("join_amount");
            this.aQB = jSONObject.optString("guard_club_category");
            this.aQC = jSONObject.optString("guard_club_gift_type");
            this.aQD = jSONObject.optJSONObject("club_level_icon_large");
            this.aQE = jSONObject.optJSONObject("club_level_icon_small");
            this.aQF = jSONObject.optJSONObject("member_level_icon");
            this.aQG = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.aQH = optJSONObject.optString("to_join");
                this.aQI = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aQK = optJSONObject2.optString("guide_text");
                this.aQL = optJSONObject2.optInt("show_times_daily");
                this.aQM = optJSONObject2.optInt("continue_show_times");
                this.aQN = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aQO = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aQP = optJSONObject4.optString("attenuat_tip_img");
                this.aQQ = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
