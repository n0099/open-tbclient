package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class br {
    private int ZZ = 0;
    private bq aaa = new bq();

    public boolean tI() {
        return this.ZZ != 0;
    }

    public bq tJ() {
        return this.aaa;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.ZZ = yule.activity_show.intValue();
            this.aaa.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ZZ = jSONObject.optInt("activity_show");
                this.aaa.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
