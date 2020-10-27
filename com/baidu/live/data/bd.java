package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class bd {
    public String aNK;
    public String aNL;
    public JSONObject aNM;
    public JSONObject aNN;
    public JSONObject aNO;
    public JSONObject aNP;
    public String aNQ;
    public String aNR;
    public int aNS;
    public String aNT;
    public int aNU;
    public int aNV;
    public int aNW;
    public int aNX;
    public String aNY;
    public String aNZ;

    public bd(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aNS = jSONObject.optInt("join_amount");
            this.aNK = jSONObject.optString("guard_club_category");
            this.aNL = jSONObject.optString("guard_club_gift_type");
            this.aNM = jSONObject.optJSONObject("club_level_icon_large");
            this.aNN = jSONObject.optJSONObject("club_level_icon_small");
            this.aNO = jSONObject.optJSONObject("member_level_icon");
            this.aNP = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.aNQ = optJSONObject.optString("to_join");
                this.aNR = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aNT = optJSONObject2.optString("guide_text");
                this.aNU = optJSONObject2.optInt("show_times_daily");
                this.aNV = optJSONObject2.optInt("continue_show_times");
                this.aNW = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aNX = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aNY = optJSONObject4.optString("attenuat_tip_img");
                this.aNZ = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
