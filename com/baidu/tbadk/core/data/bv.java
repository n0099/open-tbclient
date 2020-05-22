package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bv {
    private int dIp = 0;
    private bu dIq = new bu();

    public boolean aSO() {
        return this.dIp != 0;
    }

    public bu aSP() {
        return this.dIq;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.dIp = yule.activity_show.intValue();
            this.dIq.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.dIp = jSONObject.optInt("activity_show");
                this.dIq.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
