package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class cf {
    private int dPf = 0;
    private ce dPg = new ce();

    public boolean aUI() {
        return this.dPf != 0;
    }

    public ce aUJ() {
        return this.dPg;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.dPf = yule.activity_show.intValue();
            this.dPg.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dPf = jSONObject.optInt("activity_show");
                this.dPg.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
