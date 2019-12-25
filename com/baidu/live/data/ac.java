package com.baidu.live.data;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ac {
    public String ZT;
    public String ZU;
    public JSONObject ZV;
    public JSONObject ZW;
    public JSONObject ZX;
    public JSONObject ZY;
    public String ZZ;
    public String aaa;
    public int aab;
    public String aac;
    public int aae;
    public int aaf;
    public int aag;
    public int aah;
    public String aai;
    public String aaj;

    public ac(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aab = jSONObject.optInt("join_amount");
            this.ZT = jSONObject.optString("guard_club_category");
            this.ZU = jSONObject.optString("guard_club_gift_type");
            this.ZV = jSONObject.optJSONObject("club_level_icon_large");
            this.ZW = jSONObject.optJSONObject("club_level_icon_small");
            this.ZX = jSONObject.optJSONObject("member_level_icon");
            this.ZY = jSONObject.optJSONObject("level_discount");
            JSONObject optJSONObject = jSONObject.optJSONObject("join_club_remind");
            if (optJSONObject != null) {
                this.ZZ = optJSONObject.optString("to_join");
                this.aaa = optJSONObject.optString("has_join");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("join_club_guide");
            if (optJSONObject2 != null) {
                this.aac = optJSONObject2.optString("guide_text");
                this.aae = optJSONObject2.optInt("show_times_daily");
                this.aaf = optJSONObject2.optInt("continue_show_times");
                this.aag = optJSONObject2.optInt("condition");
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("attenuat_conf");
            if (optJSONObject3 != null) {
                this.aah = optJSONObject3.optInt("show_times_daily");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("tips_img");
            if (optJSONObject4 != null) {
                this.aai = optJSONObject4.optString("attenuat_tip_img");
                this.aaj = optJSONObject4.optString("quit_tip_img");
            }
        }
    }
}
