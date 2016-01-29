package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.YuleActivity;
/* loaded from: classes.dex */
public class am {
    private int Ub;
    private long XJ;
    private String activity_all_icon;
    private String activity_half_icon;
    private String activity_url;

    public String getActivityUrl() {
        return this.activity_url;
    }

    public String ua() {
        return this.activity_all_icon;
    }

    public String ub() {
        return this.activity_half_icon;
    }

    public void a(YuleActivity yuleActivity) {
        if (yuleActivity != null) {
            this.XJ = yuleActivity.activity_id.longValue();
            this.Ub = yuleActivity.activity_type.intValue();
            this.activity_url = yuleActivity.activity_url;
            this.activity_all_icon = yuleActivity.activity_all_icon;
            this.activity_half_icon = yuleActivity.activity_half_icon;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.XJ = jSONObject.optLong("activity_id");
                this.Ub = jSONObject.optInt("activity_type");
                this.activity_url = jSONObject.optString("activity_url");
                this.activity_all_icon = jSONObject.optString("activity_all_icon");
                this.activity_half_icon = jSONObject.optString("activity_half_icon");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
