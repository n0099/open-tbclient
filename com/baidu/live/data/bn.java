package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class bn {
    public String aPb;
    public String aPc;
    public JSONObject aPd;
    public JSONObject aPe;
    public JSONObject aPf;
    public JSONObject aPg;
    public String aPh;
    public String aPi;
    public int aPj;
    public String aPk;
    public int aPl;
    public int aPm;
    public int aPn;
    public int aPo;
    public String aPp;
    public String aPq;

    public bn(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aPj = jSONObject.optInt("join_amount");
            this.aPb = jSONObject.optString("guard_club_category");
            this.aPc = jSONObject.optString("guard_club_gift_type");
            this.aPd = jSONObject.optJSONObject("club_level_icon_large");
            this.aPe = jSONObject.optJSONObject("club_level_icon_small");
            this.aPf = jSONObject.optJSONObject("member_level_icon");
            this.aPg = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.aPh = optJSONObject.optString("to_join");
                this.aPi = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aPk = optJSONObject2.optString("guide_text");
                this.aPl = optJSONObject2.optInt("show_times_daily");
                this.aPm = optJSONObject2.optInt("continue_show_times");
                this.aPn = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aPo = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aPp = optJSONObject4.optString("attenuat_tip_img");
                this.aPq = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
