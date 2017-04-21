package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class br {
    private int aaa = 0;
    private bq aab = new bq();

    public boolean tI() {
        return this.aaa != 0;
    }

    public bq tJ() {
        return this.aab;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.aaa = yule.activity_show.intValue();
            this.aab.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aaa = jSONObject.optInt("activity_show");
                this.aab.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
