package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class at {
    public JSONObject aDA;
    public JSONObject aDB;
    public JSONObject aDC;
    public JSONObject aDD;
    public String aDE;
    public String aDF;
    public int aDG;
    public String aDH;
    public int aDI;
    public int aDJ;
    public int aDK;
    public int aDL;
    public String aDM;
    public String aDN;
    public String aDy;
    public String aDz;

    public at(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aDG = jSONObject.optInt("join_amount");
            this.aDy = jSONObject.optString("guard_club_category");
            this.aDz = jSONObject.optString("guard_club_gift_type");
            this.aDA = jSONObject.optJSONObject("club_level_icon_large");
            this.aDB = jSONObject.optJSONObject("club_level_icon_small");
            this.aDC = jSONObject.optJSONObject("member_level_icon");
            this.aDD = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.aDE = optJSONObject.optString("to_join");
                this.aDF = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aDH = optJSONObject2.optString("guide_text");
                this.aDI = optJSONObject2.optInt("show_times_daily");
                this.aDJ = optJSONObject2.optInt("continue_show_times");
                this.aDK = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aDL = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aDM = optJSONObject4.optString("attenuat_tip_img");
                this.aDN = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
