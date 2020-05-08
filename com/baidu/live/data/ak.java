package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ak {
    public String auO;
    public String auP;
    public JSONObject auQ;
    public JSONObject auR;
    public JSONObject auS;
    public JSONObject auT;
    public String auU;
    public String auV;
    public int auW;
    public String auX;
    public int auY;
    public int auZ;
    public int ava;
    public int avb;
    public String avc;
    public String avd;

    public ak(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.auW = jSONObject.optInt("join_amount");
            this.auO = jSONObject.optString("guard_club_category");
            this.auP = jSONObject.optString("guard_club_gift_type");
            this.auQ = jSONObject.optJSONObject("club_level_icon_large");
            this.auR = jSONObject.optJSONObject("club_level_icon_small");
            this.auS = jSONObject.optJSONObject("member_level_icon");
            this.auT = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.auU = optJSONObject.optString("to_join");
                this.auV = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.auX = optJSONObject2.optString("guide_text");
                this.auY = optJSONObject2.optInt("show_times_daily");
                this.auZ = optJSONObject2.optInt("continue_show_times");
                this.ava = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.avb = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.avc = optJSONObject4.optString("attenuat_tip_img");
                this.avd = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
