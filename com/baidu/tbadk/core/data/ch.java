package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class ch {
    private int eHE = 0;
    private cg eHF = new cg();

    public boolean boT() {
        return this.eHE != 0;
    }

    public cg boU() {
        return this.eHF;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.eHE = yule.activity_show.intValue();
            this.eHF.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eHE = jSONObject.optInt("activity_show");
                this.eHF.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
