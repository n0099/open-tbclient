package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bi {
    public String aMd;
    public String aMe;
    public JSONObject aMf;
    public JSONObject aMg;
    public JSONObject aMh;
    public JSONObject aMi;
    public String aMj;
    public String aMk;
    public int aMl;
    public String aMm;
    public int aMn;
    public int aMo;
    public int aMp;
    public int aMq;
    public String aMr;
    public String aMs;

    public bi(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aMl = jSONObject.optInt("join_amount");
            this.aMd = jSONObject.optString("guard_club_category");
            this.aMe = jSONObject.optString("guard_club_gift_type");
            this.aMf = jSONObject.optJSONObject("club_level_icon_large");
            this.aMg = jSONObject.optJSONObject("club_level_icon_small");
            this.aMh = jSONObject.optJSONObject("member_level_icon");
            this.aMi = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.aMj = optJSONObject.optString("to_join");
                this.aMk = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aMm = optJSONObject2.optString("guide_text");
                this.aMn = optJSONObject2.optInt("show_times_daily");
                this.aMo = optJSONObject2.optInt("continue_show_times");
                this.aMp = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aMq = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aMr = optJSONObject4.optString("attenuat_tip_img");
                this.aMs = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
