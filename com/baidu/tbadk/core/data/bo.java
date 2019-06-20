package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bo {
    private int bLH = 0;
    private bn bLI = new bn();

    public boolean afz() {
        return this.bLH != 0;
    }

    public bn afA() {
        return this.bLI;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.bLH = yule.activity_show.intValue();
            this.bLI.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bLH = jSONObject.optInt("activity_show");
                this.bLI.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
