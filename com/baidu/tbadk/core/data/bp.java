package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bp {
    private int ced = 0;
    private bo cee = new bo();

    public boolean akH() {
        return this.ced != 0;
    }

    public bo akI() {
        return this.cee;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.ced = yule.activity_show.intValue();
            this.cee.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ced = jSONObject.optInt("activity_show");
                this.cee.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
