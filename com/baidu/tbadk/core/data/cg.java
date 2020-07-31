package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class cg {
    private int dVr = 0;
    private cf dVs = new cf();

    public boolean aYC() {
        return this.dVr != 0;
    }

    public cf aYD() {
        return this.dVs;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.dVr = yule.activity_show.intValue();
            this.dVs.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dVr = jSONObject.optInt("activity_show");
                this.dVs.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
