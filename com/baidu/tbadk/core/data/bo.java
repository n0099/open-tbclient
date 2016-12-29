package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bo {
    private int Vh = 0;
    private bn Vi = new bn();

    public boolean sT() {
        return this.Vh != 0;
    }

    public bn sU() {
        return this.Vi;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.Vh = yule.activity_show.intValue();
            this.Vi.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Vh = jSONObject.optInt("activity_show");
                this.Vi.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
