package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bo {
    private int bMH = 0;
    private bn bMI = new bn();

    public boolean agB() {
        return this.bMH != 0;
    }

    public bn agC() {
        return this.bMI;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.bMH = yule.activity_show.intValue();
            this.bMI.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bMH = jSONObject.optInt("activity_show");
                this.bMI.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
