package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class as {
    public String aCd;
    public String aCe;
    public JSONObject aCf;
    public JSONObject aCg;
    public JSONObject aCh;
    public JSONObject aCi;
    public String aCj;
    public String aCk;
    public int aCl;
    public String aCm;
    public int aCn;
    public int aCo;
    public int aCp;
    public int aCq;
    public String aCr;
    public String aCs;

    public as(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aCl = jSONObject.optInt("join_amount");
            this.aCd = jSONObject.optString("guard_club_category");
            this.aCe = jSONObject.optString("guard_club_gift_type");
            this.aCf = jSONObject.optJSONObject("club_level_icon_large");
            this.aCg = jSONObject.optJSONObject("club_level_icon_small");
            this.aCh = jSONObject.optJSONObject("member_level_icon");
            this.aCi = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.aCj = optJSONObject.optString("to_join");
                this.aCk = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aCm = optJSONObject2.optString("guide_text");
                this.aCn = optJSONObject2.optInt("show_times_daily");
                this.aCo = optJSONObject2.optInt("continue_show_times");
                this.aCp = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aCq = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aCr = optJSONObject4.optString("attenuat_tip_img");
                this.aCs = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
