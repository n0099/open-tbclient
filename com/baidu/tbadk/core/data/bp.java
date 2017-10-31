package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bp {
    private int aaI = 0;
    private bo aaJ = new bo();

    public boolean sZ() {
        return this.aaI != 0;
    }

    public bo ta() {
        return this.aaJ;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.aaI = yule.activity_show.intValue();
            this.aaJ.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.aaI = jSONObject.optInt("activity_show");
                this.aaJ.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
