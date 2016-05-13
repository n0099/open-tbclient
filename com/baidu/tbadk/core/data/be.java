package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class be {
    private int Rp = 0;
    private bd Rq = new bd();

    public boolean rO() {
        return this.Rp != 0;
    }

    public bd rP() {
        return this.Rq;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.Rp = yule.activity_show.intValue();
            this.Rq.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Rp = jSONObject.optInt("activity_show");
                this.Rq.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
