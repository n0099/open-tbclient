package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class ck {
    private int eSl = 0;
    private cj eSm = new cj();

    public boolean bpV() {
        return this.eSl != 0;
    }

    public cj bpW() {
        return this.eSm;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.eSl = yule.activity_show.intValue();
            this.eSm.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.eSl = jSONObject.optInt("activity_show");
                this.eSm.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
