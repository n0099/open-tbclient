package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ak {
    public String auI;
    public String auJ;
    public JSONObject auK;
    public JSONObject auL;
    public JSONObject auM;
    public JSONObject auN;
    public String auO;
    public String auP;
    public int auQ;
    public String auR;
    public int auS;
    public int auT;
    public int auU;
    public int auV;
    public String auW;
    public String auX;

    public ak(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.auQ = jSONObject.optInt("join_amount");
            this.auI = jSONObject.optString("guard_club_category");
            this.auJ = jSONObject.optString("guard_club_gift_type");
            this.auK = jSONObject.optJSONObject("club_level_icon_large");
            this.auL = jSONObject.optJSONObject("club_level_icon_small");
            this.auM = jSONObject.optJSONObject("member_level_icon");
            this.auN = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.auO = optJSONObject.optString("to_join");
                this.auP = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.auR = optJSONObject2.optString("guide_text");
                this.auS = optJSONObject2.optInt("show_times_daily");
                this.auT = optJSONObject2.optInt("continue_show_times");
                this.auU = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.auV = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.auW = optJSONObject4.optString("attenuat_tip_img");
                this.auX = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
