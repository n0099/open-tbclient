package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bl {
    private int akn = 0;
    private bk ako = new bk();

    public boolean wS() {
        return this.akn != 0;
    }

    public bk wT() {
        return this.ako;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.akn = yule.activity_show.intValue();
            this.ako.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.akn = jSONObject.optInt("activity_show");
                this.ako.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
