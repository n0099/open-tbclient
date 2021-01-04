package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bi {
    public String aQQ;
    public String aQR;
    public JSONObject aQS;
    public JSONObject aQT;
    public JSONObject aQU;
    public JSONObject aQV;
    public String aQW;
    public String aQX;
    public int aQY;
    public String aQZ;
    public int aRa;
    public int aRb;
    public int aRc;
    public int aRd;
    public String aRe;
    public String aRf;

    public bi(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aQY = jSONObject.optInt("join_amount");
            this.aQQ = jSONObject.optString("guard_club_category");
            this.aQR = jSONObject.optString("guard_club_gift_type");
            this.aQS = jSONObject.optJSONObject("club_level_icon_large");
            this.aQT = jSONObject.optJSONObject("club_level_icon_small");
            this.aQU = jSONObject.optJSONObject("member_level_icon");
            this.aQV = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.aQW = optJSONObject.optString("to_join");
                this.aQX = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aQZ = optJSONObject2.optString("guide_text");
                this.aRa = optJSONObject2.optInt("show_times_daily");
                this.aRb = optJSONObject2.optInt("continue_show_times");
                this.aRc = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aRd = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aRe = optJSONObject4.optString("attenuat_tip_img");
                this.aRf = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
