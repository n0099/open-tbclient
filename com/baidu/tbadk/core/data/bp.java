package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bp {
    private int bNl = 0;
    private bo bNm = new bo();

    public boolean agH() {
        return this.bNl != 0;
    }

    public bo agI() {
        return this.bNm;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.bNl = yule.activity_show.intValue();
            this.bNm.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.bNl = jSONObject.optInt("activity_show");
                this.bNm.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
