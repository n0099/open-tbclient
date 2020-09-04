package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class av {
    public String aIK;
    public String aIL;
    public JSONObject aIM;
    public JSONObject aIN;
    public JSONObject aIO;
    public JSONObject aIP;
    public String aIQ;
    public String aIR;
    public int aIS;
    public String aIT;
    public int aIU;
    public int aIV;
    public int aIW;
    public int aIX;
    public String aIY;
    public String aIZ;

    public av(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIS = jSONObject.optInt("join_amount");
            this.aIK = jSONObject.optString("guard_club_category");
            this.aIL = jSONObject.optString("guard_club_gift_type");
            this.aIM = jSONObject.optJSONObject("club_level_icon_large");
            this.aIN = jSONObject.optJSONObject("club_level_icon_small");
            this.aIO = jSONObject.optJSONObject("member_level_icon");
            this.aIP = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.aIQ = optJSONObject.optString("to_join");
                this.aIR = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aIT = optJSONObject2.optString("guide_text");
                this.aIU = optJSONObject2.optInt("show_times_daily");
                this.aIV = optJSONObject2.optInt("continue_show_times");
                this.aIW = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aIX = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aIY = optJSONObject4.optString("attenuat_tip_img");
                this.aIZ = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
