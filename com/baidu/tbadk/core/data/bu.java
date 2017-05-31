package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bu {
    private int Zu = 0;
    private bt Zv = new bt();

    public boolean sU() {
        return this.Zu != 0;
    }

    public bt sV() {
        return this.Zv;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.Zu = yule.activity_show.intValue();
            this.Zv.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Zu = jSONObject.optInt("activity_show");
                this.Zv.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
