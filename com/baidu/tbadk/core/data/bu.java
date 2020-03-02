package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bu {
    private int cUR = 0;
    private bt cUS = new bt();

    public boolean aEx() {
        return this.cUR != 0;
    }

    public bt aEy() {
        return this.cUS;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.cUR = yule.activity_show.intValue();
            this.cUS.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cUR = jSONObject.optInt("activity_show");
                this.cUS.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
