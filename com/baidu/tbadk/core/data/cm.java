package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class cm {
    private int eVY = 0;
    private cl eVZ = new cl();

    public boolean bqp() {
        return this.eVY != 0;
    }

    public cl bqq() {
        return this.eVZ;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.eVY = yule.activity_show.intValue();
            this.eVZ.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eVY = jSONObject.optInt("activity_show");
                this.eVZ.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
