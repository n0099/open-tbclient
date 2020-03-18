package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ah {
    public int acA;
    public int acB;
    public int acC;
    public String acD;
    public String acE;
    public String acn;
    public String aco;
    public JSONObject acp;
    public JSONObject acq;
    public JSONObject acr;
    public JSONObject acs;
    public String acu;
    public String acv;
    public int acx;
    public String acy;
    public int acz;

    public ah(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.acx = jSONObject.optInt("join_amount");
            this.acn = jSONObject.optString("guard_club_category");
            this.aco = jSONObject.optString("guard_club_gift_type");
            this.acp = jSONObject.optJSONObject("club_level_icon_large");
            this.acq = jSONObject.optJSONObject("club_level_icon_small");
            this.acr = jSONObject.optJSONObject("member_level_icon");
            this.acs = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.acu = optJSONObject.optString("to_join");
                this.acv = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.acy = optJSONObject2.optString("guide_text");
                this.acz = optJSONObject2.optInt("show_times_daily");
                this.acA = optJSONObject2.optInt("continue_show_times");
                this.acB = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.acC = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.acD = optJSONObject4.optString("attenuat_tip_img");
                this.acE = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
