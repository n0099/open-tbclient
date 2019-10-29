package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class z {
    public JSONObject TA;
    public JSONObject TB;
    public String TC;
    public String TD;
    public int TF;
    public String TG;
    public int TH;
    public int TI;
    public int TJ;
    public int TK;
    public String TL;
    public String TM;
    public String Tw;
    public String Tx;
    public JSONObject Ty;
    public JSONObject Tz;

    public z(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.TF = jSONObject.optInt("join_amount");
            this.Tw = jSONObject.optString("guard_club_category");
            this.Tx = jSONObject.optString("guard_club_gift_type");
            this.Ty = jSONObject.optJSONObject("club_level_icon_large");
            this.Tz = jSONObject.optJSONObject("club_level_icon_small");
            this.TA = jSONObject.optJSONObject("member_level_icon");
            this.TB = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.TC = optJSONObject.optString("to_join");
                this.TD = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.TG = optJSONObject2.optString("guide_text");
                this.TH = optJSONObject2.optInt("show_times_daily");
                this.TI = optJSONObject2.optInt("continue_show_times");
                this.TJ = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.TK = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.TL = optJSONObject4.optString("attenuat_tip_img");
                this.TM = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
