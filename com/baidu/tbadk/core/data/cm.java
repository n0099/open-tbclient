package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class cm {
    private int eUz = 0;
    private cl eUA = new cl();

    public boolean bqn() {
        return this.eUz != 0;
    }

    public cl bqo() {
        return this.eUA;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.eUz = yule.activity_show.intValue();
            this.eUA.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eUz = jSONObject.optInt("activity_show");
                this.eUA.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
