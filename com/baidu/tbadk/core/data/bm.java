package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bm {
    private int aQV = 0;
    private bl aQW = new bl();

    public boolean AM() {
        return this.aQV != 0;
    }

    public bl AN() {
        return this.aQW;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.aQV = yule.activity_show.intValue();
            this.aQW.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aQV = jSONObject.optInt("activity_show");
                this.aQW.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
