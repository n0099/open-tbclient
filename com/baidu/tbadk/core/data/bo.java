package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.YuleActivity;
/* loaded from: classes.dex */
public class bo {
    private int OB;
    private long Vf;
    private String activity_all_icon;
    private String activity_half_icon;
    private String activity_url;

    public String getActivityUrl() {
        return this.activity_url;
    }

    public String sN() {
        return this.activity_all_icon;
    }

    public String sO() {
        return this.activity_half_icon;
    }

    public void a(YuleActivity yuleActivity) {
        if (yuleActivity != null) {
            this.Vf = yuleActivity.activity_id.longValue();
            this.OB = yuleActivity.activity_type.intValue();
            this.activity_url = yuleActivity.activity_url;
            this.activity_all_icon = yuleActivity.activity_all_icon;
            this.activity_half_icon = yuleActivity.activity_half_icon;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Vf = jSONObject.optLong(GroupActivityActivityConfig.ACTIVITY_ID);
                this.OB = jSONObject.optInt("activity_type");
                this.activity_url = jSONObject.optString("activity_url");
                this.activity_all_icon = jSONObject.optString("activity_all_icon");
                this.activity_half_icon = jSONObject.optString("activity_half_icon");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
