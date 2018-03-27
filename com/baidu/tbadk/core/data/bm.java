package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bm {
    private int aQM = 0;
    private bl aQN = new bl();

    public boolean AN() {
        return this.aQM != 0;
    }

    public bl AO() {
        return this.aQN;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.aQM = yule.activity_show.intValue();
            this.aQN.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aQM = jSONObject.optInt("activity_show");
                this.aQN.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
