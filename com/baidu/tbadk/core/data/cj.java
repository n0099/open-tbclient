package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class cj {
    private int eMZ = 0;
    private ci eNa = new ci();

    public boolean brm() {
        return this.eMZ != 0;
    }

    public ci brn() {
        return this.eNa;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.eMZ = yule.activity_show.intValue();
            this.eNa.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eMZ = jSONObject.optInt("activity_show");
                this.eNa.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
