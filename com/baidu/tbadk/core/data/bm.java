package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bm {
    private int aba = 0;
    private bl abb = new bl();

    public boolean sZ() {
        return this.aba != 0;
    }

    public bl ta() {
        return this.abb;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.aba = yule.activity_show.intValue();
            this.abb.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aba = jSONObject.optInt("activity_show");
                this.abb.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
