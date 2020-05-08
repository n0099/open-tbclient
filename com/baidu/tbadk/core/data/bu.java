package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bu {
    private int duu = 0;
    private bt duv = new bt();

    public boolean aMN() {
        return this.duu != 0;
    }

    public bt aMO() {
        return this.duv;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.duu = yule.activity_show.intValue();
            this.duv.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.duu = jSONObject.optInt("activity_show");
                this.duv.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
