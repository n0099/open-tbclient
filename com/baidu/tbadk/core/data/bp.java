package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bp {
    private int bMM = 0;
    private bo bMN = new bo();

    public boolean agD() {
        return this.bMM != 0;
    }

    public bo agE() {
        return this.bMN;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.bMM = yule.activity_show.intValue();
            this.bMN.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bMM = jSONObject.optInt("activity_show");
                this.bMN.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
