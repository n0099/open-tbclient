package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bu {
    private int cUS = 0;
    private bt cUT = new bt();

    public boolean aEx() {
        return this.cUS != 0;
    }

    public bt aEy() {
        return this.cUT;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.cUS = yule.activity_show.intValue();
            this.cUT.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cUS = jSONObject.optInt("activity_show");
                this.cUT.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
