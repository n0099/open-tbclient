package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bu {
    private int cQE = 0;
    private bt cQF = new bt();

    public boolean aBR() {
        return this.cQE != 0;
    }

    public bt aBS() {
        return this.cQF;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.cQE = yule.activity_show.intValue();
            this.cQF.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cQE = jSONObject.optInt("activity_show");
                this.cQF.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
