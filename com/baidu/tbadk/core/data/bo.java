package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bo {
    private int bEm = 0;
    private bn bEn = new bn();

    public boolean aaP() {
        return this.bEm != 0;
    }

    public bn aaQ() {
        return this.bEn;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.bEm = yule.activity_show.intValue();
            this.bEn.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bEm = jSONObject.optInt("activity_show");
                this.bEn.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
