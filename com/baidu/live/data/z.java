package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class z {
    public String Td;
    public String Te;
    public JSONObject Tf;
    public JSONObject Tg;
    public JSONObject Th;
    public JSONObject Ti;
    public String Tj;
    public String Tk;
    public int Tl;
    public String Tm;
    public int Tn;
    public int To;
    public int Tp;
    public int Tq;
    public String Tr;
    public String Ts;

    public z(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Tl = jSONObject.optInt("join_amount");
            this.Td = jSONObject.optString("guard_club_category");
            this.Te = jSONObject.optString("guard_club_gift_type");
            this.Tf = jSONObject.optJSONObject("club_level_icon_large");
            this.Tg = jSONObject.optJSONObject("club_level_icon_small");
            this.Th = jSONObject.optJSONObject("member_level_icon");
            this.Ti = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.Tj = optJSONObject.optString("to_join");
                this.Tk = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.Tm = optJSONObject2.optString("guide_text");
                this.Tn = optJSONObject2.optInt("show_times_daily");
                this.To = optJSONObject2.optInt("continue_show_times");
                this.Tp = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.Tq = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.Tr = optJSONObject4.optString("attenuat_tip_img");
                this.Ts = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
