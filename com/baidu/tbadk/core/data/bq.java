package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bq {
    private int Uw = 0;
    private bp Ux = new bp();

    public boolean sN() {
        return this.Uw != 0;
    }

    public bp sO() {
        return this.Ux;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.Uw = yule.activity_show.intValue();
            this.Ux.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Uw = jSONObject.optInt("activity_show");
                this.Ux.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
