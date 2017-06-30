package com.baidu.tbadk.core.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
import tbclient.FrsPage.Yule;
/* loaded from: classes.dex */
public class bv {
    private int Zv = 0;
    private bu Zw = new bu();

    public boolean sS() {
        return this.Zv != 0;
    }

    public bu sT() {
        return this.Zw;
    }

    public void a(Yule yule) {
        if (yule != null) {
            this.Zv = yule.activity_show.intValue();
            this.Zw.a(yule.yule_activity);
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.Zv = jSONObject.optInt("activity_show");
                this.Zw.parserJson(jSONObject.optJSONObject("yule_activity"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
