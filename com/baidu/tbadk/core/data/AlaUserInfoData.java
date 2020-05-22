package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.AlaUserInfo;
/* loaded from: classes.dex */
public class AlaUserInfoData extends OrmObject {
    public long ala_id;
    public int anchor_fans;
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
    public long user_id;
    public String user_name;
    public String verify_status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ala_id = jSONObject.optLong("ala_id");
                this.user_name = jSONObject.optString("user_name");
                this.portrait = jSONObject.optString("portrait");
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
                this.user_id = jSONObject.optLong("user_id");
                this.anchor_fans = jSONObject.optInt("anchor_fans");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(AlaUserInfo alaUserInfo) {
        if (alaUserInfo != null) {
            try {
                this.ala_id = alaUserInfo.ala_id.longValue();
                this.user_name = alaUserInfo.user_name;
                this.portrait = alaUserInfo.portrait;
                this.anchor_live = alaUserInfo.anchor_live.longValue();
                this.enter_live = alaUserInfo.enter_live.longValue();
                this.description = alaUserInfo.description;
                this.sex = alaUserInfo.sex;
                this.live_status = alaUserInfo.live_status.intValue();
                this.live_id = alaUserInfo.live_id.longValue();
                this.location = alaUserInfo.location;
                this.update_time = alaUserInfo.update_time.intValue();
                this.charm_count = alaUserInfo.charm_count.longValue();
                this.level_exp = alaUserInfo.level_exp.longValue();
                this.is_official = alaUserInfo.is_official.intValue();
                this.verify_status = alaUserInfo.verify_status;
                this.level_id = alaUserInfo.level_id.intValue();
                this.great_anchor_icon = alaUserInfo.great_anchor_icon;
                this.great_anchor_desc_grade = alaUserInfo.great_anchor_desc_grade;
                this.great_anchor_desc_role = alaUserInfo.great_anchor_desc_role;
                this.lng = alaUserInfo.lng.doubleValue();
                this.lat = alaUserInfo.lat.doubleValue();
                this.user_id = alaUserInfo.user_id.longValue();
                this.anchor_fans = alaUserInfo.anchor_fans.intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
