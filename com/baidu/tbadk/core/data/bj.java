package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bj {
    private int awC = 0;
    private bi awD = new bi();

    public boolean BK() {
        return this.awC != 0;
    }

    public bi BL() {
        return this.awD;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.awC = yule.activity_show.intValue();
            this.awD.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.awC = jSONObject.optInt("activity_show");
                this.awD.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
