package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bt {
    private int abt = 0;
    private bs abu = new bs();

    public boolean tj() {
        return this.abt != 0;
    }

    public bs tk() {
        return this.abu;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.abt = yule.activity_show.intValue();
            this.abu.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.abt = jSONObject.optInt("activity_show");
                this.abu.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
