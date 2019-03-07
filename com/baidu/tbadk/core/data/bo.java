package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bo {
    private int bEh = 0;
    private bn bEi = new bn();

    public boolean aaS() {
        return this.bEh != 0;
    }

    public bn aaT() {
        return this.bEi;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.bEh = yule.activity_show.intValue();
            this.bEi.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bEh = jSONObject.optInt("activity_show");
                this.bEi.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
