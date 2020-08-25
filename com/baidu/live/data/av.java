package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class av {
    public String aII;
    public String aIJ;
    public JSONObject aIK;
    public JSONObject aIL;
    public JSONObject aIM;
    public JSONObject aIN;
    public String aIO;
    public String aIP;
    public int aIQ;
    public String aIR;
    public int aIS;
    public int aIT;
    public int aIU;
    public int aIV;
    public String aIW;
    public String aIX;

    public av(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aIQ = jSONObject.optInt("join_amount");
            this.aII = jSONObject.optString("guard_club_category");
            this.aIJ = jSONObject.optString("guard_club_gift_type");
            this.aIK = jSONObject.optJSONObject("club_level_icon_large");
            this.aIL = jSONObject.optJSONObject("club_level_icon_small");
            this.aIM = jSONObject.optJSONObject("member_level_icon");
            this.aIN = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.aIO = optJSONObject.optString("to_join");
                this.aIP = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aIR = optJSONObject2.optString("guide_text");
                this.aIS = optJSONObject2.optInt("show_times_daily");
                this.aIT = optJSONObject2.optInt("continue_show_times");
                this.aIU = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aIV = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aIW = optJSONObject4.optString("attenuat_tip_img");
                this.aIX = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
