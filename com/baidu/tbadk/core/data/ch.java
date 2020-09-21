package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class ch {
    private int ehj = 0;
    private cg ehk = new cg();

    public boolean bhR() {
        return this.ehj != 0;
    }

    public cg bhS() {
        return this.ehk;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.ehj = yule.activity_show.intValue();
            this.ehk.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.ehj = jSONObject.optInt("activity_show");
                this.ehk.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
