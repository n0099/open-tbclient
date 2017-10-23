package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bp {
    private int aal = 0;
    private bo aam = new bo();

    public boolean sT() {
        return this.aal != 0;
    }

    public bo sU() {
        return this.aam;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.aal = yule.activity_show.intValue();
            this.aam.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aal = jSONObject.optInt("activity_show");
                this.aam.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
