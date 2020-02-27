package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ah {
    public String acb;
    public String acc;
    public JSONObject acd;
    public JSONObject ace;
    public JSONObject acf;
    public JSONObject acg;
    public String ach;
    public String aci;
    public int acj;
    public String acm;
    public int acn;
    public int aco;
    public int acp;
    public int acq;
    public String acr;
    public String acs;

    public ah(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.acj = jSONObject.optInt("join_amount");
            this.acb = jSONObject.optString("guard_club_category");
            this.acc = jSONObject.optString("guard_club_gift_type");
            this.acd = jSONObject.optJSONObject("club_level_icon_large");
            this.ace = jSONObject.optJSONObject("club_level_icon_small");
            this.acf = jSONObject.optJSONObject("member_level_icon");
            this.acg = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.ach = optJSONObject.optString("to_join");
                this.aci = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.acm = optJSONObject2.optString("guide_text");
                this.acn = optJSONObject2.optInt("show_times_daily");
                this.aco = optJSONObject2.optInt("continue_show_times");
                this.acp = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.acq = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.acr = optJSONObject4.optString("attenuat_tip_img");
                this.acs = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
