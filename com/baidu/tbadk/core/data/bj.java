package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bj {
    private int asz = 0;
    private bi asA = new bi();

    public boolean At() {
        return this.asz != 0;
    }

    public bi Au() {
        return this.asA;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.asz = yule.activity_show.intValue();
            this.asA.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.asz = jSONObject.optInt("activity_show");
                this.asA.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
