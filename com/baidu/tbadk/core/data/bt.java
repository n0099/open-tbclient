package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bt {
    private int abq = 0;
    private bs abr = new bs();

    public boolean tj() {
        return this.abq != 0;
    }

    public bs tk() {
        return this.abr;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.abq = yule.activity_show.intValue();
            this.abr.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.abq = jSONObject.optInt("activity_show");
                this.abr.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
