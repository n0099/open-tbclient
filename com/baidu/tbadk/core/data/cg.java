package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaPersonCenterFansActivityConfig;
import org.json.JSONObject;
import tbclient.FrsPage.YuleActivity;
/* loaded from: classes2.dex */
public class cg {
    private int aMZ;
    private String activity_all_icon;
    private String activity_half_icon;
    private String activity_url;
    private long dWS;

    public String getActivityUrl() {
        return this.activity_url;
    }

    public String bgV() {
        return this.activity_all_icon;
    }

    public String bgW() {
        return this.activity_half_icon;
    }

    public void a(YuleActivity yuleActivity) {
        if (yuleActivity != null) {
            this.dWS = yuleActivity.activity_id.longValue();
            this.aMZ = yuleActivity.activity_type.intValue();
            this.activity_url = yuleActivity.activity_url;
            this.activity_all_icon = yuleActivity.activity_all_icon;
            this.activity_half_icon = yuleActivity.activity_half_icon;
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dWS = jSONObject.optLong("activity_id");
                this.aMZ = jSONObject.optInt(AlaPersonCenterFansActivityConfig.ACTIVITY_TYPE);
                this.activity_url = jSONObject.optString("activity_url");
                this.activity_all_icon = jSONObject.optString("activity_all_icon");
                this.activity_half_icon = jSONObject.optString("activity_half_icon");
            } catch (Exception e) {
                BdLog.e(e.toString());
            }
        }
    }
}
