package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bj {
    private int arM = 0;
    private bi arN = new bi();

    public boolean Am() {
        return this.arM != 0;
    }

    public bi An() {
        return this.arN;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.arM = yule.activity_show.intValue();
            this.arN.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.arM = jSONObject.optInt("activity_show");
                this.arN.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
