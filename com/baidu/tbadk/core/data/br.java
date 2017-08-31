package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class br {
    private int aax = 0;
    private bq aay = new bq();

    public boolean tg() {
        return this.aax != 0;
    }

    public bq th() {
        return this.aay;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.aax = yule.activity_show.intValue();
            this.aay.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aax = jSONObject.optInt("activity_show");
                this.aay.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
