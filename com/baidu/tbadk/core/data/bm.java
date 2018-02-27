package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bm {
    private int aQK = 0;
    private bl aQL = new bl();

    public boolean AM() {
        return this.aQK != 0;
    }

    public bl AN() {
        return this.aQL;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.aQK = yule.activity_show.intValue();
            this.aQL.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aQK = jSONObject.optInt("activity_show");
                this.aQL.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
