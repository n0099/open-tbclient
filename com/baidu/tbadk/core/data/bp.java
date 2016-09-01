package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bp {
    private int Vg = 0;
    private bo Vh = new bo();

    public boolean sP() {
        return this.Vg != 0;
    }

    public bo sQ() {
        return this.Vh;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.Vg = yule.activity_show.intValue();
            this.Vh.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Vg = jSONObject.optInt("activity_show");
                this.Vh.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
