package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bo {
    private int bEn = 0;
    private bn bEo = new bn();

    public boolean aaP() {
        return this.bEn != 0;
    }

    public bn aaQ() {
        return this.bEo;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.bEn = yule.activity_show.intValue();
            this.bEo.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bEn = jSONObject.optInt("activity_show");
                this.bEo.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
