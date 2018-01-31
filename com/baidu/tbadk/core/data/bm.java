package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bm {
    private int aPy = 0;
    private bl aPz = new bl();

    public boolean At() {
        return this.aPy != 0;
    }

    public bl Au() {
        return this.aPz;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.aPy = yule.activity_show.intValue();
            this.aPz.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aPy = jSONObject.optInt("activity_show");
                this.aPz.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
