package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ag {
    public String aah;
    public String aai;
    public JSONObject aaj;
    public JSONObject aak;
    public JSONObject aal;
    public JSONObject aam;
    public String aan;
    public String aao;
    public int aap;
    public String aaq;
    public int aar;
    public int aas;
    public int aat;
    public int aau;
    public String aav;
    public String aaw;

    public ag(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aap = jSONObject.optInt("join_amount");
            this.aah = jSONObject.optString("guard_club_category");
            this.aai = jSONObject.optString("guard_club_gift_type");
            this.aaj = jSONObject.optJSONObject("club_level_icon_large");
            this.aak = jSONObject.optJSONObject("club_level_icon_small");
            this.aal = jSONObject.optJSONObject("member_level_icon");
            this.aam = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.aan = optJSONObject.optString("to_join");
                this.aao = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aaq = optJSONObject2.optString("guide_text");
                this.aar = optJSONObject2.optInt("show_times_daily");
                this.aas = optJSONObject2.optInt("continue_show_times");
                this.aat = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aau = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aav = optJSONObject4.optString("attenuat_tip_img");
                this.aaw = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
