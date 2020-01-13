package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bu {
    private int cQO = 0;
    private bt cQP = new bt();

    public boolean aCk() {
        return this.cQO != 0;
    }

    public bt aCl() {
        return this.cQP;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.cQO = yule.activity_show.intValue();
            this.cQP.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.cQO = jSONObject.optInt("activity_show");
                this.cQP.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
