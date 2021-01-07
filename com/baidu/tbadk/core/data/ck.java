package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class ck {
    private int eWW = 0;
    private cj eWX = new cj();

    public boolean btP() {
        return this.eWW != 0;
    }

    public cj btQ() {
        return this.eWX;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.eWW = yule.activity_show.intValue();
            this.eWX.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eWW = jSONObject.optInt("activity_show");
                this.eWX.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
