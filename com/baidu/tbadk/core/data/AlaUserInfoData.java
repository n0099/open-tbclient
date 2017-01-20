package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONObject;
import tbclient.AlaUserInfo;
/* loaded from: classes.dex */
public class AlaUserInfoData extends OrmObject {
    public long anchor_live;
    public long charm_count;
    public String description;
    public long enter_live;
    public int is_official;
    public long level_exp;
    public int level_id;
    public int live_status;
    public String location;
    public String portrait;
    public String sex;
    public int update_time;
    public String user_name;
    public String verify_status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.user_name = jSONObject.optString("user_name");
                this.portrait = jSONObject.optString(IntentConfig.PORTRAIT);
                this.enter_live = jSONObject.optLong("enter_live");
                this.anchor_live = jSONObject.optLong("anchor_live");
                this.description = jSONObject.optString("description");
                this.sex = jSONObject.optString(MyGiftListActivityConfig.USER_SEX);
                this.live_status = jSONObject.optInt("live_status");
                this.location = jSONObject.optString("location");
                this.update_time = jSONObject.optInt("update_time");
                this.charm_count = jSONObject.optLong("charm_count");
                this.level_exp = jSONObject.optLong("level_exp");
                this.is_official = jSONObject.optInt("is_official");
                this.verify_status = jSONObject.optString("verify_status");
                this.level_id = jSONObject.optInt("level_id");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(AlaUserInfo alaUserInfo) {
        if (alaUserInfo != null) {
            try {
                this.user_name = alaUserInfo.user_name;
                this.portrait = alaUserInfo.portrait;
                this.anchor_live = alaUserInfo.anchor_live.longValue();
                this.enter_live = alaUserInfo.enter_live.longValue();
                this.description = alaUserInfo.description;
                this.sex = alaUserInfo.sex;
                this.live_status = alaUserInfo.live_status.intValue();
                this.location = alaUserInfo.location;
                this.update_time = alaUserInfo.update_time.intValue();
                this.charm_count = alaUserInfo.charm_count.longValue();
                this.level_exp = alaUserInfo.level_exp.longValue();
                this.is_official = alaUserInfo.is_official.intValue();
                this.verify_status = alaUserInfo.verify_status;
                this.level_id = alaUserInfo.level_id.intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
