package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bo {
    private int bEj = 0;
    private bn bEk = new bn();

    public boolean aaS() {
        return this.bEj != 0;
    }

    public bn aaT() {
        return this.bEk;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.bEj = yule.activity_show.intValue();
            this.bEk.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bEj = jSONObject.optInt("activity_show");
                this.bEk.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
