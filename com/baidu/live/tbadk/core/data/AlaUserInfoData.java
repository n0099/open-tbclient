package com.baidu.live.tbadk.core.data;

import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaUserInfoData {
    public long ala_id;
    public long anchor_live;
    public long charm_count;
    public String description;
    public long enter_live;
    public String great_anchor_desc_grade;
    public String great_anchor_desc_role;
    public String great_anchor_icon;
    public int is_official;
    public double lat;
    public long level_exp;
    public int level_id;
    public String level_name;
    public long live_id;
    public int live_status;
    public double lng;
    public String location;
    public String portrait;
    public String sex;
    public int update_time;
    public String user_name;
    public String verify_status;

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ala_id = jSONObject.optLong("ala_id");
                this.user_name = jSONObject.optString("user_name");
                this.portrait = jSONObject.optString("bd_portrait");
                if (StringUtils.isNull(this.portrait)) {
                    this.portrait = jSONObject.optString("portrait");
                }
                this.enter_live = jSONObject.optLong("enter_live");
                this.anchor_live = jSONObject.optLong("anchor_live");
                this.description = jSONObject.optString("description");
                this.sex = jSONObject.optString("sex");
                this.live_status = jSONObject.optInt("live_status");
                this.live_id = jSONObject.optLong("live_id");
                this.location = jSONObject.optString("location");
                this.update_time = jSONObject.optInt("update_time");
                this.charm_count = jSONObject.optLong("charm_count");
                this.level_exp = jSONObject.optLong("level_exp");
                this.is_official = jSONObject.optInt("is_official");
                this.verify_status = jSONObject.optString("verify_status");
                this.level_id = jSONObject.optInt("level_id");
                this.level_name = jSONObject.optString("level_name");
                this.great_anchor_icon = jSONObject.optString("great_anchor_icon");
                this.great_anchor_desc_grade = jSONObject.optString("great_anchor_desc_grade");
                this.great_anchor_desc_role = jSONObject.optString("great_anchor_desc_role");
                this.lng = jSONObject.optDouble("lng");
                this.lat = jSONObject.optDouble("lat");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
