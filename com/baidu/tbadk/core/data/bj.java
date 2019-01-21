package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bj {
    private int awD = 0;
    private bi awE = new bi();

    public boolean BK() {
        return this.awD != 0;
    }

    public bi BL() {
        return this.awE;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.awD = yule.activity_show.intValue();
            this.awE.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.awD = jSONObject.optInt("activity_show");
                this.awE.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
