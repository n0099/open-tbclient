package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bj {
    private int amR = 0;
    private bi amS = new bi();

    public boolean yd() {
        return this.amR != 0;
    }

    public bi ye() {
        return this.amS;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.amR = yule.activity_show.intValue();
            this.amS.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.amR = jSONObject.optInt("activity_show");
                this.amS.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
